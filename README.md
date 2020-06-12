# SeleniumMinesweeperBot

Selenium based Algorithm that solves Minesweeper puzzles.
currently only based on the basic rules
1) if number of surrounding unmarked fields is equal to known number of mines, all unmarked fields must be flags
2) if the number of surrounding known mines (flags) is equal to the known number of mines, all unmarked surrounding fields are safe
3) guess corners first, then only guess when rule 1)&2) no longer generate progress.

See it in action below:
![](https://i.imgur.com/9SSn86J.gif)

the decision tree of the algorithm:

<img src = "https://i.imgur.com/bsYbUy8.png">
