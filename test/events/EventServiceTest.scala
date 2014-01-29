package events

import org.scalatest._
import framework.{EventService, Event}
import mongo.RogueMongoSpec


/**
 * Created by Daniel on 01/01/2014.
 */
class EventServiceTest extends RogueMongoSpec with ShouldMatchers with BeforeAndAfterEach {

  val eventService = new EventService
  override def beforeEach() {
    eventService.clear
  }

  val DummyStartTime: Long = 0
  val DummyEndTime: Long = 0

  it should "be able to give me a list of events" in {
    val eventList: List[Event] = eventService.get
    eventList should have length 0
  }
  it should "accpet a new project and add it to the list" in {
    val event = Event("name", "desc", 0, 1)
    eventService.add(event)
    val list = eventService.get
    list should have length 1
  }
  it should "return events only for today" in {
    val event1 = Event("name", "desc", 0, 0)
    val event2 = Event("name", "desc", eventService.morning, eventService.night)

    eventService.add(event1)
    eventService.add(event2)

    val list = eventService.activeProjects

    list should have length 1
  }
  it should "modify an existing project" in {
    val event1 = Event("a", "desc", 0, 0)
    val event2 = Event("b", "desc", eventService.morning, eventService.night)

    eventService.add(event1)
    eventService.add(event2)

    eventService.modify(Event("a", "desc2", 0, 0))

    eventService.get("a")
  }



  it should "remove a project" in {
    val event1 = Event("a", "desc", eventService.morning, eventService.night)
    val event2 = Event("b", "desc", eventService.morning, eventService.night)

    eventService.add(event1)
    eventService.add(event2)


    eventService.remove(event1)

    val list = eventService.activeProjects
    list should have length 1

  }
}
