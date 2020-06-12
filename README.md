# SeleniumMinesweeperBot

Selenium based Algorithm that solves Minesweeper puzzles.
currently only based on the basic rules
1) if number of surrounding unmarked fields is equal to known number of mines, all unmarked fields must be flags
2) if the number of surrounding known mines (flags) is equal to the known number of mines, all unmarked surrounding fields are safe
3) guess corners first, then only guess when rule 1)&2) no longer generate progress (as seen in gif wher stalemate occurs with final 2x2).

to improve calculation time, some other concepts are introduced:
1) if a fields surrounding is found out (either by flag or safe reveal) it added to a blacklist and not tested again
2) the program crawls through the puzzle in small chunks unless it gets stuck
3) if a flag is revealed, surrounding fields are checked for new information. If information was gathered, this process continues.

See it in action below:
![](https://i.imgur.com/9SSn86J.gif)

the decision tree of the algorithm:

<img src = "https://i.imgur.com/bsYbUy8.png">

ultimately most of the algorithm takes place in the rightmost column, as the program "crawls" through the puzzle. When it hits a dead end, it returns to completing a full scan. When this scan returns fruitless, another guess is placed. Not pictured is a "Blacklist" of fields which are not tested for flags or safe reveals, as they have been succesfully tested beforehand (to improve computational speed).

## Authors
* **[Korbinian Ring](https://github.com/KMRRingQA)**
