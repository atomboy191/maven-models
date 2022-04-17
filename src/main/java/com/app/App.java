package com.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println(calculateFormula("1+1+8/2*4+1"));
    }

    public static Integer calculateFormula(String input) {
        char signs[] = new char[input.length()/2];
        int signCounter = 0;
        int vals[] = new int[input.length()];
        int valCounter = 0;

        for(int i = 0 ; i < input.length() ; i++ ) {
            if(input.charAt(i) == '*')  {
                int val = Character.getNumericValue(input.charAt(i+1))  * vals[valCounter-1];
                vals[valCounter-1] = val;
                i++;
            } else if(input.charAt(i) == '/') {
                int val = vals[valCounter-1] / Character.getNumericValue(input.charAt(i+1));
                vals[valCounter-1] = val;
                i++;
            } else if(input.charAt(i) == '+' || input.charAt(i) == '-') {
                signs[signCounter] = input.charAt(i);
                signCounter++;
            } else {
                vals[valCounter] = Character.getNumericValue(input.charAt(i));
                valCounter++;
            }
        }

        System.out.println(vals );

        int finalVal = 0;
        int signIndex = 0;

        for(int i = 0 ; i < valCounter ; i=i+2 ) {
            if(signs[signIndex] == '-') {
                finalVal += vals[i] - vals[i+1];
            } else {
                finalVal += vals[i] + vals[i+1];
            } 
            signIndex++;
        }

        return finalVal;
    }
}
