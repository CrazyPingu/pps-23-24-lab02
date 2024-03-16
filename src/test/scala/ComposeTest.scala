import Exercise.{compose, genericCompose}
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

class ComposeTest {

  @Test def testCompose(): Unit = {
    val f: Int => Int = _ - 1
    val g: Int => Int = _ * 2
    assertEquals(9, compose(f, g)(5))
  }

  @Test def testGenericCompose(): Unit = {
    val f: String => String = _ + "a"
    val g: String => String = _ * 2
    assertEquals("testtesta", genericCompose(f, g)("test"))
  }
}
