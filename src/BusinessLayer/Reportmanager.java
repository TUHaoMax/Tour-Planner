package BusinessLayer;

import APP.APPLauncher;
import GUI.VIewModel.ReportingViewModel;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.DocumentException;
import javafx.collections.ObservableList;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;

@Getter
public class Reportmanager {
    private static final Logger logger= LoggerFactory.getLogger(ReportingViewModel.class);
    private String Searchpath= APPLauncher.config.Searchpath;
    private String head="";
    private String Infor="";
    private String Logs="";

    PdfDocument pdfDocument;
    Document document;
    PdfWriter pdfWriter;
    tourinformanager tim;
    logsinformanager lim;
    private Paragraph pHead;
    private Paragraph pInfor;
    private Paragraph pLogs;
    AreaBreak aB = new AreaBreak();
    private Style style_0=new Style();
    ImageData data;

    public  void tourreport(String name,File file) throws MalformedURLException, FileNotFoundException {
          pdfWriter = new PdfWriter(file);
        pdfDocument = new PdfDocument(pdfWriter);
        document = new Document(pdfDocument);
          checkImage(name);
          CreatPdf(name);

        document.close();
    }

    public void summarizereport(ObservableList<String> namelist, File file) throws MalformedURLException, FileNotFoundException {
        pdfWriter = new PdfWriter(file);
        pdfDocument = new PdfDocument(pdfWriter);
        document = new Document(pdfDocument);
        for(int i=0;i<namelist.size();i++){
            System.out.println(namelist.get(i));
            checkImage(namelist.get(i));
            CreatPdf(namelist.get(i));
        }
        document.close();
    }

    protected void checkImage(String name) throws MalformedURLException {
        File checkfile=new File(Searchpath+name+".jpg");
        if(checkfile.exists()) {
            data = ImageDataFactory.create("src/Resources/MapImage/" + name + ".jpg");
            logger.debug("have image");
        }else {
            data = ImageDataFactory.create("src/Resources/MapImage/Home.jpg");
            Infor="\nNo Information\n";
            logger.debug("no image");
        }
    }

    protected void CreatPdf(String name) throws FileNotFoundException {
        Creatmsg(name);
        Creatparagraph();
        setStyle();
        Image image = new Image(data);

        pHead.addStyle(style_0);
        document.add(pHead);
        document.add(pInfor);
        document.add(image);
        document.add(pLogs);
        document.add(aB);
        logger.debug("{} Reporting PDF create", name);
        head="";
        Infor="";
        Logs="";
    }
    protected void Creatmsg(String name){
        tim = new tourinformanager();
        tim.settour(name);
        lim = new logsinformanager(tim.TourId);
        lim.setLogslist();
        setHeadInfor();
        setLogs();
    }
    protected void setHeadInfor(){
        head=head.concat(tim.tour.getName());
        Infor=Infor.concat("Departure: ").concat(tim.Departure+" -> ")
                .concat("destination: ").concat(tim.destination+"\n")
        .concat("\n").concat(tim.Description);
    }

    protected void setLogs(){
        for (int i=0;i<lim.Logslist.size();i++){
            Logs=Logs.concat("\n\nLog "+(i+1)+" :\n").concat("Date : ").concat(String.valueOf(lim.Logslist.get(i).getLogDate())+"  ")
                    .concat("duration : ").concat(String.valueOf(lim.Logslist.get(i).getLogtime())+"  ")
                    .concat("distance : ").concat(String.valueOf(lim.Logslist.get(i).getDistance())+"\n")
                    .concat("weather : ").concat(lim.Logslist.get(0).getWeather())
                    .concat("   rating : ").concat(String.valueOf(lim.Logslist.get(i).getRating()))
                    .concat("   Transport :").concat(lim.Logslist.get(i).getTransport());
        }
    }

    protected void Creatparagraph(){
        pHead=new Paragraph(head);
        pInfor=new Paragraph(Infor);
        pLogs=new Paragraph(Logs);
    }

    private void setStyle(){
        style_0.setFontSize(30f)
                .setItalic();
    }



















    public void test(String name) throws MalformedURLException, FileNotFoundException, DocumentException {
        ImageData data = ImageDataFactory.create("src/Resources/MapImage/Home.jpg");
        Image image = new Image(data);
        Paragraph paragraph=new Paragraph("test test ++<<<>>>test");
        paragraph.add("\n{}test test ++<<<>>>test").addStyle(style_0);
       setStyle();
        AreaBreak aB = new AreaBreak();
        PdfWriter pdfWriter=new PdfWriter("PDF/"+name+".pdf");
        PdfDocument pdfDocument=new PdfDocument(pdfWriter);
        Document document=new Document(pdfDocument);

        //document.add(paragraph);
        document.add(image);
        //pdfDocument.addNewPage();
        document.add(aB);
        document.add(paragraph);
        document.close();
    }


}

