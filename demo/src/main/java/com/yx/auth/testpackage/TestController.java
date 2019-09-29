package com.yx.auth.testpackage;

import ch.qos.logback.classic.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    private CityPefDao cityPefDao;

    private Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/test")
    public List<DevIdAndUnitName> obj(){
        List <DevIdAndUnitName> list = new ArrayList();
        list.add(new DevIdAndUnitName("id","name"));
        return list;
    }

    @GetMapping("/collector/log/get")
    public String log_switch(@RequestParam(value="level") String level,
                             @RequestParam(value = "packageName",defaultValue = "")String packageName){

        ch.qos.logback.classic.LoggerContext loggerContext =(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();
        String globalLevel = loggerContext.getLogger("root").getLevel().toString();
        log.debug("当前全局日志级别为"+globalLevel);
        if(packageName.equals("")) {
            // 默认值""，更改全局日志级别；否则按传递的包名或类名修改日志级别。
            loggerContext.getLogger("root").setLevel(ch.qos.logback.classic.Level.toLevel(level));
            return "更改全局日志级别为 "+level;
        } else {
            loggerContext.getLogger(packageName).setLevel(ch.qos.logback.classic.Level.toLevel(level));
        }
        return "更改"+packageName+"日志级别为 "+level;
    }


    @GetMapping("/collector/log/getDetail")
    public Map<String,Map<String,Level>> getDetail(){
        ch.qos.logback.classic.LoggerContext loggerContext =(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();

        Map<String,Map<String,Level>> map = new HashMap();
        Map<String,Level> childMap1 = new HashMap<>();
        Map<String,Level> childMap2 = new HashMap<>();

        Level level1 = loggerContext.getLogger("com.yx.auth.testpackage.CityPefService").getLevel();
//        String strLevel1 = level1.toString();
        Level level2 = loggerContext.getLogger("com.yx.auth.testpackage.CityPefDao").getLevel();
//        String strLevel2 = level2.toString();
        Level level3 = loggerContext.getLogger("com.yx.auth.testpackage.RcuCallAndOccupyRatio").getLevel();
//        String strLevel3 = level3.toString();
        Level level4 = loggerContext.getLogger("com.yx.auth.testpackage.MyBatisScannerConfig").getLevel();
//        String strLevel4 = level2.toString();
        Level level5 = loggerContext.getLogger("com.yx.auth.testpackage.RcuCallAndOccupyRatio").getLevel();
//        String strLevel5 = level2.toString();
        Level level6 = loggerContext.getLogger("com.yx.auth.testpackage.DateUtil").getLevel();
//        String strLevel6 = level2.toString();

        childMap1.put("CityPefService",level1);
        childMap1.put("CityPefDao",level2);
        childMap1.put("RcuCallAndOccupyRatio",level3);
        childMap2.put("MyBatisScannerConfig",level4);
        childMap2.put("RcuCallAndOccupyRatio",level5);
        childMap2.put("DateUtil",level6);
        map.put("testpackage1",childMap1);
        map.put("testpackage2",childMap2);
        return map;
    }

    @GetMapping("/collector/log/getDetail2")
    public Package getDetail2(){
        ch.qos.logback.classic.LoggerContext loggerContext =(ch.qos.logback.classic.LoggerContext) LoggerFactory.getILoggerFactory();

        Package p = new Package("com.yx.auth.testpackage",loggerContext.getLogger("com.yx.auth.testpackage").getLevel());
        Package p1 = new Package("com.yx.auth.testpackage.CityPefService",loggerContext.getLogger("com.yx.auth.testpackage.CityPefService").getLevel());
        Package p2 = new Package("com.yx.auth.testpackage.DevIdAndUnitName",loggerContext.getLogger("com.yx.auth.testpackage.DevIdAndUnitName").getLevel());
        Package p3 = new Package("com.yx.auth.testpackage.MyBatisScannerConfig",loggerContext.getLogger("com.yx.auth.testpackage.MyBatisScannerConfig").getLevel());
        p.setChilds(new Package[]{p1,p2,p3});
        return p;
    }



    @GetMapping(value = "/logback")
    public String logj(){
        log.error("我是error");
        log.warn("我是warn");
        log.info("我是info");
        log.debug("我是debug");
        return "打印日志";
    }
}

