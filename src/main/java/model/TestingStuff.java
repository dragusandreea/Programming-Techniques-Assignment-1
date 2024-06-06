package model;

import controller.Regex;

import java.util.ArrayList;

public class TestingStuff {
      public static void main(String[] args)
      {
         /*
         Monomial m1 = new Monomial();
         m1.setCoefficient(3);
         m1.setDegree(5);

         Monomial m2 = new Monomial();
         m2.setCoefficient(2);
         m2.setDegree(3);

         Monomial m3 = new Monomial();
         m3.setCoefficient(2);
         m3.setDegree(0);

         //System.out.print(m1);
         //System.out.print(m2);
         //System.out.print(m3);

        // System.out.println();

         ArrayList<Monomial> monomialList = new ArrayList<Monomial>();
         monomialList.add(m1);
         monomialList.add(m2);
         monomialList.add(m3);

         Polynomial p1 = new Polynomial(monomialList);


         System.out.println("Polinomul1: " + p1);


          /*
         Monomial m4 = new Monomial();
         m4.setCoefficient(2);
         m4.setDegree(5);

         Monomial m5 = new Monomial();
         m5.setCoefficient(2);
         m5.setDegree(3);

         Monomial m6 = new Monomial();
         m6.setCoefficient(2);
         m6.setDegree(2);

         Monomial m7 = new Monomial();
         m7.setCoefficient(31);
         m7.setDegree(1);


         ArrayList<Monomial> monomialList2 = new ArrayList<Monomial>();
         monomialList2.add(m4);
         monomialList2.add(m5);
         monomialList2.add(m6);
         monomialList2.add(m7);

         Polynomial p2 = new Polynomial(monomialList2);

         System.out.println("Polinomul2: " + p2);

         Polynomial p3 = Operation.Addition(p1,p2);
         //System.out.println("PolinomulAdunare: " + p3);

        Polynomial p4 = Operation.Substraction(p1,p2);

        //System.out.println("PolinomulScadere: " + p4);

         //System.out.println("Polinomul2: " + p2);
         Polynomial p5 = Operation.Multiplication(p1,p2);

         System.out.println("PolinomulInmultire: " + p5);
         */


         //test Regex

         //String pol1 = "2x^2 + 3x^123";

         //System.out.println(Regex.getPolynomialFromInput(pol1));

         // Polynomial derivare = Operation.Derivation(p1);

          //System.out.println(derivare);

         //test division

         Monomial m1 = new Monomial();
         m1.setCoefficient(1);
         m1.setDegree(3);

         Monomial m2 = new Monomial();
         m2.setCoefficient(-2);
         m2.setDegree(2);

         Monomial m3 = new Monomial();
         m3.setCoefficient(6);
         m3.setDegree(1);

         Monomial m4 = new Monomial();
         m4.setCoefficient(-5);
         m4.setDegree(0);

         ArrayList<Monomial> monomials1 = new ArrayList<Monomial>();
         monomials1.add(m1);
         monomials1.add(m2);
         monomials1.add(m3);
         monomials1.add(m4);

         Polynomial p1 = new Polynomial(monomials1);

         Monomial m5 = new Monomial();
         m5.setCoefficient(1);
         m5.setDegree(2);

         Monomial m6 = new Monomial();
         m6.setCoefficient(-1);
         m6.setDegree(0);

         ArrayList<Monomial> monomials2 = new ArrayList<Monomial>();
         monomials2.add(m5);
         monomials2.add(m6);

         Polynomial p2 = new Polynomial(monomials2);

         ArrayList <Polynomial> result = Operation.Division(p1,p2);

         System.out.println(result);





      }
}
