package bank

import cucumber.api.scala.{ EN, ScalaDsl }
import org.slf4j.LoggerFactory


class BankAccountSteps extends ScalaDsl with EN {
  var bankAccount: BankAccount = _
  var result: Either[String, BankAccount] = _

  private val log = LoggerFactory.getLogger(classOf[BankAccountSteps])

  Before { scenario =>
    log.info("Before...")
  }
  After { scenario =>
    log.info("...After")
  }

  Given("""^an account with a balance of \$(.+)$""") { (balance: Double) =>
    bankAccount = new BankAccount(balance)
  }

  When("""^the Account Holder requests \$(.+)$""") { (amount: Double) =>
    result = bankAccount.debit(amount)
  }

  Then("""^the account balance should be \$(.+)$""") { (expectedResult: Double) =>
    assert(result.right.exists(_.balance == expectedResult))
  }

  Then("""^the Account Holder should be notified that overdrafts are not permitted$""") { () =>
    assert(result.left.exists(_.equalsIgnoreCase("overdrafts are not permitted")))
  }
}
