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
class Event extends MongoRecord[Event] with ObjectIdPk[Event] {
  def meta = Event
  object name extends StringField(this, Int.MaxValue)
  object description extends StringField(this, Int.MaxValue)
  object starttime extends LongField(this)
  object endtime extends LongField(this)
  object active extends BooleanField(this)
  object owneremail extends StringField(this, Int.MaxValue)

}
object Event extends Event with MongoMetaRecord[Event] {
  override def collectionName = "events"

  def apply(name: String, desc: String, start: Long, end: Long) = {
    Event.createRecord.name(name).description(desc).starttime(start).endtime(end).active(true)
  }

}

