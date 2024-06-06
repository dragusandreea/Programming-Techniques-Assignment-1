import model.Monomial;
import model.Operation;
import model.Polynomial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationTest {

    public Polynomial p1;
    public Polynomial p2;
    public Polynomial additionResult;
    public Polynomial subtractionResult;
    public Polynomial multiplicationResult;
    public Polynomial divisionResult1;
    public Polynomial divisionResult2;
    public Polynomial derivationResult;


    public ArrayList <Integer> integration = new ArrayList<Integer>();

    @BeforeEach
    public void setUp()
    {

        ArrayList<Monomial> m1 = new ArrayList<Monomial>();

        m1.add(new Monomial(1,3));
        m1.add(new Monomial(-2,2));
        m1.add(new Monomial(6,1));
        m1.add(new Monomial(-5,0));

        p1 = new Polynomial(m1);

        ArrayList<Monomial> m2 = new ArrayList<Monomial>();

        m2.add(new Monomial(1,2));
        m2.add(new Monomial(-1,0));

        p2 = new Polynomial(m2);

        //results
        ArrayList<Monomial> mAddition = new ArrayList<Monomial>();
        mAddition.add(new Monomial(1,3));
        mAddition.add(new Monomial(-1,2));
        mAddition.add(new Monomial(6,1));
        mAddition.add(new Monomial(-6,0));
        additionResult = new Polynomial(mAddition);


        ArrayList<Monomial> mSubtraction = new ArrayList<Monomial>();
        mSubtraction.add(new Monomial(1,3));
        mSubtraction.add(new Monomial(-3,2));
        mSubtraction.add(new Monomial(6,1));
        mSubtraction.add(new Monomial(-4,0));
        subtractionResult = new Polynomial(mSubtraction);


        ArrayList<Monomial> mMultiplication = new ArrayList<Monomial>();
        mMultiplication.add(new Monomial(1,5));
        mMultiplication.add(new Monomial(-2,4));
        mMultiplication.add(new Monomial(5,3));
        mMultiplication.add(new Monomial(-3,2));
        mMultiplication.add(new Monomial(-6,1));
        mMultiplication.add(new Monomial(5,0));
        multiplicationResult = new Polynomial(mMultiplication);


        ArrayList<Monomial> mDivisionResult1 = new ArrayList<Monomial>();
        mDivisionResult1.add(new Monomial(1,1));
        mDivisionResult1.add(new Monomial(-2,0));
        divisionResult1 = new Polynomial(mDivisionResult1);

        ArrayList<Monomial> mDivisionResult2 = new ArrayList<Monomial>();
        mDivisionResult2.add(new Monomial(0,3));
        mDivisionResult2.add(new Monomial(0,2));
        mDivisionResult2.add(new Monomial(7,1));
        mDivisionResult2.add(new Monomial(-7,0));
        divisionResult2 = new Polynomial(mDivisionResult2);


        ArrayList<Monomial> mDerivationResult = new ArrayList<Monomial>();
        mDerivationResult.add(new Monomial(3,2));
        mDerivationResult.add(new Monomial(-4,1));
        mDerivationResult.add(new Monomial(6,0));
        mDerivationResult.add(new Monomial(-0,-1));
        derivationResult = new Polynomial(mDerivationResult);


        int coef1 = 25;
        int coef2 = -67;
        int coef3 = 300;
        int coef4 = -500;


        integration.add(coef1);
        integration.add(coef2);
        integration.add(coef3);
        integration.add(coef4);


    }

    @Test
    public void additionTest()
    {
        assertTrue((Operation.Addition(p1,p2)).equals(additionResult) );
    }

    @Test
    public void subtractionTest()
    {
        assertTrue((Operation.Substraction(p1,p2)).equals(subtractionResult) );
    }

    @Test
    public void multiplicationTest()
    {
        assertTrue((Operation.Multiplication(p1,p2)).equals(multiplicationResult) );
    }

    @Test
    public void divisionTest()
    {
        assertTrue(((Operation.Division(p1,p2)).get(0)).equals(divisionResult1) && ((Operation.Division(p1,p2)).get(1)).equals(divisionResult2) );
    }

    @Test
    public void derivationTest()
    {
        assertTrue((Operation.Derivation(p1)).equals(derivationResult) );
    }

    @Test
    public void integrationTest()
    {
        Polynomial result = Operation.Integration(p1);

        boolean ok = true;

        for(int i = 0; i < result.getMonomialsList().size(); i++)
        {
            int y = (int)Math.floor(result.getMonomialsList().get(i).getCoefficient() * 100);

            if(y != integration.get(i))
                ok = false;
        }

        assertTrue(ok);
    }

}
