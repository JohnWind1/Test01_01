import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser("https://klavogonki.ru/go?type=normal")
	
aaa = WebUI.waitForElementVisible(findTestObject('Object Repository/Game_Words/button_Close'), 10, FailureHandling.OPTIONAL)

if (aaa) {
	WebUI.click(findTestObject('Object Repository/Game_Words/button_Close'))
}

aaa = WebUI.waitForElementVisible(findTestObject('Object Repository/Game_Words/link_START'), 5, FailureHandling.OPTIONAL)

if (aaa) {
	WebUI.click(findTestObject('Object Repository/Game_Words/link_START'))
}


while (true) {
	
	aaa = WebUI.waitForElementVisible(findTestObject('Object Repository/Game_Words/span_FocusWord_HighlightWord'), 1, FailureHandling.OPTIONAL)
	
	if (aaa) {
		
//		WebUI.click(findTestObject('Object Repository/Game_Words/span_FocusWord_HighlightWord'))
//		WebUI.delay(1)
		
		break
	}
/*	
	else {
		
		WebUI.delay(1)
	}
*/	
}

String test = ''

while(true) {
	String currentWord = WebUI.getText(findTestObject('Object Repository/Game_Words/span_FocusWord_HighlightWord')).replaceAll("с", "c").replaceAll("о", "o")
	
	String afterFocusSymbol = WebUI.getText(findTestObject('Object Repository/Game_Words/span_AfterFocus'))
		
	
////////////////////////////////////////////////////////
	
	test = WebUI.getText(findTestObject('Object Repository/Game_Words/span_FocusWord_HighlightWord'))
		
	int index
	//----------------------------------------------------------------------------------------
	while (true) {
		index = test.indexOf(String.valueOf(Character.valueOf((char) 111)));
		if (index >= 0) {
			test = test.replaceAll(String.valueOf(Character.valueOf((char) 111)), String.valueOf(Character.valueOf((char) 1086)));
		} else {
			break;
		}
	}

	while (true) {
		index = test.indexOf(String.valueOf(Character.valueOf((char) 79)));
		if (index >= 0) {
			test = test.replaceAll(String.valueOf(Character.valueOf((char) 79)), String.valueOf(Character.valueOf((char) 1054)));
		} else {
			break;
		}
	}

	//------------------------
	while (true) {
		//                index = test.indexOf("с");
		index = test.indexOf(String.valueOf(Character.valueOf((char) 99)));
		if (index >= 0) {
			test = test.replaceAll(String.valueOf(Character.valueOf((char) 99)), String.valueOf(Character.valueOf((char) 1089)));
		} else {
			break;
		}
	}

	while (true) {
		index = test.indexOf(String.valueOf(Character.valueOf((char) 67)));
		if (index >= 0) {
			test = test.replaceAll(String.valueOf(Character.valueOf((char) 67)), String.valueOf(Character.valueOf((char) 1057)));
		} else {
			break;
		}
	}

	//----------------------------------------------------------------------------------------
////////////////////////////////////////////////////////	
//	//Press Ctrl+A on the Edit element
//	System.out.print(test)
	

	
//	Windows.sendKeys(findTestObject('Object Repository/Game_Words/input_InputText'),Keys.chord(test))
	
	
		
				if (afterFocusSymbol.equals(".")) {
					test = test + "."
//					System.out.print(test)
					WebUI.setText(findTestObject('Object Repository/Game_Words/input_InputText'), test)
					
					
//					Windows.sendKeys(findTestObject('Object Repository/Game_Words/input_InputText'),Keys.chord("."))
					
					break
				} else {
//					System.out.print(test)
					WebUI.setText(findTestObject('Object Repository/Game_Words/input_InputText'), test)
					
				}
				
//				Windows.sendKeys(findTestObject('Object Repository/Game_Words/input_InputText'),Keys.chord(Keys.SPACE))
				
				WebUI.sendKeys(findTestObject('Object Repository/Game_Words/input_InputText'),Keys.chord(Keys.SPACE))
//				WebUI.setText(findTestObject('Object Repository/Game_Words/input_InputText')," ")
				
	
}

//WebUI.delay(15000)

int minValue = 100

		String result = WebUI.getText(findTestObject('Object Repository/Game_Words/td_ResultTest'))
		int resultNumber = Integer.parseInt(result);
		
		System.out.println("Минимальное ожидаемое кол-во знаков " + minValue)
		System.out.println("Полученное кол-во знаков " + resultNumber)
		
		if (resultNumber < minValue) {
			KeywordUtil.markFailed("Полученное кол-во знаком меньше ожидаемого - 100")
		}


		
		
		
'Delete all cookies after browser is opened'
WebUI.deleteAllCookies()

'Close browser'
WebUI.closeBrowser()


