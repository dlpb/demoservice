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
class Project extends MongoRecord[Project] with MongoId[Project] { // Bummer: ObjectIdPk not compatible with HasMongoForeignObjectId
  def meta = Project
  object name extends StringField(this, "user")
  object description extends StringField(this, "desc")
  object starttime extends LongField(this)
  object endtime extends LongField(this)
  object owneremail extends StringField(this, "owner")

}
object Project extends Project with MongoMetaRecord[Project] {
  override def collectionName = "projects"

  trait FK[T <: FK[T]] extends MongoRecord[T] {
    self: T =>
    object projectId extends ObjectIdField[T](this) with HasMongoForeignObjectId[Project] {}
  }
}

