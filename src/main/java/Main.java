import model.User;
import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 07/03/14
 * Time: 15:49
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        Main tc = new Main();
       // tc.firstConnection();
        tc.getFileInfo();


    }

    public void getFileInfo() {
        String email = "2";
        String fileName = "a";

        ClientRequest request = new ClientRequest("http://localhost:8080/userService/getDocumentInfo");
        request.accept("application/json");

        String input = "{\"receiverName\":" +
                "\"" + email +
                "\",\"fileName\":\"" + fileName +
                "\"}"  ;

                System.out.println(input);
        request.body("application/json", input);
        ClientResponse<String> response = null;
        try {
            response = request.post(String.class);

            String resultSTR = response.getEntity();

           System.out.println(resultSTR);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (response.getStatus() != 201) {

            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

        }


    }

    public void firstConnection() {

        User u1 = new User();
        u1.setUserEmailAddress("aa");
        u1.setUserName("bb");

        try {


            ClientRequest request = new ClientRequest("http://localhost:8080/userService/generateSignature");
            request.accept("application/json");

            String input = "{\"userEmailAddress\":\"aa\",\"userName\":\"bb\"}";
            request.body("application/json", input);

            ClientResponse<String> response = request.post(String.class);
            if (response.getStatus() != 201) {

                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

            }


            BufferedReader br = new BufferedReader(new InputStreamReader(
                    new ByteArrayInputStream(response.getEntity().getBytes())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
