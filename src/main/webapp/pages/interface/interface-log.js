var log = {
    init: function ()
    {
        log.list();
    },

    list: function ()
    {
        var url = Constant.getUrl("/interface/log/list");
        var params = {};

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

                $("#log-list").append(item);
            }
        });
    },

    toInfo: function (id)
    {
        $("#hidden-interface-id").val(id);
        index.loadInterfaceList();
    },
};