package br.com.lepsistemas.cleanarchitecturespringspark.spark;

import spark.Spark;

public class Routes {
	
	public void create() {
		Spark.get("/status", (request, response) -> "OK");
	}

}
