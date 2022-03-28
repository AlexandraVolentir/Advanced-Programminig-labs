## Compulsory

Created an object-oriented model of the problem. The items have at least a unique identifier, a title and its location. Used an abstract class in order to describe the items in a catalog.
Implemented the following methods representing commands that will manage the content of the catalog:
add: adds a new entry into the catalog;
toString: a textual representation of the catalog;
save: saves the catalog to an external file using JSON format; you may use Jackson or other library;
load: loads the catalog from an external file.

## Homework

Represented the commands using classes instead of methods. Used an interface for describing the generic command execute.
Implemented the commands InfoCommand, ListCommand, ReportCommand, ViewCommand.
ListCommand prints the list of items on the screen;
ViewCommand: opens an item using the native operating system application (see the Desktop class);
ReportCommand: creates (and opens) an HTML report representing the content of the catalog.
Used a template engine - FreeMarker , in order to create the HTML report.
Also, used Apache Tika in order to extract metadata from your catalog items and implement the command info in order to display them.
The application sgnals invalid date or the commands that are not valid using custom exceptions (InvalidCatalogException, InvalidFileOrURL, NodexistentInformation and etc)
The final form of the application is an executable JAR archive. The jar file was built but having problems executing it from the terminal.
