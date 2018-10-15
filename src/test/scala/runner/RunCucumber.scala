package runner

import org.junit.runner.RunWith
import cucumber.api.junit.Cucumber
import cucumber.api.CucumberOptions

@RunWith(classOf[Cucumber])
@CucumberOptions(
  plugin = Array("pretty", "html:target/cucumber-html-report", "json:target/cucumber-report.json"),
  features = Array("classpath:features/BankAccount.feature", "classpath:features/TableCount.feature"),
  glue = Array("bank", "db"))
class RunCucumber
