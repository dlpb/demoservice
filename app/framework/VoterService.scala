package framework


import com.foursquare.rogue.LiftRogue._
import com.mongodb.WriteConcern

class VoterService {


  def vote(project: String, vote:Int) = {
    Vote.createRecord.projectname(project).vote(vote).save(WriteConcern.FSYNC_SAFE)
  }

  def get(project: String) : List[Int] = {
    Vote.where(_.projectname eqs project).fetch.map(v => v.vote.get)
  }
}
