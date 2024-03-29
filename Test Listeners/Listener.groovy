import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

class Listener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def BeforeTestCase(TestCaseContext testCaseContext) {	
		def testCaseIdsToConsider = ["Login", "OMS"]
	
		String testCaseId = testCaseContext.getTestCaseId()
		
		if (!testCaseIdsToConsider.any { it -> testCaseId.contains(it) }) {
			WebUI.openBrowser('')
			
			WebUI.maximizeWindow()
			
			WebUI.navigateToUrl(GlobalVariable.URL)
			
			WebUI.setText(findTestObject('Object Repository/Page_Welcome to the Petrolink Digital Well File/input_UserName'), GlobalVariable.USERNAME)
			
			WebUI.setEncryptedText(findTestObject('Object Repository/Page_Welcome to the Petrolink Digital Well File/input_Password'),
				GlobalVariable.PASSWORD)
			
			WebUI.click(findTestObject('Object Repository/Page_Welcome to the Petrolink Digital Well File/button_Sign In'))
		}
		
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def AfterTestCase(TestCaseContext testCaseContext) {
		WebUI.closeBrowser()
	}

	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@BeforeTestSuite
	def BeforeTestSuite(TestSuiteContext testSuiteContext) {
		
	}

	/**
	 * Executes after every test suite ends.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	@AfterTestSuite
	def AfterTestSuite(TestSuiteContext testSuiteContext) {
		
	}
}