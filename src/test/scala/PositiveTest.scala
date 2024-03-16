import Exercise.positive
import org.junit.Assert.assertEquals
import org.junit.Test

class PositiveTest:

  @Test def testPositive(): Unit = {
    assertEquals("positive", positive(1))
  }

  @Test def testNegative(): Unit = {
    assertEquals("negative", positive(-1))
  }

  @Test def testZero(): Unit = {
    assertEquals("positive", positive(0))
  }

  @Test def consecutiveCalls(): Unit = {
    assertEquals("positive", positive(1))
    assertEquals("negative", positive(-1))
    assertEquals("positive", positive(0))
  }

