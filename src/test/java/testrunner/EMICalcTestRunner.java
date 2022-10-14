package testrunner;

import base.Setup;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import screens.EMICalcScreen;
import utilities.DataSet;

import java.sql.Driver;
//using dataset we get values and pass only parameter here using dataset class
public class EMICalcTestRunner extends Setup {
//start the emicalculator button only once thats why it seperates from Test cases
    @BeforeTest
    public void startEMICalc(){
        EMICalcScreen emiCalcScreen= new EMICalcScreen(driver);
        emiCalcScreen.btnEMICalc.click();
    }
    @Test(dataProvider = "data-provider", dataProviderClass = DataSet.class,priority = 1)
    public void doCalculation(double amount, double interest, int year,double processingFee, double mEMI,double tInterest, double pFee,double tPayment){
        EMICalcScreen emiCalcScreen= new EMICalcScreen(driver);
        emiCalcScreen.doCalculation(amount,interest,year,processingFee);
       String monthlyEMI=String.valueOf(emiCalcScreen.getmEMI());
        String totalInterest = String.valueOf(emiCalcScreen.gettIinterest());
        String totalProcessingFee= String.valueOf(emiCalcScreen.getpFee());
        String totalAmount = String.valueOf(emiCalcScreen.gettAmount());

        System.out.println(monthlyEMI);
        System.out.println(totalInterest);
        System.out.println(totalProcessingFee);
        System.out.println(totalAmount);

        Assert.assertEquals(monthlyEMI,String.valueOf(mEMI));
        Assert.assertEquals(totalInterest,String.valueOf(tInterest));
        Assert.assertEquals(totalProcessingFee,String.valueOf(pFee));
        Assert.assertEquals(totalAmount,String.valueOf(tPayment));



        emiCalcScreen.btnReset.click();


    }



}
