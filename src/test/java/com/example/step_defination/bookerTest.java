package com.example.step_defination;

import com.example.api.apiUtilites;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class bookerTest {

    private Response response;

    @Given("the booking API is available")
    public void the_booking_api_is_available() {
        response = apiUtilites.get("/ping");
        response.then().statusCode(201);
    }

    @When("a user requests all bookings")
    public void a_user_requests_all_bookings() {
        response = apiUtilites.get("/booking");
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain bookings")
    public void the_response_should_contain_bookings() {
        response.then().body("size()", greaterThan(0));
    }

    // Steps for POST, PUT ve DELETE functionality
    @When("a user creates a new booking with the following JSON data:")
    public void a_user_creates_a_new_booking_with_json(String jsonData) {
        response = apiUtilites.post("/booking", jsonData);
    }


    @Then("the booking should be created successfully")
    public void the_booking_should_be_created_successfully() {
        response.then().statusCode(200).body("bookingid", notNullValue());
    }

    @When("a user updates the booking with id {int} with the following JSON data:")
    public void a_user_updates_the_booking_with_id_with_json(int bookingId, String jsonData) {
        response = apiUtilites.put("/booking/" + bookingId, jsonData);
    }

    @Then("the booking should be updated successfully")
    public void the_booking_should_be_updated_successfully() {
        response.then().statusCode(200).body("booking", notNullValue());
    }

    @When("a user deletes the booking with id {int}")
    public void a_user_deletes_the_booking_with_id(int bookingId) {
        response = apiUtilites.delete("/booking/" + bookingId);
    }

    @Then("the booking should be deleted successfully")
    public void the_booking_should_be_deleted_successfully() {
        response.then().statusCode(201);
    }
}