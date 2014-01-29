package mongo

import org.scalatest.{BeforeAndAfterEach, BeforeAndAfterAll, FlatSpec}
import scala.collection.JavaConverters._
import com.mongodb.{ServerAddress, Mongo}

trait RogueMongoSpec extends FlatSpec with BeforeAndAfterAll with BeforeAndAfterEach {

  lazy val mongo = new Mongo(new ServerAddress("localhost", RogueMongo.mongoPort))

  abstract override protected def beforeAll() {
    super.beforeAll()

    RogueMongo.connectToMongo
  }

  override protected def afterAll() {
    super.afterAll()

    mongo.getDatabaseNames.asScala foreach mongo.dropDatabase
    RogueMongo.disconnectFromMongo
  }
}
