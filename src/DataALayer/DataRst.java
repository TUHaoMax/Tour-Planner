package DataALayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataRst {

    public static ArrayList<ArrayList> gettourinforResultSet(String sqlStr){
        ArrayList<ArrayList> DataList=new ArrayList<ArrayList>();
        ArrayList<Integer> IDList=new ArrayList<Integer>();
        ArrayList<String> NameList=new ArrayList<String>();
        ResultSet resultSet= ToursData.Getsql(sqlStr);

        try {
            while (resultSet.next()) {
                NameList.add(resultSet.getString("name"));
                IDList.add(resultSet.getInt("id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DataList.add(NameList);
        DataList.add(IDList);

    return DataList;

    }


}
