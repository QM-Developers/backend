var Constant = {
    path: "/backend",
    suffix: ".action",
    succeed: 100,
    failed_102: 102,
    permission_denied: 127,
    administrator: "super",

    account_waiting: 10,
    account_accept: 11,
    account_refuse: 12,

    text: "text",
    number: "number",

    getUrl: function (url)
    {
        return Constant.path + url + Constant.suffix;
    },
};