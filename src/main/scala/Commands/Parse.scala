
//
// Functions for parsing user input, and determiing
// which subcommand should be run.
//

import Commands._

object Parse {
  // Note: None of this currently deals with "help detailed"
  def parseUserInput(args: Array[String]): Either[String,Command] =
  {
    if (args.length != 0) {
      args(0).toLowerCase match
      {
        case "help" => Right(Help)
        case "--help" => Right(Help)
        case "-h" => Right(Help)
        case "query" => {
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
        case "configure" => Right(Configure)
        case "disconnect" => Right(Disconnect)
        case "set" => {
          if (args.length == 3) {
            Right(Set(args(1),args(2)))
          } else {
            Left("\"bli set\" should have exactly two arguments.")
          }
        }
        case "commit" => Right(Commit)
        case "update" => {
          if (args.length >= 2 && args(1).toLowerCase() == "references") {
            Right(UpdateReferences)
          } else {
            Left("\"bli update\" is an invalid command. Did you mean \"bli update references\"?")
          }
        }
        case "log" => {
          if (args.length == 2){
            Right(LogSingleLine(args(1)))
          } else if (args.length == 1) {
            Right(LogMultiLine)
          } else {
            Left("\"bli log\" should be run with zero or one arguments.")
          }
        }
        case "retrieve" => {
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
