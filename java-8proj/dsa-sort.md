- [Sorting](#sorting)
   - [Heap Sort](#heap-sort)
   - [Quick Sort](#quick-sort)
   - [Merge Sort](#merge-sort)
  
# Sorting
## Heap Sort

- refer ```MinHeap.java```
- reference  Coreman book and https://www.youtube.com/watch?v=t0Cq6tVNRBA
- **Min Heap** --> The elements are smaller than its children. Root is the min
- **Max Heap**---> The elements are greater than its children.Root is the max.
- **Operation on Heap**
   - **Insert** --> We fill the elements from left to right, if elements are not in its correct position we will bubble that up until we get to the right spot. Take the inserted element and compare it with its parent, if its not in correct order swap them.
   - **Remove Min Element** ---> If its min heap the root is going to be min element.Remove the min, swap the element with last added, here spot may not be correct so bubble it down to next spot untill u get correct spot.
## Quick Sort
## Merge Sort
- refer coreman 
- Follow divide and conquer approach
- worst case running time is ``` nlogn ```
- best case running time is 
  
```
MergeSort(A,p,r)
1. if(P<r)
2.  q = (p+r)/2 (Floor)
3.  MergeSort(A,p,q)
4.  MergeSort(A,q+1,r)
5.  Merge(A,p,q,r)
```

```
Merge(A,p,q,r)
1. n1 = q-p+1
2. n2 = r-q
3. let L[1....n1+1] and R[1....n2+1] be new array
4. for i=1 to n1
5.   L[i] = A[p+i-1]
6. for j =1 to n2
7.   R[j] = A[q+j]
8. L[n1+1] = infinite
9. R[n2+1] = infinite
10. i=0
11. j=0
12 for k=p to r
13     if L[i]<=R[j]
14.        A[k] = L[i]
15.        i = i+1
16.    else A[k] = R[j]
17         j = j+1
```
