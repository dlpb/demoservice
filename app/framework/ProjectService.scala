package framework

/**
 * Created by Daniel on 01/01/2014.
 */
import com.google.gson.Gson
import java.io.{File, PrintWriter, FileReader}
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.{Calendar, Date}
import org.joda.time.DateTime

object ProjectService {

  val projects = scala.collection.mutable.Map[String, Project]()

  def add(project: Project) = {
    projects(project.name) = project
  }

  def get: List[Project] = {
   projects.values.toList
  }

  def get(name: String) = {
    projects get name getOrElse(Project("NO_PROJECT","NO_PROJECT",0,0))
  }

  def activeProjects: List[Project] = {
    println("projects", projects)
    println("morning", morning)
    println("night", night)
    projects.values.toList filter(p => {
      println("date", new Date(p.startTime))
       p.startTime >= morning && p.endTime <= night
    })
      // projects.values.tList

  }

  def remove(project: Project) = {
    projects remove project.name
  }

  def modify(project: Project) = {
    add(project)
  }

  def clear() = projects.clear()

  def morning = {

    val dt = new DateTime().withHourOfDay(0).withMinuteOfHour(0).withSecondOfMinute(0)
    dt.getMillis
  }

  def night = {
    val dt = new DateTime().withHourOfDay(23).withMinuteOfHour(59).withSecondOfMinute(59)
    dt.getMillis
  }
}
