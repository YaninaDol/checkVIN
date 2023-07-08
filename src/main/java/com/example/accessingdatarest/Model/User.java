package com.example.accessingdatarest.Model;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phone_number;


    private String password;
    private int package_id;
    private int count;

    private String role_id;
    //можно не указывать Column name, если оно совпадает с названием столбца в таблице


    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)


    public User()
    {

    }

    public User(String name,String phone_number,String password,String role_id) {
        this.name = name;
        this.phone_number=phone_number;
        this.password=password;
        this.package_id=1;
        this.count=0;
        this.role_id=role_id;


    }



    public int getId() {
        return id;
    }
    public String getRole_id() {
        return role_id;
    }

    public String getName() {
        return name;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public String getPassword() {
        return password;
    }

    public int getPackage_id() {
        return package_id;
    }
    public int getCount() {
        return count;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setRole_id(String role_id){this.role_id=role_id;}

    @Override
    public String toString() {
        return "models.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
