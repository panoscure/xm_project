package Api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import properties.Properties;

import static io.restassured.RestAssured.given;

public class TallestCharacterStarWarsEverTest {


    @BeforeEach
    public void setUp() {
        Properties.loadProperties("site.properties");
        RestAssured.baseURI = Properties.getPropertyValue("api_url");

    }

    @Test
    @DisplayName("TestCase3")
    public void TallestCharacterStarWarsEverTest3() {

        int tallestHeight = 0;
        int characterHeight = 0;
        String tallestCharacterName = "";


        Response response = given()
                .when()
                .get("/films/")
                .then()
                .extract().response();


        String title = response.jsonPath().getString("results.title");
        String characters = response.jsonPath().getString("results.characters");
        System.out.println("Title: "+title);


        System.out.println("characters: " + characters);

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
            try{
                characterHeight = Integer.parseInt(characterHeightString);
            }
            catch(Exception e){
                System.out.println("Wrong Height Value");
            }

            if (characterHeight > tallestHeight) {
                tallestHeight = characterHeight;
                tallestCharacterName = characterName;

            }
        }

        System.out.println("Tallest Character Name: " + tallestCharacterName);
        System.out.println("Tallest Character's Height: " + tallestHeight);


    }


}
