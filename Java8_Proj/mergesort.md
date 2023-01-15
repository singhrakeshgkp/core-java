### Merge Sort

- Follow divide and conquer approach
- worst case running time is nlogn
- best case running time is 
- 
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
