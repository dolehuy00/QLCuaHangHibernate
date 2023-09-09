/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author DELL
 */
public class imgs {
        public imgs() {
       
    }
public String imgs(String img) {  
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("img/" + img);
    if (inputStream == null) {
        return null;
    }
    try {
        File tempFile = File.createTempFile("img", ".tmp");
        tempFile.deleteOnExit();
        OutputStream outputStream = new FileOutputStream(tempFile);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return tempFile.getAbsolutePath();
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}

}
