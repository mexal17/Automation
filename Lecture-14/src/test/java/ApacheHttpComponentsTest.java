import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class ApacheHttpComponentsTest {

    private static final String URI_COLLABORATORS = "https://api.github.com/repos/mexal17/Lecture-2/collaborators";
    private static final String TOKEN = "449c1987dae64cf9d9fac91ff7903268549beba5";
    private CloseableHttpClient httpclient;

    @BeforeClass
    public void setup() {
        httpclient = HttpClients.custom().build();
    }

    @Test
    public void showCollaboratorsTest() throws IOException, URISyntaxException {
        URIBuilder builderColl = new URIBuilder(URI_COLLABORATORS);
        builderColl.setParameter("access_token", TOKEN);
        HttpGet httpGetColl = new HttpGet(builderColl.build());
        System.out.println("\n Request: \n" + httpGetColl.getRequestLine());
        CloseableHttpResponse responseColl = httpclient.execute(httpGetColl);
        System.out.println("\n Response Status:\n" + responseColl.getStatusLine());
        HttpEntity entityColl = responseColl.getEntity();
        List<GitUser> gitUsers = Arrays.asList(new ObjectMapper().readValue(EntityUtils.toString(entityColl), GitUser[].class));
        System.out.println("\n List of Collaborators:\n" + gitUsers);
    }

    @Test
    public void sendInvitationTest() throws URISyntaxException, IOException {
        URIBuilder builderUser = new URIBuilder(URI_COLLABORATORS + "/user5");
        builderUser.setParameter("access_token", TOKEN);
        HttpPut httpPutUser = new HttpPut(builderUser.build());
        System.out.println("\n Request: \n" + httpPutUser.getRequestLine());
        CloseableHttpResponse responseAddUser = httpclient.execute(httpPutUser);
        HttpEntity entity = responseAddUser.getEntity();
        System.out.println("\n Response status:\n" + responseAddUser.getStatusLine());
        System.out.println("\n Response body:\n" + EntityUtils.toString(entity));
    }
}