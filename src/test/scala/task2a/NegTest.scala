package task2a

import org.junit.Assert.{assertFalse, assertTrue}
import org.junit.Test

class NegTest :

  @Test def testNegative(): Unit = {
    assertFalse(neg(""))
    assertTrue(neg("foo"))
    assertTrue(neg("foo") && !neg(""))
  }
