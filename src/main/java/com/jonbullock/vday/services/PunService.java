package com.jonbullock.vday.services;

import com.jonbullock.vday.util.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.*;

public class PunService {

    private final Map<String, List<String>> punMap;
    private final Random random;

    public PunService(String filePath) {
        try {
            String punsFileAsString = FileUtils.readToString(filePath);
            JSONArray tagPunArray = new JSONArray(punsFileAsString);
            int numberOfTags = tagPunArray.length();

            punMap = new HashMap<>(numberOfTags);
            for (int i = 0; i < numberOfTags; i++) {
                parsePunEntryToMap(tagPunArray, i);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read or parse data/puns.json file in resource directory!");
        }

        random = new Random();
    }

    private void parsePunEntryToMap(JSONArray tagPunArray, int i) {
        JSONObject object = tagPunArray.getJSONObject(i);
        JSONArray puns = object.getJSONArray("puns");

        int numberOfPuns = puns.length();
        if(numberOfPuns == 0) {
            return;
        }
        String tag = object.getString("tag");
        List<String> punsForTag = new ArrayList<>(numberOfPuns);

        for(int k = 0; k < numberOfPuns; k++) {
            String pun = puns.getString(k);
            punsForTag.add(pun);
        }

        punMap.put(tag, punsForTag);
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
