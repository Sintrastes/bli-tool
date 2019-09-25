
//
// An algebraic data type representing the possible
// subcommands that bli can handle.
//

object Commands {

  // A type for the specific sub-procedures that
  // bedelibry can execute. To be passed to the
  // appropriate handling functions.

  sealed trait Command

  case object Help extends Command

  case class HelpDetailed(
    command: CommandType
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

  //
  // A type for all of the different
  // types of command that can be exected. Not parameterized
  // by command line arguments.
  //

  sealed trait CommandType
  case object ConfigureT extends CommandType
  case object DisconnectT extends CommandType
  case object HelpT extends CommandType
  case object QueryT extends CommandType
  case object SetT extends CommandType
  case object CommitT extends CommandType
  case object UpdateReferencesT extends CommandType
  case object LogT extends CommandType
  case object RetrieveT extends CommandType
  case object AliasT extends CommandType
  case object PrologT extends CommandType

}
