package com.example.sajid.myapplication;

/**
 * Created by anees on 5/10/2018.
 */

public class request_class {

  String Rider_Namess;
  String Rider_RNICss;
  String Rider_timess;
  String Rider_placess;

  String TaxiDriver_Namess;
  String TaxiDriver_phonenumberss;
  String Taxi_numberss;
  String TexiPlacess;

    public request_class() {
    }

    public request_class(String rider_Name, String rider_RNIC, String rider_time, String rider_place, String taxiDriver_Name, String taxiDriver_phonenumber, String taxi_number, String texiPlace) {
        Rider_Namess = rider_Name;
        Rider_RNICss = rider_RNIC;
        Rider_timess = rider_time;
        Rider_placess = rider_place;
        TaxiDriver_Namess = taxiDriver_Name;
        TaxiDriver_phonenumberss = taxiDriver_phonenumber;
        Taxi_numberss = taxi_number;
        TexiPlacess = texiPlace;
    }

    public String getRider_Name() {
        return Rider_Namess;
    }

    public void setRider_Name(String rider_Name) {
        Rider_Namess = rider_Name;
    }

    public String getRider_RNIC() {
        return Rider_RNICss;
    }

    public void setRider_RNIC(String rider_RNIC) {
        Rider_RNICss = rider_RNIC;
    }

    public String getRider_time() {
        return Rider_timess;
    }

    public void setRider_time(String rider_time) {
        Rider_timess = rider_time;
    }

    public String getRider_place() {
        return Rider_placess;
    }

    public void setRider_place(String rider_place) {
        Rider_placess = rider_place;
    }

    public String getTaxiDriver_Name() {
        return TaxiDriver_Namess;
    }

    public void setTaxiDriver_Name(String taxiDriver_Name) {
        TaxiDriver_Namess = taxiDriver_Name;
    }

    public String getTaxiDriver_phonenumber() {
        return TaxiDriver_phonenumberss;
    }

    public void setTaxiDriver_phonenumber(String taxiDriver_phonenumber) {
        TaxiDriver_phonenumberss = taxiDriver_phonenumber;
    }

    public String getTaxi_number() {
        return Taxi_numberss;
    }

    public void setTaxi_number(String taxi_number) {
        Taxi_numberss = taxi_number;
    }

    public String getTexiPlace() {
        return TexiPlacess;
    }

    public void setTexiPlace(String texiPlace) {
        TexiPlacess = texiPlace;
    }
}
