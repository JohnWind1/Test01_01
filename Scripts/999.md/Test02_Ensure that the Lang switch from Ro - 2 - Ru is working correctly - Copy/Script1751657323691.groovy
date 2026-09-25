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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
//--------------------------------------------------------------
import java.text.SimpleDateFormat as SimpleDateFormat
import java.text.Format as Format

WebUI.openBrowser('https://999.md/')

WebUI.waitForElementPresent(findTestObject('Object Repository/999.md/LandingPage/button_Login_noLANG'), 10, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'generic_kwords.generic_keywords.takeSCR'('After_login')

if (WebUI.verifyElementPresent(findTestObject('Object Repository/999.md/LandingPage/div_text_Ro'), 5, FailureHandling.STOP_ON_FAILURE)) {
    'Romanian lang is set by default'
    WebUI.delay(1)

    KeywordUtil.markPassed('Default lang is - RO')

    // Example of using WebUI.comment()
    WebUI.comment('Romanian lang is set by default >> as EXPECTED')
} else {
    'NOT Romanian lang is set by default'
    WebUI.delay(1)

    KeywordUtil.markFailed('Default lang is - NOT RO')
}

'Expand Langs drop-down'
WebUI.click(findTestObject('Object Repository/999.md/LandingPage/div_LangSwitcher_Ro-2-Ru'))

WebUI.delay(2)

'Set/Click RU lang'
WebUI.click(findTestObject('Object Repository/999.md/LandingPage/button_LangSet_RU'))

WebUI.delay(2)

CustomKeywords.'generic_kwords.generic_keywords.takeSCR'('After_switch_lang_to_RU')

// Example of using WebUI.comment()
WebUI.comment('Russian Lang is set')

'Check that in Ru version correct word is shown for --TRANSRORT link'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/999.md/LandingPage/Announces_groups_links/RU/link_Transport'), 
    5, FailureHandling.STOP_ON_FAILURE)) {

    WebUI.delay(1)

    // Example of using WebUI.comment()
    WebUI.comment('Word is correct >>> ' + WebUI.getText(findTestObject('Object Repository/999.md/LandingPage/Announces_groups_links/RU/link_Transport')))

    KeywordUtil.markPassed('Word is correct >>> ' + WebUI.getText(findTestObject('Object Repository/999.md/LandingPage/Announces_groups_links/RU/link_Transport')))

	CustomKeywords.'generic_kwords.generic_keywords.takeSCR'('check_TransportLink_RU')

	WebUI.comment('Click on TRANSPORT link')
		
	WebUI.click(findTestObject('Object Repository/999.md/LandingPage/Announces_groups_links/RU/link_Transport'))

	WebUI.delay(2)

	WebUI.comment('Make a screenshot from TRANSPORT page')
	
		
	CustomKeywords.'generic_kwords.generic_keywords.takeSCR'('check_Transport_PAGE_RU')

} else {
	
    WebUI.delay(1)

    WebUI.comment('Expected word is >> Транспорт, Current word is >> ' + WebUI.getText(findTestObject('Object Repository/999.md/LandingPage/Announces_groups_links/RU/link_Transport')))

    KeywordUtil.markFailed('Expected word is >> Транспорт, Current word is >> ' + WebUI.getText(findTestObject('Object Repository/999.md/LandingPage/Announces_groups_links/RU/link_Transport')))
}

WebUI.delay(1)

'Delete all cookies after browser is opened'
WebUI.deleteAllCookies()

'Close browser'
WebUI.closeBrowser()



