package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void golden_master() throws IOException {
        Random rnd = new Random(42);
        String[] names = {
            "Aged Brie",
            "Backstage passes to a TAFKAL80ETC concert",
            "Sulfuras, Hand of Ragnaros",
            "Conjured Mana Cake",
            ""
        };

        Item[] items = new Item[500];

        for (int i = 0; i < 500; i++) {

            int sellin = rnd.nextInt(-100, 100);// -100 et 100
            int quality = rnd.nextInt(-100, 100);// -100 et 100

            items[i] = (new Item(names[rnd.nextInt(0, names.length)], sellin, quality));
        }

        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

/*
        Files.createFile(Path.of("golden-master.txt"));
        Arrays.stream(items).forEach( i -> {
            try {
                Files.write(Path.of("golden-master.txt"), i.toString().getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
*/
        StringBuilder itemstoStr = new StringBuilder("\"");
        Arrays.stream(items).forEach(itemstoStr::append);
        itemstoStr.append("\"");
        String goldenMaster = "Conjured Mana Cake, 29, 62Aged Brie, -17, 70, 4, 17Sulfuras, Hand of Ragnaros, -7, 82Backstage passes to a TAFKAL80ETC concert, -25, 0Aged Brie, -69, -42Aged Brie, 42, -90Conjured Mana Cake, -38, -74Aged Brie, -58, -57Backstage passes to a TAFKAL80ETC concert, -43, 0Aged Brie, 29, 56Sulfuras, Hand of Ragnaros, -15, -83Conjured Mana Cake, -89, -7Aged Brie, 63, 79Aged Brie, -78, 39Aged Brie, 33, -92Conjured Mana Cake, 56, -57Backstage passes to a TAFKAL80ETC concert, -61, 0Conjured Mana Cake, 59, -90Conjured Mana Cake, -42, -39Sulfuras, Hand of Ragnaros, -3, -81, -100, -6Aged Brie, 97, 20Backstage passes to a TAFKAL80ETC concert, -2, 0Conjured Mana Cake, -48, -71Aged Brie, 32, 86Aged Brie, -76, -5Sulfuras, Hand of Ragnaros, 94, -97, -94, 91, 43, 97Conjured Mana Cake, 46, -4Conjured Mana Cake, -6, 57Backstage passes to a TAFKAL80ETC concert, -72, 0Aged Brie, 27, -29Conjured Mana Cake, 31, -71Backstage passes to a TAFKAL80ETC concert, 10, 10Backstage passes to a TAFKAL80ETC concert, -26, 0Backstage passes to a TAFKAL80ETC concert, 3, 97Backstage passes to a TAFKAL80ETC concert, -70, 0, 94, -94Conjured Mana Cake, -55, -72Sulfuras, Hand of Ragnaros, 23, -48Conjured Mana Cake, 21, 22Sulfuras, Hand of Ragnaros, -98, 52Sulfuras, Hand of Ragnaros, -62, 32Sulfuras, Hand of Ragnaros, 68, 25Conjured Mana Cake, -74, -67Conjured Mana Cake, -74, 19Conjured Mana Cake, 3, -97Backstage passes to a TAFKAL80ETC concert, -8, 0Backstage passes to a TAFKAL80ETC concert, -71, 0, 54, -19Sulfuras, Hand of Ragnaros, -100, 51Backstage passes to a TAFKAL80ETC concert, -60, 0Aged Brie, 39, -89, -31, -70, -72, -9Conjured Mana Cake, -67, 39Sulfuras, Hand of Ragnaros, -94, -19Sulfuras, Hand of Ragnaros, 96, 29Aged Brie, -55, 89Aged Brie, 98, 74Sulfuras, Hand of Ragnaros, 36, 45Conjured Mana Cake, 30, 97Backstage passes to a TAFKAL80ETC concert, -35, 0Conjured Mana Cake, 78, 88, 92, 73Conjured Mana Cake, -33, 76Sulfuras, Hand of Ragnaros, -31, 77Aged Brie, 90, -45Conjured Mana Cake, 49, -7Aged Brie, 47, -5Conjured Mana Cake, 58, 30Backstage passes to a TAFKAL80ETC concert, 22, -24Conjured Mana Cake, 10, -57Conjured Mana Cake, 52, -84Aged Brie, 73, 87Sulfuras, Hand of Ragnaros, -83, 18Sulfuras, Hand of Ragnaros, -34, -41Aged Brie, 9, 53Backstage passes to a TAFKAL80ETC concert, 85, -13Backstage passes to a TAFKAL80ETC concert, -71, 0Aged Brie, 40, -8Aged Brie, -26, 93Conjured Mana Cake, -20, -75, -6, -41Conjured Mana Cake, -86, 29Backstage passes to a TAFKAL80ETC concert, 8, 60Aged Brie, -37, 49Backstage passes to a TAFKAL80ETC concert, 6, 1Conjured Mana Cake, -7, 38, -70, 8Conjured Mana Cake, 85, -94, -59, -33Aged Brie, -49, 39Conjured Mana Cake, -35, -81Aged Brie, 24, 90Sulfuras, Hand of Ragnaros, -82, -81Conjured Mana Cake, 6, -63Conjured Mana Cake, 74, -59, -54, 87, -35, 58Backstage passes to a TAFKAL80ETC concert, 12, -66Conjured Mana Cake, 51, 64Conjured Mana Cake, 83, -26Conjured Mana Cake, -7, 53Sulfuras, Hand of Ragnaros, -95, -100, -96, -6, -13, 16Sulfuras, Hand of Ragnaros, 81, 86Backstage passes to a TAFKAL80ETC concert, -53, 0Backstage passes to a TAFKAL80ETC concert, 36, -63Backstage passes to a TAFKAL80ETC concert, -44, 0, 85, 8Backstage passes to a TAFKAL80ETC concert, -94, 0Conjured Mana Cake, -13, -58, 58, 17Backstage passes to a TAFKAL80ETC concert, 56, -58Backstage passes to a TAFKAL80ETC concert, -41, 0Sulfuras, Hand of Ragnaros, -88, -93Aged Brie, 22, 77, 1, -44Backstage passes to a TAFKAL80ETC concert, 64, -73Backstage passes to a TAFKAL80ETC concert, 79, -4Sulfuras, Hand of Ragnaros, 18, -19, 65, 28Sulfuras, Hand of Ragnaros, 65, 88Aged Brie, 91, 52Sulfuras, Hand of Ragnaros, -98, -13Backstage passes to a TAFKAL80ETC concert, 44, 16Conjured Mana Cake, -69, 48Backstage passes to a TAFKAL80ETC concert, -72, 0Sulfuras, Hand of Ragnaros, 17, 46Sulfuras, Hand of Ragnaros, -40, -7Conjured Mana Cake, 46, 42Backstage passes to a TAFKAL80ETC concert, -68, 0Aged Brie, 9, 43Conjured Mana Cake, -70, 35Conjured Mana Cake, -93, -6Aged Brie, -34, -85Conjured Mana Cake, -52, -52Aged Brie, -6, 74, -54, -12, 52, -46Backstage passes to a TAFKAL80ETC concert, 10, -91Backstage passes to a TAFKAL80ETC concert, -42, 0, 3, 0Aged Brie, -63, 91Sulfuras, Hand of Ragnaros, -6, -2Sulfuras, Hand of Ragnaros, -99, 21Aged Brie, -71, -20Sulfuras, Hand of Ragnaros, 18, -3Conjured Mana Cake, -37, -59Sulfuras, Hand of Ragnaros, 25, -19Conjured Mana Cake, 58, 58, -4, 41, 98, 45Backstage passes to a TAFKAL80ETC concert, 16, 57Aged Brie, -95, -4Backstage passes to a TAFKAL80ETC concert, -36, 0Aged Brie, 56, -1Sulfuras, Hand of Ragnaros, 48, 30Backstage passes to a TAFKAL80ETC concert, 85, -45Sulfuras, Hand of Ragnaros, -99, 90Conjured Mana Cake, -67, -96, 20, -26Conjured Mana Cake, -85, -97Conjured Mana Cake, -25, -9Conjured Mana Cake, 49, 69, 94, 3, -82, -67Sulfuras, Hand of Ragnaros, 34, 21Conjured Mana Cake, -16, -29, -26, -32Backstage passes to a TAFKAL80ETC concert, 24, -48Conjured Mana Cake, 29, -33, 37, 41Aged Brie, 73, 82Aged Brie, 25, 65Backstage passes to a TAFKAL80ETC concert, 74, -86, -1, -99Backstage passes to a TAFKAL80ETC concert, -7, 0Conjured Mana Cake, -27, 25Aged Brie, -76, -50Conjured Mana Cake, -88, 34Sulfuras, Hand of Ragnaros, -8, 14Conjured Mana Cake, 90, 66Conjured Mana Cake, 68, -89Conjured Mana Cake, 36, -47Sulfuras, Hand of Ragnaros, 57, -43Aged Brie, 63, -57, -12, -56Conjured Mana Cake, 13, -18Aged Brie, -47, 18, 49, 50Conjured Mana Cake, -37, 54Sulfuras, Hand of Ragnaros, -74, 83Conjured Mana Cake, -56, 13Sulfuras, Hand of Ragnaros, 72, -76, -8, -18Conjured Mana Cake, 45, -41Aged Brie, 32, -94Conjured Mana Cake, -66, -22, -19, -94Conjured Mana Cake, 2, -71Conjured Mana Cake, -80, -27, 72, 74Sulfuras, Hand of Ragnaros, 28, -78Conjured Mana Cake, 16, -93Sulfuras, Hand of Ragnaros, 90, -59, -50, -62Conjured Mana Cake, 21, -22, 93, 90, 67, -54Sulfuras, Hand of Ragnaros, -10, -52, 26, -67Sulfuras, Hand of Ragnaros, 88, 78Backstage passes to a TAFKAL80ETC concert, -61, 0, -83, -93Aged Brie, -92, -77Aged Brie, 18, -93Sulfuras, Hand of Ragnaros, 29, -2Sulfuras, Hand of Ragnaros, 70, 9Backstage passes to a TAFKAL80ETC concert, -1, 0Backstage passes to a TAFKAL80ETC concert, 89, -16Conjured Mana Cake, 31, -72Conjured Mana Cake, -78, -29, -40, 87Sulfuras, Hand of Ragnaros, 86, -69Aged Brie, 39, -38Sulfuras, Hand of Ragnaros, -72, 31, 11, -76Conjured Mana Cake, -45, -32Sulfuras, Hand of Ragnaros, 38, 95, 31, 66Aged Brie, 87, -18, 55, -44Aged Brie, -83, -49Backstage passes to a TAFKAL80ETC concert, 6, 6Backstage passes to a TAFKAL80ETC concert, 49, -38Sulfuras, Hand of Ragnaros, 95, 35Conjured Mana Cake, -92, 43Aged Brie, 7, 96Aged Brie, 43, 5Aged Brie, -30, 68Conjured Mana Cake, 87, 31Sulfuras, Hand of Ragnaros, -72, 88Aged Brie, 73, -51Conjured Mana Cake, -2, -18, 48, 77Backstage passes to a TAFKAL80ETC concert, 95, 54Backstage passes to a TAFKAL80ETC concert, 15, -96, 48, 76, -64, 22Conjured Mana Cake, -89, -17Backstage passes to a TAFKAL80ETC concert, -71, 0, 38, 29Aged Brie, -100, 90, -34, -83, -41, -33, -16, 34Backstage passes to a TAFKAL80ETC concert, -35, 0Aged Brie, -2, 99Backstage passes to a TAFKAL80ETC concert, 68, -81Conjured Mana Cake, 61, -18Sulfuras, Hand of Ragnaros, 74, 67Aged Brie, 29, 47Backstage passes to a TAFKAL80ETC concert, -30, 0Backstage passes to a TAFKAL80ETC concert, 90, 70Conjured Mana Cake, -49, -84Conjured Mana Cake, -41, -59Aged Brie, 13, -73Backstage passes to a TAFKAL80ETC concert, -19, 0Conjured Mana Cake, -37, -3Aged Brie, 0, 53Backstage passes to a TAFKAL80ETC concert, -30, 0Sulfuras, Hand of Ragnaros, 48, -29, 47, -80Backstage passes to a TAFKAL80ETC concert, -42, 0Backstage passes to a TAFKAL80ETC concert, -101, 0Backstage passes to a TAFKAL80ETC concert, -1, 0Conjured Mana Cake, 34, 44, -21, 37Aged Brie, 41, -91Backstage passes to a TAFKAL80ETC concert, 51, 39Sulfuras, Hand of Ragnaros, -15, -9Conjured Mana Cake, 73, -37, 70, -84Aged Brie, -55, -48Sulfuras, Hand of Ragnaros, -50, 67, 79, 28Backstage passes to a TAFKAL80ETC concert, 5, -14Backstage passes to a TAFKAL80ETC concert, -4, 0, 63, 2Conjured Mana Cake, -16, -18Aged Brie, -98, 56Sulfuras, Hand of Ragnaros, -94, 4Conjured Mana Cake, -9, 47, 91, -18Backstage passes to a TAFKAL80ETC concert, -53, 0Aged Brie, -24, 6Backstage passes to a TAFKAL80ETC concert, -84, 0Conjured Mana Cake, 54, 98Backstage passes to a TAFKAL80ETC concert, 10, -34Sulfuras, Hand of Ragnaros, 57, 91Sulfuras, Hand of Ragnaros, 30, 98Conjured Mana Cake, 28, -17Aged Brie, -74, 43Aged Brie, -101, 70Aged Brie, 25, -81Backstage passes to a TAFKAL80ETC concert, -41, 0Conjured Mana Cake, 37, 18Backstage passes to a TAFKAL80ETC concert, 0, -52Sulfuras, Hand of Ragnaros, 61, 28Sulfuras, Hand of Ragnaros, 40, 20, 7, 44Aged Brie, -41, 11Conjured Mana Cake, -72, 85Sulfuras, Hand of Ragnaros, -31, 82Aged Brie, -63, 20Sulfuras, Hand of Ragnaros, 87, 84Sulfuras, Hand of Ragnaros, 23, 94Sulfuras, Hand of Ragnaros, 75, -65Aged Brie, -11, -39, -30, 0Backstage passes to a TAFKAL80ETC concert, 0, 32Aged Brie, -86, 97, 87, 61Backstage passes to a TAFKAL80ETC concert, -15, 0Conjured Mana Cake, -92, 26, -81, -73Backstage passes to a TAFKAL80ETC concert, 21, -34Sulfuras, Hand of Ragnaros, 61, 42Aged Brie, 7, 17Aged Brie, -9, -60Conjured Mana Cake, 35, 35Conjured Mana Cake, 82, 73, 4, 30Backstage passes to a TAFKAL80ETC concert, 17, -7, -15, -44Sulfuras, Hand of Ragnaros, 8, -65Backstage passes to a TAFKAL80ETC concert, -25, 0Sulfuras, Hand of Ragnaros, -43, 59Sulfuras, Hand of Ragnaros, 92, 19Backstage passes to a TAFKAL80ETC concert, -53, 0Aged Brie, -45, -24Conjured Mana Cake, 85, 96Backstage passes to a TAFKAL80ETC concert, -99, 0, -97, -39Sulfuras, Hand of Ragnaros, 45, -35Sulfuras, Hand of Ragnaros, -8, -81Aged Brie, -97, 7Aged Brie, -79, -35Conjured Mana Cake, 42, 63Sulfuras, Hand of Ragnaros, 44, 63Aged Brie, -21, -53Sulfuras, Hand of Ragnaros, -95, -53Sulfuras, Hand of Ragnaros, 20, -66Aged Brie, -81, -59Backstage passes to a TAFKAL80ETC concert, -14, 0Conjured Mana Cake, 43, -31Aged Brie, -76, -30Backstage passes to a TAFKAL80ETC concert, 51, 69, 61, 76Conjured Mana Cake, -77, -100Conjured Mana Cake, 36, -68, 63, 36Sulfuras, Hand of Ragnaros, -89, -11Aged Brie, 25, -47, 53, -71Sulfuras, Hand of Ragnaros, 42, -42Backstage passes to a TAFKAL80ETC concert, -78, 0Conjured Mana Cake, -14, -20, -89, 73Conjured Mana Cake, -13, -34, -63, -55, 62, 68Conjured Mana Cake, 51, 55Sulfuras, Hand of Ragnaros, -5, 16Backstage passes to a TAFKAL80ETC concert, -75, 0Backstage passes to a TAFKAL80ETC concert, 47, 76Aged Brie, 49, 4Sulfuras, Hand of Ragnaros, 59, -73Aged Brie, 93, -23Sulfuras, Hand of Ragnaros, 24, -57, 78, -27Backstage passes to a TAFKAL80ETC concert, 53, -62, 28, -32Aged Brie, -6, -78, -58, -21Conjured Mana Cake, -13, -98Sulfuras, Hand of Ragnaros, 99, -99Conjured Mana Cake, 10, -80Aged Brie, 18, -21, -4, -68Conjured Mana Cake, 54, -2Conjured Mana Cake, 97, -50Backstage passes to a TAFKAL80ETC concert, -17, 0Backstage passes to a TAFKAL80ETC concert, -31, 0Sulfuras, Hand of Ragnaros, -42, 38Aged Brie, -64, -77Conjured Mana Cake, 91, 58Backstage passes to a TAFKAL80ETC concert, 25, 37Conjured Mana Cake, -86, 20, -98, 5Conjured Mana Cake, -20, 97, 23, -48Sulfuras, Hand of Ragnaros, 4, -31Conjured Mana Cake, -68, -95Backstage passes to a TAFKAL80ETC concert, -9, 0Backstage passes to a TAFKAL80ETC concert, -22, 0Aged Brie, -51, 12Conjured Mana Cake, -35, -20Conjured Mana Cake, 42, -2Backstage passes to a TAFKAL80ETC concert, -19, 0Sulfuras, Hand of Ragnaros, 14, 72, -30, -99Sulfuras, Hand of Ragnaros, 79, -72Sulfuras, Hand of Ragnaros, -41, -62Sulfuras, Hand of Ragnaros, -75, -14Sulfuras, Hand of Ragnaros, -76, -71Sulfuras, Hand of Ragnaros, -74, 73Conjured Mana Cake, -70, -49Sulfuras, Hand of Ragnaros, 53, -58, -15, 54Conjured Mana Cake, 59, 29Conjured Mana Cake, -3, 15Conjured Mana Cake, -4, -68Aged Brie, 81, -91Sulfuras, Hand of Ragnaros, -99, 30Sulfuras, Hand of Ragnaros, -30, -30Aged Brie, 45, -78Conjured Mana Cake, -101, -13Conjured Mana Cake, -29, 72Sulfuras, Hand of Ragnaros, 14, -90Sulfuras, Hand of Ragnaros, 40, -26Sulfuras, Hand of Ragnaros, -8, -67Aged Brie, -53, -29Sulfuras, Hand of Ragnaros, 94, -90, -91, -90Sulfuras, Hand of Ragnaros, 81, 67Backstage passes to a TAFKAL80ETC concert, -68, 0Backstage passes to a TAFKAL80ETC concert, 88, -71Conjured Mana Cake, -7, 61Conjured Mana Cake, 58, -26Aged Brie, 59, -36Aged Brie, 13, -24, -36, 95, 95, -87Aged Brie, -2, 54, 64, 44Aged Brie, -83, -83Conjured Mana Cake, 96, -69Conjured Mana Cake, -22, 64, 89, -70Aged Brie, 61, 12, -58, -12Backstage passes to a TAFKAL80ETC concert, 59, -16, 20, -73Sulfuras, Hand of Ragnaros, 61, -84Sulfuras, Hand of Ragnaros, -64, 98Aged Brie, -40, -91Conjured Mana Cake, 43, 98Conjured Mana Cake, -78, -38Conjured Mana Cake, -34, 37Aged Brie, 49, 97Aged Brie, -32, -13Aged Brie, -19, -12Sulfuras, Hand of Ragnaros, 91, -30, -58, 47Backstage passes to a TAFKAL80ETC concert, 48, -75, -61, -34Backstage passes to a TAFKAL80ETC concert, 80, -31Sulfuras, Hand of Ragnaros, 46, -70Aged Brie, -46, -13Aged Brie, 12, -11Backstage passes to a TAFKAL80ETC concert, 44, -73Aged Brie, -80, -82, 37, 71Sulfuras, Hand of Ragnaros, -33, -50, 91, 76Aged Brie, -31, -28Backstage passes to a TAFKAL80ETC concert, 24, -89Conjured Mana Cake, -91, -91Sulfuras, Hand of Ragnaros, -91, -70Conjured Mana Cake, -70, -76Aged Brie, -45, -84Conjured Mana Cake, -17, -32Aged Brie, -12, 50Conjured Mana Cake, -59, -39Sulfuras, Hand of Ragnaros, 52, 57Aged Brie, 97, -30Sulfuras, Hand of Ragnaros, 9, 27Conjured Mana Cake, -34, -60Conjured Mana Cake, 36, -31Aged Brie, 56, 0Sulfuras, Hand of Ragnaros, 77, 51, -80, -99, -33, -97Sulfuras, Hand of Ragnaros, 32, 78";
        Assertions.assertThat(itemstoStr.toString())
            .isEqualTo(goldenMaster);
    }

    @Test
    public void toto() {
        Item[] items = {new Item("", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        Assertions.assertThat(gildedRose.sellInIncremented)
            .isEqualTo(-1);
    }

    @Test
    public void should_increment_3_quality_of_agedbrie_by_default() {
        Item[] items = {new Item("Aged Brie", 0, 0)};
        GildedRose gildedRose = new GildedRose(items);
        gildedRose.updateQuality();

        assertThat(items[0].quality).isEqualTo(3);
    }

}
