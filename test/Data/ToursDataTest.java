package Data;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ToursDataTest implements SQL{

    @Test
    void connect() {
        ResultSet resultSet=ToursData.Getsql(SQL.Tours_selectall);

        try {
            if(resultSet.next()){
                System.out.println(resultSet.getString("Name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}