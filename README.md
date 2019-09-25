
Bli-tool
========

This is a command line interface to the [bedelibry](https://github.com/Chinchillord/Bedellibrary) server, and is generally intended on being a multi-purpose tool to aid in the management of programming and research projects. As such, `bli` has a number of different sub-commands which are documented by running `bli help`, which shows the following help screen:

~~~
bli (version 0.1.0.0)
Maintainer: Nathan Bedell (nbedell@tulane.edu)

  Command line interface to the bedelibry server. 
  For more documentation, see https://github.com/Chinchillord/Bedellibrary.

Usage:
  bli [command] [arguments]
    (Note: command arguments are not case sensitive.)
 
Commands:
  configure:            Walk through an interactive prompt to (re)configure the application
  disconnect:           Disconnect from the currently configured bedelibry server
  help (-h, --help):    Display this help screen
  help [sub_command]    Display more detailed documentation about a subcommand.
  query:                Make a query to the configured bedelibry server    
  query open [options]: Make a query to the configured bedelibry server which   
                        returns an id of a resource, and opens the first result 
                        of the query with the appropriate application. 
      (-s, --strict): Fails if the query returns more than one result 
  set [resource] [property] 
                        Adds metadata to a directory or a file.
  commit                For future git integration. 
  update references     To be run in a tex project directory. Searches through 
                        all of the tex files in the project, and adds any missing
                        references to the local references.bib file, sourced from
                        the local bibtex repository.                             
  log                   Logs an entity (such as a note, journal entry) to the central
                        bedelibry server.
  retrieve              Retrieves the content of a note, journal article, or
                        bibTex reference given its primaryId. 
  alias [id] [new_id]   Creates a new alias for a pre-existing id (does not have to be primary)
  prolog                Runs a bedebliry prolog REPL.
~~~

More detailed documentation for each of these commands is available by running `bli help [sub_command]`.

Installation Instructions
-------------------------

TODO

Todo list
---------

See [todo list](todo.md).