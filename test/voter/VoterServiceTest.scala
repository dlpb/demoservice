package voter

import org.scalatest.{Matchers, FlatSpec}
import framework.VoterService
import org.scalatest.matchers.ShouldMatchers
import mongo.RogueMongoSpec

/**
 * Created by Daniel on 02/01/2014.
 */
class VoterServiceTest extends RogueMongoSpec with Matchers {

  val voterService = new VoterService

  it should "vote a number for a project name" in {
    voterService.vote("a", 1)
    voterService.vote("a", 1)

    val list: List[Int] = voterService.get("a")

    list should have length 2
    list(0) should equal(1)
  }
}
