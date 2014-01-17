package projects

import org.scalatest._
import Matchers._

import framework.Project
/**
 * Created by Daniel on 01/01/2014.
 */
class ProjectTest extends FlatSpec with ShouldMatchers {
  it should "have a name" in {
    val project: Project = Project("name", "desc", 0, 0)

    project.name.get should equal ("name");
  }
  it should "have a start and an end time" in {
    val project: Project = Project("name", "desc", 0l, 1l)
    project.starttime.get should be(0)
    project.endtime.get should be(1)
  }
  it should "have a description" in {
    val project: Project = Project("name", "desc", 0, 1)
    project.description.get should equal ("desc")
  }
}
