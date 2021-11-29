package com.tsi.training.aziz.mohammed.Cocktails;

import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Garnish {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idgarnish;

    private String name;
    private boolean food;

    public Garnish(String name, boolean food) {
        this.name = name;
        this.food = food;
    }

    public Garnish(){
    }

    public String toString(){
        return new Gson().toJson(this);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public int getIdGarnish() {
        return this.idgarnish;
    }

    public void setIdGarnish(int idGarnish) {
        this.idgarnish = idGarnish;
    }


}
