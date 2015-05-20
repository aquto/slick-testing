
object Program {

  import slick.backend.StaticDatabaseConfig
  import slick.backend.DatabaseConfig
  import slick.driver.JdbcProfile
  import slick.driver.MySQLDriver.api._
  import scala.concurrent.Future
  import scala.concurrent.duration._
  import scala.language.postfixOps

  type CountryCols = (Int, String, String)

  type RewardCols = (String, String, Int, java.sql.Timestamp, java.sql.Timestamp, java.sql.Timestamp, Boolean)

  @StaticDatabaseConfig("file:src/main/resources/application.conf#tsql")
  def getCountries: DBIO[Seq[CountryCols]] = {
    tsql"select * from Country"
  }

  @StaticDatabaseConfig("file:src/main/resources/application.conf#tsql")
  def getCountry(id: Int): DBIO[Seq[CountryCols]] = {
    tsql"select * from Country where id = $id"
  }


  @StaticDatabaseConfig("file:src/main/resources/application.conf#tsql")
  def getRewards: DBIO[Seq[RewardCols]] = {
    tsql"select * from Reward"
  }

  def await[A](f: Future[A]): A = {
    scala.concurrent.Await.result(f, 5 seconds)
  }

  @StaticDatabaseConfig("file:src/main/resources/application.conf#tsql")
  def main(args: Array[String]): Unit = {
    val dc = DatabaseConfig.forAnnotation[JdbcProfile]

    val db = dc.db

    val rows  = await(db.run(getRewards))
    val rows2 = await(db.run(getCountries))
    val rows3 = await(db.run(getCountry(1)))

    println("rewards")
    println(rows)

    println("countries")
    println(rows2)

    println("country")
    println(rows3)

  }
}
