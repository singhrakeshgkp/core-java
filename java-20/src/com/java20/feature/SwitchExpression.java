package com.java20.feature;

public class SwitchExpression {

  /*1. Earlier switch was statement now its expression
     a) Automatic breaks;
     b) multiple match
     c) multiline cases
  * */
  public static void main(String[] args) {

    SwitchExpression switchExp = new SwitchExpression();
    /*Case 1. java7Switch() example*/
   /*switchExp.java7Switch(1);
    switchExp.java7Switch(2);
    switchExp.java7Switch(3);
    switchExp.java7Switch(4);*/

    /*Case 2. java8Switch() example witch String*/
    /*switchExp.java8SwitchWithString("one");
    switchExp.java8SwitchWithString("two");
    switchExp.java8SwitchWithString("three");
    switchExp.java8SwitchWithString("four");*/

    /*Case 3. java8Switch() example with enum*/
    /*Months month = Months.Jan;
    switchExp.java8SwitchWithEnum(month);*/

    /*Case 4.Automatic Break From here switch turns in exp rather than statement*/
   /* System.out.println(automaticBreakEx(1));
    System.out.println(automaticBreakEx(2));
    System.out.println(automaticBreakEx(3));*/

    /*Case 5.Multimatch */
    /*System.out.println(multiMatch(1));
    System.out.println(multiMatch(2));
    System.out.println(multiMatch(3));
    System.out.println(multiMatch(4));*/

    /*Case 5.Multiline */
    System.out.println(multiLineSwitch(1));
    System.out.println(multiLineSwitch(2));
    System.out.println(multiLineSwitch(3));
    System.out.println(multiLineSwitch(4));
  }

  public void java7Switch(int num) {
    switch (num) {
      case 1:
        System.out.println("one");
        break;
      case 2:
        System.out.println("two");
        break;
      default:
        System.out.println("default");
    }
  }

  public void java8SwitchWithString(String str) {
    switch (str) {
      case "one":
        System.out.println("one");
        break;
      case "two":
        System.out.println("two");
        break;
      default:
        System.out.println("default");
        break;
    }
  }

  public void java8SwitchWithEnum(Months month) {
    switch (month) {
      case Jan:
        System.out.println("Jan");
        break;
      case Feb:
        System.out.println("Feb");
        break;
      default:
        System.out.println("default");
        break;
    }
  }

  public static String automaticBreakEx(int input) {
    // here we used return with switch because its expression not statement
    return switch (input) {
      case 1 -> "one";
      case 2 -> "two";
      default -> "default";
    };
  }

  public static String multiMatch(int input) {
    // here we used return with switch because its expression not statement
    return switch (input) {
      case 1 -> "one";
      case 2, 3 -> "two or three";
      default -> "default";
    };
  }

  public static String multiLineSwitch(int input) {
    // here we used return with switch because its expression not statement
    return switch (input) {
      case 1 -> "one";
      case 2, 3 -> "two or three";
      case 4 ->{
        yield "four";
      }default -> "default";
    };
  }
}

enum Months {
  Jan, Feb, Mar;
}