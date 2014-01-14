package framework

/**
 * Created by Daniel on 02/01/2014.
 */
object VoterService {

  private val votes = scala.collection.mutable.Map[String, List[Int]]()

  def vote(project: String, vote:Int) = {
    val results = get(project)
    votes.put(project, vote :: results)
  }

  def get(project: String) = votes.getOrElse(project, List())
}
