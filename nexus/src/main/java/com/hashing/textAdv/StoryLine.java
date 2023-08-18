package com.hashing.textAdv;

import java.util.LinkedList;
import java.util.Queue;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class StoryLine extends ListenerAdapter{

    public static Queue<String> dialogueQueue = new LinkedList<>();
    
// first dialogue sequence
    public static void startDialogueA() {
        dialogueQueue.add("Protagonist: (Confused) Where... Where am I? Everything seems so different.");
        dialogueQueue.add("Mysterious Voice: (Softly) Welcome, traveler, to the realm of ethereal beauty and wonders.");
        dialogueQueue.add("choice: Protagonist: Who are you?: Why did I end up here?: What is this place?");
    }

    public static void answer1() {
        dialogueQueue.add("Mysterious Voice: I am but a guide in this realm, a voice to illuminate your path.");
    }

    public static void answer2() {
        dialogueQueue.add("Mysterious Voice: You will discover the reason within the depths of your own being.");
    }

    public static void answer3() {
        dialogueQueue.add("Mysterious Voice: You have awakened in a place beyond the boundaries of your known existence.");
    }

    public static void startDialogueB() {
        dialogueQueue.add("Protagonist: (Curious) What do you mean? I don't understand.");
        dialogueQueue.add("Mysterious Voice: Fear not, for all will become clear in due time.");
        dialogueQueue.add("Protagonist: I have a strange feeling, like there's a void inside me.?");
        dialogueQueue.add("Mysterious Voice: The path ahead, to fill that void, will be filled with challenges and revelations.");
        dialogueQueue.add("choice: Protagonist: I will do whatever it takes.: I am still slightly confused.: This sounds very unrealistic.");
    }

    public static void answer4() {
        dialogueQueue.add("Mysterious Voice: Very well, brave traveler. Let your spirit be ignited on your journey through this realm.");
    }

    public static void answer5() {
        dialogueQueue.add("Mysterious Voice: In that case, Let your soul be enchanted on your journey through this realm.");
    }

    public static void answer6() {
        dialogueQueue.add("Mysterious Voice: I see, in that case, let your curiosity be awakened on your journey through this realm.");
    }

    public static void startDialogueC() {
        dialogueQueue.add("Narrator: After a while of walking");
        dialogueQueue.add("Protagonist: (Amazed) The air feels charged with magic.");
        dialogueQueue.add("Mysterious Voice: (Whispering) This place is a canvas for imagination, where dreams take shape and possibilities unfold. Embrace the wonder that surrounds you.");
        dialogueQueue.add("Protagonist: (In awe) It's like stepping into a painting. I've never experienced anything like this before.");
        dialogueQueue.add("Mysterious Voice: (Encouraging) Magical creatures reside here. They may aid you in your journey or pose challenges to test your mettle. Stay vigilant and earn their trust.");
        dialogueQueue.add("choice: Protagonist: I will explore every corner.: I will prove myself worthy of their assistance.: I shall see when the time is right");
    }

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
// second part 
    public static void theEnchantedForest() {
        dialogueQueue.add("Narrator: You followed the winding path that led deeper into the Enchanted Forest, where rays of sunlight filtered through the dense canopy, casting an ethereal glow on the moss-covered ground");
        dialogueQueue.add("Protagonist: (Breathing in the fragrant air) The whispers of ancient trees fill my ears.");        
        dialogueQueue.add("Mysterious Voice: (Softly) The Enchanted Forest holds secrets known only to those who dare to explore its depths. Here, the balance between light and shadow, beauty and danger, is delicately intertwined.");
        dialogueQueue.add("Narrator: As the protagonist explores the Enchanted Forest, they encounter a mischievous sprite.");
        dialogueQueue.add("Mischievous Sprite: (Giggling) Welcome, traveler! What brings you to our realm of magic and mischief?");
        dialogueQueue.add("choice: Protagonist: I seek a missing part of me. Can you offer any guidance?: I seek the truth, can you help me?: I seek knowledge, can you be of any help?");
    }

    public static void theEnchantedForest2() {
        dialogueQueue.add("Mischievous Sprite: (Playful) intriguing. A tricky situation. Solve my riddle, and I may offer you a clue to find what you seek.");
        dialogueQueue.add("options: Choose thoughtfully, considering your wisdom.: accept: pass");
    }
            
    public static void forestRiddle() {
        dialogueQueue.add("riddle: I speak without a mouth and hear without ears. I have no body, but i come alive with the wind. What am I?: fire: water: earth");
    }

    public static void fire() {
        dialogueQueue.add("Mischievous Sprite: (Impressed) Well done! You have solved the riddle.");
        dialogueQueue.add("Mischievous Sprite: (Playful) As promised, here's your clue:");
        dialogueQueue.add("Mischievous Sprite: Two hearts entwined, destiny's design, A mirror of souls, in love they shine. Together they dance, a perfect rhyme, A soulmate found, beyond space and time.");
        dialogueQueue.add("Narrator: You successfully solved the riddle and received a clue.");                
    }

    public static void pass() {
        dialogueQueue.add("Mischievous Sprite:battle scene");
    }

    public static void water() {
        dialogueQueue.add("Mischievous Sprite: (Giggling) That's not the correct answer. Try again!");
    }

    public static void earth() {
        dialogueQueue.add("Mischievous Sprite: (Giggling) That's not the correct answer. Try again!");
    }

    public static void afterClue() {
        dialogueQueue.add("Protagonist: (Gazing at the clue, deep in thought) Two hearts entwined, destiny's design... A mirror of souls, in love they shine. Together they dance, a perfect rhyme... A soulmate found, beyond space and time.");
        dialogueQueue.add("Mischievous Sprite: (Observing the protagonist's reaction) Your journey has taken a meaningful turn, seeker of truth.");
        dialogueQueue.add("choice: Protagonist: Please, tell me more.: How can I find this soulmate: How can I find the missing part of myself?");
    }    

    public static void answer7() {
        dialogueQueue.add("Mischievous Sprite: (Mischievously) Patience, dear traveler. The Enchanted Forest holds many secrets, and your path shall reveal itself in due time.");    
        dialogueQueue.add("choice: Protagonist: Thank you for your guidance.: I shall follow the whispers.: I shall trust in the forest's wisdom.");
    }

    public static void answer8() {
        dialogueQueue.add("Narrator: The protagonist's steps become lighter, guided by an invisible thread of destiny. With every stride, they can feel themselves drawing closer to the answers they seek.");
    }
        
    

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // third part

    public static void theWhisperingGlade () {
        dialogueQueue.add("Narrator:You ventured to the Whispering Glade, a hidden sanctuary, where the mystical murmurs of ancient spirits and the gentle rustling of leaves intertwine, bestowing wisdom and solace to those who listen.");
        dialogueQueue.add("Protagonist: (Curious) Among all this magic, there's a soft melody carried by the wind. It seems to be calling me towards that magical looking village over there.");
        dialogueQueue.add("Mysterious Voice: (Whispering) Ah, you have been drawn to Eldoria, a place where secrets are whispered by ancient trees and forgotten melodies linger.");
        dialogueQueue.add("choice Protagonist: I can almost hear the faint whispers.: What secrets do these trees hold?: These woods hold untold wonders, waiting to be unveiled.");
    }
    
    public static void choice9() {
        dialogueQueue.add("Narrator: As the protagonist ventures deeper, they encounter a refined looking guardian of the glade.");
        dialogueQueue.add("Seer: Welcome, wanderer, to Eldoria. I am Mow, the guardian of these ancient trees and the secrets they hold. What brings you to this place of whispers?");
        dialogueQueue.add("Protagonist: (Humbled) I seek my soulmate, the Sprite of the Enchanted Forest told me you can help me. Can you offer any assistance, wise one?");
        dialogueQueue.add("Seer: (Thoughtfully looking at his wife) Love is a powerful force, and it resonates within the heart of this glade."); 
        dialogueQueue.add("choice: Protagonist: Can you guide me, wise Mow? Show me the path to finding my destined one: What if i don't believe in love: I do not feel ready for this mission");
    }

    public static void choice10() {
        dialogueQueue.add("The yearning for a soulmate is a journey that many embark on in search of completeness. The path is not always straightforward, but the whispers of the forest have guided you here for a reason. Listen closely, for the trees carry the wisdom of ages past.");
        dialogueQueue.add("Narrator: The wind picks up, causing the leaves to rustle and dance around the protagonist and the Seer. The air is charged with anticipation as Mow begins to share his insight.");
        dialogueQueue.add("Seer: In this realm of enchantment, the intertwining of souls is often revealed through a shared purpose, a common passion, or a connection that transcends time itself.");
        dialogueQueue.add("Protagonist: (Intrigued) Is there a way to recognize this connection when it appears?");
        dialogueQueue.add("Seer: (Pausing, his eyes filled with depth) It is not always a tangible sign, but rather a feeling that resonates deep within your being. It is a sense of familiarity, a profound understanding that you have found a mirror to your own soul.");
        dialogueQueue.add("Protagonist: (Reflecting) A mirror to my soul... I will hold that feeling close as I continue my journey.");
        dialogueQueue.add("Seer: (Warmly) Remember, seeker of love, that the path may be winding, but trust in the forest's guidance, and you shall be led to your destined one.");
        dialogueQueue.add("Narrator: With the Seer's words echoing in their heart, the protagonist feels a renewed sense of purpose and determination. They bid farewell to Mow, grateful for his guidance, and continue their quest, knowing that the whispers of the Enchanted Forest will lead them closer to their soulmate.");
    }
        

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // fourth part
    public static void theLuminousCaverns() {
        dialogueQueue.add("Protagonist: (Entranced) Look at those shimmering lights emanating from the caverns over there. It's like a sky full of stars upon this forest.");
        dialogueQueue.add("Mysterious Voice: (Softly) You have been drawn to the Luminous Caverns, where starlight dances on crystalline formations, revealing secrets in its glow.");
        dialogueQueue.add("Protagonist: (In awe) The beauty is beyond words. What lies within?");
        dialogueQueue.add("Narrator: As the protagonist ventures deeper, they encounter a spectral guardian, a radiant being made of light.");
        dialogueQueue.add("Spectral Guardian: (Gentle voice) Welcome, seeker of truths, to the Luminous Caverns. I am the guardian of this sacred place. What brings you to this realm of illumination?");
        dialogueQueue.add("Protagonist: (Grateful) I am on a quest to find my wife, Lily. Can you offer any guidance, radiant guardian?");
        dialogueQueue.add("Spectral Guardian: (Wise) Love is a beacon that guides lost souls. Seek the keys of compassion, courage, and forgiveness hidden within this realm. Unite them, and they shall unlock the door to Lily's presence.");
        dialogueQueue.add("Protagonist: (Weary but determined) I have faced countless challenges, battled dark forces, and overcome the illusions that wanted to deceive me. Now my heart beats with anticipation to find Lily and embrace her once more.");
        dialogueQueue.add("Mysterious Voice: (Reassuring) Your journey has forged you into a warrior of love and resilience. Trust in the power of your unbreakable bond, and it shall guide you to your destination.");
        dialogueQueue.add("Protagonist: (Stepping forward, their voice steady) Your reign of darkness ends here. Your jealousy and twisted desires have caused enough pain. I won't let you harm Lily any longer.");
        dialogueQueue.add("Antagonist: (Snickering) Oh, how noble of you, thinking you can stand against me. Lily was meant to be mine, and no amount of false bravery can change that.");
        dialogueQueue.add("Protagonist: (Clutching their weapon tightly) Your delusions won't protect you from the consequences of your actions. Love is not something to possess or control. It is a bond that thrives in freedom and mutual respect.");
        dialogueQueue.add("Antagonist: (Baring their teeth) Love? Respect? Such naïve notions! You know nothing of true power. Lily will see the truth eventually, and when she does, she will come crawling back to me.");
        dialogueQueue.add("Protagonist: (Voice filled with conviction) Lily is strong and independent. She will never choose darkness over love. I will make sure of that.");
        dialogueQueue.add("Narrator: As the battle commences, the protagonist's combat skills are put to the test. They dodge the antagonist's dark spells, retaliating with strikes of their own. The air crackles with magical energy, and the sounds of clashing weapons echo through the battlefield.");
        dialogueQueue.add("Protagonist: (Grinning with determination) Is this the best you can do? Your darkness is nothing compared to the light of our love.");
        dialogueQueue.add("Antagonist: (Growing enraged) You will pay for your insolence! Lily is mine, and I won't let anyone take her away from me!");
        dialogueQueue.add("Protagonist: (Defiant) You may have tried to twist dreams into nightmares, but love prevails over darkness. Lily, I will find you, and together, we will defy the odds.");
        dialogueQueue.add("Narrator: With each strike or spell cast, the protagonist chips away at the antagonist's power, gradually revealing their true form—a desperate and broken soul consumed by jealousy and sorrow.");
        dialogueQueue.add("Antagonist: (Grimacing in pain) No! This cannot be! I am the rightful owner of Lily's heart!");
        dialogueQueue.add("Protagonist: (Breathing heavily but resolute) Love cannot be claimed or owned. It is freely given and received. Lily's heart belongs to only herself.");
        dialogueQueue.add("Narrator: As the battle reaches its climax, the protagonist summons their final reserves of strength and channels their love for Lily into a decisive blow.");
        dialogueQueue.add("Protagonist: (With fierce determination) This ends now!");
        dialogueQueue.add("Narrator: With a brilliant flash of light, the antagonist is momentarily incapacitated, their dark energy wavering. The protagonist approaches cautiously, their heart heavy with the knowledge that the darkness within the antagonist's heart remains unbreakable.");
        dialogueQueue.add("Protagonist: (Gazing at the fallen antagonist) Even in defeat, you refuse to see the truth. Lily deserves better than this. We will find a way to heal and move forward, leaving your darkness behind.");
        dialogueQueue.add("Narrator: With the keys of compassion, courage, and forgiveness obtained from the Luminous Caverns, the protagonist carries a newfound sense of purpose. Guided by their unyielding love for Lily, they venture onward, determined to reunite with their beloved.");
        dialogueQueue.add("Narrator: As they approach the final chamber, a massive door stands before them, adorned with intricate carvings symbolizing the virtues they have embraced. The protagonist steps forward, keys in hand, and carefully inserts each key into its corresponding lock. With a resounding click, the door begins to open, revealing a blinding light beyond.");
        dialogueQueue.add("Protagonist: (Whispering Lily's name) Lily, I'm coming for you.");
        dialogueQueue.add("Narrator: As the protagonist steps through the doorway, the light envelops them, bathing them in its warm embrace. They find themselves in a serene garden, blooming with vibrant flowers and shimmering with magical energy. At the heart of the garden stands Lily, radiant and waiting.");
        dialogueQueue.add("Lily: (Voice filled with love) My dear, you have journeyed through darkness and triumphed. I knew our bond would lead you to me.");
        dialogueQueue.add("Protagonist: (Embracing Lily tightly) Nothing could keep me away from you, Lily. Our love is unbreakable.");
        dialogueQueue.add("Narrator: The two souls, finally reunited, bask in the joy of their embrace.");
    }

}
