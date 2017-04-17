package com.serenity.demo.service.restful;

import java.util.Map;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import net.serenitybdd.core.pages.PageObject;

public class PubNativeAPIservice extends PageObject{
	public static Response validatableResponse;
	public static String endpoint = "https://api.pubnative.net/api/partner/v2/promotions/native";

	public Response callPubNativeAPIservice(Map<String, String> properties) {
		return RestAssured.given().when().queryParameters(properties).get(endpoint);
	}

}
