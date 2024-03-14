package task2a

import org.junit.Assert.assertEquals
import org.junit.Test

class PositiveTest :

  @Test def testPositive(): Unit = {
    assertEquals(task2a.Sign.POSITIVE, task2a.positive(1))
  }

  @Test def testNegative(): Unit = {
    assertEquals(task2a.Sign.NEGATIVE, task2a.positive(-1))
  }

  @Test def testZero(): Unit = {
    assertEquals(task2a.Sign.POSITIVE, task2a.positive(0))
  }

  @Test def consecutiveCalls(): Unit = {
    assertEquals(task2a.Sign.POSITIVE, task2a.positive(1))
    assertEquals(task2a.Sign.NEGATIVE, task2a.positive(-1))
    assertEquals(task2a.Sign.POSITIVE, task2a.positive(0))
  }

