package com.repolho.truco.truco.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by repolho on 10/07/16.
 */
public class Pontos implements Parcelable {

    int nos;
    int eles;
    int boisNos;
    int boisEles;


    public Pontos(Parcel in) {
        nos = in.readInt();
        eles = in.readInt();
        boisNos = in.readInt();
        boisEles = in.readInt();
    }

    public Pontos(int nos, int eles, int boisNos, int boisEles) {
        this.nos = nos;
        this.eles = eles;
        this.boisNos = boisNos;
        this.boisEles = boisEles;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(nos);
        dest.writeInt(eles);
        dest.writeInt(boisNos);
        dest.writeInt(boisEles);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Pontos> CREATOR = new Creator<Pontos>() {
        @Override
        public Pontos createFromParcel(Parcel in) {
            return new Pontos(in);
        }

        @Override
        public Pontos[] newArray(int size) {
            return new Pontos[size];
        }
    };

    public int getNos() {
        return nos;
    }

    public void setNos(int nos) {
        this.nos = nos;
    }

    public int getEles() {
        return eles;
    }

    public void setEles(int eles) {
        this.eles = eles;
    }

    public int getBoisNos() {
        return boisNos;
    }

    public void setBoisNos(int boisNos) {
        this.boisNos = boisNos;
    }

    public int getBoisEles() {
        return boisEles;
    }

    public void setBoisEles(int boisEles) {
        this.boisEles = boisEles;
    }


    public void somaNos(int v){
        this.nos += v;
    }
    public void subtraiNos(int v){
        this.nos -= v;
    }

    public void somaEles(int v){
        this.eles += v;
    }
    public void subtraiEles(int v){
        this.eles -= v;
    }

    public void somaBoiNos(int v){
        this.boisNos += v;
    }
    public void somaBoiEles(int v){
        this.boisEles += v;
    }
}
