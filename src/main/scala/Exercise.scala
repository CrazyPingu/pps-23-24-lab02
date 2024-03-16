object Exercise extends App:

  // Task 2a
  object Sign extends Enumeration {
    val POSITIVE = "positive"
    val NEGATIVE = "negative"
  }

  def positive(x: Int): String = x match {
    case x if x >= 0 => Sign.POSITIVE
    case _ => Sign.NEGATIVE
  }


  println("TASK 2A")
  println(positive(5)) // positive
  println(positive(-5)) // negative
  println(positive(0)) // positive
  println("-----------------------")


  // Task 2b
  def neg(predicate: String => Boolean): String => Boolean = (input: String) => !predicate(input)

  val empty: String => Boolean = _ == ""

  println("TASK 2B")
  println(neg(empty)("")) // false
  println(neg(empty)("foo")) // true
  println(neg(empty)("foo") && !neg(empty)("")) // true
  println("-----------------------")


  // Task 2c
  def genericNeg[X](predicate: X => Boolean): X => Boolean = (input: X) => !predicate(input)

  val isEven: Int => Boolean = _ % 2 == 0
  val isLowerCase: Char => Boolean = _.isLower

  println("TASK 2C")
  println(genericNeg(isEven)(1)) // true
  println(genericNeg(isEven)(2)) // false
  println(genericNeg(isLowerCase)('A')) // true
  println(genericNeg(isLowerCase)('a')) // false
  println("-----------------------")

  // Currying
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z


  // Task Compose
  def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

  val f: Int => Int = _ - 1
  val g: Int => Int = _ * 2
  println("TASK COMPOSE")
  println(compose(f, g)(5)) // 9
  println(compose(f, g)(0)) // -1
  println(compose(f, g)(-5)) // -11
  println("-----------------------")

  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

  val fg: String => String = _ + "a"
  val gg: String => String = _ * 2
  println("TASK GENERIC COMPOSE")
  println(genericCompose(fg, gg)("test")) // testtesta
  println(genericCompose(fg, gg)("")) // a
  println(genericCompose(fg, gg)("b")) // bba
  println("-----------------------")