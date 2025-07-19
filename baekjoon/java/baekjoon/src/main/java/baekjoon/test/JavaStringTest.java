package baekjoon.test;

import java.util.*;
import java.io.*;

public class JavaStringTest {
    public static void main(String[] args) throws IOException {
        String a = "A";
        String[] arr = {"ARR"};

//        iHateJava(a, arr);
        iLoveJava(a, arr);
        System.out.println("a = " + a);
        System.out.println(Arrays.toString(arr));

    }

    static Object iLoveJava(Object paramObj, Object[] paramArr) {
        paramArr[0] = paramObj;
        paramObj = "CHANGEOBJ";
        return paramObj;
    }

    static String iHateJava(String paramStr, String[] paramArr) {
        System.out.println("paramStr = " + paramStr);
        paramArr[0] = paramStr;
        paramStr = "CHANGE";
        return paramStr;
    }
}
