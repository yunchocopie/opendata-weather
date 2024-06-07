package shop.mtcoding;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;

public class MyHttp {

    private static HttpClient httpClient = HttpClient.newHttpClient();

    public static String get(String serviceKey, String baseDate, String baseTime, Integer nx, Integer ny) throws IOException, InterruptedException {

        String uriAndParams = "https://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?serviceKey=$serviceKey&pageNo=1&numOfRows=1000&dataType=JSON&base_date=$baseDate&base_time=$baseTime&nx=$nx&ny=$ny"
                .replace("$serviceKey", serviceKey)
                .replace("$baseDate", baseDate)
                .replace("$baseTime", baseTime)
                .replace("$nx", nx.toString())
                .replace("$ny", ny.toString());

        System.out.println(uriAndParams);

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(uriAndParams))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
}