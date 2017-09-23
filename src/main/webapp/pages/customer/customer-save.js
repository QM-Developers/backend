var save = {
    customerId: null,

    init: function ()
    {
        save.getCustomer();

        save.initBind();
    },

    initBind: function ()
    {
        var item = $("#team-create-date");
        item.datepicker().on('changeDate.datepicker.amui', function (event)
        {
            item.val(new Date(event.date).format("yyyy-MM-dd"));
        });
    },

    getCustomer: function ()
    {
        save.customerId = $("#hidden-customer-id").val();

        if (myjs.isNull(save.customerId))
            return;

        var url = Constant.getUrl("/customer/get");
        var params = {};

        params["customerId"] = save.customerId;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state = Constant.succeed)
            {
                data = data.result;

                $("#customer-sex").val(data["customerSex"]);
                $("#customer-identity").val(data["customerIdentity"]);
                $("#customer-phone").val(data["customerPhone"]);
                $("#customer-name").val(data["customerName"]);
                $("#team-id").val(data["teamId"]);
                $("#team-area").val(data["teamArea"]);
                $("#team-address").val(data["teamAddress"]);
                $("#team-create-date").val(new Date(data["teamCreateDate"]).format("yyyy-MM-dd"));
                $("#team-name").val(data["teamName"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.getUrl("/customer/save");
        var params = {};

        if (!myjs.isNull(save.customerId))
        {
            url = Constant.getUrl("/customer/update");
            params["customerId"] = save.customerId;
        }

        params["customerSex"] = $("#customer-sex").val().trim();
        params["customerIdentity"] = $("#customer-identity").val().trim();
        params["customerPhone"] = $("#customer-phone").val().trim();
        params["customerName"] = $("#customer-name").val().trim();
        params["teamId"] = $("#team-id").val().trim();
        params["teamArea"] = $("#team-area").val().trim();
        params["teamAddress"] = $("#team-address").val().trim();
        params["teamCreateDate"] = $("#team-create-date").val().trim();
        params["teamName"] = $("#team-name").val().trim();
        params["latLng"] = $("#lat-lng").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
                save.back();
        });
    },

    back: function ()
    {
        index.loadCustomerList();
    },
};