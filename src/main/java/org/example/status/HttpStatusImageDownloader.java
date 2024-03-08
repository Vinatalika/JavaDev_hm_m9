package org.example.status;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import static org.example.status.Utils.DIRECTORY_FOR_SAVE;
import static org.example.status.Utils.EXTENSION;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();
        String url = checker.getStatusImage(code);

        try (InputStream in = new URL(url).openStream()) {
            byte[] allBytes = in.readAllBytes();
            String encoded = Base64.getEncoder().encodeToString(allBytes);

            byte[] bytes = Base64.getDecoder().decode(encoded);

            String path = DIRECTORY_FOR_SAVE + code + EXTENSION;
            try (FileOutputStream fos = new FileOutputStream(path)) {
                fos.write(bytes);
                System.out.println("File with code " + code + " is downloaded and saved to " + path);
            } catch (IOException e) {
                System.err.println("Error saving file: " + e.getMessage());
            }
        } catch (IOException e) {
            throw new FileNotFoundException("File not found for code " + code);
        }
    }
}