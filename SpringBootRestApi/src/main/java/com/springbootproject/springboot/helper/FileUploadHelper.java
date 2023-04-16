package com.springbootproject.springboot.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "D:\\Spring BOOT intelijj\\SpringBootRestApi\\src\\main\\resources\\static\\images";


    public boolean uploadFile(MultipartFile multipartFile) {
        boolean b = false;
        try {
            /*InputStream inputstream = multipartFile.getInputStream();
            byte data[] = new byte[inputstream.available()];
            inputstream.read(data);

//                write
            FileOutputStream outputStream = new FileOutputStream(UPLOAD_DIR + "\\" + multipartFile.getOriginalFilename());
            outputStream.write(data);

            outputStream.flush();
            outputStream.close();*/

            Files.copy(
                    multipartFile.getInputStream(),
                    Paths.get(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING
                      );

            b = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;

    }

}
