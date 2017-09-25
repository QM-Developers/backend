var list = {
    pageSize: 10,
    modalPermission: null,

    init: function ()
    {
        list.modalPermission = $("#modal-permission");
        list.listRole(1, list.pageSize);
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
                    check: {
                        enable: true
                    }
                };
                $.fn.zTree.init($("#tree"), setting, data);
            }
        });
    },

    listRole: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/qm/role/list");
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;

        myjs.ajax_post(url, params, function (data)
        {
            switch (data.state)
            {
                case Constant.permission_denied:
                    alert("权限不足");
                    break;
                case Constant.succeed:
                    data = data.result;
                    var pageCount = data["pageCount"];
                    var item = "";
                    for (var i = 0; i < data.length; i++)
                    {
                        var permission = data[i]["permissionList"];
                        var permissionId = "";
                        for (var j = 0; j < permission.length; j++)
                            permissionId += permission[j]["permissionId"] + ",";

                        item += '<tr>' +
                            '<td>' + (i + 1) + '</td>' +
                            '<td>' + data[i]["qmPermissionName"] + '</td>' +
                            '<td>' + data[i]["qmPermissionDescribe"] + '</td>' +
                            '<td>' + data[i]["qmPermissionPid"] + '</td>' +
                            '<td>' +
                            '<div class="am-btn-toolbar">' +
                            '<div class="am-btn-group am-btn-group-xs">' +
                            '<button onclick="list.toUpdate(\'' + data[i]["qmPermissionId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                            '<span class="am-icon-pencil-square-o"></span> 编辑' +
                            '</button>' +
                            '<button onclick="list.showPermissionModel(\'' + data[i]["qmPermissionId"] + '\',\'' + permissionId + '\')" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">' +
                            '<span class="am-icon-lock"></span> 权限分配' +
                            '</button>' +
                            '<button onclick="list.remove(\'' + data[i]["qmPermissionId"] + '\',\'' + data[i]["qmPermissionName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
                            '<span class="am-icon-trash-o"></span> 删除' +
                            '</button>' +
                            '</div>' +
                            '</div>' +
                            '</td>' +
                            '</tr>'
                    }
                    $("#role-list").empty();
                    $("#role-list").append(item);

                    item = "";
                    for (var i = 1; i < pageCount + 1; i++)
                        item += '<li onclick="list.listRole(' + i + ',' + list.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
                    $("#page-count").empty();
                    $("#page-count").append(item);
                    break;
            }
        });
    },

    remove: function (pid,name)
    {
        if (!confirm("确定要删除 " + name + " 吗？"))
            return;

        var url = Constant.getUrl("/qm/role/remove");
        var params = {};

        params["qmPermissionId"] = pid;

        myjs.ajax_post(url, params, function (data)
        {
            switch (data.state)
            {
                case Constant.permission_denied:
                    alert("权限不足");
                    break;
                case Constant.succeed:
                    list.listRole(1, list.pageSize);
                    break;
                case Constant.failed_102:
                    alert("该角色正在使用中，不能删除");
                    break;
            }
        });
    },

    toSave: function ()
    {
        $("#hidden-qm-role-id").val("");
        index.loadQMRoleSave();
    },

    toUpdate: function (pid)
    {
        $("#hidden-qm-role-id").val(pid);
        index.loadQMRoleSave();
    },

    showPermissionModel: function (rid, pid)
    {
        var permissionId = "";
        if (!myjs.isNull(pid))
            permissionId = pid.split(",");

        var treeObj = $.fn.zTree.getZTreeObj("tree");
        treeObj.checkAllNodes(false);

        var nodes = treeObj.getNodes();

        var checkNode = function (nodes)
        {
            for (var i = 0; i < nodes.length; i++)
            {
                for (var j = 0; j < permissionId.length; j++)
                {
                    if (nodes[i].id === permissionId[j])
                        treeObj.checkNode(nodes[i], true);
                }
                if (!myjs.isNull(nodes[i].children))
                    checkNode(nodes[i].children);
            }
        };
        checkNode(nodes);

        list.roleId = rid;
        list.modalPermission.modal({'closeOnConfirm': false, 'closeViaDimmer': false, 'height': 500});
    },

    savePermission: function ()
    {
        var url = Constant.getUrl("/qm/role/updatePermission");
        var params = {};

        var permission = [];

        var treeObj = $.fn.zTree.getZTreeObj("tree");
        var nodes = treeObj.getCheckedNodes(true);

        for (var i = 0; i < nodes.length; i++)
            permission.push({"permissionId": nodes[i].id});

        params["permission"] = JSON.stringify(permission);
        params["qmPermissionId"] = list.roleId;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed) ;
            {
                list.listRole(1, list.pageSize);
                list.modalPermission.modal("close");
            }
        });
    }
};