package com.tsi.training.aziz.mohammed.Cocktails.controllers;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idequipment;

    private String name;
    private boolean needsPower;

    public Equipment(){
    }
    public String toString(){
        return new Gson().toJson(this);
    }

    public Equipment(String name, boolean needsPower){
        this.name = name;
        this.needsPower = needsPower;
    }

    //////////////////////////////////////RELATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @JsonIgnore
    @ManyToMany(mappedBy = "equipment")
    Set<Instruction> instructions = new HashSet<>();
    public Set<Instruction> getInstructions() {
        return instructions;
    }

    /////////////////////////////////////GETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public String getName(){
        return this.name;
    }

    public boolean getNeedsPower(){
        return this.needsPower;
    }

    public int getIdequipment() {
        return idequipment;
    }

    //////////////////////////////////////SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void setName(String name){
        this.name = name;
    }

    public void setNeedsPower(boolean needsPower){
        this.needsPower = needsPower;
    }

//    public void setIdequipment(int idequipment) {
//        this.idequipment = idequipment;
//    }

}
