package com.example.admin.englishmlearning;

/**
 * Created by Admin on 3/23/2016.
 */
public class ItemTracnghiem {

    String noidung, dapan1, dapan2, dapan3, dapan4, dapandung;



    public String getNoidung() {
        return noidung;
    }

    public String getDapan1() {
        return dapan1;
    }

    public String getDapan2() {
        return dapan2;
    }

    public String getDapan3() {
        return dapan3;
    }

    public String getDapan4() {
        return dapan4;
    }

    public String getDapandung() {
        return dapandung;
    }

    public ItemTracnghiem(String noidung,String dapan1, String dapan2, String dapan3, String dapan4, String dapandung) {

        this.noidung=noidung;
        this.dapan1=dapan1;
        this.dapan2=dapan2;
        this.dapan3=dapan3;
        this.dapan4=dapan4;
        this.dapandung=dapandung;


    }
}
