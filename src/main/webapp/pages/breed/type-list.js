var list = {
    pageSize: 10,

    init: function ()
    {
        list.listType(1, list.pageSize);
    },

    listType: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/breed/list");
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;
        params["selectId"] = $("#hidden-select-id").val().trim();

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
                    '<td>' + data[i]["typeName"] + '</td>' +
                    '<td>' + data[i]["selectName"] + '</td>' +
                    '<td>' +
                    '<div class="am-btn-toolbar">' +
                    '<div class="am-btn-group am-btn-group-xs">' +
                    '<button onclick="list.toUpdate(\'' + data[i]["typeId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                    '<span class="am-icon-pencil-square-o"></span> 编辑' +
                    '</button>' +
                    '<button onclick="list.toSelect(\'' + data[i]["typeId"] + '\',\'' + data[i]["typeName"] + '\')" class="am-btn am-btn-default am-btn-xs am-hide-sm-only">' +
                    '<span class="am-icon-lock"></span> 编辑选项' +
                    '</button>' +
                    '<button onclick="list.remove(\'' + data[i]["typeId"] + '\',\'' + data[i]["typeName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
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

    toSave: function ()
    {
        $("#hidden-type-id").val("");
        index.loadTypeSave();
    },

    toUpdate: function (tid)
    {
        $("#hidden-type-id").val(tid);
        index.loadTypeSave();
    },

    remove: function (id, name, item)
    {
        if (!confirm("确定要删除 " + name + " 吗？"))
            return;

        var url = Constant.getUrl("/breed/remove");
        var params = {};

        params["typeId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
                $(item).parents("tr").remove();
        });
    },

    toSelect: function (tid,name)
    {
        $("#hidden-type-id").val(tid);
        $("#hidden-type-name").val(name);
        index.loadSelectList();
    },

};