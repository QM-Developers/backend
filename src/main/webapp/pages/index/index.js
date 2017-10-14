var index = {
    modalPassword: $("#modal-password"),

    init: function ()
    {

    },

    load: function (url)
    {
        $("#admin-content").load(url);
    },

    loadUserSave: function ()
    {
        index.load('../user/user-save.html');
    },

    loadUserList: function ()
    {
        index.load('../user/user-list.html');
    },

    loadRoleList: function ()
    {
        index.load('../role/role-list.html');
    },

    loadRoleSave: function ()
    {
        index.load('../role/role-save.html');
    },

    loadPermissionSave: function ()
    {
        index.load('../permission/permission-save.html');
    },

    loadPermissionList: function ()
    {
        index.load('../permission/permission-list.html');
    },

    loadTypeList: function ()
    {
        index.load('../breed/type-list.html');
    },

    loadTypeList2: function ()
    {
        $("#hidden-type-id").val("");
        $("#hidden-type-name").val("");
        $("#hidden-select-id").val("");
        $("#hidden-select-name").val("");
        index.loadTypeList();
    },

    loadTypeSave: function ()
    {
        index.load('../breed/type-save.html');
    },

    loadSelectList: function ()
    {
        index.load('../breed/select-list.html');
    },

    loadSelectSave: function ()
    {
        index.load('../breed/select-save.html');
    },

    loadInfoList: function ()
    {
        index.load('../breed/info-list.html');
    },

    loadInfoSave: function ()
    {
        index.load('../breed/info-save.html');
    },

    loadCustomerSave: function ()
    {
        index.load('../customer/customer-save.html');
    },

    loadCustomerList: function ()
    {
        index.load('../customer/customer-list.html');
    },

    loadApplyList: function ()
    {
        index.load('../customer/apply-list.html');
    },

    loadApproveList: function ()
    {
        index.load('../customer/approve-list.html');
    },

    showPasswordModal: function ()
    {
        index.modalPassword.modal({'closeOnConfirm': false, 'closeViaDimmer': false});
    },

    updatePassword:function ()
    {
        var p1 = $("#password1").val().trim();
        var p2 = $("#password2").val().trim();

        if (p1 !== p2)
        {
            alert("两次输入不一致");
            return;
        }

        var url = Constant.getUrl("/password/update");
        var params = {};

        params["userPassword"] = md5(p1);

        myjs.ajax_post(url,params,function (data)
        {
            if (data.state === Constant.permission_denied)
                alert("权限不足");
            if (data.state === Constant.succeed)
            {
                alert("修改成功");
                index.modalPassword.modal("close");
            }
        });
    },

    loadGoodsTypeList:function ()
    {
        index.load("../goods/type-list.html");
    },

    loadQMPermission:function ()
    {
        index.load("../qm_permission/qm-permission-list.html");
    },

    loadQMRoleList:function ()
    {
        index.load("../qm_role/qm-role-list.html");
    },

    loadQMRoleSave:function ()
    {
        index.load("../qm_role/qm-role-save.html");
    },

    loadInterfaceList:function ()
    {
        index.load("../interface/interface-list.html");
    },

    loadInterfaceType:function ()
    {
        index.load("../interface/type/list.html");
    },

    loadInterfaceSave:function ()
    {
        index.load("../interface/interface-save.html");
    }
};