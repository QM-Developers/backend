var list = {

    init: function ()
    {
        list.tree();

        $('#doc-tab-demo-1').tabs({noSwipe: 1});

        var id = $("#hidden-interface-id").val();
        if (!myjs.isNull(id))
            list.getInterface(id);
    },

    tree: function ()
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
        $("#hidden-interface-id").val("");
        index.loadInterfaceSave();
    },

    onClick: function (event, treeId, treeNode)
    {
        if (treeNode.isParent)
            return;

        list.getInterface(treeNode.id);
    },

    getInterface: function (id)
    {
        var url = Constant.getUrl("/interface/get");
        var params = {};

        params["infoId"] = id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
            {
                data = data.result;

                $("#i-name").text(data["infoName"]);
                $("#i-url").text(data["infoPath"]);
                $("#i-method").text(data["infoMethod"]);
                $("#i-remark").text(data["infoRemark"]);
                $("#i-format").text(data["intoFormat"]);
                if (myjs.isNull(!data["requestExample"]))
                    $("#request-example").html(syntaxHighlight(JSON.parse(data["requestExample"])));
                if (myjs.isNull(!data["responseExample"]))
                    $("#response-example").html(syntaxHighlight(JSON.parse(data["responseExample"])));

                $("#i-request").empty();
                $("#i-response").empty();
                for (var i = 0; i < data["requestList"].length; i++)
                    list.appendRequest(data["requestList"][i]);

                for (var i = 0; i < data["responseList"].length; i++)
                    list.appendResponse(data["responseList"][i]);
            }
        });
    },

    appendRequest: function (data)
    {
        var item = '<tr>' +
            '<td>' + data["requestName"] + '</td>' +
            '<td>' + data["requestType"] + '</td>' +
            '<td>' + data["requestMust"] + '</td>' +
            '<td>' + data["requestText"] + '</td>' +
            '</tr>';
        $("#i-request").append(item);
    },

    appendResponse: function (data)
    {
        var item = '<tr>' +
            '<td>' + data["responseName"] + '</td>' +
            '<td>' + data["responseType"] + '</td>' +
            '<td>' + data["responseText"] + '</td>' +
            '</tr>';
        $("#i-response").append(item);
    },

    toUpdate: function ()
    {
        var treeObj = $.fn.zTree.getZTreeObj("type-tree");
        var nodes = treeObj.getSelectedNodes();

        if (myjs.isNull(nodes))
            return;

        if (nodes[0].isParent)
        {
            alert("请选择一个接口");
            return;
        }

        $("#hidden-interface-type-id").val("");
        $("#hidden-interface-id").val(nodes[0].id);

        index.loadInterfaceSave();
    },

    remove: function ()
    {
        var treeObj = $.fn.zTree.getZTreeObj("type-tree");
        var nodes = treeObj.getSelectedNodes();

        if (myjs.isNull(nodes))
        {
            alert("请选择一个接口");
            return;
        }

        if (nodes[0].isParent)
        {
            alert("请选择一个接口");
            return;
        }

        if (!confirm("确定删除 " + nodes[0].name))
            return;

        var url = Constant.getUrl("/interface/remove");
        var params = {};

        params["infoId"] = nodes[0].id;

        myjs.ajax_post(url, params, function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            else if (data.state === Constant.succeed)
            {
                list.tree();
            }
        });
    },

    toUpdateInfo: function ()
    {
        index.loadInterfaceUpdateLog();
    }
};