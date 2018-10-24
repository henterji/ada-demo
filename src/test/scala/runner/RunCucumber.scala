package runner

import org.junit.runner.RunWith
import cucumber.api.junit.Cucumber
import cucumber.api.CucumberOptions

@RunWith(classOf[Cucumber])
@CucumberOptions(
  plugin = Array("pretty", "html:target/cucumber-html-report", "json:target/cucumber-report.json", "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/report.html"),
  features = Array("classpath:features/BankAccount.feature", "classpath:features/TableCount.feature", "classpath:features/Test.feature"),
  glue = Array("bank", "db", "test"))
class RunCucumber
