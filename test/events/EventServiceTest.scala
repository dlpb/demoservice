package events

import org.scalatest._
import framework.{EventService, Event}
import mongo.RogueMongoSpec


/**
 * Created by Daniel on 01/01/2014.
 */
class EventServiceTest extends RogueMongoSpec with ShouldMatchers with BeforeAndAfterEach {

  override def beforeEach() {
    EventService.clear
  }

  val DummyStartTime: Long = 0
  val DummyEndTime: Long = 0

  it should "be able to give me a list of events" in {
    val eventList: List[Event] = EventService.get
    eventList should have length 0
  }
  it should "accpet a new project and add it to the list" in {
    val event = Event("name", "desc", 0, 1)
    EventService.add(event)
    val list = EventService.get
    list should have length 1
  }
  it should "return events only for today" in {
    val event1 = Event("name", "desc", 0, 0)
    val event2 = Event("name", "desc", EventService.morning, EventService.night)

    EventService.add(event1)
    EventService.add(event2)

    val list = EventService.activeProjects

    list should have length 1
  }
  it should "modify an existing project" in {
    val event1 = Event("a", "desc", 0, 0)
    val event2 = Event("b", "desc", EventService.morning, EventService.night)

    EventService.add(event1)
    EventService.add(event2)

    EventService.modify(Event("a", "desc2", 0, 0))

    EventService.get("a")
  }



  it should "remove a project" in {
    val event1 = Event("a", "desc", EventService.morning, EventService.night)
    val event2 = Event("b", "desc", EventService.morning, EventService.night)

    EventService.add(event1)
    EventService.add(event2)


    EventService.remove(event1)

    val list = EventService.activeProjects
    list should have length 1

  }
}
