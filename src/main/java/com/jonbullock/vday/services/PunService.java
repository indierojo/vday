package com.jonbullock.vday.services;

import java.util.*;

public class PunService {

    private final Map<String, List<String>> punMap;
    private final Random random;

    private Map<String, List<String>> getPunMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("bark", getPunListFor("Let's em-bark on a love journey!"));
        map.put("boot", getPunListFor("You boot me up!", "I'm all a-boot your love!"));
        map.put("bloom", getPunListFor("Bloom-shaka-laka! I love you!", "You make me bloom!"));
        map.put("brick", getPunListFor("You're not just another brick in the wall!"));
        map.put("crack", getPunListFor("You have a way of crack-ing me up!", "Unleash the love Crack-en!"));
        map.put("cloud", getPunListFor("There are no cloudy days with you!"));
        map.put("drift", getPunListFor("I'm glad you drifted into my heart!"));
        map.put("feet", getPunListFor("Our love is quite a feet of strength!"));
        map.put("felt", getPunListFor("I've never felt so happy!", "I've never felt this way before!"));
        map.put("fire", getPunListFor("You fire me up!", "I'm on fire, love!"));
        map.put("flower", getPunListFor("I'm going to flower you with kisses!"));
        map.put("green", getPunListFor("If you asked me if I loved you, of course I'd be a-green!"));
        map.put("graffiti", getPunListFor("You're sweeter than gravy tea!"));
        map.put("hand", getPunListFor("I've really gotta hand it to you!", "Hand by me!"));
        map.put("heat", getPunListFor("You heat up my world!"));
        map.put("hold", getPunListFor("Hold me close, lover!", "I've got a-hold of you!"));
        map.put("hot", getPunListFor("I've got the hots for you!", "Hotty."));
        map.put("key", getPunListFor("You've got the key to my heart!"));
        map.put("leaf", getPunListFor("You leaf me breathless!"));
        map.put("liquid", getPunListFor("Liquid love. Yeah."));
        map.put("lock", getPunListFor("You've got me on lock-down!"));
        map.put("red", getPunListFor("You red my mind -- I love you!", "I'm so red-dy for your love!"));
        map.put("rock", getPunListFor("You rock my socks off, lover!", "You rock me like a hurricane!"));
        map.put("sand", getPunListFor("I can't sand to be without you!", "I'll sand by you!"));
        map.put("snow", getPunListFor("Snow way could anyone love you more than me!", "You snow that I love you."));
        map.put("spill", getPunListFor("I spill love you after all these years!"));
        map.put("splash", getPunListFor("You've really made a splash!", "You're way better than the movie Splash!"));
        map.put("string", getPunListFor("You hold the strings to my heart!", "You string-then me!"));
        map.put("stripe", getPunListFor("You're st-ripe for lovin!"));
        map.put("thread", getPunListFor("I thread a love story the other day and thought of you!"));
        map.put("tread", getPunListFor("I tread to think of any love but ours!", "Are you tread-y for love?"));
        map.put("tree", getPunListFor("I be-tree-ch you to find someone who loves you more!"));
        map.put("valentine", getPunListFor("Will you be my valentine?"));
        map.put("water", getPunListFor("Water you going to do with all this love?"));
        map.put("wall", getPunListFor("You make me feel wall fuzzy inside.", "Wall I want is you!"));
        map.put("yarn", getPunListFor("I yarn to be near you!", "Ya[ea]rn-ed all this love!"));
        map.put("yellow", getPunListFor("Yellow there, beautiful.", "I yell-OH! when I see you!"));
        return map;
    }

    private List<String> getPunListFor(String... s) {
        List<String> punList = new ArrayList<>(s.length);
        Collections.addAll(punList, s);
        return punList;
    }

    public PunService() {
        punMap = getPunMap();
        random = new Random();
    }

    public String getRandomPunFor(List<String> tags) {
        int numberOfTags = tags.size();
        String pickedTag;
        if(numberOfTags == 1) {
            pickedTag = tags.get(0);
        } else {
            int randomTagNumber = random.ints(0, numberOfTags).findAny().getAsInt();
            pickedTag = tags.get(randomTagNumber);
        }

        return getRandomPunFor(pickedTag);
    }

    public String getRandomPunFor(String tag) {
        tag = tag.toLowerCase();
        if(!punMap.containsKey(tag)) {
            throw new RuntimeException("Tag: " + tag + " does not exist!");
        }

        List<String> punsForTag = punMap.get(tag);
        int numberOfPuns = punsForTag.size();
        if(numberOfPuns == 0) {
            throw new RuntimeException("No pun found for tag: " + tag + "!");
        }

        String pickedPun;
        if(numberOfPuns == 1) {
            pickedPun = punsForTag.get(0);
        } else {
            int randomTagNumber = random.ints(0, numberOfPuns).findAny().getAsInt();
            pickedPun = punsForTag.get(randomTagNumber);
        }

        return pickedPun;
    }
}
