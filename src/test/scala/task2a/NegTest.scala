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
    assertTrue(p1(1)(2)(2))
    assertFalse(p1(1)(2)(1))
    assertTrue(p1(3)(4)(4))
    assertTrue(p1(-3)(4)(4))
    assertFalse(p1(-3)(4)(-4))
  }

  @Test def testCurriedDefNeg(): Unit = {
    assertTrue(p3(1)(2)(2))
    assertFalse(p3(1)(2)(1))
    assertTrue(p3(3)(4)(4))
    assertTrue(p3(-3)(4)(4))
    assertFalse(p3(-3)(4)(-4))
  }

  @Test def testNonCurriedValNeg(): Unit = {
    assertTrue(p2(1,2,2))
    assertFalse(p2(1,2,1))
    assertTrue(p2(3,4,4))
    assertTrue(p2(-3,4,4))
    assertFalse(p2(-3,4,-4))
  }

  @Test def testNonCurriedDefNeg(): Unit = {
    assertTrue(p4(1,2,2))
    assertFalse(p4(1,2,1))
    assertTrue(p4(3,4,4))
    assertTrue(p4(-3,4,4))
    assertFalse(p4(-3,4,-4))
  }
