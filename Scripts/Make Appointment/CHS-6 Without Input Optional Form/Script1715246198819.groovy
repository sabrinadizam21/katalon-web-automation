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

WebUI.callTestCase(findTestCase('00_Main/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Make Appointment/select_Facility'), facility, false)

WebUI.click(findTestObject('Make Appointment/radiobtn_Medicaid_programs'))

WebUI.setText(findTestObject('Make Appointment/input_Visit Date (Required)_visit_date'), visit_date)

WebUI.click(findTestObject('Make Appointment/button_Book Appointment'))

verifyMatch(findTestObject('Summary Appointment/p_Facility'), facility)

verifyMatch(findTestObject('Summary Appointment/p_hospital_readmission'), 'No')

verifyMatch(findTestObject('Summary Appointment/p_Program'), 'Medicaid')

verifyMatch(findTestObject('Summary Appointment/p_Visit Date'), visit_date)

WebUI.verifyElementNotVisible(findTestObject('Summary Appointment/p_Comment'), FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

def verifyMatch(def actualObject, def expected) {
    text = WebUI.getText(actualObject)

    WebUI.verifyMatch(text, expected, false, FailureHandling.STOP_ON_FAILURE)
}

