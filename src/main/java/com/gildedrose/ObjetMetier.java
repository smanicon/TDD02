package com.gildedrose;

public class ObjetMetier {

    private ICollaborateur collaborateur;

//    @Deprecated
//    public ObjetMetier() {
//        this.collaborateur = new Collaborateur();
//    }

    public ObjetMetier(ICollaborateur collaborateur) {
        this.collaborateur = collaborateur;
    }

    public int faitDuMétier() {
        return this.collaborateur.faitQuelqueChose() + 1;
    }
}
