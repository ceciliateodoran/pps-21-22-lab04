import exercises.{Course, Student}
import org.junit.Assert.{assertEquals, assertFalse, assertTrue}
import org.junit.Test
import u04lab.code.List.*

class StudentTest {
  private val cPPS = Course("PPS", "Viroli")
  private val cPCD = Course("PCD", "Ricci")
  private val cSDR = Course("SDR", "D'Angelo")
  private val s1 = Student("mario", 2015)
  private val s2 = Student("gino", 2016)
  private val s3 = Student("rino") // defaults to 2017

  @Test
  def testEnrolling() =
    assertEquals(Nil(), s1.courses)
    s1.enrolling(cPPS)
    s1.enrolling(cPCD)
    assertEquals(Cons("PCD",Cons("PPS",Nil())), s1.courses)

  @Test
  def testCourses() =
    s2.enrolling(cPPS)
    s3.enrolling(cPPS)
    s3.enrolling(cPCD)
    s3.enrolling(cSDR)
    assertEquals(Cons("PPS",Nil()), s2.courses)
    assertEquals(Cons("SDR",Cons("PCD",Cons("PPS",Nil()))), s3.courses)

  @Test
  def testHasTeacher() =
    s1.enrolling(cPPS)
    s1.enrolling(cPCD)
    assertTrue(s1.hasTeacher("Viroli"))
    assertTrue(s1.hasTeacher("Ricci"))
    assertFalse(s1.hasTeacher("D'Angelo"))
}
