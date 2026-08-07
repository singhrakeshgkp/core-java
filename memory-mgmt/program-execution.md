- [Programs](#programs)
  - [Program-1](#program-1)


# Programs
## Program 1

```
 class Test{
  main(){
      fun1();
     }
  p.s.v fun1(){
    int i = 123;
    fun2();
    }
  p.s.v fun2(){
   Employee e = new Employee();
   fun3();
  }
 p.s.v fun3(){
  double j = 4.4
 }
 }
```

1. As soon as main method execution start jvm create a thread stack.
   ```
    2 fun1
    1 main() ---> main method gets stored in stack first
   ```
