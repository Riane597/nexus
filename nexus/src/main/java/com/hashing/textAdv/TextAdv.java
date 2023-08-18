package com.hashing.textAdv;

import java.util.ArrayList;
import java.util.List;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.LayoutComponent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class TextAdv extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {

        String message = event.getMessage().getContentRaw();

        if (message.equalsIgnoreCase("start")) {

            MessageChannelUnion channel = event.getChannel();

            event.getMessage().delete().queue();

            event.getJDA().addEventListener(new Game(channel));
        }
    }
}

class Game extends ListenerAdapter {

    Game(MessageChannelUnion channel) {
        this.channel = channel;
        begin();
    }

    // private Queue<String> dialogueQueue = new LinkedList<>();
    private EmbedBuilder embed = new EmbedBuilder();
    private final MessageChannelUnion channel;
    private Long messageId;

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {

        switch (event.getComponentId()) {
            
            case "start01":
                StoryLine.startDialogueA();
                displayNextDialogueLine(event);
                break;

            case "next02":
                displayNextDialogueLine(event);
                break;

            case "stats":
                displayStats(event);
                break;

            case "back":
                goBack(event);
                break;

                // start
            case"Who are you?":
                StoryLine.answer1();
                StoryLine.startDialogueB();
                displayNextDialogueLine(event);
                break;
            
            case"Why did I end up here?":
                StoryLine.answer2();
                StoryLine.startDialogueB();
                displayNextDialogueLine(event);
                break;

            case"What is this place?":
                StoryLine.answer3();
                StoryLine.startDialogueB();
                displayNextDialogueLine(event);
                break;

            case"I will do whatever it takes.":
                StoryLine.answer4();
                StoryLine.startDialogueC();
                displayNextDialogueLine(event);
                strength += 1;
                reputation += 1;
                faith += 1;
                break;

            case"I am still slightly confused.":
                StoryLine.answer5();
                StoryLine.startDialogueC();
                displayNextDialogueLine(event);
                knowledge += 1;
                break;

            case"This sounds very unrealistic.":
                StoryLine.answer6();
                StoryLine.startDialogueC();
                displayNextDialogueLine(event);
                knowledge -= 1;
                reputation -= 1;
                break;

            case"I will explore every corner.":
                StoryLine.theEnchantedForest();
                displayNextDialogueLine(event);
                knowledge += 1;
                faith += 1; 
                break;

            case"I will prove myself worthy of their assistance.":
                StoryLine.theEnchantedForest();
                displayNextDialogueLine(event);
                strength += 1;
                reputation += 1;
                break;

            case"I shall see when the time is right":
                StoryLine.theEnchantedForest();
                displayNextDialogueLine(event);
                reputation += 1;
                faith -= 1;
                break;
            
                //enchanted forest 
            case "I seek a missing part of me. Can you offer any guidance?":
                StoryLine.theEnchantedForest2();
                displayNextDialogueLine(event);
                break;

            case "I'm seeking truth, can you help me?":
                StoryLine.theEnchantedForest2();
                displayNextDialogueLine(event);
                break;

            case "I'm seeking knowledge, can you be of any help?":
                StoryLine.theEnchantedForest2();
                displayNextDialogueLine(event);
                break;
                
            //riddle

            case "accept":
                StoryLine.forestRiddle();
                displayNextDialogueLine(event);
                break;

            case "pass":
                StoryLine.pass();
                displayNextDialogueLine(event);
                break;

            // riddle answer

            case "fire":
                StoryLine.fire();
                StoryLine.afterClue();
                knowledge += 1;
                displayNextDialogueLine(event);
                break;

            case "water":
                StoryLine.water();
                knowledge -= 1;
                displayNextDialogueLine(event);
                break;

            case "earth":
                StoryLine.earth();
                knowledge -= 1;
                displayNextDialogueLine(event);
                break;

            case "How can I find this soulmate":
                StoryLine.answer7();
                displayNextDialogueLine(event);
                break;

            case "How can I find the missing part of myself?":
                StoryLine.answer7();
                displayNextDialogueLine(event);
                break;

            case "Thank you for your guidance.":
                StoryLine.answer8();
                displayNextDialogueLine(event);
                break;

            case "I shall follow the whispers.":
                StoryLine.answer8();
                displayNextDialogueLine(event);
                break;

            case "I shall trust in the forest's wisdom.":
                StoryLine.answer8();
                displayNextDialogueLine(event);
                break;

            //whispering glade


            //luminous caverns

                                 
            default:
                break;
        }
    }

    private List<MessageEmbed> tempEmbed;
    private List<ActionRow> tempActioRow;
    private int health = 3;
    private int knowledge = 2;
    private int strength = 1;
    private int faith = 2;
    private int reputation = 1;

    public void displayStats(ButtonInteractionEvent event) {

        String healthText = "Health: ";
        String knowledgeText = "Knowledge: "; 
        String strengthText = "Strength: ";
        String faithText = "Faith: ";
        String reputationText = "Reputation: ";

        
        for (int i = 0; i < health; i ++) {
            healthText = healthText + ":cat:";
            if (i + 1 == health) {
                healthText = healthText + "\n";
            }
        }
        for (int i = 0; i < knowledge; i ++) {
            knowledgeText = knowledgeText + ":atom:";
            if (i + 1 == knowledge) {
                knowledgeText = knowledgeText + "\n";
            }
        }
        for (int i = 0; i < strength; i ++) {
            strengthText = strengthText + ":crossed_swords:";
            if (i + 1 == strength) {
                strengthText = strengthText + "\n";
            }
        }
        for (int i = 0; i < faith; i ++) {
            faithText = faithText + ":heart:";
            if (i + 1 == faith) {
                faithText = faithText + "\n";
            }
        }
        for (int i = 0; i < reputation; i ++) {
            reputationText = reputationText + ":fleur_de_lis:";
            if (i + 1 == reputation) {
                reputationText = reputationText + "\n";
            }
        }

        embed.clear();
        embed.setTitle("Player Stats");
        embed.setDescription(healthText + knowledgeText + strengthText + faithText + reputationText);

        tempEmbed = event.getMessage().getEmbeds();
        tempActioRow = event.getMessage().getActionRows();

        event.editMessageEmbeds(embed.build()).setActionRow(
            Button.primary("back", "back")
        ).queue();
    }

    public void goBack(ButtonInteractionEvent event) {
        event.editMessageEmbeds(tempEmbed).setComponents(tempActioRow).queue();
    }

    public void begin() {
        embed.clear();
        embed.setTitle("The journey begins.. ");
        
        channel.sendMessageEmbeds(embed.build()).addActionRow(
            Button.primary("start01", "Start")
        ).queue(e -> {
            messageId = e.getIdLong();
        });
    }

    private void displayNextDialogueLine(ButtonInteractionEvent event) {

        if (StoryLine.dialogueQueue.isEmpty()) {

            embed.clear();
            embed.setTitle("The End");
            event.editMessageEmbeds(embed.build()).setComponents().queue();

            event.getJDA().removeEventListener(this);
            return;
        } 

        String dialogueLine = StoryLine.dialogueQueue.poll();
        String[] parts = dialogueLine.split(": ");

        if (dialogueLine.startsWith("riddle")) {
            embed.clear();
            embed.setTitle(parts[1]);

            List<LayoutComponent> list = new ArrayList<>();

        for (int i = 0; i < (parts.length - 2); i ++) {
            list.add(ActionRow.of(Button.primary(parts[i + 2], parts[i + 2])));
            }
            event.editMessageEmbeds(embed.build()).setComponents(list).queue();
        }

        else if (dialogueLine.startsWith("options")) {

            embed.clear();
            embed.setTitle(parts[1]);

            List<LayoutComponent> list = new ArrayList<>();

            for(int i = 0; i < (parts.length - 2); i ++) {
                list.add(ActionRow.of(Button.primary(parts[i + 2], parts[i + 2])));
            }

            event.editMessageEmbeds(embed.build()).setComponents(list).queue();
        }

        else if (dialogueLine.startsWith("choice")) {

            embed.clear();
            embed.setTitle(parts[1]);

            List<LayoutComponent> list = new ArrayList<>();

            for(int i = 0; i < (parts.length - 2); i ++) {
                list.add(ActionRow.of(Button.primary(parts[i + 2], parts[i + 2])));
            }

            event.editMessageEmbeds(embed.build()).setComponents(list).queue();
        }
        else {
            embed.clear();
            embed.setAuthor(parts[0]);
            embed.setDescription(parts[1]);

            if (parts[0].equals("Protagonist")) {
                embed.setColor(0xFFFFFF);
            } 
            else if (parts[0].equals("Mysterious Voice")) {
                embed.setColor(0x800080);
            }
            else if (parts[0].equals("Mischievous Sprite")) {
                embed.setColor(0x68cbf8);
            }
            else if (parts[0].equals("Dryad")) {
                embed.setColor(0x5bb450);
            }
            else if (parts[0].equals("Spectral Guardian")) {
                embed.setColor(0x84898b);
            }
            else if (parts[0].equals("Antagonist")) {
                embed.setColor(0xFF0000);
            }
            else if (parts[0].equals("Lily")) {
                embed.setColor(0xFFFFFF);
            }
            else if (parts[0].equals("Narrator")) {
                embed.setColor(0x000000);
            }

            List<LayoutComponent> list = new ArrayList<>();
                list.add(ActionRow.of(Button.success("next02", "Next Line"), Button.secondary("stats", "Stats")));
            event.editMessageEmbeds(embed.build()).setComponents(list).queue();
        }
    }

}




//     private void displayLives(MessageReceivedEvent event) {
//         event.getChannel().sendMessage("Remaining Lives: " + lives).queue();
//     } 
        
//     private void deductLife(MessageReceivedEvent event) {
//         lives--;
//         System.out.println("You have lost a life.");
//         displayLives(event);
//         if (lives <= 0) {
//             gameOver(event);
//         }
//     }
        
//     //monsters
//     private void monsters () {

//     }