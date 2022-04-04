## Compulsory

Structured the code in the following classes:

frame.MainFrame - The main frame of the application.
game.ConfigPanel - a configuration panel for introducing parameters regarding the grid size and a button for creating a new game. The panel is placed at the top part of the frame. The panel contains labels and input components.
game.DrawingPanel - a canvas (drawing panel) for drawing the board. Draws the grid lines according to the values specified in the config panel. This panel must be placed in the center part of the frame.
game.ControlPanel - a control panel for managing the game. This panel will contain the buttons: Load, Save, Exit ,etc. and it will be placed at the bottom part of the frame.

## Homework

Created the object-oriented model (which was actually present with the classes from compulsory - MaiFrame, game.ConfigPanel, game.DrawingPanel, game.ControlPanel)
Initialized the game by generating random sticks and placed them on the board. Implemented the direct mode for drawing the game board.
Implemented the logic of the game. When the player executes a mouse pressed operation, a stone is drawn at the mouse location: red or blue depending on whose turn it is. Validated the move, according to the game rules. 
Didn't determine the winner of the game and didn't do the bonus.

Exported the current image of the game board into a PNG file.
Use object serialization in order to save and restore the current status of the game.