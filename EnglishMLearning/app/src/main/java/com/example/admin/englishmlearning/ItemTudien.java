package com.example.admin.englishmlearning;

import android.widget.TextView;

/**
 * Created by Admin on 3/16/2016.
 */
public class ItemTudien {
    private String tu, tuloai, phienam, dichnghia;

    public ItemTudien(String tu, String tuloai, String phienam, String dichnghia) {
        this.dichnghia = dichnghia;
        this.phienam = phienam;
        this.tu = tu;
        this.tuloai = tuloai;
    }

    public String getDichnghia() {
        return dichnghia;
    }

    public String getPhienam() {
        return phienam;
    }

    public String getTuloai() {
        return tuloai;
    }

    public String getTu() {
        return tu;
    }

    public void setDichnghia(String dichnghia) {
        this.dichnghia = dichnghia;
    }

    public void setPhienam(String phienam) {
        this.phienam = phienam;
    }

    public void setTuloai(String tuloai) {
        this.tuloai = tuloai;
    }

    public void setTu(String tu) {
        this.tu = tu;
    }
}
