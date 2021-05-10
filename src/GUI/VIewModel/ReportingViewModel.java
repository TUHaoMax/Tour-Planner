package GUI.VIewModel;
import BusinessLayer.tourinformanager;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class ReportingViewModel {
    private static final Logger logger= LoggerFactory.getLogger(ReportingViewModel.class);
    private  String path="PDF/";
    private  Paragraph paragraph;
    private  String msg="";
    private String date="";

    public  void PDfcreate(String name) {
        Creatmsg(name);
        getDatetime();
        Creatparagraph();
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path+name+"_"+date+".pdf"));
            document.open();
            document.add(paragraph);
            document.close();
            logger.debug("{} Reporting PDF create",name);
            msg="";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void Creatmsg(String name){
        tourinformanager tim=new tourinformanager();
        tim.settour(name);
        msg=msg.concat("Tour Name: ").concat(tim.Name+"\n")
                .concat("Departure: ").concat(tim.Departure+"\n")
                .concat("destination: ").concat(tim.destination+"\n");
    }

    protected void Creatparagraph(){
        paragraph=new Paragraph("Reporting "+date+"\n"+msg);
    }

    protected void getDatetime(){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("{yyyy-mm-dd}_[hh;mm;ss]");
        this.date=dateFormat.format(date);
    }

}
