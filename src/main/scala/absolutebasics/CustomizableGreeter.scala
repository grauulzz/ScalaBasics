
package absolutebasics

class CustomizableGreeter(prefix: String, suffix: String) extends Greeter(prefix: String, suffix: String) {
  override def greet(name: String): Unit = {
    println(prefix + name + suffix)
  }

  override def getSysUserName: String = super.getSysUserName + " jankens"
}


