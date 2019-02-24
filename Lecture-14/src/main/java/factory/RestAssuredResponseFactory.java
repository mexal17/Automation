package factory;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import constant.HttpMethodType;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredResponseFactory {

    private static final String TOKEN = "2ec8d0055afbe6924a8f9ff143838a9c5c02535d";
    private static final String URI_COLLABORATORS = "https://api.github.com/repos/mexal17/Lecture-2/collaborators";
    private static final String URI_SEND_INVITATION = "https://api.github.com/repos/mexal17/Lecture-2/collaborators/user5";
    private static RequestSpecification requestSpecification;

    private RestAssuredResponseFactory() {
    }

    private static void setup() {
        if (requestSpecification == null) {
            RestAssured.baseURI = "https://api.github.com";
            requestSpecification = given().auth().oauth2(TOKEN);
        }
    }

    public static Response getResponse(HttpMethodType methodType) {
        switch (methodType) {
            case GET:
                setup();
                return requestSpecification.get(URI_COLLABORATORS);
            case PUT:
                setup();
                return requestSpecification.put(URI_SEND_INVITATION);
            default:
                throw new IllegalArgumentException("Method type is not supported");
        }
    }
}
