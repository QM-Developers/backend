import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SysCustomerAccountTest
{
    private static final String PREFIX = "/customer/account/";

    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
//        String result = save(client);
//        String result = listByApprove(client);
//        String result = updateRefuse(client);
        String result = updateAccept(client);

        System.out.println(result);
    }

    private static String save(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "save" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("customerId", "9a5fcadc7fc643bb8e181598a2fd2833");
        form.param("customerName", "五五");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String listByApprove(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "listByApprove" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("pageNum", "1");
        form.param("pageSize", "10");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String updateRefuse(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "updateRefuse" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("accountId", "25a1cbdb3ecd44bb81d7445308fd7ccb");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String updateAccept(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "updateAccept" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("accountId", "73b74dbb2efb4fc6983a7237baee3f90");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }
}
