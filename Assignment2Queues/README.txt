Implemented Deque and RandomizedQueue data structures

Deque uses a doubly linked list as it needs to support add/remove operations from both ends of the list

RandomizedQueue uses an array as it must support constant time
deque operations removing a random element. This is done by swapping the random
element with the element at the end of the array. Since items are only obtained through
the random dequeue operation the order of the items in the actual array doesn't matter.

The iterator uses the same deque logic for the next() method but it must work on a copy
of the array so that each iterator is independent. Otherwise, a single iterator could print out
the same item multiple times as another iterator could swap  elements into the sub array the other
iterator is working on.
A simple way of implementing iterator is to use StdRandom.permutation(size) then iterating over the arr in the
order given by the permutation, but I thought that went against the spirit of the assingment and you should
implement the logic without relying on external libraries.

Permutation uses similar logic that was done in the RandomWord file.
k words are added to the rq then the (k+1) word has a (k / (k+1)) chance of being added. Since the
probabilites of the other k are uniform this means all (k+1) words have a uniform chance of being chosen.
This can be proven by induction for any positive integer n and 0 <= k <= n.