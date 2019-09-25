
//
// Functions for parsing user input, and determiing
// which subcommand should be run.
//

import Commands._

object Parse {
  def parseUserInput(args: Array[String]): Either[String,Command] =
  {
    // First, check to see if this is a detailed help command
    val checkDetailedHelp = if (args.length == 2) {
      args(1).toLowerCase() match {
        case "help" | "-h" | "--help" | "--h" => {
          args(0) match {
            case "help" => Some(HelpDetailed(HelpT))
            case "query" => Some(HelpDetailed(QueryT))
            case "configure" => Some(HelpDetailed(ConfigureT))
            case "disconnect" => Some(HelpDetailed(DisconnectT))
            case "set" => Some(HelpDetailed(SetT))
            case "commit" => Some(HelpDetailed(CommitT))
            case "log" => Some(HelpDetailed(LogT))
            case "retrieve" => Some(HelpDetailed(RetrieveT))
            case "alias" => Some(HelpDetailed(AliasT))
            case "prolog" => Some(HelpDetailed(PrologT))
            case _ => None
          }
        }
        case _ => {
          None
        }
      }
    } else if (args.length == 3) {
      if (((args(2).toLowerCase() == "help")
       || (args(2).toLowerCase() == "-h")
       || (args(2).toLowerCase() == "--help")
       || (args(2).toLowerCase() == "--h"))
       && (args(0).toLowerCase() == "update")
       && (args(1).toLowerCase() == "references") ) {
         // This actually needs to be when the arguments have
         // length 3
           Some(HelpDetailed(UpdateReferencesT))
      } else {
        None
      }
    } else {
      None
    }

    checkDetailedHelp match {
      // If it is a detailed help command, return.
      case Some(x) => Right(x)
      // Otherwise, parse all of the normal subcommands
      case None => {
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
            case "configure" => {
              if (args.length == 1) {
                Right(Configure)
              } else {
                Left("\"bli configure\" should have no arguments.")
              }
            }
            case "disconnect" => {
              if (args.length == 1){
                Right(Disconnect)
              } else {
                Left("\"bli disconnect\" should have no arguments.")
              }
            }
            case "set" => {
              if (args.length == 3) {
                Right(Set(args(1),args(2)))
              } else {
                Left("\"bli set\" should have exactly two arguments.")
              }
            }
            case "commit" => {
              Right(Commit)
            }
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
  }
}
