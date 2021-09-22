package io.nellis;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.nellis.model.JokeResponse;
import io.nellis.model.ServerResponse;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class MainFunction implements RequestHandler<Map<String, String>, JokeResponse> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @SneakyThrows
    @Override
    public JokeResponse handleRequest(Map<String, String> input, Context context) {
        LambdaLogger logger = context.getLogger();

        logger.log("Hi, mom");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v2.jokeapi.dev/joke/Any?type=twopart"))
                .build();

        HttpResponse<String> httpResponse =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        ServerResponse decodedResponse = gson.fromJson(httpResponse.body(), ServerResponse.class);

        return new JokeResponse(decodedResponse.getSetup(), decodedResponse.getDelivery());
    }
}
