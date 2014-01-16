/**
 * Created by Daniel on 11/01/2014.
 */

import framework.RogueMongo
import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {


 RogueMongo.connectToMongo

  }
}
