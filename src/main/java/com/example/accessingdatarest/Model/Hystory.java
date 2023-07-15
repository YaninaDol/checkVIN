package com.example.accessingdatarest.Model;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Hystory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String date;
    private int user_id;
    private String package_name;

    public Hystory()
    {

    }

    public Hystory(String date,int user_id,String package_name)
    {
        this.date=date;
        this.user_id=user_id;
        this.package_name=package_name;
    }
    @Override
    public String toString() {
        return "models.User{" +
                "date=" + date +
                ", user_id='" + user_id + '\'' +
                ", package_name='" + package_name + '\'' +
                '}';
    }
}
