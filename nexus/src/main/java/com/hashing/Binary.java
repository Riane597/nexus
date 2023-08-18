package com.hashing;

import java.util.Random;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.EmbedBuilder;

public class Binary extends ListenerAdapter{

    

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()) {
            return;
        }
    
        MessageChannelUnion channel = event.getChannel();
        String messageContent = event.getMessage().getContentRaw().trim();

        if (messageContent.startsWith(".enbcd")) {
            event.getJDA().addEventListener(new Encode(channel));
        }

        if (messageContent.startsWith(".debcd")) {
            event.getJDA().addEventListener(new Decode(channel));
        }
        
        if (messageContent.startsWith(".enoct")) {
            event.getJDA().addEventListener(new decimalToOctal(channel));
        }

        if (messageContent.startsWith(".deoct")) {
            event.getJDA().addEventListener(new octalToDecimal(channel));
        }
    }


    class Decode extends ListenerAdapter {
        private final Random random = new Random();
        private MessageChannelUnion channel;
    
        public Decode(MessageChannelUnion channel) {
            this.channel = channel;
            play();
        }
    
        private int currentDecimal = 0;
        private String expected = null;
        private boolean isDecoding = false;
    
        public void play() {
            
            if(currentDecimal == 0) {
                currentDecimal = getRandomDecimal();
            }
    
            expected = encodeToBCD(currentDecimal);
            
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("BCD");
            embed.setDescription("Write the decimal for: " + expected);
            channel.sendMessageEmbeds(embed.build()).queue();
    
            isDecoding = true;
        }
    
        @Override
        public void onMessageReceived(MessageReceivedEvent event) {
            
            if (event.getAuthor().isBot()) {
                return;
            }
    
            String messageContent = event.getMessage().getContentRaw().trim();
    
                if(isDecoding){
                if(currentDecimal != 0) {  
                    if(messageContent.equals(String.valueOf(currentDecimal))) {
                        channel.sendMessage("Correct").queue();
                        
                        currentDecimal = 0;
                        isDecoding = false;
                        expected = null;
                    
                        event.getJDA().removeEventListener(this);
    
                    } else {
                        channel.sendMessage("Not Correct").queue();
                    }
                }
    
                if (currentDecimal != 0) {
                    isDecoding = true;
                }
            }
        }
    
        private int getRandomDecimal() {
            // return random.nextInt(1000);
            return Math.abs(random.nextInt());
        }
    
        private String encodeToBCD(int decimal) {
            StringBuilder bcdBuilder = new StringBuilder();
            String decimalString = String.valueOf(decimal);
            for (int i = 0; i < decimalString.length(); i++) {
                char digit = decimalString.charAt(i);
                String bcd = getBCD(digit);
                bcdBuilder.append(bcd).append(" ");
            }
            return bcdBuilder.toString().trim();
        }
    
        private String getBCD(char digit) {
            switch (digit) {
                case '0':
                    return "0000";
                case '1':
                    return "0001";
                case '2':
                    return "0010";
                case '3':
                    return "0011";
                case '4':
                    return "0100";
                case '5':
                    return "0101";
                case '6':
                    return "0110";
                case '7':
                    return "0111";
                case '8':
                    return "1000";
                case '9':
                    return "1001";
                default:
                    return "";
            }
        }
    }
    
    // --------------------------------------------------------------
    
    class Encode extends ListenerAdapter {
    
        private final Random ran = new Random();
        private MessageChannelUnion channel;
    
        public Encode(MessageChannelUnion channel) {
            this.channel = channel;
            play();
        }
    
        private int currentDecimal = 0;
        private String answer = null;
        private boolean running = false;
    
        public void play() {
    
            if (currentDecimal == 0) {
                currentDecimal = getRandomDecimal();
            }
    
            answer = encodeToBCD(currentDecimal);
    
            EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle(Integer.toString(currentDecimal));
                embed.setDescription("Give the BCD");
            channel.sendMessageEmbeds(embed.build()).queue();
    
            running = true;
        }
    
        public void onMessageReceived(MessageReceivedEvent event) {
    
            if (event.getAuthor().isBot()) {
                return;
            }
    
            String messageContent = event.getMessage().getContentRaw().trim();
     
            if (running) {
                if(messageContent.equals(answer)) {
                    channel.sendMessage("Correct").queue();
    
                    currentDecimal = 0;
                    running = false;
                    answer = null;
    
                event.getJDA().removeEventListener(this);
    
                } else {
                    channel.sendMessage("Not Correct").queue();
                }
            }
    
            if (currentDecimal != 0) {
                running = true;
            }
    
        }
    
        private int getRandomDecimal() {
            return Math.abs(ran.nextInt());
        }
    
        private String encodeToBCD(int currentDecimal) {
            StringBuilder answerExpected = new StringBuilder();
            String decimalString = String.valueOf(currentDecimal);
            for (int i = 0; i < decimalString.length(); i++) {
                char digit = decimalString.charAt(i);
                String bcd = getBCD(digit);
                answerExpected.append(bcd).append(" ");
                }
            return answerExpected.toString().trim();
        }
    
        private String getBCD(char digit) {
            switch (digit) {
                case '0':
                return "0000";
            case '1':
                return "0001";
            case '2':
                return "0010";
            case '3':
                return "0011";
            case '4':
                return "0100";
            case '5':
                return "0101";
            case '6':
                return "0110";
            case '7':
                return "0111";
            case '8':
                return "1000";
            case '9':
                return "1001";
            default:
                return "";
            }
        }
    }
    
    //---------------------------------------------------------------------
    
    class octalToDecimal extends ListenerAdapter {
        private final Random random = new Random();
        private MessageChannelUnion channel;
    
        public octalToDecimal(MessageChannelUnion channel) {
            this.channel = channel;
            play();
        }
    
        private int currentOctal = 0;
        private String expected = null;
        private boolean isDecoding = false;
    
        public void play() {
            if(currentOctal == 0) {
                currentOctal = getRandomOctal();
            }
    
            expected = encodeToOctal(currentOctal);
            
            EmbedBuilder embed = new EmbedBuilder();
            embed.setTitle("Octal");
            embed.setDescription("Write the decimal for: " + expected);
            channel.sendMessageEmbeds(embed.build()).queue();
    
            isDecoding = true;
        }
    
        @Override
        public void onMessageReceived(MessageReceivedEvent event) {
            if (event.getAuthor().isBot()) {
                return;
            }
    
            String messageContent = event.getMessage().getContentRaw().trim();
    
            if(isDecoding){
                if(currentOctal != 0) {  
                    try{
                        int userDecimal = Integer.parseInt(messageContent);
    
                    if(userDecimal == currentOctal) {
                        channel.sendMessage("Correct").queue();
                        
                        currentOctal = 0;
                        isDecoding = false;
                        expected = null;
                    
                        event.getJDA().removeEventListener(this);
    
                    } else {
                        channel.sendMessage("Not Correct").queue();
                    }
                } catch (NumberFormatException e) {
                        channel.sendMessage("Please enter a decimal");
                }
            }
    
                if (currentOctal != 0) {
                    isDecoding = true;
                }
            }
        }
    
        private int getRandomOctal() {
            return Math.abs(random.nextInt());
        }
    
        private String encodeToOctal(int decimal) {
            StringBuilder octalBuilder = new StringBuilder();
            String decimalString = String.valueOf(decimal);
            for (int i = 0; i < decimalString.length(); i++) {
                char digit = decimalString.charAt(i);
                String octal = getOctal(digit);
                octalBuilder.append(octal);
            }
            return octalBuilder.toString();
        }
    
        private String getOctal(char digit) {
            switch (digit) {
                case '0':
                    return "000";
                case '1':
                    return "001";
                case '2':
                    return "010";
                case '3':
                    return "011";
                case '4':
                    return "100";
                case '5':
                    return "101";
                case '6':
                    return "110";
                case '7':
                    return "111";
                default:
                    return "";
            }
        }
    }    
    
        //--------------------------------------------------------------------------------
    
        class decimalToOctal extends ListenerAdapter {
    
            private final Random ran = new Random();
            private MessageChannelUnion channel;
        
            public decimalToOctal(MessageChannelUnion channel) {
                this.channel = channel;
                play();
            }
        
            private int currentOctal = 0;
            private boolean running = false;
        
            public void play() {
                currentOctal = getRandomDecimal();
                encodeToOctal(currentOctal);
                
                EmbedBuilder embed = new EmbedBuilder();
                embed.setTitle(Integer.toString(currentOctal));
                    embed.setDescription("Give the Octal");
                channel.sendMessageEmbeds(embed.build()).queue();
        
                running = true;
            }
    
            @Override
            public void onMessageReceived(MessageReceivedEvent event) {
                if (event.getAuthor().isBot()) {
                    return;
                }
        
                String messageContent = event.getMessage().getContentRaw().trim();
         
                if(running){
                    if(currentOctal != 0) {  
                        try{
                            int userOctal = Integer.parseInt(messageContent, 8);
        
                        if(userOctal == currentOctal) {
                            channel.sendMessage("Correct").queue();
                            
                            currentOctal = 0;
                            running = false;
                            event.getJDA().removeEventListener(this);
        
                        } else {
                            channel.sendMessage("Not Correct").queue();
                        }
                    } catch (NumberFormatException e) {
                            channel.sendMessage("Please enter an octal").queue();
                    }
                }
        
                    if (currentOctal != 0) {
                        running = true;
                    }
                }
            }
        
            private int getRandomDecimal() {
                int randomNumber = ran.nextInt(100000);
                String decimalString = Integer.toString(randomNumber);
    
                for (char digit : decimalString.toCharArray()) {
                    if (digit < '0' || digit > '7') {
                        return getRandomDecimal();  // Recursively generate a new random number
                    }
                }
                
                return randomNumber;
            }
        
            private String encodeToOctal(int currentDecimal) {
                StringBuilder answerExpected = new StringBuilder();
                String decimalString = String.valueOf(currentDecimal);
                for (int i = 0; i < decimalString.length(); i++) {
                    char digit = decimalString.charAt(i);
                    String octal = getOctal(digit);
                    answerExpected.append(octal).append(" ");
                    }
                return Integer.toOctalString(currentOctal).trim();
            }
        
            private String getOctal(char digit) {
                switch (digit) {
                    case '0':
                        return "000";
                    case '1':
                        return "001";
                    case '2':
                        return "010";
                    case '3':
                        return "011";
                    case '4':
                        return "100";
                    case '5':
                        return "101";
                    case '6':
                        return "110";
                    case '7':
                        return "111";
                    default:
                        return "";
            }
        }
    }
}
