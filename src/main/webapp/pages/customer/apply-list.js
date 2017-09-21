var list = {
    pageSize: 10,

    init: function ()
    {
        list.listApply(1, list.pageSize);
    },

    listApply: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/customer/account/listByProposer");
        var params = {};

        params["pageNum"] = pageNum;
        params["pageSize"] = pageSize;

        myjs.ajax_post(url, params, function (data)
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
                    '<td>' + data[i]["userName"] + '</td>' +
                    '<td>' + data[i]["customerName"] + '</td>' +
                    '<td>' + list.getStatus(data[i]["accountStatus"]) + '</td>' +
                    '</tr>'
            }
            $("#apply-list").empty();
            $("#apply-list").append(item);

            item = "";
            for (var i = 1; i < pageCount + 1; i++)
                item += '<li onclick="list.listApply(' + i + ',' + list.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
            $("#page-count").empty();
            $("#page-count").append(item);
        });
    },

    getStatus: function (status)
    {
        switch (status)
        {
            case Constant.account_waiting:
                return "待审核";
            case Constant.account_accept:
                return "通过审核";
            case Constant.account_refuse:
                return "审核未通过";
        }
    }
};