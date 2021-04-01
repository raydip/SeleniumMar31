package kwdFramework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Applications {

	@Test
	public void invalidLoginTest() throws IOException {
		String data[][] = GenericMethods.getData("D:\\development\\documents\\TestDataLocal.xlsx", "sheet2");
		Methods mtd = new Methods();
		for (int i = 1; i < data.length; i++) {
			switch (data[i][3]) {

			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maxBrowser();
				break;
			case "impWait":
				mtd.impWait();
				break;
			case "navigateToApp":
				mtd.navToApp(data[i][6]);
				break;
			case "enterInTextBox":
				mtd.entInTextBox(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickBtn(data[i][4], data[i][5]);
				break;
			case "verifyErrorMsg":
				String actualMsg = mtd.getErrorMsg(data[i][4], data[i][5]);
				Assert.assertEquals(actualMsg, data[i][6]);
				break;
			case "closeApp":
				mtd.appClose();
				break;

			}
		}
	}
}
