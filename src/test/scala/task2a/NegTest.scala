package task2a

import org.junit.Assert.{assertFalse, assertTrue}
import org.junit.Test

class NegTest :


  @Test def testNeg(): Unit = {
    val predicateExample: String => Boolean = _ == ""
    assertFalse(neg(predicateExample)(""))
    assertTrue(neg(predicateExample)("foo"))
    assertTrue(neg(predicateExample)("foo") && !neg(predicateExample)(""))
  }
