package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    Item[] items;
    public int sellInIncremented = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    @Deprecated
    public void updateQuality() {
        updateQuality(1);
    }
    public void updateQuality(int icrementQuality) {
        for (int i = 0; i < items.length; i++) {

            if (!items[i].name.equals(AGED_BRIE)
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                decrementSulfuraQualityWhenGreater0(i);
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!isSulfura(i)) {
                items[i].sellIn = items[i].sellIn - 1;
                sellInIncremented--;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        decrementSulfuraQualityWhenGreater0(i);
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private void decrementSulfuraQualityWhenGreater0(int i) {
        if (items[i].quality <= 0) {
            return;
        }
        if (isSulfura(i)) {
            return;
        }
        decrementQuality(i);
    }

    private boolean isSulfura(int i) {
        return items[i].name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void decrementQuality(int i) {
        items[i].quality = items[i].quality - 1;
    }
}
