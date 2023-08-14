package Api;


import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import properties.Properties;


import static io.restassured.RestAssured.given;

public class PeopleSchemaValidationTest {


    @BeforeEach
    public void setUp() {
        Properties.loadProperties("site.properties");
        RestAssured.baseURI = Properties.getPropertyValue("api_url");

    }

    @Test
    @DisplayName("TestCase4")
    public void PeopleSchemaValidationTest4() {



        String schemaFilePath = getClass().getResource("/SchemaPeople.json").getPath();
        System.out.println("Schema file path: " + schemaFilePath);



        String jsonSchemaPath = "src/test/resources/SchemaPeople.json"; // Replace with actual path
        String jsonSchema = TestUtils.readJsonFile(jsonSchemaPath);

        // Make the API call and get the response
        Response response = RestAssured.given()
                .when()
                .get("/people/1/")
                .then()
                .extract()
                .response();

        // Perform JSON schema validation using the provided schema
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

        System.out.println("JSON schema validation successful!");



    }


}
