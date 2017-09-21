var list = {
    memberId: null,
    pageSize: 10,
    modelRole: $("#modal-role"),
    checkSelectAll: $("#check-select-all"),
    roleList: $("#role-list"),

    init: function ()
    {
        list.listUser(1, list.pageSize);
        list.listRole(1, 10);

        list.initBind();
    },

    initBind: function ()
    {
        list.checkSelectAll.bind("click", function ()
        {
            list.selectAll()
        });
    },

    listUser: function (pageNum, pageSize)
    {
        var url = Constant.path + "/user/list" + Constant.suffix;
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state !== Constant.succeed)
                return;
            var pageCount = data["pageCount"];
            data = data.result;
            var item = "";
            var role;
            var roleId;
            var roleName;

            for (var i = 0; i < data.length; i++)
            {
                role = data[i]["roleList"];
                roleId = "";
                roleName = "";
                for (var j = 0; j < role.length; j++)
                {
                    roleId += role[j]["roleId"] + ",";
                    roleName += role[j]["roleName"] + ",";
                }
                roleName = roleName.substring(0, roleName.length - 1);
                item += '<tr>' +
                    '<td>' + (i + 1) + '</td>' +
                    '<td>' + data[i]["userName"] + '</td>' +
                    '<td>' + data[i]["userPhone"] + '</td>' +
                    '<td><hidden value="' + roleId + '"/>' + roleName + '</td>' +
                    '<td>' +
                    '<div class="am-btn-toolbar">' +
                    '<div class="am-btn-group am-btn-group-xs">' +
                    '<button onclick="list.toUpdate(\'' + data[i]["userId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                    '<span class="am-icon-pencil-square-o"></span> 编辑' +
                    '</button>' +
                    '<button onclick="list.showRoleModel(\'' + data[i]["userId"] + '\',\'' + roleId + '\');" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">' +
                    '<span class="am-icon-user-plus"></span> 分配角色' +
                    '</button>' +
                    '<button onclick="list.remove(\'' + data[i]["userId"] + '\',\'' + data[i]["userName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
                    '<span class="am-icon-trash-o"></span> 删除' +
                    '</button>' +
                    '</div>' +
                    '</div>' +
                    '</td>' +
                    '</tr>'
            }
            $("#user-list").empty();
            $("#user-list").append(item);

            item = "";
            for (var i = 1; i < pageCount + 1; i++)
                item += '<li onclick="list.listUser(' + i + ',' + list.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
            $("#page-count").empty();
            $("#page-count").append(item);
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
            if (data.state === Constant.permission_denied)
                return;

            if (data.state !== Constant.succeed)
                return;
            var pageCount = data["pageCount"];
            data = data.result;
            var item = "";

            for (var i = 0; i < data.length; i++)
            {
                item += '<tr>' +
                    '<td><input type="checkbox" value="' + data[i]["roleId"] + '"></td>' +
                    '<td>' + data[i]["roleName"] + '</td>' +
                    '<td>' + data[i]["roleText"] + '</td>' +
                    '</tr>';
            }
            list.roleList.append(item);
            if (pageNum < pageCount)
                list.listRole(pageNum + 1, pageSize);
        });
    },

    toUpdate: function (uid)
    {
        $("#hidden-user-id").val(uid);
        index.loadUserSave();
    },

    toSave: function ()
    {
        $("#hidden-user-id").val("");
        index.loadUserSave();
    },

    remove: function (uid, name, item)
    {
        if (!confirm("确定要删除 " + name + " 吗？"))
            return;

        var url = Constant.getUrl("/user/remove");
        var params = {};

        params["memberId"] = uid;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
                $(item).parents("tr").remove();
        });
    },

    showRoleModel: function (uid, rid)
    {
        var check = list.roleList.find("input:checkbox");
        var roleId = rid.split(",");

        $(check).prop("checked", false);
        for (var i = 0; i < check.length; i++)
            for (var j = 0; j < roleId.length; j++)
                if (check[i].value === roleId[j])
                    check[i].checked = true;

        list.memberId = uid;
        list.modelRole.modal({'closeOnConfirm': false, 'closeViaDimmer': false});
    },

    selectAll: function ()
    {
        var item = list.checkSelectAll;
        item.parents("table:eq(0)").find("input:checkbox").prop("checked", item.prop("checked"));
    },

    saveRole: function ()
    {
        if (myjs.isNull(list.memberId))
        {
            alert("选择用户发生错误！");
            return;
        }

        var url = Constant.getUrl("/user/updateRole");
        var params = {};
        var role = [];

        var select = $("#role-list input[type='checkbox']");
        for (var i = 0; i < select.length; i++)
            if ($(select[i]).prop("checked"))
            {
                if (select[i].value === Constant.administrator)
                {
                    alert("不能分配超级管理员");
                    return;
                }
                role.push({"roleId": select[i].value});
            }

        params["memberId"] = list.memberId;
        params["role"] = JSON.stringify(role);

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
            {
                list.modelRole.modal("close");
                list.listUser(1, list.pageSize);
                return;
            }
            if (data.state === Constant.failed_102)
                alert("不能分配超级管理员");
        });
    },
};