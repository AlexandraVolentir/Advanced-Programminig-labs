Created an object oriented model of the problem. Assumed that there are 10 tiles for each letter in the alphabet and each letter is worth a random number of points (between 1 and 10).
Each player has a name and they must perform in a concurrent manner, extracting repeatedly tokens from the board.
After each extraction, the player will submit to the board all the letters.
Simulated the game using a thread for each player.
Payed attention to the synchronization of the threads when extracting tokens from the bag and when putting words on the board.
Homework (2p)
Used the following number of tiles for each letter: A-9, B-2, C-2, D-4, E-12, F-2, G-3, H-2, I-9, J-1, K-1, L-4, M-2, N-6, O-8, P-2, Q-1, R-6, S-4, T-6, U-4, V-2, W-2, X-1, Y-2, Z-1
Used the following points for the letters:
(1 point)-A, E, I, O, U, L, N, S, T, R
(2 points)-D, G
(3 points)-B, C, M, P
(4 points)-F, H, V, W, Y
(5 points)-K
(8 points)- J, X
(10 points)-Q, Z
Created an implementation of a dictionary, using some collection of words. Use an appropriate collection to represent the dictionary. This collection should be large enough; you may use aspell to generate a text file containing English words, or anything similar: WordNet, dexonline, etc.
Implement the scoring and determine who the winner is at the end of the game.
. This thread will display the running time of the game and it will stop the game if it exceeds a certain time limit.

Bonus (2p+)
The dictionay offers the possibility to search not only for a word, but for words which start with a given prefix (lookup).
Implemented the prefix search (for a classical collection) using a parallel stream.