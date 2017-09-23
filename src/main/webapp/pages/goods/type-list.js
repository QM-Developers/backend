var list = {
    init: function ()
    {
        list.listTypeTree();
    },

    listTypeTree: function ()
    {
        var url = Constant.getUrl("/goods/type/tree");
        var params = {};

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
            {
                data = data.result;
                var setting = {
                    data: {
                        simpleData: {enable: true},
                        key: {url: ''}
                    },
                    callback: {onClick: list.onClick}
                };
                $.fn.zTree.init($("#type-tree"), setting, data);
            }
        });
    },

    onClick: function (event, treeId, treeNode)
    {
        $("#type-id").val(treeNode.id);
        $("#type-name").val(treeNode.name);
        var pNode = treeNode.getParentNode();
        var item = "";

        if (!myjs.isNull(pNode))
            item += '<option value="' + pNode.id + '">' + pNode.name + '</option>';
        item += '<option value="0">无</option>';
        item += '<option value="' + treeNode.id + '">' + treeNode.name + '</option>';

        $("#type-pid").empty();
        $("#type-pid").append(item);
    },

    save: function ()
    {
        var url = Constant.getUrl("/goods/type/save");
        var params = {};

        params["goodsTypeName"] = $("#type-name").val().trim();
        params["goodsTypePid"] = $("#type-pid").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
                list.listTypeTree();
        });
    },

    update: function ()
    {
        var url = Constant.getUrl("/goods/type/update");
        var params = {};

        params["goodsTypeId"] = $("#type-id").val().trim();
        params["goodsTypeName"] = $("#type-name").val().trim();
        params["goodsTypePid"] = $("#type-pid").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
                list.listTypeTree();
        });
    },

    remove: function ()
    {
        var url = Constant.getUrl("/goods/type/remove");
        var params = {};

        params["goodsTypeId"] = $("#type-id").val().trim();

        myjs.ajax_post(url, params, function (data)
        {
            switch(data.state)
            {
                case Constant.permission_denied:
                    alert("权限不足");
                    break;
                case Constant.succeed:
                    list.listTypeTree();
                    break;
                case Constant.failed_102:
                    alert("不能删除有商品的类目");
                    break;
            }
        });
    },
};