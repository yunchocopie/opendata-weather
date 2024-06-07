package shop.mtcoding;

import java.util.List;

public class WeatherReponse {
    Response response;

    class Response{
        Body body;

        class Body{
            String dataType;
            Items items;
            String pageNo;
            String numOfRows;
            String totalCount;

            class Items {
                List<Item> item;

                class Item {
                    String baseDate;
                    String baseTime;
                    String category;
                    String nx;
                    String ny;
                    String obsrValue;
                }
            }
        }
    }
}
