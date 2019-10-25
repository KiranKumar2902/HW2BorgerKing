package com.example.hw2bk;

import android.view.Menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ItemDatabase {

    public static Item getItemByID(int itemID) {
        return Items.get(itemID);
    }

    public static ArrayList<Item> getAllItems() {
        return new ArrayList<Item>((List) Arrays.asList(Items.values().toArray()));
    }

    private static final HashMap<Integer, Item> Items = new HashMap<>();

    static {

        Items.put(1, new Item(
                1,
                R.drawable.bigmac,
                "BigMac",
                15.00,
                "Our Big Mac® burger is irresistible with two 100% Aussie beef patties, iceberg lettuce, melting cheese, onions, pickles and our signature sauce. Try one today!",
                0
        ));

        Items.put(2, new Item(
                2,
                R.drawable.bigpatty,
                "BigMeat",
                12.50,
                "We're calling this bad boy the \"Big Meat\" Burger not just because it's a half pound of thick, juicy beef (although that's plenty of reason).",
                0
        ));

        Items.put(3, new Item(
                3,
                R.drawable.breakfast,
                "BreakkyBurger",
                10.00,
                "It starts with a warm, crisp hash brown, melting cheese, rasher bacon and a freshly cracked egg. Finished with a 100% Aussie beef patty and a generous dollop of BBQ sauce in between a toasted sesame seed bun.",
                0
        ));

        Items.put(4, new Item(
                4,
                R.drawable.cheeseburger,
                "Cheeseburger",
                6.00,
                "A legendary combo of 100% Aussie beef, onions, pickle, ketchup, mustard and cheese, all in a soft burger bun.",
                0
        ));


        Items.put(5, new Item(
                5,
                R.drawable.dip,
                "Angus",
                17.00,
                "What's better than a classic Aussie burger filled with crispy bacon, homegrown wholeleaf lettuce, beetroot, 100% Aussie sourced eggs, our juicy 100% Angus beef and a delicious tomato onion relish?",
                0
        ));

        Items.put(6, new Item(
                6,
                R.drawable.flatbread,
                "FlatBurger",
                13.00,
                "Mediterranean style burger filled with pickles and halal meat enveloped in two fresh slices of pita bread",
                0
        ));
        Items.put(7, new Item(
                7,
                R.drawable.lettuce,
                "LettuceFeast",
                9.00,
                "Grilled or Crispy 100% Aussie Chicken Breast, Cheese, Crispy Lettuce, tomato, creamy garlic aioli all on a sesame seed bun. Yum.",
                0
        ));
        Items.put(8, new Item(
                8,
                R.drawable.meal,
                "MushroomFeast",
                9.00,
                "The MushroomFeast burger is an Australian favourite. A juicy beef patty, cheese, tomato, lettuce, pickles, three sauces all on a classic sesame seed bun.",
                0
        ));

        Items.put(9, new Item(
                9,
                R.drawable.pickles,
                "PickledBorger",
                8.00,
                "It's mighty simple, but it works. Take a whole quarter pound* of 100% Aussie beef, then complete the tasty picture with cheese, onions, tangy mustard and pickles. Bet your mouth is watering right now.",
                0
        ));

        Items.put(10, new Item(
                10,
                R.drawable.poppyseed,
                "SeedBorger",
                2.50,
                "The new SeedBorgor made with 100% Aussie Chicken Breast, BBQ sauce, rasher bacon, crisp lettuce, creamy mayo all on a sesame seed bun. What’s not to love?",
                0
        ));

        Items.put(11, new Item(
                11,
                R.drawable.sliders,
                "Sliders",
                2.50,
                "A delicious combination of crispy coated chicken, cheese and mayonnaise.",
                0
        ));

        Items.put(12, new Item(
                12,
                R.drawable.stacked,
                "FeastOfAllFeasts",
                25.00,
                "Multiply the taste. With our 100% Aussie beef, onions, pickle, ketchup, mustard and cheese, all in a soft toasted bun.",
                0
        ));

        Items.put(13, new Item(13,
                R.drawable.tomato,
                "TomatoBorger",
                14.50,
                "Rejoice: the TomatoBorger you know and love now has a spicy twist with the introduction of the Spicy Chicken Clubhouse. Mouth-watering 100% Aussie Chicken breast, tasty rasher bacon, caramelised onions, tomato, lettuce, spicy Sriracha sauce and our legendary Big Mac special sauce.",
                0
        ));

        Items.put(14, new Item(
                14,
                R.drawable.whopper,
                "Whopperv2",
                14.00,
                "It’s not rocket science why the Whopperv2®, our largest burger, has been an Aussie favourite for over 40 years. It’s just 100% Aussie beef, flame-grilled to perfection. Every time.",
                0

        ));


        Items.put(15, new Item(
                15,
                R.drawable.flag,
                "Stacker",
                20.00,
                "Try our new Whopper® Cheese Your Way range. Pick a Whopper Cheese and stack with single, double or triple flame-grilled beef. It's your Whopper, your way!",
                0
        ));


    }

}