
//
// Functions for parsing user input, and determiing
// which subcommand should be run.
//

import Commands._

object Parse {
  // Note: None of this currently deals with "help detailed"
  def parseUserInput(args: Array[String]): Either[String,Command] =
  {
    // First, check to see if this is a detailed help command

    // Otherwise, parse all of the normal subcommands
    if (args.length != 0) {
      args(0).toLowerCase match
      {
        case "help" => Right(Help)
        case "--help" => Right(Help)
        case "-h" => Right(Help)
        case "query" => {
          // Check to see if this is a detailed help command

          // Parse syntax for a regular query
          if (args.length == 2) {
            Right(Query(args(1)))
          } else if (args.length == 3) {
            if (args(1).toLowerCase() == "open") {
              // Note: The logic is wrong here. I need to fix this.
              val isStrict = true
              Right(QueryOpen(args(2), isStrict))
            } else {
              Left("Unrecognized subcommand of \"bli query\". Did you mean \"bli query open\"?")
            }
          } else {
            Left("Invalid number of arguments.")
          }
        }
        case "configure" => {
          if (args.length == 1) {
            Right(Configure)
          } else if ((args.length == 2) && (args(1).toLowerCase() == "help")) {
            Right(HelpDetailed(Configure))
          } else {
            Left("Invalid number of arguments")
          }
        }
        case "disconnect" => {
          // Note: I don't think the error messages here are exactly accurate
          if (args.length == 1){
            Right(Disconnect)
          } else {
            if ((args.length == 2) && (args(1).toLowerCase() == "help")) {
              Right(HelpDetailed(Disconnect))
            } else {
              Left("Invalid number of arguments")
            }
          }
        }
        case "set" => {
          if (args.length == 3) {
            Right(Set(args(1),args(2)))
          } else if (args.length == 2 && args(1).toLowerCase() == "help") {
            Right(HelpDetailed(Set("","")))
          } else {
            Left("\"bli set\" should have exactly two arguments.")
          }
        }
        case "commit" => {
          // Note: I want to fix the logic of this command before
          // I write the logic for handling it's commandline
          // arguents
          Right(Commit)
        }
        case "update" => {
          // Parse detailed help command

          // Parse regular update command
          if (args.length >= 2 && args(1).toLowerCase() == "references") {
            Right(UpdateReferences)
          } else {
            Left("\"bli update\" is an invalid command. Did you mean \"bli update references\"?")
          }
        }
        case "log" => {
          // Parse detailed help command

          // Parse regular log command
          if (args.length == 2){
            Right(LogSingleLine(args(1)))
          } else if (args.length == 1) {
            Right(LogMultiLine)
          } else {
            Left("\"bli log\" should be run with zero or one arguments.")
          }
        }
        case "retrieve" => {
          // Parse detailed help command

          // Parse regular retireve command
          if (args.length == 2){
            Right(Retrieve(args(1)))
          } else {
            Left("\"bli retrieve\" should have exactly one argument")
          }
        }
        case "alias" => {
          if (args.length == 3){
            Right(Alias(args(1),args(2)))
          } else {
            Left("\"bli alias\" should have exactly two arguments.")
          }
        }
        case "prolog" => {
          if (args.length == 1){
            Right(Prolog)
          } else {
            Left("\"bli prolog\"")
          }
        }
        case _ => {
          Left("Invalid subcommand. Run \"bli help\" for proper argument format.")
        }
      }
    } else {
      // if length(arguments) == 0
      Left("No arguments provided. Run \"bli help\" for proper argument format.")
    }
  }
}
