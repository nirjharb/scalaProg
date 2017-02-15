package scalaprogram

/**
  * Created by User on 02-02-2017.
  */
object ScalaProgram extends App {
  //factorial of a number : 5! = 5 * 4 * 3 * 2 * 1
  //def factorial (x: BigInt):BigInt = if (x <= 0) 1 else x * factorial(x-1)
  //factorial(10)

  //fibonacci series : 0, 1, 1, 2, 3, 5, 8, 13...
  def fibonacci (n: Int) :Int = if (n < 2) 1 else fibonacci(n-1)+fibonacci(n-2)
  val result = fibonacci(8)
  println(result)
}
