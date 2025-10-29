# Java 20 Table of contents
- [Some Good Feature of Java So far](#some-good-feature-of-java-so-far)
   - [Switch Expression](#switch-expression)
   - [Text Blocks](#text-blocks)
   - [Records](#Records)
   - [Sealed classes and Interface](#sealed-classes-and-interface)
   - [Pattern Matching](#pattern-matching)
  
## Some Good Feature of Java So far

### Switch Expression
- Unitil java 7 only integers could be used in switch case and this had been the standards for long time. for more see ```java7SwitchEx()``` method
- In java 8 Strings and Enums were introduced in case values. From here switch statement started to evolve
- Switch Expression
   - Automated break :- we do not specify break statement because here we are dealing with expression not statement. In previous version if we forget to specify break statement, the code flows in the next case and we get the wrong result.
   - Multicase
   - Multiline
- ```SwitchExpression.java``` 

### Text Blocks
- ```TextBlocksEx.java```

### Records
- Records are immutable we can not modify it once created
- ToString, equal, hashcode, getter and constructor gets created automatically, no need to create explicitly.
- Can not extend as Record is the implicit base calss
- Its final implicitly so no ofther classess can extend it.
- Records can also be created in method, this type of record are know as local record
- ```RecordExample.java```

### Sealed Classes and Interface
- If we want to restrict interface not to be implemented by any of the classess except permitted classes
- If class implementing sealed interface is in same file then these calsses will be permitted by default. if not then need to specify permit keyword.
- Implementing class should be in the same package/module
- ```SealedInterfaceEx.java```, ```SealedClassEx.java```

### Pattern Matching
- Pattern matching with instance of operator
- Pattern matchin with switch
- ```PatternMatching.java```
