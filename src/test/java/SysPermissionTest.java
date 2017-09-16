import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SysPermissionTest
{
    private static final String PREFIX = "/permission/";

    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
//        String result = save(client);
//        String result = update(client);
//        String result = list(client);
        String result = get(client);

        System.out.println(result);
    }

    private static String save(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "save" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("permissionName", "测试权限");
        form.param("permissionUrl", "");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String update(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "update" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("permissionId", "8821044b28b040e5972167e53704da9e");
        form.param("permissionName", "测试");
        form.param("permissionUrl", "1123");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String list(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "list" + UrlConstant.SUFFIX;

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
        String url = UrlConstant.BASE_URL + PREFIX + "get" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("permissionId", "8821044b28b040e5972167e53704da9e");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }
}
