### Stream Operations
 - allMatch, anyMatch
 - Close-> you can not use stream if its alredy closed(you will get ``` java.lang.IllegalStateException: stream has already been operated upon or closed ```)
 - dropwhile-> ``` dropWhile removes the elements that do match the predicate , until it finds an element that does not match the                           predicate.     From that point on it lets all elements pass through ```
- FlatMap -> use to deal with Arry[][] or List<List<>>.. etc. As if we convert this kind of list/set in stream it would be stream of stream.
- ForeachOrdered-> maintain the order if used with parallel stream unlike foreach which does not guarantee the order if used with parallet stream.
- 
### Consumer with Stream
### BiConsumer With Stream
### Stream with Predicate Function
 - Predicate with Stream
 - 
