package com.corejava;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastExample { 
    public static void main(String[] args) 
    { 
    	//ConcurrentHashMap
        Map<String, String> cityCode = new HashMap<String, String>(); 
        cityCode.put("Delhi", "India"); 
        cityCode.put("Moscow", "Russia"); 
        cityCode.put("New York", "USA"); 
  
        Iterator iterator = cityCode.keySet().iterator(); 
  
        while (iterator.hasNext()) { 
            System.out.println(cityCode.get(iterator.next())); 
  
            // adding an element to Map 
            // exception will be thrown on next call 
            // of next() method. 
            cityCode.put("Istanbul", "Turkey"); 
        } 
    } 
}