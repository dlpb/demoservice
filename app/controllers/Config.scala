package controllers

import framework.{VoterService, EventService}

trait Config {

  val eventService = new EventService
  val voteService = new VoterService


  lazy val applicationController = new Application
  lazy val eventController = new EventController(eventService)
  lazy val voteController = new VoteController(voteService)
}
