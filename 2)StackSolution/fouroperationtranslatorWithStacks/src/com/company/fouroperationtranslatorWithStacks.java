package com.company;

import edu.princeton.cs.algs4.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author talhasagdan
 */
public class fouroperationtranslatorWithStacks {
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
            double val=Math.pow(value2, value1);
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
        while (i<val.length){
            if(values.size()==0){
                values.push(Double.parseDouble(val[i]));
                values.push(Double.parseDouble(val[i+1]));
                i=i+2;
            }
            else{
                if(i<val.length){

                    values.push(Double.parseDouble(val[i]));
                    i++;
                }
                else
                    i++;
            }

            if (op2[j-1].equals("tothepower")){

                operations.push(op2[j-1]);
                String operation= operations.pop();
                double value1=values.pop();
                double value2=values.pop();
                result(operation,value1,value2);
                j++;
            }
            else if(op2[j-1].equals("minus")){
                operations.push(op2[j-1]);
                j++;
            }
            else if(op2[j-1].equals("plus")){

                operations.push(op2[j-1]);
                j++;
            }
            else if(op2[j-1].equals("times")){

                operations.push(op2[j-1]);
                j++;
            }


        }


        String[] oala= new String[operations.size()];

        int m=0;
        while(!operations.isEmpty()){
            oala[m]=operations.pop();
            m++;
        }


        if(oala.length!=0){
            int n=0;
            double[] vala=new double[values.size()];
            while(!values.isEmpty()){
                vala[n]=values.pop();
                n++;
            }


            j=1;
            i=0;
            while(i<vala.length){

                if(values.size()==0){

                    values.push(vala[i]);
                    values.push(vala[i+1]);
                    i=i+2;
                }
                else{
                    if(i<vala.length){

                        values.push(vala[i]);
                        i++;
                    }
                    else
                        i++;
                }

                if (oala[j-1].equals("times")){

                    operations.push(oala[j-1]);
                    String operation= operations.pop();
                    double value1=values.pop();
                    double value2=values.pop();
                    result(operation,value1,value2);
                    j++;
                }
                else if(oala[j-1].equals("minus")){
                    operations.push(oala[j-1]);
                    j++;
                }
                else if(oala[j-1].equals("plus")){

                    operations.push(oala[j-1]);
                    j++;
                }
            }

            String[] olast= new String[operations.size()];
            double[] vlast=new double[values.size()];
            int e=0;
            int d=0;
            while(!operations.isEmpty()){
                olast[d]=operations.pop();
                d++;
            }

            if(olast.length!=0){


                while(!values.isEmpty()){
                    vlast[e]=values.pop();
                    e++;
                }

                i=0;
                j=1;

                while (i<vlast.length+1){
                    if (values.size()==2){
                        double value1=values.pop();
                        double value2=values.pop();
                        if(olast[j-1].equals("plus")){
                            operations.push(olast[j-1]);
                            String operation= operations.pop();
                            result(operation,value1,value2);
                            j++;
                        }
                        else if(olast[j-1].equals("minus")){
                            operations.push(olast[j-1]);
                            String operation= operations.pop();
                            result(operation,value1,value2);
                            j++;
                        }
                    }
                    else if(i<vlast.length){
                        values.push(vlast[i]);
                        i++;
                    }
                    else
                        i++;
                }

                StdOut.println("Case #"+ Integer.toString(k) + ":" + values.pop().toString());



            }
            else{
                StdOut.println("Case #"+ Integer.toString(k) + ":" + values.pop().toString());
            }

        }
        else
            StdOut.println("Case #"+ Integer.toString(k) + ":" + values.pop().toString());
    }
}


