package com.jonbullock.vday.services;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PunServiceTest {

    private final PunService punService = new PunService();

    @Test
    public void it_should_find_a_random_pun() {
        String pun = punService.getRandomPunFor("Water");
        assertNotNull(pun);
        assertTrue(!pun.isEmpty());
    }

    @Test
    public void testGetRandomPunForTags() throws Exception {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("Water");
        tags.add("Valentine");

        // Water and Valentine each have 1 pun. We want to run
        //   through and make sure that it is getting both of them.

        Set<String> uniquePuns = new HashSet<>(2);
        for (int i = 0; i < 100; i++) {
            String pun = punService.getRandomPunFor(tags);
            uniquePuns.add(pun);

            if(uniquePuns.size() == 2) {
                break;
            }
        }

        // Todo: It is possible that this will occasionally not work.
        // Todo:   Since it is random.
        assertEquals(2, uniquePuns.size());
    }

    @Test
    public void testGetRandomPunForTag() throws Exception {
        Set<String> uniquePuns = new HashSet<>(2);
        for (int i = 0; i < 100; i++) {
            String pun = punService.getRandomPunFor("tread");
            uniquePuns.add(pun);

            // Tread has 2 different puns, we want to run through and
            //   make sure that it finds both of them.

            if(uniquePuns.size() == 2) {
                break;
            }
        }

        // Todo: It is possible that this will occasionally not work.
        // Todo:   Since it is random.
        assertEquals(2, uniquePuns.size());
    }
}