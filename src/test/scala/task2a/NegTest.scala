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

  @Test def testCurriedValNeg(): Unit = {
    assertTrue(curriedValNeg(1)(2)(2))
    assertFalse(curriedValNeg(1)(2)(1))
    assertTrue(curriedValNeg(3)(4)(4))
    assertTrue(curriedValNeg(-3)(4)(4))
    assertFalse(curriedValNeg(-3)(4)(-4))
  }

  @Test def testCurriedDefNeg(): Unit = {
    assertTrue(curriedDefNeg(1)(2)(2))
    assertFalse(curriedDefNeg(1)(2)(1))
    assertTrue(curriedDefNeg(3)(4)(4))
    assertTrue(curriedDefNeg(-3)(4)(4))
    assertFalse(curriedDefNeg(-3)(4)(-4))
  }

  @Test def testNonCurriedValNeg(): Unit = {
    assertTrue(nonCurriedValNeg(1,2,2))
    assertFalse(nonCurriedValNeg(1,2,1))
    assertTrue(nonCurriedValNeg(3,4,4))
    assertTrue(nonCurriedValNeg(-3,4,4))
    assertFalse(nonCurriedValNeg(-3,4,-4))
  }

  @Test def testNonCurriedDefNeg(): Unit = {
    assertTrue(nonCurriedDefNeg(1,2,2))
    assertFalse(nonCurriedDefNeg(1,2,1))
    assertTrue(nonCurriedDefNeg(3,4,4))
    assertTrue(nonCurriedDefNeg(-3,4,4))
    assertFalse(nonCurriedDefNeg(-3,4,-4))
  }
