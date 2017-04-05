Run "run.bat" to execute the java file.

Enter number of rows and columns (m,n) in 1st line.
Enter the subsequent m lines with cell matrix as show below:

X X X
O O O
X O X


The function getDirec() returns the element from the array according to the direction key value passed to it.

////////////////////////////////////////////////////////////////
(x-1)(y-1)		(x-1)(y)		(x-1)(y+1)

(x)(y-1)		(x)(y)			(x)(y+1)
	
(x+1)(y-1)		(x+1)(y)		(x+1)(y+1)
///////////////////////////////////////////////////////////////

So each cell checks around its 8 neighbours and calculate number of alive cells.
Based upon this value, changes occur in the present cell.

In order to handle toad pattern I am initially padding with zeros around the matrix.
So rows and columns become m+2 and n+2.

From the given input array, if any 3 consecutive living cells are found in the boundary, 
the boundary in the output array will be updated with a living cell such that the 3 consecutive living cells 
of input array forms as a neighbour to this new living cell formed. Whenever new edge is added in toad pattern,
the boundary values gets updated accordingly.

So the time complexity need not be always O((m+2)(n+2)).
Best case time complexity (when it is not a toad pattern) will be O(mn) and worst case timecomplexity will be O((m+2)(n+2)).
