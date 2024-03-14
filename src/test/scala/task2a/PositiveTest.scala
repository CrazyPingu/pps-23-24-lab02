package task2a

import org.junit.Assert.assertEquals
import org.junit.Test

class PositiveTest:

  @Test def testPositive(): Unit = {
    assertEquals(Sign.POSITIVE, positive(1))
  }

  @Test def testNegative(): Unit = {
    assertEquals(Sign.NEGATIVE, positive(-1))
  }

  @Test def testZero(): Unit = {
    assertEquals(Sign.POSITIVE, positive(0))
  }

  @Test def consecutiveCalls(): Unit = {
    assertEquals(Sign.POSITIVE, positive(1))
    assertEquals(Sign.NEGATIVE, positive(-1))
    assertEquals(Sign.POSITIVE, positive(0))
  }

