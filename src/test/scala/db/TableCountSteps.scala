package db

import com.waioeka.sbt.runner.CucumberSpec
import cucumber.api.scala.{ EN, ScalaDsl }
import org.slf4j.LoggerFactory

class TableCountSteps extends ScalaDsl with EN {
  var tableCount: TableCount = _
  var result: Long = _

  private val log = LoggerFactory.getLogger(classOf[TableCountSteps])

  Before { scenario =>
    log.info("Before...")
  }
  After { scenario =>
    log.info("...After")
  }

  Given("""^a table with name of ([^\"]*)""") { (name: String) =>
    tableCount = new TableCount(name)
  }

  When("""^the operator requests count""") { () =>
    result = tableCount.count()
  }

  Then("""^the table record count should be ([^\"]*)""") { (expectedResult: Long) =>
    assert(result == expectedResult)
  }
}