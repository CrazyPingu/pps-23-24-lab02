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

  @Test def testGenericNeg(): Unit = {
    val isEven: Int => Boolean = _ % 2 == 0
    val isLowerCase: Char => Boolean = _.isLower

    assertTrue(genericNeg(isEven)(1))
    assertFalse(genericNeg(isEven)(2))
    assertTrue(genericNeg(isLowerCase)('A'))
    assertFalse(genericNeg(isLowerCase)('a'))
  }

  @Test def testCurriedNeg(): Unit = {
    assertTrue(curriedNeg(1)(2)(2))
    assertFalse(curriedNeg(1)(2)(1))
    assertTrue(curriedNeg(3)(4)(4))
    assertTrue(curriedNeg(-3)(4)(4))
    assertFalse(curriedNeg(-3)(4)(-4))
  }

  @Test def testNonCurriedNeg(): Unit = {
    assertTrue(nonCurriedNeg(1,2,2))
    assertFalse(nonCurriedNeg(1,2,1))
    assertTrue(nonCurriedNeg(3,4,4))
    assertTrue(nonCurriedNeg(-3,4,4))
    assertFalse(nonCurriedNeg(-3,4,-4))
  }
