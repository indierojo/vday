package com.jonbullock.vday.services;

import com.jonbullock.vday.models.Image;
import com.jonbullock.vday.util.ImagePathParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ImageService {

    private final List<Image> imageList;
    private final Random random;

    private List<String> getImageFileList() {
        List<String> imageList = new ArrayList<>(17);
        imageList.add("1_cc_fire_hot_heat.jpg");
        imageList.add("2_br_leaf_green.jpg");
        imageList.add("3_bl_hand_hold.jpg");
        imageList.add("4_cr_water_liquid_spill.jpg");
        imageList.add("5_cr_yarn_thread_red_string.jpg");
        imageList.add("6_bc_hand_tree_bark.jpg");
        imageList.add("7_tr_snow_boot_tread.jpg");
        imageList.add("8_tl_feet_brick_crack.jpg");
        imageList.add("9_tr_rock_sand_drift.jpg");
        imageList.add("10_br_yarn_felt_cloud_stripe.jpg");
        imageList.add("11_tr_leaf_hold_hand.jpg");
        imageList.add("12_bl_key_lock.jpg");
        imageList.add("13_tc_brick_wall_graffiti.jpg");
        imageList.add("14_tl_red_valentine_hand_hold.jpg");
        imageList.add("15_tc_yellow_flower_bloom.jpg");
        imageList.add("16_bl_fire_hot_heat_splash_liquid_water.jpg");
        imageList.add("17_tr_yellow_leaf.jpg");
        return imageList;
    }

    public ImageService() {
        List<String> imageFileList = getImageFileList();
        imageList = imageFileList.stream()
                .map(ImagePathParser::getImageFrom)
                .collect(Collectors.toList());
        random = new Random();
    }

    public Image getRandomImage() {

        IntStream intStream = random.ints(0, imageList.size());
        return imageList.get(intStream.findAny().getAsInt());
    }

    public Image getById(int id) {
        return imageList.stream().filter(i -> i.getId() == id).findFirst().get();
    }

    public Image getRandomByTag(String tagName) {

        List<Image> matchingImages = imageList.stream()
                .filter(i -> i.containsTag(tagName))
                .collect(Collectors.toList());
        int numImages = matchingImages.size();
        int result = random.ints(0, numImages).findAny().getAsInt();
        return matchingImages.get(result);
    }
}
