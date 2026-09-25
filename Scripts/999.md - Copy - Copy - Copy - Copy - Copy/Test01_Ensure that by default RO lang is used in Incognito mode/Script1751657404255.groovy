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
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.Keys as Keys
//------
import java.nio.file.Path
import java.nio.file.Paths

WebUI.openBrowser("https://999.md/")

WebUI.waitForElementPresent(findTestObject('Object Repository/999.md/LandingPage/button_Login_noLANG'), 10, FailureHandling.STOP_ON_FAILURE)

	CustomKeywords.'generic_kwords.generic_keywords.takeSCR'('After_successful_LOGIN')

if (WebUI.verifyElementPresent(findTestObject('Object Repository/999.md/LandingPage/div_text_Ro'), 5, FailureHandling.STOP_ON_FAILURE)) {
	'Romanian lang is set by default'
	
	WebUI.delay (1)
		
	KeywordUtil.markPassed("Default lang is - RO")
	
	CustomKeywords.'generic_kwords.generic_keywords.takeSCR'('After_default_lang_check_RO')
	
	// Example of using WebUI.comment()
	WebUI.comment("Romanian lang is set by default >> as EXPECTED")
	

} else {
	'NOT Romanian lang is set by default'
	
	WebUI.delay (1)
	
	KeywordUtil.markFailed("Default lang is - NOT RO")
	
	// Example of using WebUI.comment()
	WebUI.comment("Romanian lang is  NOT SET  >> ERROR >>>> ")
	
	CustomKeywords.'generic_kwords.generic_keywords.takeSCR'('Incorrect_Lang_set___ERROR')
	
}






WebUI.delay (1)

'Delete all cookies after browser is opened'
WebUI.deleteAllCookies()

'Close browser'
WebUI.closeBrowser()


