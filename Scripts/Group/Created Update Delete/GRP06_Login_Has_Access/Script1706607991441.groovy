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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_Welcome to the Petrolink Digital Well File/input_UserName'), username)

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Welcome to the Petrolink Digital Well File/input_Password'), 
    password)

WebUI.click(findTestObject('Object Repository/Page_Welcome to the Petrolink Digital Well File/button_Sign In'))

actual_url = WebUI.getUrl()

'this step for verify url, means user login successfuly'
WebUI.verifyMatch(actual_url, GlobalVariable.URL, false)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_IDM/span_Welcome to IDM'), 0)

WebUI.verifyElementText(findTestObject('Object Repository/Page_IDM/span_Welcome to IDM'), 'Welcome to IDM')

KeywordUtil.markPassed('Login Successfully. Test Case Passed.')

