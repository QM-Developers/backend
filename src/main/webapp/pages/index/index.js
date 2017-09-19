var index = {
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

    loadPermissionSave:function ()
    {
        index.load('../permission/permission-save.html');
    },

    loadPermissionList:function ()
    {
        index.load('../permission/permission-list.html');
    },

    loadTypeList:function ()
    {
        index.load('../breed/type-list.html');
    },

    loadTypeList2:function ()
    {
        $("#hidden-type-id").val("");
        $("#hidden-type-name").val("");
        $("#hidden-select-id").val("");
        $("#hidden-select-name").val("");
        index.loadTypeList();
    },

    loadTypeSave:function ()
    {
        index.load('../breed/type-save.html');
    },

    loadSelectList:function ()
    {
        index.load('../breed/select-list.html');
    },

    loadSelectSave:function ()
    {
        index.load('../breed/select-save.html');
    },

    loadInfoList:function ()
    {
        index.load('../breed/info-list.html');
    },

    loadInfoSave:function ()
    {
        index.load('../breed/info-save.html');
    },
};