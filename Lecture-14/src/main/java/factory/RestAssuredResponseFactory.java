package factory;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import constant.HttpMethodType;

import static com.jayway.restassured.RestAssured.given;

public class RestAssuredResponseFactory {

    private static final String TOKEN = "9831d26fead1dcb4cd9419a9107a84555742f0a3";
    private static RequestSpecification requestSpecification;

    private RestAssuredResponseFactory() {
    }

    private static void setup() {
        if (requestSpecification == null) {
            RestAssured.baseURI = "https://api.github.com";
            requestSpecification = given().auth().oauth2(TOKEN);
        }
    }

    public static Response generateRequest(String url, HttpMethodType methodType) {
        switch (methodType) {
            case GET: {
                setup();
                return requestSpecification.get(url);
            }
            case PUT: {
                setup();
                return requestSpecification.put(url);
            }
            default: {
                return null;
            }
        }
    }
}
