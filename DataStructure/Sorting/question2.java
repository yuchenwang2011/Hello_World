The situation here is like the final stage of a merge sort. 
After the recursive calls have already sorted the sublists. 
All that’s left to do is merge the lists. This is only O(n)

But it also requires O(n) auxiliary temporary space
 (in addition to the space required for storing the records in memory) 
while performing the merge.

If the interviewer told you that memory on the server is tight 
and it’s not acceptable to use O(n) auxiliary space during the sort, 
then you have to go back to quick sort, but O(n log(n)) is not that much worse than O(n).

The sublists are already sorted, so at each point in the merge 
you just need the next item from each sublist. Obviously you still need storage 
for all n account records, but if you merge the sublists as you receive them, 
you no longer have a requirement for an additional size n buffer.
 (You probably need a small constant-size buffer for each of the servers sending information, 
so if there are m departmental servers, additional memory required is O(m); 
presumably m is much smaller than n.) This is an example of an online algorithm: 
an algorithm that processes data as it becomes available, 
rather than requiring all data to be available before starting processing.

The online approach has limitations, too. 
It requires the merge to be integrated with the commu- nications with the departmental servers, 
increasing complexity and decreasing modularity. 
Also, if one of the departmental servers has problems during the process and stops sending data, 
it stalls the entire operation. 
