package Api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import properties.Properties;

import static io.restassured.RestAssured.given;

public class TallestCharacterNewerFilmTest {


    @BeforeEach
    public void setUp() {
        Properties.loadProperties("site.properties");
        RestAssured.baseURI = Properties.getPropertyValue("api_url");

    }

    @Test
    @DisplayName("TestCase2")
    public void TallestCharacterNewerFilmTest2() {

        int tallestHeight = 0;
        String tallestCharacterName = "";


        Response response = given()
                .when()
                .get("/films/")
                .then()
                .extract().response();


        String latestTitle = response.jsonPath().getString("results.max { it.release_date }.title");
        String latestUrl = response.jsonPath().getString("results.max { it.release_date }.url");
        String characters = response.jsonPath().getString("results.max { it.release_date }.characters");


        System.out.println("Latest Film Title: " + latestTitle);
        System.out.println("Latest Film URL: " + latestUrl);
        System.out.println("Latest Film characters: " + characters);

        String[] urls = characters.replaceAll("[\\[\\]\\s]", "").split(",");

        for (String path : urls) {
            String valueWithoutPrefix = path.replace("https://swapi.dev/api/", "/");
            valueWithoutPrefix = valueWithoutPrefix.substring(0, valueWithoutPrefix.length() - 1); // Remove trailing comma

            Response resp = given()
                    .when()
                    .get(valueWithoutPrefix)
                    .then()
                    .extract().response();

            String characterHeightString = resp.jsonPath().getString("height");
            String characterName = resp.jsonPath().getString("name");
            System.out.println("characterHeightString"+characterHeightString);
            int characterHeight = Integer.parseInt(characterHeightString);

            if (characterHeight > tallestHeight) {
                tallestHeight = characterHeight;
                tallestCharacterName = characterName;

            }
        }

        System.out.println("Tallest Character Name: " + tallestCharacterName);
        System.out.println("Tallest Character's Height: " + tallestHeight);




    }


}
