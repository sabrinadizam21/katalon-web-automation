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

WebUI.callTestCase(findTestCase('Make Appointment/CHS-5 Verify Add Appointment'), input, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('00. Main/a_CURA Healthcare_menu-toggle'))

WebUI.click(findTestObject('00. Main/a_History'))

verifyMatch(findTestObject('History/p_Facility'), input.facility)

verifyMatch(findTestObject('History/p_hospital_readmission'), 'Yes')

verifyMatch(findTestObject('History/p_Program'), 'Medicare')

verifyMatch(findTestObject('History/div_Visit Date'), input.visit_date)

verifyMatch(findTestObject('History/p_Comment'), input.comment)

def verifyMatch(def actualObject, def expected) {
    text = WebUI.getText(actualObject)

    WebUI.verifyMatch(text, expected, false, FailureHandling.STOP_ON_FAILURE)
}

