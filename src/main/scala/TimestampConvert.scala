import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.TimeZone
import java.time.{Instant, ZoneId, ZonedDateTime}

object TimestampConvert extends App {

  val iso8601TimestampString = "2023-07-07T01:56:12Z"

  /*val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  val date = format.parse(iso8601TimestampString)

  println(date)

  val timestamp = new Timestamp(date.getTime)
  timestamp.setNanos(0) // Clear nanoseconds

  println(timestamp)*/

  //val instant = Instant.parse(iso8601TimestampString)

  // Convert Instant to java.sql.Timestamp
  val timestamp1: Timestamp = Timestamp.valueOf(Instant.parse(iso8601TimestampString).atZone(ZoneId.of("UTC")).toLocalDateTime)

  println(timestamp1)
}
