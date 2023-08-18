package com.hashing.cardGame;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApiEndpoints {

}


class Test {
    public static void main(String[] args) {
        Test i = new Test();
        // i.shuffleDeck();
        i.getCard(3); 
    }

    private String deckId = "two4ehcnql1i";


    public void getCard(int count) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest getDeck = HttpRequest.newBuilder()
                .uri(new URI("https://www.deckofcardsapi.com/api/deck/" + deckId + "/draw/?count=" + count))
                .GET()
                .build();
            
            HttpResponse<String> response = client.send(getDeck, BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            DeckPojo i = mapper.readValue(response.body(), DeckPojo.class);
            
            System.out.println("status: " + i.getStatus());
            System.out.println("deckid: " + i.getDeckId());
            System.out.println("remaining cards: " + i.getRemaining());
            System.out.println("shuffled: " + i.getShuffled());

            for (CardPojo card : i.getCard()) {
                // System.out.println("card_code" + card.getCode());
                // System.out.println("image_link" + card.getImage());
                // System.out.println("card_value" + card.getValue());
                // System.out.println("card_suit" + card.getSuit());
            }

        } catch (Exception i) {
            i.printStackTrace();// xd ok run nooo 
        }
    }
    
    public void shuffleDeck() {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest getDeck = HttpRequest.newBuilder()
                .uri(new URI("https://www.deckofcardsapi.com/api/deck/" + deckId + "/shuffle/"))
                .GET()
                .build();
            
            HttpResponse<String> response = client.send(getDeck, BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            // mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            DeckPojo i = mapper.readValue(response.body(), DeckPojo.class);
            
            System.out.println(i.getStatus());
            System.out.println(i.getDeckId());
            System.out.println(i.getRemaining());
            System.out.println(i.getShuffled());

        } catch (Exception i) {
            System.out.println(i.getStackTrace());
        }
    }
}



@JsonIgnoreProperties(ignoreUnknown = true)
class DeckPojo {
    private boolean success;
    private String deck_id;
    private CardPojo[] cards;
    private int remaining;
    private boolean shuffled;

    public boolean getStatus() {
        return success;
    }

    public void setStatus(boolean success) {
        this.success = success;
    }

    public String getDeckId() {
        return deck_id;
    }

    public void setDeckId(String deck_id) {
        this.deck_id = deck_id;
    }

    public CardPojo[] getCard() {
        return cards;
    }

    public void setCard(CardPojo[] cards) {
        this.cards = cards;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public boolean getShuffled() {
        return shuffled;
    } 

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class CardPojo {

    private String code;
    private String image;
    private String value;
    private String suit;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}


// {
//     "success": true, 
//     "deck_id": "kxozasf3edqu", 
//     "cards": [
//         {
//             "code": "6H", 
//             "image": "https://deckofcardsapi.com/static/img/6H.png", 
//             "images": {
//                           "svg": "https://deckofcardsapi.com/static/img/6H.svg", 
//                           "png": "https://deckofcardsapi.com/static/img/6H.png"
//                       }, 
//             "value": "6", 
//             "suit": "HEARTS"
//         }, 
//         {
//             "code": "5S", 
//             "image": "https://deckofcardsapi.com/static/img/5S.png", 
//             "images": {
//                           "svg": "https://deckofcardsapi.com/static/img/5S.svg", 
//                           "png": "https://deckofcardsapi.com/static/img/5S.png"
//                       }, 
//             "value": "5", 
//             "suit": "SPADES"
//         }
//     ], 
//     "remaining": 50
// }