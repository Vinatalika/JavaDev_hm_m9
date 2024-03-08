package org.example.status;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.example.status.Utils.EXTENSION;
import static org.example.status.Utils.TEST_URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        String stringUrl = TEST_URL + code + EXTENSION;
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(stringUrl).openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return stringUrl;
            } else {
                return null;
            }
        } catch (IOException e) {
            return null;
        }
    }
}
