package classMetier.Util;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class FilePdf {

    public static void createPdf(String title, String texte, String name) throws FileNotFoundException, DocumentException {

        Document document = new Document();
        String Realname="src\\PDF\\"+name+".pdf";


        PdfWriter.getInstance(document,new FileOutputStream(Realname));
        {
            document.open();
            document.addTitle(title);
            document.add(new Paragraph(texte));

        }
        document.close();

    }
}
