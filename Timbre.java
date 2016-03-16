
package pdf417;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BarcodePDF417;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class timbre {
    
    public static final String DEST = "/rutaOrigen"; //ruta del documento en formato pdf de origen al cual se añade el timbre
    public static final String INPUT="/rutaDestino"; //ruta del documento con el timbre agregado

    public timbre() {
    }
        
    public void GenerarTimbre(File file) throws DocumentException, FileNotFoundException, UnsupportedEncodingException, IOException{
       
        String lectura,cadena="";
        BarcodePDF417 pdf417 = new BarcodePDF417();

        pdf417.setCodeRows(5); //setear el codigo de barras
        pdf417.setCodeColumns(18);
        pdf417.setErrorLevel(5);
        pdf417.setLenCodewords(999);
        pdf417.setOptions(BarcodePDF417.PDF417_FORCE_BINARY); 

        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        
        while ((lectura = b.readLine()) != null) { //leer el archivo txt
            cadena=cadena+lectura+"\n";
        }
        
        System.out.println("Datos timbre: \n"+cadena);
        pdf417.setText(cadena);                     //insertar texto al pdf417
        b.close();
        com.itextpdf.text.Image image = pdf417.getImage();
        try {                                       //insertar el timbre en la factura de origen
            PdfReader pdfReader = new PdfReader(INPUT);
            PdfStamper pdfStamper = new PdfStamper(pdfReader,new FileOutputStream(DEST));

            for(int i=1; i<= pdfReader.getNumberOfPages(); i++){

                PdfContentByte content = pdfStamper.getUnderContent(i);
                image.setAbsolutePosition(50,20);                    //seteo imagen
                image.scaleAbsolute(184, 72);
                content.addImage(image);
        }

        pdfStamper.close();

        } catch (IOException | DocumentException e) {
        }
        }
}
