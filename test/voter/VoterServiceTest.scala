package voter

import org.scalatest.{Matchers, FlatSpec}
import framework.VoterService
import org.scalatest.matchers.ShouldMatchers
import mongo.RogueMongoSpec

/**
 * Created by Daniel on 02/01/2014.
 */
class VoterServiceTest extends RogueMongoSpec with Matchers {
  it should "vote a number for a project name" in {
    VoterService.vote("a", 1)
    VoterService.vote("a", 1)

    val list: List[Int] = VoterService.get("a")

    list should have length 2
    list(0) should equal(1)
  }
}
