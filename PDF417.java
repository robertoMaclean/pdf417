
package pdf417;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class pdf417{
   

    public static final String DATOS_TIMBRE="/ruta/txt"; //ruta del documento txt con la info. que debe ir en el timbre
    
    public static void main(String[] args) throws DocumentException, FileNotFoundException, UnsupportedEncodingException, IOException{

        timbre timbre=new timbre();
        File file = new File(DATOS_TIMBRE);
        timbre.GenerarTimbre(file);
    }
    
}


