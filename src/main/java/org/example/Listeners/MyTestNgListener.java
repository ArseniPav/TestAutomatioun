package org.example.Listeners;


import com.codeborne.selenide.WebDriverRunner;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.example.tests.BaseTest;

public class MyTestNgListener implements ITestListener, IInvokedMethodListener {
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult){
        if (method.isConfigurationMethod()||method.isTestMethod()){
            int status = testResult.getStatus();
            if (status != 1&& WebDriverRunner.hasWebDriverStarted()&&status!=3&&WebDriverRunner.hasWebDriverStarted()){
                try{
                    BaseTest.takeScreenshot();
                } catch (Exception e){
                    System.out.println("Не удалось сделать скриншот");
                }
            }
        }
    }
    }

