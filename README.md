# Mountain_Climbing
A dynamic programming solution to an extra credit problem in CS311 Introduction to Algorithms.

Reads an input file where:
first line is the number of test cases (0-10).
for every test case, 
- next line is the dimensions of an array NxM
- next N lines are M inputs of the array

The main function mountainClimbing() will output the max value that can be achieved by starting at the top left of each array and "scaling" down to the bottom right.
Requires a dynamic programming approach since there are many possible scalings and a brute force approach would take too long.
