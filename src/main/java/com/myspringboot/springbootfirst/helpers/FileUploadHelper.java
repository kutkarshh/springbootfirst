package com.myspringboot.springbootfirst.helpers;

import java.io.File;
import java.io.IOException;
/* import java.io.FileOutputStream;
import java.io.InputStream; */
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    // Static Path to Image Resources Location

    /*
     * private final String UPLOAD_DIR =
     * "E:\\Projects\\SpringBootProjects\\newSpringBoot\\springbootfirst\\src\\main\\resources\\static\\images";
     */

    // Dynamic Path to Image Resources Location
    private final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();

    public FileUploadHelper() throws IOException {

    }

    public boolean getUploadImage(MultipartFile image) {
        boolean f = false;
        try {
            // Basic Method

            /*
             * InputStream is = image.getInputStream();
             * byte[] data = new byte[is.available()];
             * is.read(data);
             * 
             * // Write
             * FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "\\" +
             * image.getOriginalFilename());
             * fos.write(data);
             * fos.flush();
             * fos.close();
             * f = true;
             */

            // Alternate Method to Upload
            Path filePath = Paths.get(UPLOAD_DIR + File.separator + image.getOriginalFilename());
            Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}