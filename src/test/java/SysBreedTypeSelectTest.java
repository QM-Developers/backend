import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SysBreedTypeSelectTest
{
    private static final String PREFIX = "/breed/select/";

    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
//        String result = save(client);
        String result = list(client);

        System.out.println(result);
    }

    private static String save(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "save" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("selectName", "自繁自养");
        form.param("typeId", "c03c63175e234b7cbd7b46307cdfd46e");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }

    private static String list(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "list" + UrlConstant.SUFFIX;

        Form form = new Form();

        form.param("userId", "5198012fab4d45be806393acaded43ae");
        form.param("token", "1");
        form.param("typeId", "65053460a17a450f91b8c26b3ae3e751");
        form.param("pageNum", "1");
        form.param("pageSize", "10");

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }
}
