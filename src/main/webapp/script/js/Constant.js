var Constant = {
    path: "/backend",
    suffix: ".action",
    succeed: 100,
    failed_102:102,
    administrator:"super",

    text:"text",
    number:"number",

    getUrl: function (url)
    {
        return Constant.path + url + Constant.suffix;
    },
};