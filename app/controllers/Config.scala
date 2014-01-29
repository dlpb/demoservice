package controllers

trait Config {
  lazy val applicationController = new Application
  lazy val eventController = new EventController
  lazy val voteController = new EventController
}
