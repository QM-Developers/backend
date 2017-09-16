var login = {
    SUCCEED: 100,

    init: function ()
    {

    },

    login: function ()
    {
        var url = Constant.path + "/login/browser" + Constant.suffix;
        var params = {};

        params["phone"] = $("#phone").val().trim();
        params["password"] = md5($("#password").val().trim());

        console.log(url);

        myjs.ajax_post(url, params, function (data)
        {
            console.log(data);
            if (parseInt(data) === login.SUCCEED)
                window.location.href = Constant.path + "/pages/index/index.html";
            else
                alert("用户名或密码错误");
        });
    }
};