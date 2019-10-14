#用户表
CREATE TABLE IF NOT EXISTS `user`
(
    `id`           varchar(11) CHARACTER SET latin1 COLLATE latin1_swedish_ci  NOT NULL,
    `name`         varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci     NULL DEFAULT NULL,
    `password`     varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
    `email`        varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
    `phone_number` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
    `create_time`  datetime                                                    NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = latin1
  COLLATE = latin1_swedish_ci
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

#角色表
CREATE TABLE IF NOT EXISTS `role`
(
    `id`          varchar(11) CHARACTER SET utf8 COLLATE utf8_bin  NOT NULL,
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

#用户角色关联表
CREATE TABLE IF NOT EXISTS `user_role`
(
    `id`          varchar(11) CHARACTER SET utf8 COLLATE utf8_bin  NOT NULL,
    `user_id`     varchar(11) CHARACTER SET utf8 COLLATE utf8_bin  NULL DEFAULT NULL,
    `role_id`     varchar(11) CHARACTER SET utf8 COLLATE utf8_bin  NULL DEFAULT NULL,
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

#权限表
CREATE TABLE IF NOT EXISTS `permission`
(
    `id`          varchar(11) CHARACTER SET utf8 COLLATE utf8_bin  NOT NULL,
    `name`        varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `url`         varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

#角色权限关联表
CREATE TABLE IF NOT EXISTS `role_permission`
(
    `id`            varchar(11) CHARACTER SET utf8 COLLATE utf8_bin  NOT NULL,
    `role_id`       varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `permission_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    `description`   varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_bin
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

#查询用户所有角色及权限
/*select u.id, u.name as username, r.name as rolename, p.`name` as pname
from user u
         left join user_role ur on u.id = ur.user_id
         left join role r on ur.role_id = r.id
         left join role_permission rp on r.id = rp.role_id
         left join permission p on rp.permission_id = p.id
where u.id = 1*/