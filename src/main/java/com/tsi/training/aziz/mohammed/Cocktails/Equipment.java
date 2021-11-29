package com.tsi.training.aziz.mohammed.Cocktails;


import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int idequipment;

    private String name;
    private boolean needsPower;

    public Equipment(String name, boolean needsPower){
        this.name = name;
        this.needsPower = needsPower;
    }

    public Equipment(){
    }

    public String toString(){
        return new Gson().toJson(this);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public boolean getNeedsPower(){
        return this.needsPower;
    }

    public void setNeedsPower(boolean needsPower){
        this.needsPower = needsPower;
    }

    public int getIdequipment() {
        return idequipment;
    }

    public void setIdequipment(int idequipment) {
        this.idequipment = idequipment;
    }
}
