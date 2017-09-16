import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SysCustomerTest
{
    private static final String PREFIX = "/customer/";

    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
        String result = save(client);
//        String result = update(client);
//        String result = list(client);
//        String result = get(client);
//        String result = remove(client);

        System.out.println(result);
    }

    private static String save(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "save" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("customerName", "五五");
        form.param("customerPhone", "13599996666");
        form.param("teamId", "10086");
        form.param("teamName", "中国移动通信");
        form.param("teamCreateDate", "2017-1-10");
        form.param("teamArea", "鹤山市");
        form.param("teamAddress", "文化路181号露露商店旁");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String update(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "update" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("customerId", "234179164b8946f09e1e4953a29fb61f");
        form.param("customerName", "六六");
        form.param("customerPhone", "13566666666");
        form.param("customerSex", "男");

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
        form.param("customerId", "a907bb1c229a404889d5114b691cb307");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String remove(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "remove" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("customerId", "234179164b8946f09e1e4953a29fb61f");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }
}
