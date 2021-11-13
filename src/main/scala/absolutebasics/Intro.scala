package absolutebasics

import jdk.nashorn.internal.objects.annotations.Property
import scala.collection.JavaConverters._

object Intro {

  Console.println(1)

  // named result of an expression is a value
  val x = 1 + 1

  // values can't be reassinged eg. x=3

  // the type a value (result of expression) can be ommited as above or
  val y: Int = 2 + 2

  // variables are like values, except you can reassign them (also suports type inference)
  var z: Int = 1 + 1
  z = 3

  // combine expressions with "blocks"
  println({
    x + y
  })

  // functions are expressions with parameters and take arguments
  // anonymous function (nameless) returns an integer plus 1
  // the expression is assinged to a value named addOne
  val addOne = (x: Int) => x + 1
  println(addOne(1))
  println(addOne(addOne(1)))

  // the left of => are params of the anon func
  // the right side is the expression to be carried out on input of the params
  val multOne = (x: Int) => x * 1
  println(multOne(9))

  val multTwoNums = (x: Int, y: Int) => x * y
  val funcOfMultTwoNums = multTwoNums(2, 10)

  println({
    addOne(funcOfMultTwoNums) + funcOfMultTwoNums + multTwoNums(funcOfMultTwoNums, funcOfMultTwoNums)
  })

  val area = (len: Int, width: Int) => len * width
  val getArea = () => area(2, 2)

  val volume = (area: Int, height: Int) => area * height
  val getVolume = () => volume(getArea(), 2)

  // volume
  println(volume(area(2, 2), 2))

  // or volume utlizing the getters
  println(getVolume())

  // not entirely sure why this would be usefull, probrably just redundant (you can call volumMethod in the same way)
  val v: (Int, Int, Int) => Int = volumeMethod

  private def volumeMethod = {
    val v = (len: Int, width: Int, height: Int) => len * width * height
    v
  }

  val vol1 = v(1, 1, 1)
  val vol2 = v(2, 2, 2)
  val vol3 = v(3, 3, 3)

  // could use type inference here but showing what the function type will return is handy
  def sequenceOfVolumes(values: Int*): Seq[Int] = {
    values
  }

  println(sequenceOfVolumes(vol1, vol2, vol3))

  def getCubicString(volume: Int): String = {
    volume.toString + "^3"
  }

  // returning "Unit" is similiar to void, signifies nothing meaningfull to return as a type
  def getCubicStringSequence(volume: Seq[Int]): Unit = {
    for ((x, i) <- volume.view.zipWithIndex) println("[" + i + "] " + getCubicString(x))
  }

  var getCubicStringOneliner = for ((x, i) <- sequenceOfVolumes(vol1, vol2, vol3)
    .view.zipWithIndex) println("[" + i + "] " + getCubicString(x))

  println(getCubicStringOneliner)
  getCubicStringSequence(sequenceOfVolumes(vol1, vol2, vol3))

  // currying example (multiple parameter lists)
  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(9)((m, n) => m + n)
  println(res) // 55

  // example of multiple param lists
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier

  println(addThenMultiply(1, 2)(3)) // 9

  // class example
  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer") // Hello, Scala developer!

  // Greeter class has some methods to use some cool scala built in methods (like getProperties())
  val getStuff = new Greeter("Hello, ", "!")
  getStuff.greet(getStuff.getSysUserName) // getStuff.getEnvVariables or getStuff.getSysProperties

  // case class example
  // case classes can be instantiated without the "new" keyword
  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)

  // instances of case classes are compared by value, not by reference:  (same as java.. nothin new here)
  if (point == anotherPoint) {
    println(s"$point and $anotherPoint are the same.")
  } else {
    println(s"$point and $anotherPoint are different.")
  }

  // declaring a new instance of object and calling a method addOne()
  var newObjectInstance: Int = Intro.addOne(1)
  println(newObjectInstance)

  // reassigning the new object to an instance of this objects method addOne()
  newObjectInstance += this.addOne(1)
  println(newObjectInstance)

  // shit override default method attempt. Works but seems wrong
  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer") // How are you, Scala developer?

  println(customGreeter.getSysUserName)

  def main(args: Array[String]): Unit = {
    println("ah, the beloved main method (extends App does the same thing btw)")
  }
}


