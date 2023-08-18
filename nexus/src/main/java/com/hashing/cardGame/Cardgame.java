package com.hashing.cardGame;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class Cardgame extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().equals("cardgame")) {
            EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle("join cardgame");

            event.getChannel().sendMessageEmbeds(embed.build()).addActionRow(
                Button.success("join", "Join")
            ).queue();
        }
    }

    private List<User> players = new ArrayList<>();

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        if (event.getComponentId().equals("join")) {
            if (players.contains(event.getUser())) {
                event.reply("Already joined").setEphemeral(true).queue();
            } else {
                players.add(event.getUser());
                event.reply("Joined!").setEphemeral(true).queue();
            }

            if (players.size() == 2) {
                Long guildId = event.getGuild().getIdLong();
                JDA jda = event.getJDA();
                event.getJDA().addEventListener(new CardGameCode(players, jda, guildId));
            }
        }
    }
}

class CardGameCode extends ListenerAdapter {

    private List<User> players = new ArrayList<>();
    private JDA jda;
    private Long guildId;

    CardGameCode(List<User> players, JDA jda, Long guildId) {
        this.players = players;
        this.jda = jda;
        this.guildId = guildId;
        game();
    }

    private Long channelOneId;
    private Long channelTwoId;
    private User playerOne;
    private User playerTwo;

    private String deckId = "two4ehcnql1i";


    public void game() {

        createChannels();

        // shuffleDeck(); 
    }

    public void createChannels() {

        String intro = "**Game of Pure Strategy**\n"
                     + "A game for two players, played with 3 suits of cards. Aces are worth one point, jacks, queens and kings are worth 11, 12, 13 respectively. the number cards are worth their face value\n"
                     + "The objective is to win with the most points\n"
                     + "\n"
                     + "**How to play**"
                     + "Each player gets one suit of cards and one suit is shuffled and placed in the middle (one suit is discarded),\n"
                     + "The top card of the middle deck is placed between players.\n"                    
                     + "The players then select one of their cards and place it facedown, players reveal the cards at the same time.\n"
                     + "The player with the higher card wins the middle card.\n"
                     + "If there's a tie, the players' cards are discarded and another card of the middle deck is added, on top of the previous one.\n"
                     + "Players can then win both cards.\n"
                     + "At the end, points are tallied."
                     + "- Dont cheat!!\n"
                     + "- Have fun\n"
                     + "^_^\n"; 

        jda.getGuildById(guildId).createTextChannel("cardgame").queue(i -> {
            channelOneId = i.getIdLong();
            playerOne = players.get(0);
            i.sendMessage(intro + playerOne.getAsMention()).queue();
        });
        
        jda.getGuildById(guildId).createTextChannel("cardgame").queue(i -> {
            channelTwoId = i.getIdLong();
            playerTwo = players.get(1);
            i.sendMessage(intro + playerTwo.getAsMention()).queue();
        });
    }

    // public static void main(String[] args) {
    //     CardGameCode i = new CardGameCode(null, null, null);
    //     i.shuffleDeck();
    // } // can you run this pls, mhm sec

    
    // public void shuffleDeck() {

    //     if (deckId == null) {
    //         try {
    //             HttpClient client = HttpClient.newHttpClient();
    //             HttpRequest getDeck = HttpRequest.newBuilder()
    //                 .uri(new URI("https://www.deckofcardsapi.com/api/deck/" + deckId + "/shuffle/"))
    //                 .GET()
    //                 .build();
                
    //             HttpResponse<String> response = client.send(getDeck, BodyHandlers.ofString());
    //             ObjectMapper mapper = new ObjectMapper();
    //             mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    //             DeckPojo i = mapper.readValue(response.body(), DeckPojo.class);
                
    //             System.out.println(i.getStatus());
    //             System.out.println(i.getDeck());
    //             System.out.println(i.getRemaining());
    //             System.out.println(i.getShuffled());

    //             // DeckPojo o = new DeckPojo();
    //             // o.setDeck(i.getDeck());

    //         } catch (Exception i) {
    //             System.out.println(i.getStackTrace());
    //         }
    //     }
    // }
}
