import Exercise.{Shape, area, perimeter, scale}
import org.junit.jupiter.api.Test
import org.junit.Assert.assertEquals
class ShapeTest :

  @Test def testCircle(): Unit = {
    val circle = Shape.Circle(5)
    assertEquals(78.54, area(circle), 0.01)
    assertEquals(31.42, perimeter(circle), 0.01)
    assertEquals(Shape.Circle(10), scale(circle, 2))
  }

  @Test def testRectangle(): Unit = {
    val rectangle = Shape.Rectangle(5, 10)
    assertEquals(50, area(rectangle), 0.01)
    assertEquals(30, perimeter(rectangle), 0.01)
    assertEquals(Shape.Rectangle(10, 20), scale(rectangle, 2))
  }

  @Test def testSquare(): Unit = {
    val square = Shape.Square(5)
    assertEquals(25, area(square), 0.01)
    assertEquals(20, perimeter(square), 0.01)
    assertEquals(Shape.Square(10), scale(square, 2))
  }
