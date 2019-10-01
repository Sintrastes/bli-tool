
//
// Functions to handle each of the respective subcommands
// of bli.
//

import Commands._
import sys.process._

object Handlers {

  def handleConfigure() =
  {

  }

  def handleDisconnect() =
  {

  }

  def handleHelp() =
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
     println("  configure:            Walk through an interactive prompt to (re)configure the application")
     println("  disconnect:           Disconnect from the currently configured bedelibry server")
     println("  help (-h, --help):    Display this help screen")
     println("  help [sub_command]    Display more detailed documentation about a subcommand.")
     println("  query:                Make a query to the configured bedelibry server    ")
     println("  query open [options]: Make a query to the configured bedelibry server which   ")
     println("                        returns an id of a resource, and opens the first result ")
     println("                        of the query with the appropriate application. ")
     println("      (-s, --strict): Fails if the query returns more than one result ")
     println("  set [resource] [property] ")
     println("                        Adds metadata to a directory or a file.")
     println("  commit                For future git integration. ")
     println("  update references     To be run in a tex project directory. Searches through ")
     println("                        all of the tex files in the project, and adds any missing")
     println("                        references to the local references.bib file, sourced from")
     println("                        the local bibtex repository.                             ")
     println("  log                   Logs an entity (such as a note, journal entry) to the central")
     println("                        bedelibry server.")
     println("  retrieve              Retrieves the content of a note, journal article, or")
     println("                        bibTex reference given its primaryId. ")
     println("  alias [id] [new_id]   Creates a new alias for a pre-existing id (does not have to be primary)")
     println("  prolog                Runs a bedebliry prolog REPL.")
  }

  def handleDetailedHelp(command: CommandType) =
  {
    command match {
      case HelpT => {
        println("\"bli help\" detailed usage:")
        println("  help (-h, --help):    Display this help screen")
        println("  help [sub_command]    Display more detailed documentation about a subcommand.")
      }
      case QueryT => {
        println("\"bli query\" detailed usage:")
      }
      case UpdateReferencesT => {
        println("\"bli update references\" detailed usage:")
      }
      case CommitT => {
        println("\"bli commit\" detailed usage:")
      }
      case ConfigureT => {
        println("\"bli configure\" detailed usage:")
      }
      case DisconnectT => {
        println("\"bli disconnect\" detailed usage:")
      }
      case LogT => {
        println("\"bli log\" detailed usage:")
      }
      case RetrieveT => {
        println("\"bli retrieve\" detailed usage:")
      }
      case AliasT => {
        println("\"bli alias\" detailed usage:")
      }
      case SetT => {
        println("\"bli set\" detailed usage:")
      }
      case PrologT => {
        println("\"bli prolog\" detailed usage:")
      }
    }
  }

  def handleQuery(query: String) =
  {
    println("Handling a query request.")
  }

  def handleQueryOpen(query: String, isStrict: Boolean) =
  {
    println("Handling a query open request.")
  }

  def handleSet(resc: String, property: String) =
  {
    // Note: In general, this should really take
    // a list of properties
  }

  def handleCommit() =
  {
    // Note: Currently this is just an alias for {
    // two git commands, but I plan on adding more
    // features later

    // Also, this should take in a command line argument,
    // rather than having a fixed commit message.
    "git add -A" ! ;
    // I have no clue why this doesn't work.
    "git commit -m \"Commit from bedelibry!\"" !
  }

  def handleUpdateReferences() =
  {

  }

  def handleLogSingleLine(content: String) =
  {

  }

  def handleLogMutliLine() =
  {

  }

  def handleRetrieve(id: String) =
  {

  }

  def handleAlias(id1: String, id2: String) =
  {

  }

  def handleProlog() =
  {
    try {
       Seq("bli-prolog").!<
    } catch {
      case e: Exception => {
        println("Error opening bli-prolog executable:")
        println("  " + e.toString())
      }
    }
  }

}
