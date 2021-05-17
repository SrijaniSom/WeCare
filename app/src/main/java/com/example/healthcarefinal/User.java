package com.example.healthcarefinal;

public class User
{
    private String mname;
    private String mphone;
    private String madd;

    public User(String i,String ro,String re)
    {
        mname=i;
        mphone=ro;
        madd=re;
    }
    public String getname()
    {
        return mname;
    }
    public String getphone()
    {
        return mphone;
    }
    public String getaddress()
    {
        return madd;
    }

}
