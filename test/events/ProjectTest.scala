package events

import org.scalatest._
import Matchers._

import framework.Event
/**
 * Created by Daniel on 01/01/2014.
 */
class ProjectTest extends FlatSpec with ShouldMatchers {
  it should "have a name" in {
    val event: Event = Event("name", "desc", 0, 0)

    event.name.get should equal ("name");
  }
  it should "have a start and an end time" in {
    val event: Event = Event("name", "desc", 0l, 1l)
    event.starttime.get should be(0)
    event.endtime.get should be(1)
  }
  it should "have a description" in {
    val event: Event = Event("name", "desc", 0, 1)
    event.description.get should equal ("desc")
  }
}
