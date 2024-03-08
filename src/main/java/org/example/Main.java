package org.example;

import org.example.status.HttpImageStatusCli;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}