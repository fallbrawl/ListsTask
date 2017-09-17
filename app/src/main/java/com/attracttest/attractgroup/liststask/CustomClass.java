package com.attracttest.attractgroup.liststask;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nexus on 16.09.2017.
 */
public class CustomClass implements Serializable {
    private String field1;
    private String field2;
    private String field3;
    private static ArrayList<CustomClass> result;

    public CustomClass(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public static ArrayList<CustomClass> init() {
        result  = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            result.add(new CustomClass("wow" + i, "wow2", "wow3"));
        }

        return result;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }
}
