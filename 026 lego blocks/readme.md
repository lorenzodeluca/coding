You have an infinite number of 4 types of lego blocks of sizes given as (depth x height x width):

d	h	w
1	1	1
1	1	2
1	1	3
1	1	4

Using these blocks, you want to make a wall of height
and width

. Features of the wall are:

- The wall should not have any holes in it.
- The wall you build should be one solid structure, so there should not be a straight vertical break across all rows of bricks.
- The bricks must be laid horizontally.

How many ways can the wall be built?

Example


The height is and the width is

. Here are some configurations:

image

These are not all of the valid permutations. There are

valid permutations in all.

Function Description

Complete the legoBlocks function in the editor below.

legoBlocks has the following parameter(s):

    int n: the height of the wall
    int m: the width of the wall

Returns
- int: the number of valid wall formations modulo

Input Format

The first line contains the number of test cases

.

Each of the next
lines contains two space-separated integers and

.

Constraints