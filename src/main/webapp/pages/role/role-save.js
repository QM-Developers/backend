var save = {
    roleId:"",

    init: function ()
    {
        save.getRole();
    },

    getRole: function ()
    {
        save.roleId = $("#hidden-role-id").val();

        console.log(save.roleId);

        if (myjs.isNull(save.roleId))
            return;

        var url = Constant.getUrl("/role/get");
        var params = {};

        params["roleId"] = save.roleId;

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.succeed)
            {
                data = data.result;
                $("#role-name").val(data["roleName"]);
                $("#role-text").val(data["roleText"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.path + "/role/save" + Constant.suffix;
        var params = {};

        if (!myjs.isNull(save.roleId))
        {
            url = Constant.path + "/role/update" + Constant.suffix;
            params["roleId"] = save.roleId;
        }

        params["roleName"] = $("#role-name").val().trim();
        params["roleText"] = $("#role-text").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
                save.back();
            else
                console.log(data);
        });
    },

    back:function ()
    {
        index.loadRoleList();
    },
};