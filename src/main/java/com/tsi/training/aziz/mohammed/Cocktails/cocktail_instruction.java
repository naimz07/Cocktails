package com.tsi.training.aziz.mohammed.Cocktails;


import com.tsi.training.aziz.mohammed.Cocktails.controllers.Cocktail;
import com.tsi.training.aziz.mohammed.Cocktails.controllers.Instruction;

import javax.persistence.*;

@Entity
public class cocktail_instruction {

    @EmbeddedId
    cocktail_instructionKey id;

    @ManyToOne
    @MapsId("idinstruction")
    @JoinColumn(name = "instruction_idinstruction", referencedColumnName = "idinstruction")
    Instruction instruction;

    @ManyToOne
    @MapsId("idcocktail")
    @JoinColumn(name = "cocktail_idcocktail", referencedColumnName = "idcocktail")
    Cocktail cocktail;

    private int cocktail_step_no;

    public cocktail_instruction(){}

    public cocktail_instruction(int cocktail_step_no){
        this.cocktail_step_no = cocktail_step_no;
    }

    public int getCocktail_step_no() {
        return cocktail_step_no;
    }

    public void setCocktail_step_no(int cocktail_step_no) {
        this.cocktail_step_no = cocktail_step_no;
    }
}
