package com.corejava.java25;
import module java.base;
import module java.net.http;
import module java.sql;
import java.sql.Date;
/*
*
* command to list down modules :- java --list-modules
* Ambiguity :- Here Date is present in java.base and java.sql both module to resolve ambiguity we have used import specific date class
* */
public class ModuleImport {
  HttpClient httpClient = null;
  Date date = null;
}
