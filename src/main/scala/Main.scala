
sealed trait Command
case object Help       extends Command
case object Query      extends Command
case object Configure  extends Command
case object Disconnect extends Command
case object QueryOpen  extends Command

object Main extends App {
  
  def printHelpScreen() =
  {
     println("bli (version 0.1.0.0)")
     println("Maintainer: Nathan Bedell (nbedell@tulane.edu)")
     println("")
     println("  Command line interface to the bedelibry server. ")
     println("  For more documentation, see https://github.com/Chinchillord/Bedellibrary.")
     println("")
     println("Usage:")
     println("  bli [command] [arguments]")
     println("    (Note: command arguments are not case sensitive.)")
     println(" ")
     println("Commands:")
     println("  configure:         Walk through an interactive prompt to (re)configure the application")
     println("  disconnect:        Disconnect from the currently configured bedelibry server")
     println("  help (-h, --help): Display this help screen")
     println("  query:             Make a query to the configured bedelibry server    ")
     println("  query open:        Make a query to the configured bedelibry server    ")
     println("    [options]:                                                          ") 
     println("        (-s, --strict): Fails if the query returns more than one result ") 
     println("                                                                        ")          
  }

  def handleQueryOpenRequest() =
  {
    println("Handling a query open request.")
  }
  
  def handleQueryRequest() =
  {
    println("Handling a query request.")
  }

  def tryDisconnectServer() =
  {

  }

  if (args.length != 0) {
    // Note: rather than matching here on args(0), we could instead match on a case class representing 
    // the possible behaviors for the application. That way e.x. we can have more flexibility in how the app is run
    // (e.x. such as case sensitivity)
    args(0) match {
      case "help"  => {
         printHelpScreen()
         }
      case "query" => {
         if (args.length >= 2) {
             // make a query request to the Bedelibry server
             // (check first to make sure this is a "query open"
             }
         }
      case "configure" => {
          // run a configuration prompt
          // Note: If the user has not already configured the bli executable, then
          // if they try to run any of the other commands, it should prompt them to run this first
          }
      case "disconnect" => {
            tryDisconnectServer()
         }
    }
  }
}