package controller;
import model.Monomial;
import model.Polynomial;

import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Regex {

    public static Polynomial getPolynomialFromInput(String textInput)
    {
        String text="";
        if(!text.valueOf(0).equals('-'))
        {
            text = "+"+textInput;
        }
        else
        {
            text = textInput;
        }

        //aici construiesc ArrayList de monom
        ArrayList<Monomial> monomialsInput = new ArrayList<Monomial>();

        String formatInputParts = "([+-]?(?:(?:([+-]\\d+)x)\\^(\\d+))|(?:([+-]\\d+))x|(?:([+-]\\d+))|(?:x))";

        Pattern patternInputParts = Pattern.compile(formatInputParts);
        Matcher matcherInputParts = patternInputParts.matcher(text);

        //caut un match pt formatul de Input
        while(matcherInputParts.find())
        {

            double coefficient = Double.valueOf(matcherInputParts.group(2));
            int degree = Integer.valueOf(matcherInputParts.group(3));
            //System.out.println("Am intrat");
            Monomial m = new Monomial();
            m.setCoefficient(coefficient);
            m.setDegree(degree);

            monomialsInput.add(m);
        }

        Polynomial polynomialInput = new Polynomial(monomialsInput);

        return polynomialInput;
    }
}
