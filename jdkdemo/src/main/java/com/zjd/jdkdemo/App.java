package com.zjd.jdkdemo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Runtime rt = Runtime.getRuntime();
    	rt.availableProcessors();
    	User u = new User();
    	u.name="a";
    	updateObject(u);
    	System.out.println(u.name);	//a
    }
    
    public static void updateObject(User u){
    	u = new User();
    	u.name = "b";
    }
    
    public static  class User{
    	public String name;
    }
}
