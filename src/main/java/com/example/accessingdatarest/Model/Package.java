package com.example.accessingdatarest.Model;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class Package {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int max;
    private int price;

    public Package()
    {

    }
    public Package(String name,int max,int price)
    {
        this.name=name;
        this.max=max;
        this.price=price;

    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public  int getMax(){return max;}
    public int getPrice(){return price;}

    public void setName(String name) {
        this.name = name;
    }
    public void setMax(int max) {
        this.max = max;
    }
    public void setPrice (int price) {this.price=price;}

}