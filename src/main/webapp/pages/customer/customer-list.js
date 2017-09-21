var list = {
    pageSize: 10,

    init: function ()
    {
        list.listCustomer(1, list.pageSize);
    },

    listCustomer: function (pageNum, pageSize)
    {
        var url = Constant.getUrl("/customer/list");
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
                    '<td>' + data[i]["customerName"] + '</td>' +
                    '<td>' + data[i]["teamName"] + '</td>' +
                    '<td>' + data[i]["customerPhone"] + '</td>' +
                    '<td>' + (parseInt(data[i]["hadAccount"]) === 1 ? "已建账" : "未建账") + '</td>' +
                    '<td>' +
                    '<div class="am-btn-toolbar">' +
                    '<div class="am-btn-group am-btn-group-xs">' +
                    '<button onclick="list.toUpdate(\'' + data[i]["customerId"] + '\')"  class="am-btn am-btn-default am-btn-xs am-text-secondary">' +
                    '<span class="am-icon-pencil-square-o"></span> 编辑' +
                    '</button>' +
                    '<button onclick="list.saveAccount(\'' + data[i]["customerId"] + '\',\'' + data[i]["customerName"] + '\')"  class="am-btn am-btn-default am-btn-xs am-hide-sm-only">' +
                    '<span class="am-icon-pencil-square-o"></span> 申请建账' +
                    '</button>' +
                    '<button onclick="list.remove(\'' + data[i]["customerId"] + '\',\'' + data[i]["customerName"] + '\',this);" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">' +
                    '<span class="am-icon-trash-o"></span> 删除' +
                    '</button>' +
                    '</div>' +
                    '</div>' +
                    '</td>' +
                    '</tr>'
            }
            $("#customer-list").empty();
            $("#customer-list").append(item);

            item = "";
            for (var i = 1; i < pageCount + 1; i++)
                item += '<li onclick="list.listCustomer(' + i + ',' + list.pageSize + ')" class="' + (pageNum === i ? "am-active" : "") + '"><a href="javascript:(0)">' + i + '</a></li>';
            $("#page-count").empty();
            $("#page-count").append(item);
        });
    },

    toUpdate: function (id)
    {
        $("#hidden-customer-id").val(id);
        index.loadCustomerSave();
    },

    toSave: function ()
    {
        $("#hidden-customer-id").val("");
        index.loadCustomerSave();
    },

    remove: function (id, name, item)
    {
        if (!confirm("确定要删除 " + name + " 吗？"))
            return;

        var url = Constant.getUrl("/customer/remove");
        var params = {};

        params["customerId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state === Constant.succeed)
                $(item).parents("tr").remove();
        });
    },

    saveAccount: function (id, name)
    {
        if (!confirm("要为 " + name + " 申请建账吗？"))
            return;

        var url = Constant.getUrl("/customer/account/save");
        var params = {};

        params["customerId"] = id;
        params["customerName"] = name;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state === Constant.succeed)
                alert("申请成功");
        });
    },
};