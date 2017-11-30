To summarize, you have a few unsorted items to add to a large sorted list. 
This sounds like a job for insertion sort! The situation described is close to that 
for which insertion sort has its best-case O(n) performance. 

But stop to consider the other properties of insertion sort to see 
if there are any problems with this choice. Insertion sort is stable and in-place, 
so no problems there. Worst and aver- age case performance are O(n2) — that could be a problem. 
In this scenario the number of unsorted items is usually small, 
in which case you can expect nearly O(n) performance, but if the factory has
a bad day and a large number of items fail, you may see closer to O(n2). 
Ask the interviewer if an occasional sort that runs long can be tolerated in this environment: 
If so, then insertion sort is your answer; if not, you need to keep looking.

Suppose that worst-case O(n2) is not acceptable. Try thinking of it as two lists: 
a large sorted list and a (usually) small, possibly partially sorted list. 
Sorted lists can be efficiently merged, so you just need to sort the small 
(new serials numbers) list and then merge the two of them. Because you’ll do at least some merging,
 you might choose to sort the small list with a merge sort.
 What’s the worst-case efficiency of this approach? If the length of the old,
sorted list is l and the new, unsorted list is m, then the sort of the new list is O(m log(m)) 
and the merge is O(l + m). Combined, this is O(l + m log(m)). 
This approach does have the drawback that O(l + m) additional memory is needed for the merge.
