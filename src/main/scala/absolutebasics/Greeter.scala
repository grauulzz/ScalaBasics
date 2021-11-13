package absolutebasics
import jdk.nashorn.internal.objects.annotations.Property
import scala.collection.JavaConverters._

class Greeter(prefix: String, suffix: String) {

  def greet(name: String): Unit =
    println(prefix + name + suffix)

  def getSysUserName = {
    def name: String = System.getProperty("user.name").toString
    name
  }

  def getEnvVariables = {
    val environmentVars = System.getenv().asScala
    for ((k, v) <- environmentVars) println(s"key: $k, value: $v")
  }

  def getSysProperties = {
    val properties = System.getProperties().asScala
    for ((k, v) <- properties) println(s"key: $k, value: $v")
  }
}
