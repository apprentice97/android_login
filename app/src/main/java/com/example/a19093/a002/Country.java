package com.example.a19093.a002;

public class Country {
    private String country_name;
    private String country_number;
    public Country(String _name, String _number){
        this.country_name = _name;
        this.country_number = _number;
    }
    public String getCountry_name(){
        return country_name;
    }
    public String getCountry_number(){
        return country_number;
    }
}
