package com.gildedrose;

public class Collaborateur implements ICollaborateur {
    public int faitQuelqueChose() {
        throw new RuntimeException("Tu ne dois pas m'appeler");
    }
}
