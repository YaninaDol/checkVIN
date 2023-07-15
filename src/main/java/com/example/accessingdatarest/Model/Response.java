package com.example.accessingdatarest.Model;

public class Response {
    private int user_id;
    private String user_Role;
    private int package_name;
    private String login;

    public Response(int id,String role,int package_name,String Login)
    {
        this.user_id=id;
        this.user_Role=role;
        this.package_name=package_name;
        this.login=Login;
    }

}
