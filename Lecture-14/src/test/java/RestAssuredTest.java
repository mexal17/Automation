import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredTest {
    private static final String COLLABORATORS_END_POINT = "/repos/mexal17/Lecture-2/collaborators";
    private static final String TOKEN = "449c1987dae64cf9d9fac91ff7903268549beba5";
    private RequestSpecification requestSpecification;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.github.com";
        requestSpecification = given().auth().oauth2(TOKEN);
    }

    @Test
    public void showCollaboratorsTest() {
        Response response = requestSpecification.get(COLLABORATORS_END_POINT);
        System.out.println("List collaborators:\n");
        GitUser[] arrayGitUsers = response.getBody().as(GitUser[].class);
        System.out.println(Arrays.toString(arrayGitUsers));
    }

    @Test
    public void sendInvitationTest() {
        Response response = requestSpecification.put(COLLABORATORS_END_POINT + "/user1");
        System.out.println("Response status for 'Add user as a collaborator' invitation:\n" + response.getStatusLine()
                + "\nResponse body for 'Add user as a collaborator' invitation:\n" + response.asString());
    }
}