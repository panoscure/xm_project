package Api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import properties.Properties;

import static io.restassured.RestAssured.given;

public class LatestReleasedFilmTest {


    @BeforeEach
    public void setUp() {
        Properties.loadProperties("site.properties");
        RestAssured.baseURI = Properties.getPropertyValue("api_url");

    }

    @Test
    @DisplayName("TestCase1")
    public void latestReleaseTest1() {

        Response response = given()
                .when()
                .get("/films/")
                .then()
                .extract().response();


        String latestTitle = response.jsonPath().getString("results.max { it.release_date }.title");

        System.out.println("Latest Film Title: " + latestTitle);



    }


}
