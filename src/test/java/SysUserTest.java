import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qm.backend.constant.RoleConstant;
import com.qm.backend.util.CryptographyUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SysUserTest
{
    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
//        String result = save(client);
//        String result = update(client);
//        String result = list(client);
//        String result = get(client);
        String result = updateRole(client);

        System.out.println(result);
    }

    private static String save(Client client)
    {
        String url = UrlConstant.BASE_URL + "/user/save.action";

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("userName", "三三");
        form.param("userPhone", "13733336666");
        form.param("userPassword", "123456");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String update(Client client)
    {
        String url = UrlConstant.BASE_URL + "/user/update.action";

        Form form = new Form();
        form.param("memberId", "5198012fab4d45be806393acaded43ae");
        form.param("userPassword", CryptographyUtil.md5("123456", null));

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String list(Client client)
    {
        String url = UrlConstant.BASE_URL + "/user/list.action";

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("pageNum", "1");
        form.param("pageSize", "10");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String get(Client client)
    {
        String url = UrlConstant.BASE_URL + "/user/get.action";

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("memberId", "5198012fab4d45be806393acaded43ae");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String updateRole(Client client)
    {
        String url = UrlConstant.BASE_URL + "/user/updateRole.action";

        Form form = new Form();

        JSONArray arr = new JSONArray();
        JSONObject json = new JSONObject();
        json.put("roleId", RoleConstant.ADMINISTRATOR);

        arr.add(json);

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("memberId", "5198012fab4d45be806393acaded43ae");
        form.param("role", arr.toJSONString());

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }
}
