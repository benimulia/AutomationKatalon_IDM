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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://skicvdevpv1.dev.petrolink.net/oms/omsserver/home/')

WebUI.click(findTestObject('Object Repository/OMS/a_module-select-btn aclmanager-module'))

WebUI.setText(findTestObject('Object Repository/OMS/input_form-control input-sm input-textCls s_6a30a2'), 'samscvtech')

WebUI.setText(findTestObject('Object Repository/OMS/input_form-control input-sm input-textCls s_69fb31'), 'https://samscvtech8.dev.petrolink.net/PetroVault')

WebUI.click(findTestObject('Object Repository/OMS/span_save-btn'))

WebUI.click(findTestObject('Object Repository/OMS/span_samscvtech'))

WebUI.click(findTestObject('Object Repository/OMS/span_Connect'))

WebUI.setText(findTestObject('Object Repository/OMS/input_UserName'), 'administrator')

WebUI.setEncryptedText(findTestObject('Object Repository/OMS/input_Password'), 'p4y+y39Ir5Oy1MY8jPt0uQ==')

WebUI.click(findTestObject('Object Repository/OMS/button_Sign In'))

WebUI.click(findTestObject('Object Repository/OMS/a_ALL'))

WebUI.click(findTestObject('Object Repository/OMS/a_'))

WebUI.click(findTestObject('Object Repository/OMS/a_idm'))

WebUI.click(findTestObject('Object Repository/OMS/a_Add User Group'))

WebUI.click(findTestObject('Object Repository/OMS/div_All'))

WebUI.click(findTestObject('Object Repository/OMS/a_Groups'))

WebUI.setText(findTestObject('Object Repository/OMS/input_filterSearchBox pull-right'), 'automation')

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/OMS/first_row_user_groups'))

WebUI.click(findTestObject('OMS/btn_add_groups'))

WebUI.click(findTestObject('Object Repository/OMS/a_user-list-close-btn'))

WebUI.click(findTestObject('Object Repository/OMS/input_CheckBoxInput_1'))

WebUI.click(findTestObject('OMS/input_CheckBoxInput_2'))

WebUI.click(findTestObject('OMS/input_CheckBoxInput_3'))

WebUI.click(findTestObject('OMS/input_CheckBoxInput_4'))

WebUI.click(findTestObject('OMS/input_CheckBoxInput_5'))

WebUI.click(findTestObject('Object Repository/OMS/div_Never'))

WebUI.click(findTestObject('Object Repository/OMS/div_Always'))

WebUI.click(findTestObject('Object Repository/OMS/a_Save'))

