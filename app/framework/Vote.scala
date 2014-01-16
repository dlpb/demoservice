package framework

import net.liftweb.mongodb.record.MongoRecord
import com.foursquare.rogue.LiftRogue._
import net.liftweb.mongodb.record.MongoMetaRecord
import net.liftweb.record.field._
import com.foursquare.rogue.HasMongoForeignObjectId
import net.liftweb.mongodb.record.field.ObjectIdField
import net.liftweb.mongodb.record.MongoId
/**
 * Created by Daniel on 01/01/2014.
 */

class Vote extends MongoRecord[Vote] with MongoId[Vote] { // Bummer: ObjectIdPk not compatible with HasMongoForeignObjectId
  def meta = Vote
  object projectname extends StringField(this, "projectname")
  object vote extends IntField(this)
}
object Vote extends Vote with MongoMetaRecord[Vote] {
  override def collectionName = "votes"

  trait FK[T <: FK[T]] extends MongoRecord[T] {
    self: T =>
    object voteId extends ObjectIdField[T](this) with HasMongoForeignObjectId[Vote] {}
  }
}

