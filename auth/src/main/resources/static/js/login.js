let panel_title = '.panel_title';
$(document).ready(function () {

    //进入页面默认为登录面板
    changePanel('login');

    $($(panel_title).get(0)).css('color', 'steelblue').css('font-weight', '600');
    $(panel_title).on('click', function () {
        $(panel_title).css('color', '').css('font-weight', '');
        $(this).css('color', 'steelblue').css('font-weight', '600');
    });

    $('.bt').on('mouseover', function () {
        $(this).css('background-color', '#a56a2f');
    }).on('mouseout', function () {
        $(this).css('background-color', '');
    });

});

/**
 * 登录
 */
function login() {
    let username = $("#username").val();
    let password = $("#password").val();
    if (username === "" || password === "") {
        alert("请输入用户名或密码");
        return;
    }
    let list = {
        "id": "",
        "name": username,
        "password": password
    };
    $.ajax({
        //请求方式
        type: "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url: "http://localhost:8090/login/jwtLogin/",
        //数据，json字符串
        data: JSON.stringify(list),
        //请求成功
        success: function (result) {
            if (result.code !== 1) {
                alert("用户名或密码错误");
                return;
            }
            window.location.href = "./index.html";
        },
        //请求失败，包含具体的错误信息
        error: function (e) {
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}


/**
 * 注册 检测用户是否已存在
 */
function reg() {
    let username = $("#reg_username").val().trim();
    let password = $("#reg_password").val().trim();
    if (username === "" || password === "") {
        alert("请输入用户名或密码");
        return;
    }
    let param = {
        "userName": username,
    };
    $.ajax({
        //请求方式
        type: "POST",
        //请求的媒体类型
        contentType: "application/json;charset=UTF-8",
        //请求地址
        url: "http://localhost:8090/login/validateReg/",
        //数据，json字符串
        data: JSON.stringify(param),
        //请求成功
        success: function (result) {

            console.log(result);

            if (Number(result['code']) < 0) {  //用户名已存在
                alert(result['msg']);
            } else {
                addRegUser(username, password);
            }
        },
        //请求失败，包含具体的错误信息
        error: function (e) {
            console.log(e.status);
            console.log(e.responseText);
        }
    });
}

/**
 * 注册 新增用户
 */
function addRegUser(username, password) {
    let param = {
        'name': username,
        'password': password
    };
    $.ajax({
        url: 'http://localhost:8090/login/reg',
        data: JSON.stringify(param),
        type: 'POST',
        contentType: "application/json;charset=UTF-8",
        dataType: 'json',
        success: function (data) {
            console.log(data);
            if (Number(data['code']) > 0) {
                alert(data['msg']);
                location.href = '/html/login.html';
            } else {
                alert('注册失败！');
            }
        },
        error: function (e) {
            console.log(e);
        }
    })

}

/**
 * 切换“登录”和“注册”面板
 */
function changePanel(param) {
    if (param === 'login') {
        $('#login_panel').prop('hidden', false);
        $('#reg_panel').prop('hidden', true);
    } else if (param === 'reg') {
        $('#login_panel').prop('hidden', true);
        $('#reg_panel').prop('hidden', false);
    }

}