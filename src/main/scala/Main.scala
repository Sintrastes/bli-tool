
import Commands._
import Parse._
import Handlers._
import Config._

object Main extends App {

    var configData = getConfigData()
    // println(configData.ipAddress)
    // println(configData.portNumber)

    parseUserInput(args) match {
      case Right(Help) => handleHelp()
      case Right(Configure) => handleConfigure()
      case Right(Disconnect) => handleDisconnect()
      case Right(LogMultiLine) => handleLogMutliLine()
      case Right(Query(query)) => handleQuery(query)
      case Right(QueryOpen(query, isStrict)) => handleQueryOpen(query, isStrict)
      case Right(HelpDetailed(command)) => handleDetailedHelp(command)
      case Right(Set(resc,property)) =>
      case Right(Commit) => handleCommit()
      case Right(UpdateReferences) => handleUpdateReferences()
      case Right(LogSingleLine(content)) => handleLogSingleLine(content)
      case Right(Retrieve(entityId)) => handleRetrieve(entityId)
      case Right(Alias(id1, id2)) => handleAlias(id1, id2)
      case Right(Prolog) => handleProlog()
      case Left(errorMsg) => {
        println(errorMsg)
      }
    }
}
