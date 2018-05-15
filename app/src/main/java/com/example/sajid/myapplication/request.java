package com.example.sajid.myapplication;

/**
 * Created by anees on 5/11/2018.
 */

public class request {

    String myRider_Name;
    String myRider_RNIC;
    String myRider_time;
    String myRider_place;

    String myTaxiDriver_Name;
    String myTaxiDriver_phonenumber;
    String myTaxi_number;
    String myTexiPlace;


    public request() {
    }

    public request(String myRider_Name, String myRider_RNIC, String myRider_time, String myRider_place, String myTaxiDriver_Name, String myTaxiDriver_phonenumber, String myTaxi_number, String myTexiPlace) {
        this.myRider_Name = myRider_Name;
        this.myRider_RNIC = myRider_RNIC;
        this.myRider_time = myRider_time;
        this.myRider_place = myRider_place;
        this.myTaxiDriver_Name = myTaxiDriver_Name;
        this.myTaxiDriver_phonenumber = myTaxiDriver_phonenumber;
        this.myTaxi_number = myTaxi_number;
        this.myTexiPlace = myTexiPlace;
    }

    public String getMyRider_Name() {
        return myRider_Name;
    }

    public void setMyRider_Name(String myRider_Name) {
        this.myRider_Name = myRider_Name;
    }

    public String getMyRider_RNIC() {
        return myRider_RNIC;
    }

    public void setMyRider_RNIC(String myRider_RNIC) {
        this.myRider_RNIC = myRider_RNIC;
    }

    public String getMyRider_time() {
        return myRider_time;
    }

    public void setMyRider_time(String myRider_time) {
        this.myRider_time = myRider_time;
    }

    public String getMyRider_place() {
        return myRider_place;
    }

    public void setMyRider_place(String myRider_place) {
        this.myRider_place = myRider_place;
    }

    public String getMyTaxiDriver_Name() {
        return myTaxiDriver_Name;
    }

    public void setMyTaxiDriver_Name(String myTaxiDriver_Name) {
        this.myTaxiDriver_Name = myTaxiDriver_Name;
    }

    public String getMyTaxiDriver_phonenumber() {
        return myTaxiDriver_phonenumber;
    }

    public void setMyTaxiDriver_phonenumber(String myTaxiDriver_phonenumber) {
        this.myTaxiDriver_phonenumber = myTaxiDriver_phonenumber;
    }

    public String getMyTaxi_number() {
        return myTaxi_number;
    }

    public void setMyTaxi_number(String myTaxi_number) {
        this.myTaxi_number = myTaxi_number;
    }

    public String getMyTexiPlace() {
        return myTexiPlace;
    }

    public void setMyTexiPlace(String myTexiPlace) {
        this.myTexiPlace = myTexiPlace;
    }
}
