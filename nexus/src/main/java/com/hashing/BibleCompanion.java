package com.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class BibleCompanion extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        if (message.getContentRaw().startsWith("!bible")) {
            String[] Args = (message).getContentRaw().split(" ");
            if (Args.length == 4) {
                String book = Args[1];
                int chapter = Integer.parseInt(Args[2]);
                int verse = Integer.parseInt(Args[3]);

                String verseText = fetchBibleVerse(book, chapter, verse);
                message.getChannel().sendMessage("Bible Verse: " + verseText).queue();
            } else {
                message.getChannel().sendMessage("Invalid command format. Usage: !bible [book] [chapter] [verse]").queue();
            }
        }
    }

    private String fetchBibleVerse(String book, int chapter, int verse) {
        try {
            URL url = new URL("https://bible-api.com/" + book + chapter + ":" + verse);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String jsonResult = response.toString();
                return jsonResult;

            } else {
                return "Error: Unable to fetch data from the API. Response code: " + responseCode;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Failed to fetch the Bible verse.";
        }
    }
}




//     public static void main(String[] args) {
//         String book = "john";
//         int chapter = 3;
//         int verse = 16;

//         try {
//             URL url = new URL("https://bible-api.com/" + book + chapter + ":" + verse);
//             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//             conn.setRequestMethod("GET");

//             int responseCode = conn.getResponseCode();
//             if (responseCode == HttpURLConnection.HTTP_OK) {
//                 BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                 String inputLine;
//                 StringBuilder response = new StringBuilder();

//                 while ((inputLine = in.readLine()) != null) {
//                     response.append(inputLine);
//                 }
//                 in.close();

//                 String jsonResult = response.toString();
//                 System.out.println("JSON Response: " + jsonResult);

//             } else {
//                 System.out.println("Error: Unable to fetch data from the API. Response code: " + responseCode);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }
