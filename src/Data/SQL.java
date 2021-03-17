package Data;

public interface SQL {
    String Tours_selectall="SELECT \"ID\", \"Name\"\n" +
            "\tFROM public.\"Tours\";";

    String Tours_insert="INSERT INTO public.\"Tours\" VALUES (?, ?)";
    //Tours

    //Logs
    String Logs_selectToursid="select * from Logs where ToursId= ?";

}
