package com.example.scretchjavafx;

public class Modal {

public float calculate(long number1, long number2,String opteration)
{
    double result=0;
    switch(opteration)
    {
        case "+":
           return  number1+number2;
        case "-":
            return  number1-number2;
        case "/":
            if(number2==0)
                return 0;
            else{
            return  number1/number2;}
        case "*":
            return  number1*number2;

        default :

            return 0;
    }

}



}


