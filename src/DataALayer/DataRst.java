package DataALayer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

public class DataRst {

    public static ArrayList<ArrayList> gettourinforResultSet(){
        ArrayList<ArrayList> DataList=new ArrayList<ArrayList>();
        ArrayList<Integer> IDList=new ArrayList<Integer>();
        ArrayList<String> NameList=new ArrayList<String>();
        ArrayList<String> destinationList=new ArrayList<>();
        ArrayList<String> DepartureList=new ArrayList<>();
        ResultSet resultSet= ToursData.Getsql(SQL.Tours_selectall);

        try {
            while (resultSet.next()) {
                NameList.add(resultSet.getString("name"));
                IDList.add(resultSet.getInt("id"));
                destinationList.add(resultSet.getString("destination"));
                DepartureList.add(resultSet.getString("Departure"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataList.add(NameList);
        DataList.add(DepartureList);
        DataList.add(destinationList);
        DataList.add(IDList);

    return DataList;

    }

    public static ArrayList<ArrayList> getlogsResultSet(int tid){
        ArrayList<ArrayList> DataList=new ArrayList<ArrayList>();
        ArrayList<Integer> IDList=new ArrayList<Integer>();
        ArrayList<Date> DateList=new ArrayList<Date>();
        ArrayList<Time> durationList=new ArrayList<>();
        ArrayList<Integer> TouridList=new ArrayList<>();
        ArrayList<Integer> Ratinglist=new ArrayList<>();
        ArrayList<String> Weatherlist=new ArrayList<>();
        ArrayList<Integer> Distancelist=new ArrayList<>();

        ResultSet resultSet= ToursData.Getsql(SQL.Logs_selectToursid,tid);

        try {
            while (resultSet.next()) {
                DateList.add(resultSet.getDate("date"));
                IDList.add(resultSet.getInt("id"));
                durationList.add(resultSet.getTime("duration"));
                TouridList.add(resultSet.getInt("tourid"));
                Ratinglist.add(resultSet.getInt("rating"));
                Weatherlist.add(resultSet.getString("weather"));
                Distancelist.add(resultSet.getInt("distance"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        DataList.add(IDList);
        DataList.add(DateList);
        DataList.add(durationList);
        DataList.add(TouridList);
        DataList.add(Ratinglist);
        DataList.add(Weatherlist);
        DataList.add(Distancelist);
        return DataList;

    }


}
