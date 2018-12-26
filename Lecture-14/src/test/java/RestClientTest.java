import constant.LibraryType;
import factory.ClientFactory;
import model.GitUser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.ApacheRepositoryService;
import service.RestAssuredRepositoryService;

import java.util.List;

public class RestClientTest {

    private ApacheRepositoryService apacheRepositoryService;
    private RestAssuredRepositoryService restAssuredRepositoryService;

    @BeforeClass
    public void setup() {
        apacheRepositoryService = new ApacheRepositoryService(ClientFactory.getInstance(LibraryType.APACHE_HTTP));
        restAssuredRepositoryService = new RestAssuredRepositoryService(ClientFactory.getInstance(LibraryType.REST_ASSURED));
    }

    @Test
    public void apacheGetCollaboratorsTest() {
        System.out.println("\n----------- Apache test ------------");
        List<GitUser> collaborators = apacheRepositoryService.getCollaborators();
        System.out.println("collaborators: " + collaborators);
        Assert.assertEquals(200, apacheRepositoryService.getGitHubResponseFromGet().getStatusCode());
    }

    @Test
    public void apacheSendInvitationTest() {
        System.out.println("\n----------- Apache test ------------");
        String invitation = apacheRepositoryService.sendInvitation();
        System.out.println("\n" + invitation);
        Assert.assertEquals(201, apacheRepositoryService.getGitHubResponseFromPut().getStatusCode());
    }

    @Test
    public void restAssuredGetCollaboratorsTest() {
        System.out.println("\n----------- RestAssured test ------------");
        List<GitUser> collaborators = restAssuredRepositoryService.getCollaborators();
        System.out.println("collaborators: " + collaborators);
        Assert.assertEquals(200, restAssuredRepositoryService.getGitHubResponseFromGet().getStatusCode());
    }

    @Test
    public void restAssuredSendInvitationTest() {
        System.out.println("\n----------- RestAssured test ------------");
        String invitation = restAssuredRepositoryService.sendInvitation();
        System.out.println("\n" + invitation);
        Assert.assertEquals(201, restAssuredRepositoryService.getGitHubResponseFromPut().getStatusCode());
    }

}
