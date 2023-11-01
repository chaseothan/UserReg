package com.example.userreghw;

public class User
{

    private String fName;
    private String lName;
    private String username;
    private String email;
    private String password;
    private String age;


    public String getfName()
    {
        return fName;
    }

    public void setfName(String f)
    {
        fName = f;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String l)
    {
        lName = l;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String u)
    {
        username = u;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        email = e;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String p)
    {
        password = p;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String a)
    {
        age = a;
    }



    public User()
    {

    }

    public User(String f, String l, String u, String e, String p, String a)
    {
        fName = f;
        lName = l;
        username = u;
        email = e;
        password = p;
        age = a;


    }
}
