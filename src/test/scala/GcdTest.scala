import Exercise.gcd
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

class GcdTest:

  @Test def testGcd(): Unit = {
    assertEquals(0, gcd(0, 0))
    assertEquals(1, gcd(0, 1))
    assertEquals(1, gcd(1, 0))
    assertEquals(2, gcd(2, 2))
    assertEquals(1, gcd(3, 2))
    assertEquals(2, gcd(4, 2))
    assertEquals(2, gcd(2, 4))
    assertEquals(4, gcd(12, 8))
    assertEquals(6, gcd(6, 12))
    assertEquals(7, gcd(14, 7))
  }

