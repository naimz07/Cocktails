package com.tsi.training.aziz.mohammed.Cocktails.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Glass {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idglass;

    private String name;
    private int volume;

    public Glass(){
    }
    public String toString(){
        return new Gson().toJson(this);
    }
    public Glass( String name, int volume){
        this.name = name;
        this.volume = volume;
    }

    ///////////////////////////////////////RELATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    @JsonIgnore
    @ManyToMany(mappedBy = "glass")
    Set<Instruction> instructions = new HashSet<>();
    public Set<Instruction> getInstructions() {
        return instructions;
    }

    //////////////////////////////////////GETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public int getIdGlass() {
        return this.idglass;
    }

    public String getName() {
        return this.name;
    }

    public int getVolume() {
        return this.volume;
    }

    //////////////////////////////////////SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void setIdGlass(int idGlass) {
        this.idglass = idGlass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int volume) {
        this.volume = volume;
    }


}
