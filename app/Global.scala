import com.softwaremill.macwire.{Macwire, InstanceLookup}
import controllers.Config
import mongo.RogueMongo
import play.api._

object Global extends GlobalSettings with Macwire {
  val instanceLookup = InstanceLookup(valsByClass(new Config {}))

  override def getControllerInstance[A](controllerClass: Class[A]) =
      instanceLookup.lookupSingleOrThrow(controllerClass)

  override def onStart(app: Application) {
    Logger.info("Application has started")
    RogueMongo.connectToMongo
  }  
  
  override def onStop(app: Application) {
    Logger.info("Application shutdown...")
  }  
    
}