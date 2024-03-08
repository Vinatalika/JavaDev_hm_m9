package org.example.status;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter HTTP status code: ");
            int statusCode = scanner.nextInt();

            HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
            downloader.downloadStatusImage(statusCode);
        } catch (InputMismatchException e) {
            System.err.println("Please enter a valid number.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}