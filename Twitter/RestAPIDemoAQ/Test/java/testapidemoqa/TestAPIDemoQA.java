package testapidemoqa;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAPIDemoQA {

    @Test(priority = 1)
    public void getWeatherDetails() {

        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        //Request object
        RequestSpecification httprequest = RestAssured.given();
        //Response object
        Response response = httprequest.request(Method.GET, "/New York");
        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        //Status line verification
        String sttausLine = response.getStatusLine();
        System.out.println("Status Line is :" + sttausLine);
        Assert.assertEquals(sttausLine, "HTTP/1.1 200 OK");
    }

    @Test (priority = 2)
    void RegistrationSuccessful(){

        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";
        //Request object
        RequestSpecification httpRequest = RestAssured.given();
        //Response Object
        //Request payload sending along with post request
        JSONObject requestParam = new JSONObject();
        requestParam.put("FirstName", "PNT");
        requestParam.put("LastName", "NY");
        requestParam.put("UserName", "PNTNY1");
        requestParam.put("Password", "PNT1234");
        requestParam.put("Email", "PNT1234@gmail.com");
        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParam.toJSONString()); //Attach above data to the request
        //Response object
        Response response = httpRequest.request(Method.POST, "/register");
        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 201);
        //Success code validation
        String successCode = response.jsonPath().get("SuccessCode");
        Assert.assertEquals(successCode,"OPERATION_SUCCESS");

    }
    //GET_Request
    @Test(priority = 3)
    void googleMapTest(){

        RestAssured.baseURI = "http://maps.googleapis.com";
        //Request object
        RequestSpecification httprequest = RestAssured.given();
        //Response object
        Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response body is:" + responseBody);
        //capture details of headers from response
        String contentType= response.header("content-Type");
        System.out.println("content type is "+ contentType);
    }
    //Get Request Print All Header
    @Test(priority = 4)
    public void GetWeatherDetails(){

        RestAssured.baseURI = "https://maps.googleapis.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is" + responseBody);
        Headers allHeaders = response.headers();
        for(Header header: allHeaders){
            System.out.println(header.getName());
            System.out.println(header.getValue());
        }
    }
    //GET_Request_Authorization
    @Test (priority = 5)
    public void AuthorizationTest(){

        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        //Basic authentication
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("ToolsQA");
        authScheme.setPassword("TestPassword");
        RestAssured.authentication = authScheme;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "/");
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        String statusLine = response.getStatusLine();
        System.out.println("status line is:" + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }



}
