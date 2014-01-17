package framework

import net.liftweb.mongodb.record.MongoRecord
import com.foursquare.rogue.LiftRogue._
import net.liftweb.mongodb.record.MongoMetaRecord
import net.liftweb.record.field._
import com.foursquare.rogue.HasMongoForeignObjectId
import net.liftweb.mongodb.record.field.{ObjectIdPk, ObjectIdField}
import net.liftweb.mongodb.record.MongoId
/**
 * Created by Daniel on 01/01/2014.
 */
class Project extends MongoRecord[Project] with ObjectIdPk[Project] {
  def meta = Project
  object name extends StringField(this, Int.MaxValue)
  object description extends StringField(this, Int.MaxValue)
  object starttime extends LongField(this)
  object endtime extends LongField(this)
  object owneremail extends StringField(this, Int.MaxValue)

}
object Project extends Project with MongoMetaRecord[Project] {
  override def collectionName = "projects"

  def apply(name: String, desc: String, start: Long, end: Long) = {
    Project.createRecord.name(name).description(desc).starttime(start).endtime(end)
  }

  override def toString: String = {
     "[" + name.get + ", " + description.get + ", start= " + new java.util.Date(starttime.get) + ", end "+ new java.util.Date(endtime.get) + "]"
  }
}

