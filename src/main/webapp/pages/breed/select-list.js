var list = {
    pageSize: 10,

    init: function ()
    {
        list.listSelect(1, list.pageSize);
    },

    listSelect: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/breed/select/list");
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;
        params["typeId"] = $("#hidden-type-id").val().trim();

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
                    '<td>' + data[i]["selectName"] + '</td>' +
                    '<td>' + data[i]["typeName"] + '</td>' +
                    '<td>' +
                    '<div class="am-btn-toolbar">' +
                    '<div class="am-btn-group am-btn-group-xs">' +
                    '<button onclick="list.toUpdate(\'' + data[i]["selectId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                    '<span class="am-icon-pencil-square-o"></span> 编辑' +
                    '</button>' +
                    '<button onclick="list.toType(\'' + data[i]["selectId"] + '\',\'' + data[i]["selectName"] + '\')" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">' +
                    '<span class="am-icon-lock"></span> 编辑类目' +
                    '</button>' +
                    '<button onclick="list.toInfo(\'' + data[i]["selectId"] + '\',\'' + data[i]["selectName"] + '\')" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">' +
                    '<span class="am-icon-lock"></span> 类目信息' +
                    '</button>' +
                    '<button onclick="list.remove(\'' + data[i]["selectId"] + '\',\'' + data[i]["selectName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
                    '<span class="am-icon-trash-o"></span> 删除' +
                    '</button>' +
                    '</div>' +
                    '</div>' +
                    '</td>' +
                    '</tr>'
            }
            $("#type-list").empty();
            $("#type-list").append(item);

            item = "";
            for (var i = 1; i < pageCount + 1; i++)
                item += '<li onclick="list.listType(' + i + ',' + list.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
            $("#page-count").empty();
            $("#page-count").append(item);
        });
    },

    toType: function (id, name)
    {
        $("#hidden-select-id").val(id);
        $("#hidden-select-name").val(name);
        index.loadTypeList();
    },

    toInfo: function (id, name)
    {
        $("#hidden-select-id").val(id);
        $("#hidden-select-name").val(name);
        index.loadInfoList();
    },

    toUpdate: function (sid)
    {
        $("#hidden-select-id").val(sid);
        index.loadSelectSave();
    },

    remove: function (id, name, item)
    {
        if (!confirm("确定要删除 " + name + " 吗？"))
            return;

        var url = Constant.getUrl("/breed/select/remove");
        var params = {};

        params["selectId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
                $(item).parents("tr").remove();
        });
    },

    toSave: function ()
    {
        $("#hidden-select-id").val("");
        index.loadSelectSave();
    },
};