var save = {
    typeId: "",

    init: function ()
    {
        save.getType();
    },

    getType: function ()
    {
        save.typeId = $("#hidden-type-id").val();
        $("#select-name").val($("#hidden-select-name").val());
        $("#select-id").val($("#hidden-select-id").val());

        if (myjs.isNull(save.typeId))
            return;

        var url = Constant.getUrl("/breed/get");
        var params = {};

        params["typeId"] = save.typeId;

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.succeed)
            {
                data = data.result;
                $("#type-name").val(data["typeName"]);
                $("#select-name").val(data["selectName"]);
                $("#select-id").val(data["selectId"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.path + "/breed/save" + Constant.suffix;
        var params = {};

        if (!myjs.isNull(save.typeId))
        {
            url = Constant.path + "/breed/update" + Constant.suffix;
            params["typeId"] = save.typeId;
        }

        params["typeName"] =  $("#type-name").val().trim();
        params["selectId"] = $("#select-id").val().trim();
        params["selectName"] =  $("#select-name").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
                save.back();
        });
    },

    back: function ()
    {
        index.loadTypeList();
    },
};