var save = {
    roleId: "",

    init: function ()
    {
        save.getRole();
    },

    getRole: function ()
    {
        save.roleId = $("#hidden-qm-role-id").val();

        if (myjs.isNull(save.roleId))
            return;

        var url = Constant.getUrl("/qm/role/get");
        var params = {};

        params["qmPermissionId"] = save.roleId;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
            {
                data = data.result;
                $("#role-name").val(data["qmPermissionName"]);
                $("#role-text").val(data["qmPermissionDescribe"]);
                $("#role-code").val(data["qmPermissionPid"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.path + "/qm/role/save" + Constant.suffix;
        var params = {};

        if (!myjs.isNull(save.roleId))
        {
            url = Constant.path + "/qm/role/update" + Constant.suffix;
            params["qmPermissionId"] = save.roleId;
        }

        params["qmPermissionName"] = $("#role-name").val().trim();
        params["qmPermissionDescribe"] = $("#role-text").val().trim();
        params["qmPermissionPid"] = $("#role-code").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
                save.back();
            else
                console.log(data);
        });
    },

    back: function ()
    {
        index.loadQMRoleList();
    },
};