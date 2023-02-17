# Non Concurrent Collection
1. **What is IdentityHashMap?**
2. **What is WeakHashMap?**
3. **What are the methods to make collection thread-safe?**
4. **Explain UnsupportedOperationException?**<br/>
UnsupportedOperationException is an exception whch is thrown on methods that are not supported by actual collection type.
For example, Developer is making a read-only list using “Collections.unmodifiableList(list)” and calling call(), add() or remove() method. It should clearly throw UnsupportedOperationException.<br/>
5. **Explain the difference between Queue and Deque?**
6. **What is the difference between Iterator and Enumeration?**
7. **What is the difference between HashMap and Hashtable?**
8. **What is the difference between Collection and Collections?**
9. **What is the difference between Comparable and Comparator?**
10. **What do you understand by fail-fast?**
11. **How to make Java ArrayList Read-Only?**
12. **Synchronized HashMap vs HashTable?**<br/>
 - <b>HashTable</b>
   - HashTable returns iterator which is fail fast on concurrent modification
   - Synchronization at object level, Every read write operation need to acquire lock
 - <b>SynChronized HashMap</b>
   - Synchronized HashMap returns iterator which is fail safe, do not produce concurrent modification exception when try to updte/add the elements in map
   - Synchronization at object level, Every read write operation need to acquire lock
13. 
14. df
15. fdf
16. f
17. ffd
18. fdf
19. df
20. f
21. f
22. df
23. df
24. f
25. f
26. f
# Concurrent Collections

