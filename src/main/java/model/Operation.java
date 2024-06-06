package model;


import java.util.*;

public  class  Operation {
     public static Polynomial Addition(Polynomial p1, Polynomial p2) {

          ArrayList<Monomial> additionResult = new ArrayList<Monomial>();

          int i = 0; //first
          int j = 0; //second

          while(i < p1.getMonomialsList().size() && j < p2.getMonomialsList().size())
          {
               //iau polinoamele de la indexii i si j (puterea lor)

               if(p1.getMonomialsList().get(i).getDegree() > p2.getMonomialsList().get(j).getDegree())
               {
                   additionResult.add(p1.getMonomialsList().get(i));
                   i++;
               }
               else
               {
                    if(p2.getMonomialsList().get(j).getDegree() > p1.getMonomialsList().get(i).getDegree())
                    {
                         additionResult.add(p2.getMonomialsList().get(j));
                         j++;
                    }
                    else
                    {
                         //sunt egale
                         Monomial addition = new Monomial();
                         addition.setDegree(p2.getMonomialsList().get(j).getDegree());
                         addition.setCoefficient(p1.getMonomialsList().get(i).getCoefficient() + p2.getMonomialsList().get(j).getCoefficient());
                         additionResult.add(addition);

                         i++;
                         j++;

                    }
               }
          }

          //daca au mai ramas elemente in primul polinom
          while(i < p1.getMonomialsList().size())
          {
               additionResult.add(p1.getMonomialsList().get(i));
               i++;
          }

          //daca au mai ramas elemente in al doilea polinom
          while(j < p2.getMonomialsList().size())
          {
               additionResult.add(p2.getMonomialsList().get(j));
               j++;
          }

          Collections.sort(additionResult);

          Polynomial result = new Polynomial(additionResult);

          return result;

     }

     public static Polynomial Substraction(Polynomial p1, Polynomial p2) {

          ArrayList<Monomial> substractionResult = new ArrayList<Monomial>();

          int i = 0; //first
          int j = 0; //second

          while(i < p1.getMonomialsList().size() && j < p2.getMonomialsList().size())
          {
               //iau polinoamele de la indexii i si j (puterea lor)

               if(p1.getMonomialsList().get(i).getDegree() > p2.getMonomialsList().get(j).getDegree())
               {
                    substractionResult.add(p1.getMonomialsList().get(i));
                    i++;
               }
               else
               {
                    if(p2.getMonomialsList().get(j).getDegree() > p1.getMonomialsList().get(i).getDegree())
                    {
                         Monomial s = new Monomial();
                         s.setCoefficient(-p2.getMonomialsList().get(j).getCoefficient());
                         s.setDegree(p2.getMonomialsList().get(j).getDegree());
                         substractionResult.add(s);
                         j++;
                    }
                    else
                    {
                         //sunt egale
                         Monomial addition = new Monomial();
                         addition.setDegree(p2.getMonomialsList().get(j).getDegree());
                         addition.setCoefficient(p1.getMonomialsList().get(i).getCoefficient() - p2.getMonomialsList().get(j).getCoefficient());
                         substractionResult.add(addition);

                         i++;
                         j++;

                    }
               }
          }

          //daca au mai ramas elemente in primul polinom
          while(i < p1.getMonomialsList().size())
          {
               substractionResult.add(p1.getMonomialsList().get(i));
               i++;
          }

          //daca au mai ramas elemente in al doilea polinom
          while(j < p2.getMonomialsList().size())
          {
               Monomial s = p2.getMonomialsList().get(j);
               s.setCoefficient(-p2.getMonomialsList().get(j).getCoefficient());
               substractionResult.add(s);
               j++;
          }

          Collections.sort(substractionResult);

          Polynomial result = new Polynomial(substractionResult);

          return result;

     }

     public static Polynomial Multiplication(Polynomial p1, Polynomial p2)
     {

          ArrayList <Monomial> multiplicationResult = new ArrayList<Monomial>();
          Polynomial result = new Polynomial(multiplicationResult);

          Polynomial p = new Polynomial();

         for(Monomial m1: p1.getMonomialsList())
         {
              for(Monomial m2: p2.getMonomialsList())
              {
                   Monomial multiplication = new Monomial();
                   multiplication.setCoefficient(m1.getCoefficient() * m2.getCoefficient());
                   multiplication.setDegree(m1.getDegree() + m2.getDegree());

                   ArrayList <Monomial> multiplicationAux = new ArrayList<Monomial>();
                   multiplicationAux.add(multiplication);
                   p = new Polynomial(multiplicationAux);

                   result = Operation.Addition(result,p);

              }

              Collections.sort(multiplicationResult);
              //result = p;
         }

         return result;
     }

     public static Polynomial Derivation(Polynomial p)
     {
          ArrayList <Monomial> derivationResult = new ArrayList<Monomial>();
          Polynomial result = new Polynomial(derivationResult);

          for(Monomial m: p.getMonomialsList())
          {
               Monomial derivation = new Monomial();
               derivation.setDegree(m.getDegree() - 1);
               derivation.setCoefficient(m.getCoefficient() * m.getDegree());

               derivationResult.add(derivation);
          }

          Collections.sort(derivationResult);

          return result;
     }


     public static Polynomial Integration(Polynomial p)
     {
          ArrayList <Monomial> integrationResult = new ArrayList<Monomial>();
          Polynomial result = new Polynomial(integrationResult);

          for(Monomial m: p.getMonomialsList())
          {
               Monomial integration = new Monomial();
               integration.setDegree(m.getDegree() + 1);
               integration.setCoefficient(m.getCoefficient() / (m.getDegree() +1));

               integrationResult.add(integration);
          }

          Collections.sort(integrationResult);

          return result;

     }

     public static ArrayList <Polynomial> Division ( Polynomial p1, Polynomial p2)
     {
          Collections.sort(p1.getMonomialsList());
          Collections.sort(p2.getMonomialsList());

          ArrayList<Polynomial> result = new ArrayList <Polynomial>();

          //System.out.println(p1.getMonomialsList());
          //System.out.println(p2.getMonomialsList());

          if(p2.getMonomialsList().size() > 0) {
               ArrayList<Monomial> quotientMonomialsList = new ArrayList<Monomial>();
               Polynomial q = new Polynomial(quotientMonomialsList);

               ArrayList<Monomial> restMonomialsList = new ArrayList<Monomial>(p1.getMonomialsList());
               Polynomial r = new Polynomial(restMonomialsList);

               int index = 0;

               while (r.getMonomialsList().size() != 0 && r.getMonomialsList().get(index).getDegree() >= p2.getMonomialsList().get(0).getDegree()) {

                    boolean found = false;
                    while (!found) {
                         if (r.getMonomialsList().get(index).getCoefficient() != 0) {
                              found = true;
                         } else
                              index++;
                    }

                    if (found &&  r.getMonomialsList().get(index).getDegree() >= p2.getMonomialsList().get(0).getDegree() ) {
                         System.out.println(r.getMonomialsList().get(index));
                         Monomial t = new Monomial();
                         t.setDegree(r.getMonomialsList().get(index).getDegree() - p2.getMonomialsList().get(0).getDegree());
                         t.setCoefficient(r.getMonomialsList().get(index).getCoefficient() / p2.getMonomialsList().get(0).getCoefficient());

                         ArrayList<Monomial> auxList = new ArrayList<Monomial>();
                         auxList.add(t);

                         Polynomial aux = new Polynomial(auxList);

                         q = Addition(q, aux);
                         r = Substraction(r, Multiplication(aux, p2));

                         if (p1.getMonomialsList().size() == 1)
                              break;

                         //System.out.println(r);
                    }}

                    result.add(q);
                    result.add(r);

                    return result;
               }
          else
               {    // (null,null)
                    System.out.println("Division by 0");
                    return result;
               }



     }

}
