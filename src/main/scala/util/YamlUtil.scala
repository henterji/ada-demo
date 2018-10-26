package util

import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import scala.collection.mutable.ListBuffer
import scala.beans.BeanProperty
import java.io.{File, FileInputStream}

object YamlUtil {
  def main(args: Array[String]) {
    val filename = "src/main/resources/config.yaml"
    val input = new FileInputStream(new File(filename))
    val yaml = new Yaml(new Constructor(classOf[Config]))
    val e = yaml.load(input).asInstanceOf[Config]
    println(e)
  }
}

/**
* With the Snakeyaml Constructor approach shown in the main method,
* this class must have a no-args constructor.
*/
class Config {
    @BeanProperty var env = ""
    @BeanProperty var user = ""
    @BeanProperty var driver = ""
    override def toString: String = s"env: $env, user: $user, driver: $driver"
}
