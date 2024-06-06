package model;

import java.util.ArrayList;
import java.util.Collections;

public class Polynomial{
    ArrayList<Monomial> monomialsList = new ArrayList<Monomial>();

    public Polynomial(ArrayList<Monomial> monomialsList) {
        this.monomialsList = monomialsList;
    }
    public Polynomial(){ }

    public ArrayList<Monomial> getMonomialsList() {
        return monomialsList;
    }
    public void setMonomialsList(ArrayList<Monomial> monomialsList) {
        this.monomialsList = monomialsList;
    }

    @Override
    public String toString()
    {
        String result = "";

        for(Monomial m: monomialsList)
        {
            result += m.toString();
        }

        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        Polynomial o  = (Polynomial) obj;

        if( o == this)
            return true;

       Collections.sort(this.getMonomialsList());
       Collections.sort(o.getMonomialsList());

       if(this.getMonomialsList().size()!= o.getMonomialsList().size())
           return false;
       else
       {
           for(int i = 0; i < this.getMonomialsList().size();i++)
           {
               if(!this.getMonomialsList().get(i).equals(o.getMonomialsList().get(i)))
               {
                   return false;
               }
           }

           return true;
       }

    }


}
