# Priority Queues
## About the project:
- Implementing in Java the Priority Queue ADT. Assessed Exercise 2 for Algorithms &amp; Data Structure 2 (COMPSCI2007) course in Level 2.
- Consist of 2 parts:
  -   Part 1: Implementing in Java the Priority Queue ADT using 2 different data structures.
  -   Part 2: Using the Priority Queue to implement an algorithm for a practical problem.

## Part 1:
- implement the min-priority Queue ADT for maintaning a collection of elements each with an associated value called "key".
- This ADT supports:
  - INSERT(Q, x): insert the element x into the queue Q. 
  - MIN(Q): returns the element of Q with the smallest key.
  - EXTRACT-MIN (Q): removes and returns the element of Q with the smallest key.


## Part 2:
- Implement an efficient algorithm to solve the following problem:
`
You are given n ropes of different lengths (expressed as integers), and you are asked to connect them to form a single rope with the minimum cost. The cost of connecting two ropes is equal to the sum of their lengths. 
`
- Given a sequence of rope lengths, the expected outputs are a sequence of rope connection operations and the total cost.

## How to use:
To run any of the .java files as an application using:

Command line:
<br />
1.	Navigate to the project directory: `cd <directory>` 
2.	Run the project: `javac <filename> && java <filename>`

<br />

NB: `<filename>` must include `.java`. E.g. `RopeProblem.java`

<br />

## What did I learn from this:
- Using (min) priority queue ADTs and how to implement them in Java.
- Time complexity of algorithms and recursive calls.
- How to run some methods faster in terms of their running time by making other methods do extra work beforehand and store results in extra attributes.

