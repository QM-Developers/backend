var list = {
    pageSize: 10,

    init: function ()
    {
        list.listApprove(1, list.pageSize);
    },

    listApprove: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/customer/account/listByApprove");
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
                    '<td>' + data[i]["customerName"] + '</td>';
                if (parseInt(data[i]["accountStatus"]) === Constant.account_waiting)
                {
                    item += '<td>' +
                        '<div class="am-btn-toolbar">' +
                        '<div class="am-btn-group am-btn-group-xs">' +
                        '<button onclick="list.accept(\'' + data[i]["accountId"] + '\',\'' + data[i]["customerName"] + '\',this)"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                        '<span class="am-icon-check"></span> 同意' +
                        '</button>' +
                        '<button onclick="list.refuse(\'' + data[i]["accountId"] + '\',\'' + data[i]["customerName"] + '\',this)"  class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
                        '<span class="am-icon-close"></span> 拒绝' +
                        '</button>' +
                        '</div>' +
                        '</div>' +
                        '</td>';
                } else
                    item += '<td>' + list.getStatus(data[i]["accountStatus"]) + '</td>';
                item += '</tr>';
            }
            $("#approve-list").empty();
            $("#approve-list").append(item);

            item = "";
            for (var i = 1; i < pageCount + 1; i++)
                item += '<li onclick="list.listApprove(' + i + ',' + list.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
            $("#page-count").empty();
            $("#page-count").append(item);
        });
    },

    accept: function (id, name, item)
    {
        if (!confirm("确定为 " + name + " 建立账号吗？"))
            return;

        var url = Constant.getUrl("/customer/account/updateAccept");
        var params = {};

        params["accountId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state === Constant.succeed)
                $(item).parents("td:eq(0)").html(list.getStatus(Constant.account_accept));
        });
    },

    refuse: function (id, name, item)
    {
        if (!confirm("确定拒绝建立 " + name + " 的账号吗？"))
            return;

        var url = Constant.getUrl("/customer/account/updateRefuse");
        var params = {};

        params["accountId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state === Constant.succeed)
                $(item).parents("td:eq(0)").html(list.getStatus(Constant.account_refuse));
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
    },

};