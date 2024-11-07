package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MétierTest {
    @Test
    public void testLeMétier() {
        ICollaborateur collaborateur = new ICollaborateur() {
            @Override
            public int faitQuelqueChose() {
                return 0;
            }
        };

        ObjetMetier objetMetier = new ObjetMetier(collaborateur);
        int actual = objetMetier.faitDuMétier();
        Assertions.assertThat(actual).isEqualTo(1);
    }
}
