package framework

/**
 * Created by Daniel on 01/01/2014.
 */
import java.util.Date
import org.joda.time.DateTime
import com.foursquare.rogue.LiftRogue._
import com.mongodb.WriteConcern

object ProjectService {


  def add(project: Project) = {
    project.save(WriteConcern.FSYNC_SAFE)
    println(project)
  }

  def get: List[Project] = {
   Project.findAll
  }

  def get(name: String): List[Project] = {
    Project.where(_.name eqs name).fetch
  }

  def activeProjects: List[Project] = {
    println("morn ", morning)
    println("night", night)
    get foreach { x => println("start", x.starttime.get, new Date(x.starttime.get)); println("end  ", x.endtime.get)}
    val x = Project.where(_.starttime gte morning).and(_.endtime lte night).fetch
    println(x)
    x
  }

  def remove(project: Project) = {
    project.delete_!
  }

  def modify(project: Project) = {
    add(project)
  }

  def clear() = Project.bulkDelete_!!!

  def morning = {

    val dt = new DateTime().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0)
    dt.getMillis
  }

  def night = {
    val dt = new DateTime().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59)
    dt.getMillis
  }
}
