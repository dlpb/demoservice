package voter

import org.scalatest.FlatSpec
import framework.VoterService
import org.scalatest.matchers.ShouldMatchers

/**
 * Created by Daniel on 02/01/2014.
 */
class VoterServiceTest extends FlatSpec with ShouldMatchers{
  it should "vote a number for a project name" in {
    VoterService.vote("a", 1)
    VoterService.vote("a", 1)

    val list: List[Int] = VoterService.get("a")

    list should have length 2
    list(0) should equal(1)
  }
}
