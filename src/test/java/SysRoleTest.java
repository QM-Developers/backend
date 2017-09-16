import com.qm.backend.util.CryptographyUtil;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SysRoleTest
{
    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
//        String result = save(client);
//        String result = update(client);
        String result = list(client);
//        String result = get(client);

        System.out.println(result);
    }

    private static String save(Client client)
    {
        String url = UrlConstant.BASE_URL + "/role/save.action";

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("roleName", "业务员");
        form.param("roleText", "拥有客户管理权限");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String update(Client client)
    {
        String url = UrlConstant.BASE_URL + "/role/update.action";

        Form form = new Form();
        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("roleId", "b03407084ffe4f05b04d80992e5a7362");
        form.param("roleName", "游客");
        form.param("roleText", "没有任何权限");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String list(Client client)
    {
        String url = UrlConstant.BASE_URL + "/role/list.action";

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
        String url = UrlConstant.BASE_URL + "/role/get.action";

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("roleId", "b03407084ffe4f05b04d80992e5a7362");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }
}
