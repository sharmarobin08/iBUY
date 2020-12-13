
package com.example.ibuy.db;

public class members {

    String Name, Email, Password, Address, Mobile;
    public members(String name, String email, String password, String address, String mobile)
    {
        Name = name;
        Email = email;
        Password = password;
        Address = address;
        Mobile = mobile;
    }
    public members() {}
    public String getlName()
    {
        return Name;
    }
    public void setName(String name)
    {
        Name = name;
    }
    public String getEmail()
    {
        return Email;
    }
    public void setEmail(String email)
    {
        Email = email;
    }
    public String getPassword()
    {
        return Password;
    }
    public void setPassword(String password)
    {
        Password = password;
    }
    public String getAddress()
    {
        return Address;
    }
    public void setAddress(String address)
    {
        Address = address;
    }
    public String getMobile()
    {
        return Mobile;
    }
    public void setMobile(String mobile)
    {
        Mobile = mobile;
    }

}
