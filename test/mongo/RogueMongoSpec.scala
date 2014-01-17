package mongo

import org.scalatest.{BeforeAndAfterEach, BeforeAndAfterAll, FlatSpec}
import framework.RogueMongo

trait RogueMongoSpec extends FlatSpec with BeforeAndAfterAll with BeforeAndAfterEach {


  abstract override protected def beforeAll() {
    super.beforeAll()

    RogueMongo.connectToMongo
  }

  override protected def afterAll() {
    super.afterAll()

    RogueMongo.disconnectFromMongo
  }
}
