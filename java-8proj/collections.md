# List
- List interface is an ordered collection that allows us to add and remove element just like array.
<details><summary><b>ArrayList</b></summary> 
 
 - We can create resizable array, we can say its kind of dynamic array
</details>

<details><summary><b>LinkedList</b></summary> 
 
 - Provide the functionality of linked list(doubly linked list) data structure.
</details>


<details><summary><b>Vector</b></summary> 
 
 - Vector and Array list provides the same functionality. However, there exists some differences between them. the main difference is that each operation of vector is synchronized.
 
</details>


<details><summary><b>Stack</b></summary> 
 
 - provide the functionality of stack data structure
 - Elements are accessed in LIFO(last in first out) or FILO(first in last out) manner.
 - Method supported
   - Push - used to insert the element in the stack
   - Pop  - Used to remove elements from stack
   - Peek - Return an object from top of the stack. There are othr mehtod supported such as empty, search .. etc

</details>

# Queue

<details><summary><b>Priority Queue</b></summary> 
 
 - Provide the functionality of heap data structure.
 - Unlike normal queue priority queue elements are retrieve in sorted order
 - Lets say u want to retrieve the elements in ascendind order. In this case, the head of the priority queue will be the smallest element. Once this smallest is retrieved, the next smallest element will be head of the queue.
 - Its important to note that elements of a priority queue may not be sorted. However, elements are always retrieve in sorted order.
 - Method/operation supported
   - add() -> Insert the elements to the queue, if the queue is full it throws exception
   - offer() -> Insert the elements to the queue. If the queue is full, it returns false.
   - Peek() -> used to access the elements from priority queue, this mehtod returns the head of the queue.
   - remove()-> remove the specified elemetns from queue
   - poll() -> returns and remove the head of the queue.
</details>

<details><summary><b>De-Queue</b></summary> 
 
 - Does not allow Null key
 - Sorts the elements in ASC order of keys
 - By default sort the elements in asc order for that it uses ```compareTo``` method for comparison.
</details>

# Set
- Used to store unique value.
- <b>Initial Capacity :- </b> capacity is number of buckets (used to store key value pair) in the hash table, and the initial capacity is simply the capacity at the time  Hash table is created.
- <b>Load Factor :- </b> The load factor is a measure of how full the Hash table is allowed to get before its capacity is automatically increased

<details><summary><b>HashSet impl->Set</b></summary> 
 
 - Do not maintain the order
 - Can store null value
 - Take constant time for basic operation such as add, remove, contains or size.
 - Uses shallow technique while cloning.
 - Iterator returned by class are fail fast.
 - Internal Working of HashSet
   - It uses the MashMap internally, when we add any element in HashSet it either return true or false.
   - Since HashSet uses hash map internally, so when we say set.add(value), it internally execute ```map.put(e, PRESENT)==null```  this code.
   - If value is already present in map it will reutrn non null value it turns out set.add return false value(Hash Map put method return old value)
   - similarily when map.put(key,present) return null that results in set.add(value) return true it denotes that value is not present in set.
 - <b>Q. Why HashSet doesn't have get(object o) methods?</b>
 - <b>Ans.</b> It provide contains method to check if element exists or not, get(Object obj) method is useful when we have one object/information linked to other object/information such as key value pair found in hash map. Unlike HashMap, HashSet is all about storing unique value/object
 
</details>

<details><summary><b>LinkedHashSet impl->Set</b></summary> 
 
 - Can store null value
 - Default initial capacity is ```16``` and load factor  ```0.75 f```
 - Maintain the insertion order
 - Internal working of LinkedHashSet
   - It internally uses LinkedHashMap
</details>

<details><summary><b>TreeSet impl->SortedSet->Set</b></summary> 
 
 - Does not allow Null
 - Takes log(n) time for basic operations such as add, remove, contains
 - By default sort the elements in asc order for that it uses ```compareTo``` method for comparison.
</details>


# Map

- <b>Initial Capacity :- </b> capacity is number of buckets (used to store key value pair) in the hash table, and the initial capacity is simply the capacity at the time  Hash table is created.
- <b>Load Factor :- </b> The load factor is a measure of how full the Hash table is allowed to get before its capacity is automatically increased

<details><summary><b>HashMap</b></summary> 
 
 - Do not maintain the order
 - Can store one null key and multiple null value
 - Does not maintain insertion order
 - Internal working of hash map
   - Works on the principle of hashing. To understand hashing first we need to understand ```hash function, bucket and hash value```
   - <b>Hash Function :- </b> hashCode function which returns an integer value is ```Hash Function```
   - <b>Hash Value :- </b> An integer value returned by hash function
   - <b>Bucket :- </b> Bucket can have multiple key value pairs, it simply uses linked list to store the objects.
   - Uses hash value to determine the location where element need to be stored
   - when we use map.get(obj) to get value, it uses the hash key and determine the location and then apply equal method to compare the key.
 - Default load factor is ```0.75f``` and default initial capacity is ```16```
 - Complexity O(1), O(n) or O(log n)
</details>

<details><summary><b>LinkedHashMap</b></summary> 
 
 - Allow one null key and multiple null value
 - Maintain the insertion order.
</details>

<details><summary><b>TreeMap</b></summary> 
 
 - Does not allow Null key
 - Sorts the elements in ASC order of keys
 - By default sort the elements in asc order for that it uses ```compareTo``` method for comparison.
</details>

