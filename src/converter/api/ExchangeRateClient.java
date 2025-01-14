package java.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;

public class ExchangeRateClient {

    private static final Dotenv dotenv = Dotenv.configure().directory("./").load(); // Garante o carregamento do .env
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public static double getExchangeRate(String from, String to) throws Exception {
        String apiKey = dotenv.get("API_KEY");
        System.out.println("Carregando chave da API: " + apiKey);
        if (apiKey == null) {
            throw new IllegalStateException("A chave da API não foi encontrada no arquivo .env");
        }

        String url = API_URL + apiKey + "/pair/" + from + "/" + to;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Erro na API: " + response.statusCode());
        }

        // Parse o JSON usando Gson
        Gson gson = new Gson();
        JsonObject json = gson.fromJson(response.body(), JsonObject.class);

        if (!"success".equals(json.get("result").getAsString())) {
            throw new RuntimeException("Erro na resposta da API: " + json.get("result").getAsString());
        }

        // Obtenha a taxa de conversão
        return json.get("conversion_rate").getAsDouble();
    }
}
