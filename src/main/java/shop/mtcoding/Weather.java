package shop.mtcoding;



import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * DB에 Select 한 데이터를 담기 위한 오브젝트
 */

@ToString
@Getter
public class Weather {
    private int id;
    private String first;
    private String second;
    private String third;
    private int longitude;
    private int latitude;

    public Weather(int id, String first, String second,String third, int longitude, int latitude) {
        this.id = id;
        this.first = first;
        this.second = second;
        this.third = third;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}