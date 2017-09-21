var save = {
    selectId: "",

    init: function ()
    {
        save.getSelect();
    },

    getSelect: function ()
    {
        save.selectId = $("#hidden-select-id").val();
        $("#type-name").val($("#hidden-type-name").val());
        $("#type-id").val($("#hidden-type-id").val());

        if (myjs.isNull(save.selectId))
            return;

        var url = Constant.getUrl("/breed/select/get");
        var params = {};

        params["selectId"] = save.selectId;

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state === Constant.succeed)
            {
                data = data.result;
                $("#select-name").val(data["selectName"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.path + "/breed/select/save" + Constant.suffix;
        var params = {};

        if (!myjs.isNull(save.selectId))
        {
            url = Constant.path + "/breed/select/update" + Constant.suffix;
            params["selectId"] = save.selectId;
        }

        params["selectName"] = $("#select-name").val().trim();
        params["typeId"] = $("#type-id").val().trim();
        params["typeName"] = $("#type-name").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state === Constant.succeed)
                save.back();
        });
    },

    back: function ()
    {
        index.load('../breed/select-list.html');
    },
};