package controllers

import play.api.mvc._
import framework.{Event, EventService}
import com.google.gson.Gson
import play.api.data.Form
import play.api.data.Forms._
import play.api.libs.json._
import org.joda.time.format.DateTimeFormat

/**
 * Created by Daniel on 30/12/2013.
 */
class EventController extends Controller{

    implicit val eventWrites = new Writes[Event] {
      def writes(e: Event): JsValue = {
        Json.obj(
          "name" -> e.name.get,
          "desc" -> e.description.get,
          "start" -> e.starttime.get,
          "end" -> e.endtime.get

        )
      }
    }

  def getCurrentProjects = Action {
     val json = Json.toJson(EventService.activeProjects)

     Ok(json)
  }

  def allProjects = Action {
    val json = Json.toJson(EventService.get)
    Ok(json)
  }


  val eventForm = Form(
  tuple(
      "name" -> nonEmptyText,
      "desc" -> text,
      "dateStart" -> text,
      "timeStart" -> text,
      "dateEnd" -> text,
      "timeEnd" -> text,
      "active" -> boolean
    )
  )
  def addProject = Action { implicit request =>
     val x = eventForm.bindFromRequest()
    val (name, desc, dateStart, timeStart, dateEnd, timeEnd, active) = x.get

    val formatter = DateTimeFormat.forPattern("dd/mm/yyyyHH:mm:ss")
    val startTime = formatter.parseDateTime(s"""$dateStart$timeStart""").getMillis
    val endTime = formatter.parseDateTime(s"""$dateEnd$timeEnd""").getMillis


    EventService.add(Event(name, desc, startTime, endTime))

    println(EventService.get)
    Ok(s"""{"result":"success"}""")
  }
}
