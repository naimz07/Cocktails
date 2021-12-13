package com.tsi.training.aziz.mohammed.Cocktails;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class cocktail_instructionKey implements Serializable {

    @Column(name = "cocktail_idcocktail")
    int idcocktail;

    @Column(name = "instruction_idinstruction")
    int idinstruction;


    public int getIdcocktail() {
        return idcocktail;
    }

    public void setIdcocktail(int idcocktail) {
        this.idcocktail = idcocktail;
    }

    public int getIdinstruction() {
        return idinstruction;
    }

    public void setIdinstruction(int idinstruction) {
        this.idinstruction = idinstruction;
    }
}
