var list = {
    pageSize: 10,
    permissionList: $("#permission-list"),
    modelPermission: $("#modal-permission"),
    roleId: null,
    checkSelectAll: $("#check-select-all"),

    init: function ()
    {
        list.listRole(1, list.pageSize);
        list.listPermission(1, list.pageSize);

        list.initBind();
    },

    initBind: function ()
    {
        list.checkSelectAll.bind("click", function ()
        {
            list.selectAll()
        });
    },


    listRole: function (pageNum, pageSize)
    {
        var url = Constant.path + "/role/list" + Constant.suffix;
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state !== Constant.succeed)
                return;
            var pageCount = data["pageCount"];
            data = data.result;
            var item = "";

            for (var i = 0; i < data.length; i++)
            {
                var permission = data[i]["permissionList"];
                var permissionId = "";
                for (var j = 0; j < permission.length; j++)
                    permissionId += permission[j]["permissionId"] + ",";

                item += '<tr>' +
                    '<td>' + (i + 1) + '</td>' +
                    '<td>' + data[i]["roleName"] + '</td>' +
                    '<td>' + data[i]["roleText"] + '</td>' +
                    '<td>' +
                    '<div class="am-btn-toolbar">' +
                    '<div class="am-btn-group am-btn-group-xs">' +
                    '<button onclick="list.toUpdate(\'' + data[i]["roleId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                    '<span class="am-icon-pencil-square-o"></span> 编辑' +
                    '</button>' +
                    '<button onclick="list.showPermissionModel(\'' + data[i]["roleId"] + '\',\'' + permissionId + '\')"  class="am-btn am-btn-default am-btn-xs am-hide-sm-only">' +
                    '<span class="am-icon-lock"></span> 权限分配' +
                    '</button>' +
                    '<button onclick="list.remove(\'' + data[i]["roleId"] + '\',\'' + data[i]["roleName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
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
        });
    },

    listPermission: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/permission/list");
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
            {
                var pageCount = data["pageCount"];
                var item = "";
                data = data.result;

                for (var i = 0; i < data.length; i++)
                {
                    item += '<tr>' +
                        '<td><input type="checkbox" value="' + data[i]["permissionId"] + '"></td>' +
                        '<td>' + data[i]["permissionName"] + '</td>' +
                        '<td>' + data[i]["permissionText"] + '</td>' +
                        '</tr>';
                }

                $("#permission-list").append(item);
                if (pageSize < pageCount)
                    list.listPermission(pageNum + 1, pageSize);
            }
        });
    },

    toSave: function ()
    {
        $("#hidden-role-id").val("");
        index.loadRoleSave();
    },

    toUpdate: function (rid)
    {
        $("#hidden-role-id").val(rid);
        index.loadRoleSave();
    },

    remove: function (id, name, item)
    {
        if (!confirm("确定要删除 " + name + " 吗？"))
            return;

        var url = Constant.getUrl("/role/remove");
        var params = {};

        params["roleId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
                $(item).parents("tr").remove();
        });
    },

    showPermissionModel: function (rid, pid)
    {
        var check = list.permissionList.find("input:checkbox");
        var permissionId = "";
        if (!myjs.isNull(pid))
            permissionId = pid.split(",");

        $(check).prop("checked", false);
        for (var i = 0; i < check.length; i++)
            for (var j = 0; j < permissionId.length; j++)
                if (check[i].value === permissionId[j])
                    check[i].checked = true;

        list.roleId = rid;
        list.modelPermission.modal({'closeOnConfirm': false, 'closeViaDimmer': false});
    },

    selectAll: function ()
    {
        var item = list.checkSelectAll;
        item.parents("table:eq(0)").find("input:checkbox").prop("checked", item.prop("checked"));
    },

    savePermission: function ()
    {
        var url = Constant.getUrl("/role/updatePermission");
        var params = {};

        var permission = [];
        var check = list.permissionList.find("input[type='checkbox']");
        for (var i = 0; i < check.length; i++)
            if (check[i].checked)
                permission.push({"permissionId": check[i].value});

        params["permission"] = JSON.stringify(permission);
        params["roleId"] = list.roleId;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed) ;
            {
                list.listRole(1, list.pageSize);
                list.modelPermission.modal("close");
            }
        });
    }
};