package com.github.anastasiazhukova.jsonparser.Utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {
    public static String toString(InputStream pInputStream) throws IOException {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            inputStreamReader = new InputStreamReader(pInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
        } finally {
            close(pInputStream);
            close(inputStreamReader);
            close(bufferedReader);
        }

        return sb.toString();
    }

    private static void close(Closeable pCloseable) {
        if (pCloseable != null) {
            try {
                pCloseable.close();
            } catch (IOException pE) {
                Log.e("IOUtils", pE.getMessage());
            }
        }
    }
}
