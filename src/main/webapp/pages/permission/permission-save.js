var save = {
    permissionId:"",

    init: function ()
    {
        save.getPermission();
    },

    getPermission: function ()
    {
        save.permissionId = $("#hidden-permission-id").val();

        console.log(save.permissionId);

        if (myjs.isNull(save.permissionId))
            return;

        var url = Constant.getUrl("/permission/get");
        var params = {};

        params["permissionId"] = save.permissionId;

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.succeed)
            {
                data = data.result;
                $("#permission-name").val(data["permissionName"]);
                $("#permission-text").val(data["permissionText"]);
                $("#permission-url").val(data["permissionUrl"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.path + "/permission/save" + Constant.suffix;
        var params = {};

        if (!myjs.isNull(save.permissionId))
        {
            url = Constant.path + "/permission/update" + Constant.suffix;
            params["permissionId"] = save.permissionId;
        }

        params["permissionName"] = $("#permission-name").val().trim();
        params["permissionText"] = $("#permission-text").val().trim();
        params["permissionUrl"] = $("#permission-url").val().trim();

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
        index.loadPermissionList();
    },
};