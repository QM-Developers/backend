var list = {
    pageSize:10,

    init:function ()
    {
        list.listInfo(1,list.pageSize);
    },

    listInfo:function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/breed/info/list");
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;
        params["selectId"] = $("#hidden-select-id").val().trim();

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state !== Constant.succeed)
                return;
            var pageCount = data["pageCount"];
            data = data.result;
            var item = "";

            for (var i = 0; i < data.length; i++)
            {
                item += '<tr>' +
                    '<td>' + (i + 1) + '</td>' +
                    '<td>' + data[i]["infoName"] + '</td>' +
                    '<td>' + list.getInfoType(data[i]["infoType"]) + '</td>' +
                    '<td>' + data[i]["selectName"] + '</td>' +
                    '<td>' +
                    '<div class="am-btn-toolbar">' +
                    '<div class="am-btn-group am-btn-group-xs">' +
                    '<button onclick="list.toUpdate(\'' + data[i]["infoId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                    '<span class="am-icon-pencil-square-o"></span> 编辑' +
                    '</button>' +
                    '<button onclick="list.remove(\'' + data[i]["infoId"] + '\',\'' + data[i]["infoName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
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

    getInfoType:function (type)
    {
        switch (type)
        {
            case Constant.text:
                return "文本";
                break;
            case Constant.number:
                return "数字";
                break;
            default:
                break;
        }
    },

    toSave:function ()
    {
        $("#hidden-info-id").val("");
        index.loadInfoSave();
    },

    toUpdate:function (id)
    {
        $("#hidden-info-id").val(id);
        index.loadInfoSave();
    },

    remove:function (id,name,item)
    {
        if (!confirm("确定要删除 " + name + " 吗？"))
            return;

        var url = Constant.getUrl("/breed/info/remove");
        var params = {};

        params["infoId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
                $(item).parents("tr").remove();
            else if (data.state === Constant.permission_denied)
                alert("权限不足");
        });
    }
};