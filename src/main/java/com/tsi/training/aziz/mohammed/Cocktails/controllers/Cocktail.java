package com.tsi.training.aziz.mohammed.Cocktails.controllers;


import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cocktail {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idcocktail;

    private String name;
    private String description;
    private int price;

    public Cocktail(){}
    public String toString(){
        return new Gson().toJson(this);
    }

    public Cocktail(String name, String description, int price){
        this.name = name;
        this.description = description;
        this.price = price;
    }

    //////////////////////////////////RELATION\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

//    @ManyToMany
//    @JoinTable(
//            name = "cocktail_instructions",
//            joinColumns = @JoinColumn(name = "idcocktail"),
//            inverseJoinColumns = @JoinColumn(name = "idinstructions")
//    )
//    private Set<Instruction> instruction = new HashSet<>();


    ///////////////////////////////////////GETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public int getIdcocktail() {
        return this.idcocktail;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }

    ////////////////////////////////////////SETTERS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

//    public void setIdcocktail(int idcocktail) {
//        this.idcocktail = idcocktail;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
