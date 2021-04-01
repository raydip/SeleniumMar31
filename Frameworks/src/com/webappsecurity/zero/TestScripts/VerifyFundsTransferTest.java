package com.webappsecurity.zero.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;
import com.webappsecurity.zero.Pages.TransferFundsVerify;
import com.webappsecurity.zero.Pages.TransferfundsConfirmation;

import utils.GenericMethods;

public class VerifyFundsTransferTest extends BaseClass {

	@Test
	public void verifyfundTransfer() throws IOException {

		Login lp = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferfundsConfirmation tfc = new TransferfundsConfirmation(driver);

		String[][] data = GenericMethods.getData("D:\\development\\documents\\TestDataLocal.xlsx", "sheet1");
		for (int i =1; i < data.length; i++) {
			
			lp.applicationLogin(data[i][0], data[i][1]);
			
			acc.clickTransferFunds();
			
			tf.doTransferFunds(data[i][2], data[i][3]);
			
			tfv.clickSubmit();
			
			String actualText = tfc.confMsg();
			String expectedText = data[i][4];
			
			Assert.assertEquals(actualText, expectedText);
			tfc.logoutFromApp();
			driver.get("http://zero.webappsecurity.com/login.html");
		}
	}
}
