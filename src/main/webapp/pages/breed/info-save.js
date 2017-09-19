var save = {
    infoId: "",

    init: function ()
    {
        save.getUser();
    },

    getUser: function ()
    {
        save.infoId = $("#hidden-info-id").val();
        $("#select-id").val($("#hidden-select-id").val());
        $("#select-name").val($("#hidden-select-name").val());

        if (myjs.isNull(save.infoId))
            return;

        var url = Constant.getUrl("/breed/info/get");
        var params = {};

        params["infoId"] = save.infoId;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
            {
                data = data.result;
                $("#info-name").val(data["infoName"]);
                $("#info-type").val(data["infoType"]);
            }
        });
    },

    save: function ()
    {
        var url = Constant.path + "/breed/info/save" + Constant.suffix;
        var params = {};

        if (!myjs.isNull(save.infoId))
        {
            url = Constant.path + "/breed/info/update" + Constant.suffix;
            params["infoId"] = save.infoId;
        }

        params["infoName"] = $("#info-name").val().trim();
        params["infoType"] = $("#info-type").val().trim();
        params["selectId"] = $("#select-id").val().trim();
        params["selectName"] = $("#select-name").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.succeed)
                save.back();
        });
    },

    back: function ()
    {
        index.loadInfoList();
    },
};