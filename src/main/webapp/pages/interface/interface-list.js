var list = {
    init: function ()
    {
        list.tree();
    },

    tree:function ()
    {
        var url = Constant.getUrl("/interface/tree");
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

    toSave: function ()
    {
        var treeObj = $.fn.zTree.getZTreeObj("type-tree");
        var nodes = treeObj.getSelectedNodes();

        if (myjs.isNull(nodes))
            return;

        if (!nodes[0].isParent)
        {
            alert("请选择一个接口分类");
            return;
        }

        $("#hidden-interface-type-id").val(nodes[0].id);
        index.loadInterfaceSave();
    },
};