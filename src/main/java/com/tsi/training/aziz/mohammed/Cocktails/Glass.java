package com.tsi.training.aziz.mohammed.Cocktails;

import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Glass {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idglass;

    private String name;
    private int volume;


    public Glass( String name, int volume){
        this.name = name;
        this.volume = volume;
    }

    public String toString(){
        return new Gson().toJson(this);
    }

    public Glass(){
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setAge(int volume) {
        this.volume = volume;
    }

    public int getIdGlass() {
        return this.idglass;
    }

    public void setIdGlass(int idGlass) {
        this.idglass = idGlass;
    }


}
