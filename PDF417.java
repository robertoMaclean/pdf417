/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdf417;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class pdf417{
   

    public static final String DATOS_TIMBRE="D:\\pdf417\\DatosTimbre";
    
    public static void main(String[] args) throws DocumentException, FileNotFoundException, UnsupportedEncodingException, IOException{

        timbre timbre=new timbre();
        File file = new File(DATOS_TIMBRE);
        timbre.GenerarTimbre(file);
    }
    
}


