import exercises.Complex
import exercises.Complex.*
import org.junit.Assert.{assertEquals, assertTrue}
import org.junit.Test

class ComplexTest {
  private val a = Array(Complex(10, 20), Complex(1, 1), Complex(7, 0))
  private val b = Complex(1, 1)

  @Test
  def testSum() =
    val c = a(0) + a(1) + a(2)
    assertEquals(18.0, c.re, 0.1)
    assertEquals(21.0, c.im, 0.1)

  @Test
  def testProduct() =
    val c = a(0) * a(1)
    assertEquals(-10.0, c.re, 0.1)
    assertEquals(30.0, c.im, 0.1)

  @Test
  def testEquals() =
    val c = Complex(1, 1)
    assertEquals(b, c)
    assertTrue(b == c)
    assertTrue(b.equals(c))

  @Test
  def testToString() =
    assertEquals("ComplexImpl(10.0,20.0)", a(0).toString)
    assertEquals("ComplexImpl(1.0,1.0)", b.toString)
}