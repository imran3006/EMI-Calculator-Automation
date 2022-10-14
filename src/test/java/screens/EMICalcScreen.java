package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//@Getter
//@Setter
public class EMICalcScreen {
    @FindBy(id="com.continuum.emi.calculator:id/btnStart")
    public AndroidElement btnEMICalc;
    @FindBy(id="com.continuum.emi.calculator:id/etLoanAmount")
    AndroidElement txtAmount;
    @FindBy(id="com.continuum.emi.calculator:id/etInterest")
    AndroidElement txtInterest;
    @FindBy(id="com.continuum.emi.calculator:id/etYears")
    AndroidElement txtYears;
    @FindBy(id="com.continuum.emi.calculator:id/etMonths")
    AndroidElement txtMonths;
    @FindBy(id="com.continuum.emi.calculator:id/etEMI")
    AndroidElement txtEMI;
    @FindBy(id="com.continuum.emi.calculator:id/etFee")
    AndroidElement txtProcessFee;
    @FindBy(id="com.continuum.emi.calculator:id/btnCalculate")
    AndroidElement btnCalculate;
    @FindBy(id="com.continuum.emi.calculator:id/btnReset")
    public AndroidElement btnReset;

    @FindBy(id="com.continuum.emi.calculator:id/monthly_emi_result")
    AndroidElement lblEMIRes;
    @FindBy(id="com.continuum.emi.calculator:id/total_interest_result")
    AndroidElement lblInterestRes;
    @FindBy(id="com.continuum.emi.calculator:id/processing_fee_result")
    AndroidElement lblProcessingFeeRes;
    @FindBy(id="com.continuum.emi.calculator:id/total_payment_result")
    AndroidElement lblTotalPayRes;


    // for get text we define here private variables against the values of calculation result
    private Double mEMI;
    private Double tIinterest;
    private Double pFee;
    private Double tAmount;



    public Double getmEMI() {
        return mEMI;
    }

    public void setmEMI(Double mEMI) {
        this.mEMI = mEMI;
    }

    public Double gettIinterest() {
        return tIinterest;
    }

    public void settIinterest(Double tIinterest) {
        this.tIinterest = tIinterest;
    }

    public Double getpFee() {
        return pFee;
    }

    public void setpFee(Double pFee) {
        this.pFee = pFee;
    }

    public Double gettAmount() {
        return tAmount;
    }

    public void settAmount(Double tAmount) {
        this.tAmount = tAmount;
    }

    public EMICalcScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void doCalculation(double amount, double interest, int year,double processingFee){
//        btnEMICalc.click();
        txtAmount.sendKeys(""+amount+"");
        txtInterest.sendKeys(""+interest+"");
        txtYears.sendKeys(""+year+"");
        txtProcessFee.sendKeys(""+processingFee+"");
        btnCalculate.click();

        //USING  SETTER METHOD set the values
        setmEMI(Double.parseDouble(lblEMIRes.getText().replace(",", "")));
        settIinterest(Double.parseDouble(lblInterestRes.getText().replace(",", "")));
        setpFee(Double.parseDouble(lblProcessingFeeRes.getText().replace(",", "")));
        settAmount(Double.parseDouble(lblTotalPayRes.getText().replace(",", "")));



    }





}
