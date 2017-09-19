var list = {
    pageSize: 10,

    init: function ()
    {
        list.listPermission(1, list.pageSize);
    },

    listPermission: function (pageNum, pageSize)
    {
        var url = Constant.path + "/permission/list" + Constant.suffix;
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
                item += '<tr>' +
                    '<td>' + (i + 1) + '</td>' +
                    '<td>' + data[i]["permissionName"] + '</td>\n' +
                    '<td>' + data[i]["permissionText"] + '</td>' +
                    '<td>' + data[i]["permissionUrl"] + '</td>' +
                    '<td>' +
                    '<div class="am-btn-toolbar">' +
                    '<div class="am-btn-group am-btn-group-xs">' +
                    '<button onclick="list.toUpdate(\'' + data[i]["permissionId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                    '<span class="am-icon-pencil-square-o"></span> 编辑' +
                    '</button>' +
                    '<button onclick="list.remove(\'' + data[i]["permissionId"] + '\',\'' + data[i]["permissionName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
                    '<span class="am-icon-trash-o"></span> 删除' +
                    '</button>' +
                    '</div>' +
                    '</div>' +
                    '</td>' +
                    '</tr>'
            }
            $("#permission-list").empty();
            $("#permission-list").append(item);

            item = "";
            for (var i = 1; i < pageCount + 1; i++)
                item += '<li onclick="list.listPermission(' + i + ',' + list.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
            $("#page-count").empty();
            $("#page-count").append(item);
        });
    },

    toUpdate: function (uid)
    {
        $("#hidden-permission-id").val(uid);
        index.loadPermissionSave();
    },

    toSave: function ()
    {
        $("#hidden-permission-id").val("");
        index.loadPermissionSave();
    },

    remove:function (uid,name,item)
    {
        if (!confirm("确定要删除 "+name+" 吗？"))
            return;

        var url = Constant.getUrl("/permission/remove");
        var params = {};

        params["permissionId"] = uid;

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.succeed)
                $(item).parents("tr").remove();
        });
    }
};