package com.example.admin.englishmlearning;

/**
 * Created by Admin on 3/18/2016.
 */
public class ItemNguphap {
    private int id;
    private String ten;
    private String congthuc;
    private String dauhieu;

    public ItemNguphap(int id, String ten, String congthuc, String dauhieu) {
        this.id = id;
        this.ten = ten;
        this.congthuc = congthuc;
        this.dauhieu = dauhieu;
    }

    public String getDauhieu() {
        return dauhieu;
    }

    public String getCongthuc() {
        return congthuc;
    }

    public String getTen() {
        return ten;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }

    public void setDauhieu(String dauhieu) {
        this.dauhieu = dauhieu;
    }
}
