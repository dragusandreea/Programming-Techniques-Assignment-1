package model;

import java.text.DecimalFormat;

public class Monomial  implements  Comparable<Monomial>{
    private double coefficient;
    private int degree;

    public Monomial(int coefficient, int degree)
    {
       this.coefficient = coefficient;
       this.degree = degree;
    }

    public Monomial() { }
    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    @Override
    public String toString()
    {
        DecimalFormat decf = new DecimalFormat("0.00");

        if(coefficient != 0)
         {

        if (coefficient > 0)
            return "+" + decf.format(coefficient) + "x^" + degree;
        else
            return decf.format(coefficient) + "x^" + degree;
        }
        else
            return "";


    }

    @Override
    public int compareTo(Monomial o) {
        if(this.degree > o.degree)
            return -1;
        else
        {
            if(this.degree < o.degree)
                return 1;
            else
                return 0;
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        Monomial o = (Monomial) obj;

        if( o == this)
            return true;

        if(this.getCoefficient() == o.getCoefficient() && this.getDegree() == o.getDegree())
            return true;
        else
            return false;
    }
}
