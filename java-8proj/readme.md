
# Core Java
# Java 8 Features
<p> Lambda Expression, Functional Interface, Default Method, DateTime, SomeFeature indroduced in concurrency</p>

- [Lambda and Functional interface](/java-8proj/LambdaAndFunctionalInterface.md)
- [Stream API](/java-8proj/streams.md)
- [Method Reference](/java-8proj/method_reference.md)
- [Parallel and Asynchronous programming with Stream and Completable future](/java-8proj/parallel-programming.md)
- [Generics](/java-8proj/generics.md)
- [Optional](#optional)
# Java Date time
# Exception Handling

# Java Collections
- [Collection](/java-8proj/collections.md)
- Collection [Hierarchy](/java-8proj/collections_hierarchy.jpg)
- Concurrent Collections for more details click [here](/java-8proj/concurrent_collections.md) 
- Collections Questions and Answers [Q and A](/java-8proj/collections_QA.md) 
# Pattern Matching by Venkat
- Benfits-> reduce verbosity, reduces if else statement.
- Pattern matching with InstanceOf ```PatternMatcherEx1.java```
- Type Matching
- Null Matching
- Matching with null and type
-Dominance
-Completness
  - with sealed classes
  - what if classes change?
- Guarded Pattern

# Optional
- Its a container, that may or may not contain non-null value
- Its primarily used to avoid nullpointer exception and makes code more readable and intentional when dealing with potentially missing values.
## Use optional (see OptionalEx.java)
- As a method return type (main use case)
- When u need functional style chaining
- When Returning Optional From Repository or Utility Layer
- For Value Retrieval That Is Contextually Optional
## Avoid to use optional
- Never use optional as a member variables in entities, DTO, Models as jpa, jackson and other framework don't handle optional field. its not serializable and adds unnecessary complexity
- For performance critical code -> optional adds a small overhead(extra object wrapping and unwrapping), in tight loop, high frequency call or low level library avoid to use it.
- When value is always expected avoid to use it. ex.  Optional.of("Rakesh").

