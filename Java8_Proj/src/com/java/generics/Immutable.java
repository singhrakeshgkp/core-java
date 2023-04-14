package com.java.generics;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
/*RetentionPolicy.SOURCE-> Thrown away at compile time, it's not gonna be put into bytecode
 *RetentionPolicy.CLASS-> it sits in the bytecode with no reason
 *RetentionPolicy.RUNTIME-> will be available at runtime. if u are using reflection with it it has to be runtime
 *
 * 
 * */
public @interface Immutable {

}
