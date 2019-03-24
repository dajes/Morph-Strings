# Morph Strings

Given two strings X and Y: 
X contains 0 and 1 characters 
Y contains sequences of A and B characters
Figure 0 can morph into a non-empty sequence of A characters
Number 1 can morph into a non-empty sequence of either A or B characters
Check if string X can morph into string Y.

My solution is of O(n^5) which is more effective than naive approach of O(2^n) in all cases except n in range [1;22]:
We represent sequences of Y string as categorical boxes: either 0 ('A') or 1 ('B'). Also, it is crucial to keep a record about how big these boxes can be - the number of letters in it. Then, we vary box sizes in all possible ways so that altogether they are the same size as string X. And check their identity by a simple rule: if either our box elements correspond to X elements respectively or the X element is '1', then it is possible to morph X into Y. If none of the variety of box sizes satisfies the condition, then it is impossible to morph X into Y.
Project source contains visualisation class, so it is clear what configuration of box sizes it is currently checking, but you can set the "pause" argument to the constructor of MorphString class equals 0, and it will check almost instantly.