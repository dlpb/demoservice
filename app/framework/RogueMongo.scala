package framework

import net.liftweb.mongodb.{MongoDB, MongoIdentifier}
import com.mongodb.{ServerAddress, Mongo}

/**
 * Created by Daniel on 11/01/2014.
 */

object RogueMongo extends MongoIdentifier {
  override def jndiName = "test"

  private var mongo: Option[Mongo] = None

  def connectToMongo = {
    val MongoPort = 27017
    mongo = Some(new Mongo(new ServerAddress("localhost", MongoPort)))
    MongoDB.defineDb(RogueMongo, mongo.get, "voter")
  }

  def disconnectFromMongo = {
    mongo.foreach(_.close)
    MongoDB.close
    mongo = None
  }

  def connection = {
    MongoDB.getDb(RogueMongo).get
  }
}