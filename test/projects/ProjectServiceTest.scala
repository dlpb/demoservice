package projects

import org.scalatest._
import framework.{ProjectService, Project}
import mongo.RogueMongoSpec


/**
 * Created by Daniel on 01/01/2014.
 */
class ProjectServiceTest extends RogueMongoSpec with ShouldMatchers with BeforeAndAfterEach {

  override def beforeEach() {
    ProjectService.clear
  }

  val DummyStartTime: Long = 0
  val DummyEndTime: Long = 0

  it should "be able to give me a list of projects" in {
    val projectList: List[Project] = ProjectService.get
    projectList should have length 0
  }
  it should "accpet a new project and add it to the list" in {
    val project = Project("name", "desc", 0, 1)
    ProjectService.add(project)
    val list = ProjectService.get
    list should have length 1
  }
  it should "return projects only for today" in {
    val project1 = Project("name", "desc", 0, 0)
    val project2 = Project("name", "desc", ProjectService.morning, ProjectService.night)

    ProjectService.add(project1)
    ProjectService.add(project2)

    val list = ProjectService.activeProjects

    list should have length 1
  }
  it should "modify an existing project" in {
    val project1 = Project("a", "desc", 0, 0)
    val project2 = Project("b", "desc", ProjectService.morning, ProjectService.night)

    ProjectService.add(project1)
    ProjectService.add(project2)

    ProjectService.modify(Project("a", "desc2", 0, 0))

    ProjectService.get("a")
  }



  it should "remove a project" in {
    val project1 = Project("a", "desc", ProjectService.morning, ProjectService.night)
    val project2 = Project("b", "desc", ProjectService.morning, ProjectService.night)

    ProjectService.add(project1)
    ProjectService.add(project2)


    ProjectService.remove(project1)

    val list = ProjectService.activeProjects
    list should have length 1

  }
}
