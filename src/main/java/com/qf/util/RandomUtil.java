package com.qf.util;

import java.util.UUID;

public class RandomUtil {

    public static String random(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
