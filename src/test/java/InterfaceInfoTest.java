import com.alibaba.fastjson.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;

public class InterfaceInfoTest
{
    private static final String PREFIX = "/interface/";

    public static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();
        String result = tree(client);

        System.out.println(result);
    }

    private static String tree(Client client)
    {
        String url = UrlConstant.BASE_URL + PREFIX + "tree" + UrlConstant.SUFFIX;

        JSONObject json = new JSONObject();

        json.put("userId","5198012fab4d45be806393acaded43ae");
        json.put("token","1");

        System.out.println(json.toJSONString());

        Form form = new Form();
        for (String s: json.keySet())
            form.param(s,json.getString(s));

        WebTarget target = client.target(url);

        return target.request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED), String.class);
    }
}
