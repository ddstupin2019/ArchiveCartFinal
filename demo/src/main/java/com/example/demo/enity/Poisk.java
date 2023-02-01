package com.example.demo.enity;

import java.util.ArrayList;
import java.util.List;

public class Poisk {
    public static boolean poisk(Carta input, String filter){
            if (input.getMesto().contains(filter) || filter.equals("0")){
                return true;
            }
        return false;
    }
}
