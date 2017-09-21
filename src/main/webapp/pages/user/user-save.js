var save = {
    userId: "",

    init: function ()
    {
        save.getUser();
    },

    getUser: function ()
    {
        save.userId = $("#hidden-user-id").val();

        if (myjs.isNull(save.userId))
            return;

        var url = Constant.getUrl("/user/get");
        var params = {};

        params["memberId"] = save.userId;

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
            {
                data = data.result;
                $("#user-name").val(data["userName"]);
                $("#user-phone").val(data["userPhone"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.path + "/user/save" + Constant.suffix;
        var params = {};

        if (!myjs.isNull(save.userId))
        {
            url = Constant.path + "/user/update" + Constant.suffix;
            params["memberId"] = save.userId;
        }

        params["userName"] = $("#user-name").val().trim();
        params["userPhone"] = $("#user-phone").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
                save.back();
        });
    },

    back: function ()
    {
        index.load('../user/user-list.html');
    },
};