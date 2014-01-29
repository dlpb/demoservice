package framework

import org.joda.time.DateTime
import com.foursquare.rogue.LiftRogue._
import com.mongodb.WriteConcern

class EventService {


  def add(event: Event) = {
    event.save(WriteConcern.FSYNC_SAFE)
  }

  def get(): List[Event] = {
    Event.findAll
  }

  def get(name: String): List[Event] = {
    Event.where(_.name eqs name).fetch
  }

  def activeProjects(): List[Event] = {
    Event.where(_.starttime gte morning).and(_.endtime lte night).and(_.active eqs true).fetch
  }

  def remove(project: Event) = {
    project.active(false).save(WriteConcern.FSYNC_SAFE)
  }

  def modify(project: Event) = {
    add(project)
  }

  def clear() = Event.bulkDelete_!!!

  def morning = {

    val dt = new DateTime().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0).withMillisOfSecond(0)
    dt.getMillis
  }

  def night = {
    val dt = new DateTime().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59).withMillisOfSecond(999)
    dt.getMillis
  }
}
