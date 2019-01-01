package rest.client;

import constant.LibraryType;
import factory.ClientFactory;
import model.GitUser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.RestRepositoryService;

import java.util.List;

public class RestClientTest {

    @DataProvider
    public Object[] repositoryServices() {
        return new Object[]{new RestRepositoryService(ClientFactory.getInstance(LibraryType.APACHE_HTTP)),
                new RestRepositoryService(ClientFactory.getInstance(LibraryType.REST_ASSURED))};
    }

    @Test(dataProvider = "repositoryServices")
    public void getCollaboratorsTest(RestRepositoryService repositoryService) {
        List<GitUser> collaborators = repositoryService.getCollaborators();
        System.out.println("-> " + repositoryService.getRestClient().getType() + " library: collaborators = " + collaborators);
        Assert.assertEquals(repositoryService.getGitHubResponseFromGet().getStatusCode(), 200);
    }

    @Test(dataProvider = "repositoryServices")
    public void sendInvitationTest(RestRepositoryService repositoryService) {
        String invitation = repositoryService.sendInvitation();
        System.out.println("-> " + repositoryService.getRestClient().getType() + " library:\n" + invitation);
        Assert.assertEquals(repositoryService.getGitHubResponseFromPut().getStatusCode(), 201);
    }
}
