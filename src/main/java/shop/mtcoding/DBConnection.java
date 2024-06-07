package shop.mtcoding;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/weatherdb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private Connection connection;

    // 생성자: 데이터베이스 연결 설정
    public DBConnection() throws ClassNotFoundException, SQLException {
        // MySQL JDBC 드라이버 로드
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 데이터베이스 연결
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        //System.out.println("Database connected!");
    }

    // 데이터베이스 연결 객체 반환
    public Connection getConnection() {
        return connection;
    }

    // 데이터베이스 연결 해제
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
            //System.out.println("Database connection closed.");
        }
    }

    // 쿼리 실행 메서드
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // 리소스 해제 메서드
    public void closeResources(ResultSet resultSet, Statement statement) {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
