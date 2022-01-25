package com.xiong.utils;
import org.junit.Test;

import java.util.UUID;


public class IDutils {
    public static String getID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
@Test
    public void test(){
    System.out.println(IDutils.getID());
    System.out.println(IDutils.getID());
    System.out.println(IDutils.getID());
    System.out.println(IDutils.getID());
}

}
