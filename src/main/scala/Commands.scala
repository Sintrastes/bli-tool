
//
// An algebraic data type representing the possible
// subcommands that bli can handle.
//

object Commands {

  sealed trait Command

  case object Help extends Command

  case class HelpDetailed(
    command: Command
  ) extends Command

  case class Query(
    query: String
  ) extends Command

  case class QueryOpen(
    query: String,
    strict: Boolean
  ) extends Command

  case class Set(
     resource: String,
     property: String
  ) extends Command

  case object UpdateReferences extends Command

  case object Commit extends Command

  case object Configure  extends Command

  case object Disconnect extends Command

  case class LogSingleLine(
    entry: String
  ) extends Command

  case object LogMultiLine extends Command

  case class Retrieve(
    id: String
  ) extends Command

  case class Alias(
    id: String,
    new_id: String
  ) extends Command

  case object Prolog extends Command

}
