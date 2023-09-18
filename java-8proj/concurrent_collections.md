# ConcurrentHashMap(CHM)
- Synchronization is at segment level
- Lock is obtained for write operation at segment level
- Default concurrency level is 16, we can modify it as per our need
- Multiple thread can modify the CHM, hence the performance is much better.
- Concurrent hash map doesn't lock the entire collection while performing modification. So it may not provide accurate information about its size using size operation.
- <b>Put vs putIfAbsent</b>
  - if a key is not associated with a value, we can us ethe following code to put the value
    ```
    if(!map.contains(key)){
     return map.put(key,new Obj());
    }else{
     return map.get(key);
    }
    ```
  - if multiple threads access above code, it won't work as expected (race condition may occurs)
  - for this CHM provides ```putIfAbsent``` method to associate a key with value.
- <b>Put vs replace</b>
  - To replace the value we normaly write the code as given below.
    ```
      if (map.containsKey(key)) {
       return map.put(key, value);
     } 
     
    ```
  - In case of muti-threaded environment this above code can lead to race condition. For this CHM provides a method ```replace(key,value)``` to update existing key

# CopyOnWritearrayList
- Thread safe variant of ArrayList.
- 
