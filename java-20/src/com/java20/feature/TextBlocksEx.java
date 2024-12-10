package com.java20.feature;

public class TextBlocksEx {

  public static void main(String[] args) {

    /*case 1 text before text blocks*/
    /*System.out.println(txtBeforeTxtBlock("java"));*/

    /*case 2 textWithTxtBlocks*/
   /* System.out.println(textWithTextBlocks("java"));*/

    /*case 3 escape not required if double quotes used*/
    /*System.out.println(textWithTextBlocksAndEscape("java"));*/

    /*case 4 autoRemoveSpaces. At the end of second line we have many spaces. But if u observe the output only spaces between the string
    will be replaced with '-' char. spaces at end of the line will be ignored.
     */
   /* System.out.println(autoRemoveSpaces("java").replace(" ","-"));*/

    /*case 5 preserve spaces- to preserve spaces use '\s' char*/
    System.out.println(preserveSpaces("java").replace(" ","-"));
  }

  public static String txtBeforeTxtBlock(String course){
    String msg = "Welcome to the world of "
        +course +" how are u? its gonna"
        +" fun today";
    return  msg;
  }

  public static String textWithTextBlocks(String course){
    String msg = """
        Hello and welcome to the world of
        course,
        how are u doing?
        """;
    return  msg;
  }

  public static String textWithTextBlocksAndEscape(String course){
    String msg = """
        Hello and welcome to the world of
        "java",
        how are u doing?
        """;
    return  msg;
  }

  public static String autoRemoveSpaces(String course){
    String msg = """
        Hello and welcome to the world of
        "java",                         
        how are u doing?
        """;
    return  msg;
  }

  public static String preserveSpaces(String course){
    String msg = """
        Hello and welcome to the world of
        "java",                         \s
        how are u doing?
        """;
    return  msg;
  }
}
