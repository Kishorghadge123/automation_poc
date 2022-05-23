package api.patchDataValidation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.APIUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class PatchRequestTest {
    String end_point;
    @BeforeClass
    public void startUp() throws IOException {
        APIUtils.readAPIConfigs();
        APIUtils.setBaseURL();
    }
    @AfterClass
    public void delete() throws IOException {
        Response response = APIUtils.deleteRequest(end_point);
        Assert.assertEquals(response.getStatusCode(),204,"status code mismatch");
        System.out.println("User Deleted Successfully");
    }
    @Feature("API Test")
    @Story("API-001: api test for update user functionality")
    @Description("to test user is updated when update user api is called")
    @Test(description = "to verify user is updated when update user api is called")
    public void test_user_updated_successfully_using_patch_api_method1_body_from_json_file() throws Exception {

        end_point = APIUtils.api_config.getProperty("create_user_end_point");
        String body = Files.readString(Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\api_test_data\\CreateUserJsonBody.json"), StandardCharsets.US_ASCII);

        Response response = APIUtils.postRequest(end_point,body);
        System.out.println("User Created Successfully");

        Assert.assertEquals(response.getStatusCode(),201,"status code mismatch");

        String id =  response.getBody().jsonPath().getJsonObject("id").toString();

        System.out.println(id);

        end_point = APIUtils.api_config.getProperty("create_user_end_point")+"/"+id;
        body = Files.readString(Path.of(System.getProperty("user.dir") + "\\src\\test\\resources\\api_test_data\\patchMethodDataJsonBody.json"), StandardCharsets.US_ASCII);

        response = APIUtils.patchRequest(end_point,body);

        System.out.println("User Updated successfully");

        Assert.assertEquals(response.getStatusCode(),200,"status code mismatch");

//        String id =  response.getBody().jsonPath().getJsonObject("id").toString();
        String name =  response.getBody().jsonPath().getJsonObject("name").toString();
        System.out.println(name);
        String email =  response.getBody().jsonPath().getJsonObject("email").toString();
        System.out.println(email);
        String gender =  response.getBody().jsonPath().getJsonObject("gender").toString();
        System.out.println(gender);
        String status =  response.getBody().jsonPath().getJsonObject("status").toString();
        System.out.println(status);

        JsonMapper mapper = new JsonMapper();
        System.out.println(mapper);
        JsonNode node = mapper.readValue(body, JsonNode.class);

//        // method - 2
//        Assert.assertEquals(name, node.get("name").asText(),"name mismatch");
//        Assert.assertEquals(email, node.get("email").asText(),"email mismatch");
//        Assert.assertEquals(gender, node.get("gender").asText(),"gender mismatch");
//        Assert.assertEquals(status, node.get("status").asText(), "status mismatch");
    }
}
