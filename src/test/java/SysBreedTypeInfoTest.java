import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class SysBreedTypeInfoTest
{
    private static final String PREFIX = "/breed/info/";

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
        form.param("infoName", "自繁自养");
        form.param("infoType", "text");
        form.param("selectId", "1146ef65646f481eb2cec8eb76cbb53d");

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
}
