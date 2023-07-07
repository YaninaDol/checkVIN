package com.example.accessingdatarest.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String vin;

    private String make;

    private String model;

    private String year;
    private String trim;
    private String engine;
    private String style;
    private String made_in;
    private String brake_system;
    private String tank_size;
    private String height;
    private String lenght;
    private String width;
    private String seating;
    private String higway_milage;
    private String city_milage;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице


    //@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, orphanRemoval = true)


    public Car()
    {

    }

    public Car(String vin,String make,String model,String year,String trim,String engine,String style,String made_in,String brake_system,String tank_size, String height,String lenght,String width,String seating,String higway_milage,String city_milage) {
        this.vin = vin;
        this.make=make;
        this.model=model;
        this.year=year;
        this.trim=trim;
        this.engine=engine;
        this.style=style;
        this.made_in=made_in;
        this.brake_system=brake_system;
        this.tank_size=tank_size;
        this.height=height;
        this.lenght=lenght;
        this.width=width;
        this.seating=seating;
        this.higway_milage=higway_milage;
        this.city_milage=city_milage;
    }



    public int getId() {
        return id;
    }




    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id+"," +"\"Make\":" + make+"," +
                "\"Model\":" + model+"," +"\"Year\":" + year+"," +
                "\"Trim\":" + trim+"," +"\"Engine\":" + engine+"," +
                "\"Style\":" + style+"," +"\"Made_in\":" + made_in+"," +
                "\"Brake_system\":" + brake_system+"," +"\"Tank_size\":" + tank_size+"," +
                "\"Height\":" + height+"," +"\"Lenght\":" + lenght+"," +
                "\"Width\":" + width+"," +"\"Seating\":" + seating+"," +
                "\"Higway_milage\":" + higway_milage+"," +"\"City_milage\":" + city_milage +
                "}";
    }
}
