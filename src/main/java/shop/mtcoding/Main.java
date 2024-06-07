package shop.mtcoding;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        WeatherDAO weatherDAO = new WeatherDAO();

        // 첫번째 입력
        List<String> distinctFirstList = weatherDAO.selectDistinctFirst();
        distinctFirstList.forEach(first -> System.out.print("[" + first + "] "));
        System.out.println();
        System.out.print("현재 위치하고 있는 지역을 입력하세요 >>> ");
        String firstLocation = sc.nextLine();
        System.out.println(firstLocation);

        // 두번째 입력
        List<String> distinctSecondList = weatherDAO.selectSecondByFirst(firstLocation, 1);
        distinctSecondList.forEach(second -> System.out.print("[" + second + "] "));
        System.out.println();
        System.out.print("현재 위치하고 있는 지역을 입력하세요 >>> ");
        String secondLocation = sc.nextLine();
        System.out.println(secondLocation);

        // 세번째 입력
        List<String> distinctThirdList = weatherDAO.selectThirdBySecond(secondLocation, 1);
        distinctThirdList.forEach(third -> System.out.print("[" + third + "] "));
        System.out.println();
        System.out.print("현재 위치하고 있는 지역을 입력하세요 >>> ");
        String thirdLocation = sc.nextLine();
        System.out.println(thirdLocation);

        // 위도 값 불러오기
        int latitude = weatherDAO.selectLatitude(firstLocation, secondLocation, thirdLocation);
        System.out.println("위도 : " + latitude);

        // 경도 값 불러오기
        int longitude = weatherDAO.selectLongitude(firstLocation, secondLocation, thirdLocation);
        System.out.println("경도 : " + longitude);

        String url = MyHttp.get("hNhIlLgRzNpro10y9tkzReZ20JkH1E3T%2BkE7R0I%2F8sykr1iokHhzjLwlZB8nUJ9klWdYBrPYSunGGZAV8i99eg%3D%3D", "20240607", "1600", latitude, longitude);
        System.out.println("url : " + url);

        String jsonData = url;
        // Gson 객체 생성
        Gson gson = new Gson();

        // JSON 문자열을 WeatherReponse 객체로 파싱
        WeatherReponse weatherResponse = gson.fromJson(jsonData, WeatherReponse.class);

        // WeatherReponse 객체에서 category가 "T1H"인 obsrValue 값 가져오기
        List<WeatherReponse.Response.Body.Items.Item> items = weatherResponse.response.body.items.item;
        for (WeatherReponse.Response.Body.Items.Item item : items) {
            if (item.category.equals("T1H")) {
                System.out.println("오늘의 기온 : " + item.obsrValue);
                break; // 첫 번째 일치하는 항목만 가져옴
            }
        }
    }
}
