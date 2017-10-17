/**
 * Created by leroy(lier@gr158.com) on 2017/10/12.
 */
var flag = 0;

(function ($) {
    $('#login-btn').click(function () {
        if(flag == 1){
            return;
        }
        flag = 1;
        clearMessage();
        if(validLogin()){
            login();
        } else {
            alertMessage("请输入用户名或密码");
        }
    });
}(jQuery));

function validLogin() {
    var account = $('#account').val();
    var password = $('#password').val();
    if(account == null || account == ""){
        return false;
    }
    if(password == null || password == ""){
        return false;
    }
    return true;
}

function login() {
    var code = $("#code").val();
    if(code == null || code == ""){
        alertMessage("登录异常");
        return;
    }
    var account = $('#account').val();
    var password = $('#password').val();
    var temp = MD5(password + account);
    temp = MD5(temp + code);
    password = temp;
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: ctx + "/logining",
        data: {
            account: account,
            password: password
        }
    }).success(function (data) {
        if(data.code == 0){
            window.location.href = ctx + "/index";
        } else {
            alertMessage(data.message);
        }
    }).error(function (XMLHttpRequest, textStatus, errorThrown) {
        alertMessage("登录失败");
    });
}

function alertMessage(message) {
    $('.login-message label').text(message);
    $('.login-message').show();
    flag = 0;
}

function clearMessage() {
    $('.login-message label').text("");
    $('.login-message').hide();
}