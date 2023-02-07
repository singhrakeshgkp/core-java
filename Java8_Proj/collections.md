# Set
- Used to store unique value.

<details><summary><b>HashSet impl->Set</b></summary> 
 
 - Do not maintain the order
 - Internal Working of HashSet
   - It uses the MashMap internally, when we add any element in HashSet it either return true or false.
   - Since HashSet uses hash map internally, so when we say set.add(value), it internally execute ```map.put(e, PRESENT)==null```  this code.
   - If value is already present in map it will reutrn non null value it turns out set.add return false value(Hash Map put method return old value)
   - similarily when map.put(key,present) return null that results in set.add(value) return true it denotes that value is not present in set.
 - dsfd
 - sdfdsf
  
</details>

<details><summary><b>LinkedHashSet impl->Set</b></summary> 
</details>

<details><summary><b>TreeSet impl->SortedSet->Set</b></summary> 
</details>
