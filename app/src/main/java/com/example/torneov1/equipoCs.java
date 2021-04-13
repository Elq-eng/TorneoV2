package com.example.torneov1;

public class equipoCs {
    String Nequipo, Ncap, Cel;

    public equipoCs() {
    }

    public equipoCs(String nequipo, String ncap, String cel) {
        Nequipo = nequipo;
        Ncap = ncap;
        Cel = cel;
    }

    public String getNequipo() {
        return Nequipo;
    }

    public void setNequipo(String nequipo) {
        Nequipo = nequipo;
    }

    public String getNcap() {
        return Ncap;
    }

    public void setNcap(String ncap) {
        Ncap = ncap;
    }

    public String getCel() {
        return Cel;
    }

    public void setCel(String cel) {
        Cel = cel;
    }
}

