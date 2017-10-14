var save = {
    item:{
        request:$("#request-list"),
        response:$("#response-list"),
        responseExample:$("#response-example"),
        requestExample:$("#request-example"),
    },

    init: function ()
    {

    },

    save:function ()
    {
        var url = Constant.getUrl("/interface/save");
        var params = {};

        params["infoId"] = $("#info-id").val().trim();
        params["infoName"] = $("#info-name").val().trim();
        params["infoPath"] = $("#info-path").val().trim();
        params["infoMethod"] = $("#info-method").val().trim();
        params["intoFormat"] = $("#info-format").val().trim();
        params["infoRemark"] = $("#info-remark").val().trim();
        params["typeId"] = $("#hidden-interface-type-id").val().trim();
        params["update"] = $("#update").val().trim();
        params["request"] = JSON.stringify(save.getRequest());
        params["response"] = JSON.stringify(save.getResponse());

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.permission_denied)
            {
                alert("权限不足");
                return;
            }
            if (data.state === Constant.succeed)
                save.back();
            else
                console.log(data);
        });
    },

    appendRequestItem: function (name, type, must, text)
    {
        name = myjs.isNull(name) ? "" : name;
        text = myjs.isNull(text) ? "" : text;
        var item = '<tr>' +
            '<td><input type="text" value="' + name + '"></td>' +
            '<td>' +
            '<select>' +
            '<option ' + ("String" === type ? "selected" : "") + '>String</option>' +
            '<option ' + ("Integer" === type ? "selected" : "") + '>Integer</option>' +
            '<option ' + ("Float" === type ? "selected" : "") + '>Float</option>' +
            '<option ' + ("Boolean" === type ? "selected" : "") + '>Boolean</option>' +
            '<option ' + ("Array" === type ? "Array" : "") + '>Array</option>' +
            '<option ' + ("Object" === type ? "Object" : "") + '>Object</option>' +
            '</select>' +
            '</td>' +
            '<td>' +
            '<select>' +
            '<option ' + ("must" === type ? "selected" : "") + '>是</option>' +
            '<option ' + ("must" === type ? "selected" : "") + '>否</option>' +
            '</select>' +
            '</td>' +
            '<td><input type="text"></td>' +
            '<td><span onclick="save.removeRequestItem(this)">删除</span></td>' +
            '</tr>';

        save.item.request.append(item);
    },

    appendResponseItem:function (name, type, text)
    {
        name = myjs.isNull(name) ? "" : name;
        text = myjs.isNull(text) ? "" : text;
        var item = '<tr>' +
            '<td><input type="text" value="' + name + '"></td>' +
            '<td>' +
            '<select>' +
            '<option ' + ("String" === type ? "selected" : "") + '>String</option>' +
            '<option ' + ("Integer" === type ? "selected" : "") + '>Integer</option>' +
            '<option ' + ("Float" === type ? "selected" : "") + '>Float</option>' +
            '<option ' + ("Boolean" === type ? "selected" : "") + '>Boolean</option>' +
            '<option ' + ("Array" === type ? "Array" : "") + '>Array</option>' +
            '<option ' + ("Object" === type ? "Object" : "") + '>Object</option>' +
            '</select>' +
            '</td>' +
            '<td><input type="text"></td>' +
            '<td><span onclick="save.removeRequestItem(this)">删除</span></td>' +
            '</tr>';

        save.item.response.append(item);
    },

    showRequestExample:function (val)
    {
        val = JSON.parse(val);
        save.item.requestExample.html((syntaxHighlight(val)));
    },

    showResponseExample:function (val)
    {
        val = JSON.parse(val);
        save.item.responseExample.html((syntaxHighlight(val)));
    },

    removeRequestItem: function (item)
    {
        $(item).parents("tr:eq(0)").remove();
    },

    back:function ()
    {
        index.loadInterfaceList();
    },

    getRequest:function ()
    {
        var request = [];
        var tr = $("#request-list tr");

        for (var i = 0; i < tr.length; i++)
            request.push(getValue(tr[i]),i);

        function getValue(item,i)
        {
            var tds = $(item).find("td");
            var standard = {};
            standard["requestName"] = $(tds[0]).find("input").val();
            standard["requestType"] = $(tds[1]).find("select").val();
            standard["requestMust"] = $(tds[2]).find("select").val();
            standard["requestText"] = $(tds[3]).find("input").val();
            standard["sort"] = i;
            return standard;
        }

        return request;
    },

    getResponse:function ()
    {
        var response = [];
        var tr = $("#response-list tr");

        for (var i = 0; i < tr.length; i++)
            response.push(getValue(tr[i]),i);

        function getValue(item,i)
        {
            var tds = $(item).find("td");
            var standard = {};
            standard["responseName"] = $(tds[0]).find("input").val();
            standard["responseType"] = $(tds[1]).find("select").val();
            standard["responseText"] = $(tds[2]).find("input").val();
            standard["sort"] = i;
            return standard;
        }

        return response;
    },
};
