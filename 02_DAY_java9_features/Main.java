package day02_java9_features;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java 9+ Features: Modules, JShell, HTTP Client");

        // Fetch data from a website using the new HTTP Client
        try {
            fetchWebsiteData("https://jsonplaceholder.typicode.com/posts/1");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }
    }

    private static void fetchWebsiteData(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Response Code: " + response.statusCode());
        System.out.println("Response Body: " + response.body());
    }
}

