package Frame;

import org.openqa.selenium.By;

public class Register {
	
	public static void main(String[] args) {
				
		Common.LaunchBrowser();
		Common.AppLaunchSuccess("Verify_to");
		Common.waitMethod();		
		
		//Sending keys**********		
		/*Common.form_Eidt("Email_Xpath", "Email");
		Common.form_Eidt("mobile_Xpath", "Mobile_number");
		Common.form_Eidt("Name_Xpath", "name");
		Common.form_Eidt("Repeat_Email_Xpath", "Repeat_Email");
		Common.form_Eidt("Pass_Xpath", "password");
		Common.form_Eidt("Renter_pass_Xpath", "RenterPass");
		Common.form_Eidt("City_Xpath", "City");
		Common.form_Eidt("WebSite_Xpath", "website");
		Common.form_Eidt("Street_Xpath", "street");
		Common.form_Eidt("First_Question_Xpath", "First_Question");
		Common.form_Eidt("First_Answer_Xpath", "First_Answer");
		Common.form_Eidt("Second_Question_Xpath", "Second_Question");
		Common.form_Eidt("Second_Answer_Xpath", "Second_Answer");
		Common.form_Eidt("Third_Question_Xpath", "Third_Question");
		Common.form_Eidt("Third_Answer_Xpath", "Third_Answer");*/
		
		
		//*************Selecting From options************
		/*Common.select("July", "Month");
		Common.select("18", "date");		
		Common.select("India", "country12");		
		Common.select("United Kingdom", "Nationality_Xpath");*/
		
		//************Check Box************
		
//		Common.ClickElements("Forgot_password");
		Common.ClickElements("Register_Xpath");	
		
	    	
	/*	Common.ClickElements("Select_Manual");
		Common.ClickElements("Select_VBScript");
		Common.ClickElements("Select_QualityCenter");
		Common.ClickElements("Select_Selenium");
		Common.ClickElements("Select_Sql");
		Common.ClickElements("Select_Agree");
		Common.ClickElements("Select_Updates");
		Common.ClickElements("Register_btn_Xpath");*/
//		Common.ClickElements("Gender");
		
		//**************Navigation
		
		Common.window_Handle("Navigated_Iframe", "Navi_Confirm_Xpath");
//		Common.window_Handle("Navigated_Iframe", "Naiv_Confirm_Forgot_Xpath");
        Common.waitMethod();
        Common.radioButton(By.xpath(Parameterization.readProperty("radioBtn_Xpath")), Parameterization.readProperty("val_Female"), "radio for gender");
		Common.checkBoxButtons(By.xpath(Parameterization.readProperty("CheckBox_xpath")), Parameterization.readProperty("manual"), "click on manual");
        Common.checkBoxButtons(By.xpath(Parameterization.readProperty("CheckBox_xpath")), Parameterization.readProperty("seleWithjava"), "Click on java");
		
//		Data.Common.driver.close();
	}

}
