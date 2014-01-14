package controllers

import play.api.mvc._
import framework.{Project, ProjectService}
import com.google.gson.Gson
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json._
import org.joda.time.format.DateTimeFormat

/**
 * Created by Daniel on 30/12/2013.
 */
object ProjectController extends Controller{

    implicit val projectWrites = new Writes[Project] {
      def writes(c: Project): JsValue = {
        Json.obj(
          "name" -> c.name,
          "desc" -> c.description,
          "start" -> c.startTime,
          "end" -> c.endTime

        )
      }
    }

  def getCurrentProjects = Action {
     val json = Json.toJson(ProjectService.activeProjects)

     Ok(json)
  }

  def allProjects = Action {
   // val json = new Gson().toJson(ProjectService.get.toList)

    
    val json = Json.toJson(ProjectService.get)

    Ok(json)
  }


  val projectForm = Form(
  tuple(
      "name" -> nonEmptyText,
      "desc" -> text,
      "dateStart" -> text,
      "timeStart" -> text,
      "dateEnd" -> text,
      "timeEnd" -> text
    )
  )
  def addProject = Action { implicit request =>
     val x = projectForm.bindFromRequest()
    val (name, desc, dateStart, timeStart, dateEnd, timeEnd) = x.get

    val formatter = DateTimeFormat.forPattern("dd/mm/yyyyHH:mm:ss")
    val startTime = formatter.parseDateTime(s"""$dateStart$timeStart""")
    val endTime = formatter.parseDateTime(s"""$dateEnd$timeEnd""")


    ProjectService.add(Project(name, desc, startTime.getMillis, endTime.getMillis))

    println(ProjectService.get)
    Ok(s"""{"result":"success"}""")
  }
}
