package shop.mtcoding;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class WeatherDAO {

    public List<String> selectDistinctFirst() {
        List<String> firstList = new ArrayList<>();
        DBConnection dbConnection = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            dbConnection = new DBConnection();
            conn = dbConnection.getConnection();
            String sql = "SELECT DISTINCT first FROM weather_tb ORDER BY first";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String first = rs.getString("first");
                firstList.add(first);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbConnection != null) {
                dbConnection.closeResources(rs, pstmt);
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return firstList;
    }

    public List<String> selectSecondByFirst(String first, int offset) {
        List<String> secondList = new ArrayList<>();
        DBConnection dbConnection = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            dbConnection = new DBConnection();
            conn = dbConnection.getConnection();
            String sql = "SELECT DISTINCT second FROM weather_tb WHERE first = ? ORDER BY second LIMIT ?, ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, first);
            pstmt.setInt(2, offset); // offset 설정
            pstmt.setInt(3, Integer.MAX_VALUE); // 원하는 개수 설정, Integer.MAX_VALUE를 사용하면 모든 결과를 가져옴
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String second = rs.getString("second");
                secondList.add(second);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbConnection != null) {
                dbConnection.closeResources(rs, pstmt);
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return secondList;
    }

    public List<String> selectThirdBySecond(String second, int offset) {
        List<String> thirdList = new ArrayList<>();
        DBConnection dbConnection = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            dbConnection = new DBConnection();
            conn = dbConnection.getConnection();
            String sql = "SELECT DISTINCT third FROM weather_tb WHERE second = ? ORDER BY third LIMIT ?, ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, second);
            pstmt.setInt(2, offset); // offset 설정
            pstmt.setInt(3, Integer.MAX_VALUE); // 원하는 개수 설정, Integer.MAX_VALUE를 사용하면 모든 결과를 가져옴
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String third = rs.getString("third");
                thirdList.add(third);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbConnection != null) {
                dbConnection.closeResources(rs, pstmt);
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return thirdList;
    }

    public int selectLongitude(String first,String second, String third) {
        int longitude = 0;
        DBConnection dbConnection = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            dbConnection = new DBConnection();
            conn = dbConnection.getConnection();
            String sql = "SELECT DISTINCT longitude FROM weather_tb WHERE first = ? and second = ? and third = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, first);
            pstmt.setString(2, second);
            pstmt.setString(3, third);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                longitude = rs.getInt("longitude");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbConnection != null) {
                dbConnection.closeResources(rs, pstmt);
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return longitude;
    }

    public int selectLatitude(String first,String second, String third) {
        int latitude = 0;
        DBConnection dbConnection = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            dbConnection = new DBConnection();
            conn = dbConnection.getConnection();
            String sql = "SELECT latitude FROM weather_tb WHERE first = ? and second = ? and third = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, first);
            pstmt.setString(2, second);
            pstmt.setString(3, third);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                latitude = rs.getInt("latitude");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (dbConnection != null) {
                dbConnection.closeResources(rs, pstmt);
                try {
                    dbConnection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return latitude;
    }



}
