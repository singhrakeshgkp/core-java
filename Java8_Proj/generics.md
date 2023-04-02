# Generics

### Creating Generics Method and classess
- GenericMethodExample1- Generic Method syntax <T> List<T> convertArryToList(T[] array)(<T> - generic type, List<T> -> Return type)
- GenericMethodExample12- 
  - GenericMethodExample12.1 -> UpperBound :- A method accepts a type and all its subclasses (example <? extends Number>).
  - GenericMethodExample12.2 -> Lower Bound:- A method accepts a type and all its superclasses. ```public static void validateTillStringType(Collection<? super String> collection) ```


# Generics By Venkat
- Generics Basic ```GenericsBVSEx1.java```
- Creating generic method ```GenericsBVSEx2.java```
- Placing constraints on generic type parameters ```GenericsBVSEx3.java```
- Liskov substitution in Generics(definition- User of a base class should be able to use object of derived class without knowing the difference) 
  - Derived extends from base ```GenericsBVSEx4.java```. Derived is covariant of base
  - Generics of derived doesn't extend from generic of base. Generic of derived is not covariant of generic of base
- Using Wildcards ```GenericsBVSEx5.java```
- Generics and type erasures ```GenericsBVSEx6.java```
- Effect of type erasures and related gotchas
  - Parameterized type can not be primitive
  - You can not instantiate parameterized type ```GenericsBVSEx7.java```
  - Multiple Parameterized interfaces restrictions. you can not have a class like below, as repeating interface is not allowed after type erasure it will become callable callable
    ```
     class Test implements Callable<Integer>, Callable<String>
    ```
  - Still can result in runtime exception ```GenericsBVSEx8.java```
    - backward compatibility 
    - unboxing
  - Mixed with autoboxing, can get confusing
  - static fields are not what we may think they are
  - use caution with equality
- Converting from non-generic to Generics

