var list = {
    init: function ()
    {
        list.listPermissionTree();
    },

    listPermissionTree: function ()
    {
        var url = Constant.getUrl("/qm/permission/tree");
        var params = {};

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
            {
                data = data.result;
                var setting = {
                    data: {
                        simpleData: {enable: true},
                        key: {url: ''}
                    },
                    callback: {onClick: list.onClick}
                };
                $.fn.zTree.init($("#type-tree"), setting, data);
            }
        });
    },

    onClick: function (event, treeId, treeNode)
    {
        $("#permission-id").val(treeNode.id);
        $("#permission-name").val(treeNode.name);
        $("#permission-url").val(treeNode.url);
        var pNode = treeNode.getParentNode();
        var item = "";

        if (!myjs.isNull(pNode))
            item += '<option value="' + pNode.id + '">' + pNode.name + '</option>';
        item += '<option value="0">无</option>';
        item += '<option value="' + treeNode.id + '">' + treeNode.name + '</option>';

        $("#permission-pid").empty();
        $("#permission-pid").append(item);
    },

    save: function ()
    {
        var url = Constant.getUrl("/qm/permission/save");
        var params = {};

        params["permissionName"] = $("#permission-name").val().trim();
        params["permissionUrl"] = $("#permission-url").val().trim();
        params["permissionPid"] = $("#permission-pid").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
                list.listPermissionTree();
        });
    },

    remove: function ()
    {
        if (!confirm("确定要删除 " + $("#permission-name").val() + " 吗"))
            return;

        var url = Constant.getUrl("/qm/permission/remove");
        var params = {};

        params["permissionId"] = $("#permission-id").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            switch(data.state)
            {
                case Constant.permission_denied:
                    alert("权限不足");
                    break;
                case Constant.succeed:
                    list.listPermissionTree();
                    break;
                case Constant.failed_102:
                    alert("该权限正在使用中，不能删除");
                    break;
            }
        });
    },

    update: function ()
    {
        var url = Constant.getUrl("/qm/permission/update");
        var params = {};

        params["permissionName"] = $("#permission-name").val().trim();
        params["permissionUrl"] = $("#permission-url").val().trim();
        params["permissionPid"] = $("#permission-pid").val().trim();
        params["permissionId"] = $("#permission-id").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
                list.listPermissionTree();
        });
    }

};