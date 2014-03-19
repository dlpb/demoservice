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
class EventController(eventService: EventService) extends Controller{


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
     val json = Json.toJson(eventService.activeProjects)

     Ok(json)
  }

  def allProjects = Action {
    val json = Json.toJson(eventService.get)
    Ok(json)
  }


  val eventForm = Form(
  tuple(
      "name" -> nonEmptyText,
      "desc" -> text,
      "start" -> text,
      "end" -> text,
      "active" -> boolean
    )
  )
  def addProject = Action { implicit request =>
     val x = eventForm.bindFromRequest()
  println(request.body)
  println(x)
    val (name, desc, start, end, active) = x.get

    val formatter = DateTimeFormat.forPattern("dd MM YYYY HH:mm")
    val startTime = formatter.parseDateTime(s"""$start 12:00""").getMillis
    val endTime = formatter.parseDateTime(s"""$end 12:00""").getMillis


    eventService.add(Event(name, desc, startTime, endTime))

    Ok(s"""{"result":"success"}""")
  }
}
