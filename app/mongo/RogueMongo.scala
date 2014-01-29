package mongo

import net.liftweb.mongodb.{MongoDB, MongoIdentifier}
import com.mongodb.{ServerAddress, Mongo}

/**
 * Created by Daniel on 11/01/2014.
 */

object RogueMongo extends MongoIdentifier {
  override def jndiName = "test"
  val mongoPort = 27017

  private var mongo: Option[Mongo] = None

  def connectToMongo = {
    mongo = Some(new Mongo(new ServerAddress("localhost", mongoPort)))
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