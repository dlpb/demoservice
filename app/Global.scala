import mongo.RogueMongo
import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    Logger.info("Application has started")
    RogueMongo.connectToMongo
  }  
  
  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }  
    
}