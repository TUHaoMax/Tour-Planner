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
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Test
    void insert(){
        String Name="Tour-1";
        ToursData.Dosql(SQL.Tours_insert,Name);
    }
    @Test
    void delete(){
        String Name="Tour-1";
        ToursData.Dosql(SQL.Tours_Delete,Name);
    }
}