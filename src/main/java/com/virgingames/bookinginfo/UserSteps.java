package com.virgingames.bookinginfo;


import com.virgingames.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class UserSteps {

    @Step("Getting all users of Bingo")
    public ValidatableResponse getAllUsersOfBingo(){
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_USERS)
                .then();
    }
    @Step("Getting all users of Bingo with query parameters")
    public ValidatableResponse getUsersWithQueryParams(String queryParamskey, String queryParamsValue){
        return SerenityRest.given().log().ifValidationFails()
                .when()
                .queryParams(queryParamskey, queryParamsValue)
                .get(EndPoints.GET_ALL_USERS)
                .then();
    }

}
