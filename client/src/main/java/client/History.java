package client;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class History {
    private static OutputStreamWriter out;

    private static String getHistoryFilenameByLogin(String login) {
        return "history_" + login + ".txt";
    }

    public static void start(String login) {
        try {
            out = new OutputStreamWriter(
                    new FileOutputStream(getHistoryFilenameByLogin(login), true),
                    StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void stop() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeLine(String msg) {
        try {
            out.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String readHistory(String login, int limit) {
        List<String> hist = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        try (BufferedReader bufin = new BufferedReader(new InputStreamReader(new FileInputStream(getHistoryFilenameByLogin(login)),
                StandardCharsets.UTF_8))) {
            String str;
            while ((str = bufin.readLine()) != null) {
                hist.add(str);
            }
            int from = Math.max(hist.size() - limit, 0);
            for (int i = from; i < hist.size(); i++) {
                sb.append(hist.get(i)).append("\n");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }
}

