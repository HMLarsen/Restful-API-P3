package com.furb.prog3.trab3.util;

import springfox.documentation.spring.web.json.Json;

public class SuccessMessage {

	public static Json message(String message) {
		String json = "{\"success\":{\"text\":\"" + message + "\"}}";
		return new Json(json);
	}

}
