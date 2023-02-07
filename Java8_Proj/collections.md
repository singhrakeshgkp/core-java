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
