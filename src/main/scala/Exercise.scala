import scala.annotation.tailrec

object Exercise extends App:

  // Task 2a -- Svolto da solo
  def positive(x: Int): String = x match
    case x if x >= 0 => "positive"
    case _ => "negative"

//  println("TASK 2A")
//  println(positive(5)) // positive
//  println(positive(-5)) // negative
//  println(positive(0)) // positive
//  println("-----------------------")


  // Task 2b -- Svolto da solo
  def neg(predicate: String => Boolean): String => Boolean = (input: String) => !predicate(input)

  val empty: String => Boolean = _ == ""

//  println("TASK 2B")
//  println(neg(empty)("")) // false
//  println(neg(empty)("foo")) // true
//  println(neg(empty)("foo") && !neg(empty)("")) // true
//  println("-----------------------")


  // Task 2c -- Svolto da solo
  def genericNeg[X](predicate: X => Boolean): X => Boolean = (input: X) => !predicate(input)

  val isEven: Int => Boolean = _ % 2 == 0
  val isLowerCase: Char => Boolean = _.isLower

//  println("TASK 2C")
//  println(genericNeg(isEven)(1)) // true
//  println(genericNeg(isEven)(2)) // false
//  println(genericNeg(isLowerCase)('A')) // true
//  println(genericNeg(isLowerCase)('a')) // false
//  println("-----------------------")

  // Currying -- Svolto da solo
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z


  // Task Compose -- Svolto da solo
  def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

  val f: Int => Int = _ - 1
  val g: Int => Int = _ * 2
//  println("TASK COMPOSE")
//  println(compose(f, g)(5)) // 9
//  println(compose(f, g)(0)) // -1
//  println(compose(f, g)(-5)) // -11
//  println("-----------------------")

  def genericCompose[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))

//  val fg: String => String = _ + "a"
//  val gg: String => String = _ * 2
//  println("TASK GENERIC COMPOSE")
//  println(genericCompose(fg, gg)("test")) // testtesta
//  println(genericCompose(fg, gg)("")) // a
//  println(genericCompose(fg, gg)("b")) // bba
//  println("-----------------------")

  // Task 3 -- Svolto da solo
  @tailrec
  def gcd(a: Int, b: Int): Int = b match
    case 0 => a
    case _ => gcd(b, a % b)

//  println("TASK 3")
//  println(gcd(12, 8)) // 4
//  println(gcd(6, 24)) // 6
//  println(gcd(14, 7)) // 7
//  println("-----------------------")

  // Task 4 -- Svolto da solo
  enum Shape:
    case Rectangle(width: Double, height: Double)
    case Circle(radius: Double)
    case Square(side: Double)

  import Shape.*

  def perimeter(shape: Shape): Double = shape match
    case Rectangle(width, height) => 2 * (width + height)
    case Circle(radius) => 2 * Math.PI * radius
    case Square(side) => 4 * side

  def area(shape: Shape): Double = shape match
    case Rectangle(width, height) => width * height
    case Circle(radius) => Math.PI * Math.pow(radius, 2)
    case Square(side) => Math.pow(side, 2)

  def scale(shape: Shape, factor: Double): Shape = shape match
    case Rectangle(width, height) => Rectangle(width * factor, height * factor)
    case Circle(radius) => Circle(radius * factor)
    case Square(side) => Square(side * factor)

//  println("TASK 4")
//  val r = Shape.Rectangle(2, 3)
//  val c = Shape.Circle(3)
//  val s = Shape.Square(2)
//  println(f"Rectangle perimeter: ${perimeter(r)}%.2f") // 10.00
//  println(f"Rectangle area: ${area(r)}%.2f") // 6.00
//  println(f"Rectangle scale: ${scale(r, 2)}") // Rectangle(4.0,6.0)
//  println(f"Circle perimeter: ${perimeter(c)}%.2f") // 18.85
//  println(f"Circle area: ${area(c)}%.2f") // 28.27
//  println(f"Circle scale: ${scale(c, 2)}") // Circle(6.0)
//  println(f"Square perimeter: ${perimeter(s)}%.2f") // 8.00
//  println(f"Square area: ${area(s)}%.2f") // 4.00
//  println(f"Square scale: ${scale(s, 2)}") // Square(4.0)
//  println("-----------------------")



// Task 5
object Optionals:
  /**
   * Optional is a type that represents a value that may or may not be present.
   * Similar to Optional in Java but using the ADT concept.
   * Therefore, an Optional is a sum type with two cases: Maybe and Empty.
   * Maybe contains the value, and Empty represents the absence of a value.
   *
   * @tparam A
   */
  enum Optional[+A]:
    case Maybe(value: A)
    case Empty()

  object Optional:
    /**
     * isEmpty returns true if the optional is Empty, false otherwise.
     * Example:
     *
     * isEmpty(Empty()) == true
     * isEmpty(Maybe(1)) == false
     *
     * @param optional the optional to check
     * @tparam A the type of the optional
     * @return true if the optional is Empty, false otherwise
     */
    def isEmpty[A](optional: Optional[A]): Boolean = optional match
      case Empty() => true
      case _ => false

    /**
     * getOrElse returns the value of the optional if it is Maybe, otherwise it returns the default value.
     * Example:
     * orElse(Maybe(1), 0) == 1
     * orElse(Empty(), 0) == 0
     *
     * @param optional the optional to get the value from
     * @param default the default value to return if the optional is Empty
     * @tparam A the type of the optional
     * @tparam B the type of the default value
     * @return the value of the optional if it is Maybe, otherwise the default value
     */
    def orElse[A, B >: A](optional: Optional[A], default: B): B = optional match
      case Maybe(value) => value
      case Empty() => default

    /**
     * map applies the function f to the value of the optional if it is Maybe, otherwise it returns Empty.
     * Example:
     *
     * map(Maybe(1), (x: Int) => x + 1) == Maybe(2)
     * map(Empty(), (x: Int) => x + 1) == Empty()
     *
     *
     * @param optional the optional to apply the function to
     * @param f the function to apply to the value of the optional
     * @tparam A the type of the optional
     * @tparam B the type of the result of the function
     * @return the result of applying the function to the value of the optional if it is Maybe, otherwise Empty
     */
    def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
      case Maybe(value) => Maybe(f(value))
      case Empty() => Empty()

    /**
     * filter keeps the value (if present, otherwise the output is Empty) only if it satisfies the given predicate.
     *
     * @param optional the optional to filter
     * @param predicate the predicate function
     * @tparam A the type of the optional
     * @return the optional with value if it satisfies the predicate, otherwise Empty
     */
    def filter[A](optional: Optional[A])(predicate: A => Boolean): Optional[A] = optional match
      case Maybe(value) if predicate(value) => Maybe(value)
      case _ => Empty()
