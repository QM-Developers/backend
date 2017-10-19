var log = {
    pageSize: 20,

    init: function ()
    {
        log.list(1, log.pageSize);
    },

    list: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/interface/log/list");
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
            if (data.state === Constant.succeed)
            {
                var pageCount = data["pageCount"];
                data = data.result;
                var item = '';
                for (var i = 0; i < data.length; i++)
                {
                    item += '<tr>' +
                        '<td>' + data[i]["infoName"] + '</td>' +
                        '<td>' + data[i]["updateText"] + '</td>' +
                        '<td>' + new Date(data[i]["updateDate"]).format("yyyy-MM-dd hh:mm:ss") + '</td>' +
                        '<td><a onclick="log.toInfo(\'' + data[i]["infoId"] + '\')" href="###">查看</a></td>' +
                        '</tr>'
                }

                $("#log-list").empty();
                $("#log-list").append(item);

                item = "";
                for (var i = 1; i < pageCount + 1; i++)
                    item += '<li onclick="log.list(' + i + ',' + log.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
                $("#page-count").empty();
                $("#page-count").append(item);
            }
        });
    },

    toInfo: function (id)
    {
        $("#hidden-interface-id").val(id);
        index.loadInterfaceList();
    },
};