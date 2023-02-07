
1. What is IdentityHashMap?
2. What is WeakHashMap?
3. What are the methods to make collection thread-safe?
4. Explain UnsupportedOperationException?
UnsupportedOperationException is an exception whch is thrown on methods that are not supported by actual collection type.
For example, Developer is making a read-only list using “Collections.unmodifiableList(list)” and calling call(), add() or remove() method. It should clearly throw UnsupportedOperationException.<br/>
5. 
