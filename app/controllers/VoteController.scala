package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import framework.{EventService, VoterService}
import com.google.gson.Gson
import play.api.libs.json.{Json, JsValue, Writes}


class VoteController(voterService: VoterService) extends Controller {


  val voteForm = Form(
    tuple(
      "project" -> nonEmptyText,
      "vote"  -> number
    )
  )

  def registerVote() = Action { implicit request =>
    val (project, vote) = voteForm.bindFromRequest.get
    voterService.vote(project, vote)
    Ok(s"""{"result":"success", "vote":"$vote"}""")
  }

  def getVotes(project: String) = Action {
    val votes = voterService.get(project).map(i => i.toString)

//    val map = scala.collection.mutable.Map[Int, Int]()

//    for(vote <- votes)
//      map(vote) = map.getOrElse(vote, 0) + 1

    val json = Json.toJson(votes)
    println("json is ", json)
    Ok(json)
  }

}
