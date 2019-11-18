package com.furb.prog3.trab3.util;

import springfox.documentation.spring.web.json.Json;

public class SuccessResponse {

	public static Json message(String message) {
		String json = "{\"success\":{\"text\":\"" + message + "\"}}";
		return new Json(json);
	}

}
