package com.company;

import edu.princeton.cs.algs4.*;
import java.util.*;
import java.io.*;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author talhasagdan
 */
public class fouroperationtranslator {
    public static Stack<String> operations = new Stack<String>();
    public static Stack<Double> values = new Stack<Double>();



    public static void main(String[] args){

        StdOut.println("Please Enter Number of Test Cases:      (if don't in this(1 <= t <= 20)  program will close)");
        Scanner t_in =new Scanner(System.in);
        int t= t_in.nextInt();
        if (t>0 && t<=20){
        }
        else
            StdOut.println("Oops! Number of test cases should be: 1 <= t <= 20");

        int i =0;
        int k=1;
        while (i<t){
            Scanner s_in=new Scanner(System.in);
            String s= s_in.nextLine();
            if(s.length()>0 && s.length()<=1000){
                calculate(s,k);
                k++;
                i++;
            }
            else{
                StdOut.println("Oops! Test case #s should be: 1 <= s <=1000 (if dont continue ask)");
                continue;
            }
        }
    }



    public static void result(String operation, double value1, double value2){
        if (operation.equals("plus")) {
            double val =value1 + value2;
            values.push(val);
        }
        else if (operation.equals("minus")){
            double val= value2 - value1;
            values.push(val);
        }
        else if (operation.equals("tothepower")){
            double val=Math.pow(value1, value2);
            values.push(val);
        }
        else if (operation.equals("times")){
            double val=value1 * value2;
            values.push(val);
        }

    }





    public static void calculate(String s,int k) {
        String[] op=s.split("0|1|2|3|4|5|6|7|8|9");
        String[] val= s.split("times|plus|tothepower|minus");

        List<String> list = new ArrayList<String>(Arrays.asList(op));
        list.removeAll(Arrays.asList("", null));
        String[] op2= new String[list.size()];
        op2=list.toArray(op2);



        int j =1;
        int i=0;

        while (i<val.length+1){
            if (values.size()==2){
                double value1=values.pop();
                double value2=values.pop();
                if(op2[j-1].equals("plus")){
                    operations.push(op2[j-1]);
                    String operation= operations.pop();
                    result(operation,value1,value2);
                    j++;
                }
                else if(op2[j-1].equals("minus")){
                    operations.push(op2[j-1]);
                    String operation= operations.pop();
                    result(operation,value1,value2);
                    j++;
                }
                else if(op2[j-1].equals("tothepower")){
                    operations.push(op2[j-1]);
                    String operation= operations.pop();
                    result(operation,value1,value2);
                    j++;
                }
                else if(op2[j-1].equals("times")){
                    operations.push(op2[j-1]);
                    String operation= operations.pop();
                    result(operation,value1,value2);
                    j++;
                }
            }
            else if(i<val.length){
                values.push(Double.parseDouble(val[i]));
                i++;
            }
            else
                i++;
        }
        int num=0;
        while(num<val.length){
            double num2=Double.parseDouble(val[num]);
            if(num2>=0 && num2<=Math.pow(10.0,9)){
                num++;
                continue;
            }
            else
                StdOut.println("All numbers appearing in s will be:  0<= s <= 10^9 (If don't program will close.)");
            System.exit(0);

        }
        if(values.peek()>Math.pow(10,9) || values.peek()<Math.pow(-10,9)){
            StdOut.println("Oops! Your result is should be : -10^9 > s > 10^9  (If don't program will continue next case.)");
            values.pop();
        }

        else
            StdOut.println("Case #"+ Integer.toString(k) + ":" + values.pop().toString());
    }
}