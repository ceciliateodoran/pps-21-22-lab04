package exercises

import u04lab.code.*

trait Student:
  def name: String
  def year: Int
  def enrolling(courses: Course*): Unit // the student participates to a Course
  def courses: List[String] // names of course the student participates to
  def hasTeacher(teacher: String): Boolean // is the student participating to a course of this teacher?

trait Course:
  def name: String
  def teacher: String

object Student:
  def apply(name: String, year: Int = 2017): Student = StudentImpl(name, year)
  private case class StudentImpl(override val name: String, override val year: Int) extends Student:
    private var coursesList: List[Course] = List.Nil()

    override def enrolling(courses: Course*): Unit = courses.foreach(c => coursesList = List.Cons(c, coursesList))
    override def courses: List[String] = List.map(coursesList)(_.name)
    override def hasTeacher(teacher: String): Boolean = List.contains(List.map(coursesList)(_.teacher), teacher)

object Course:
  def apply(name: String, teacher: String): Course = CourseImpl(name, teacher)
  private case class CourseImpl(override val name: String, override val teacher: String) extends Course