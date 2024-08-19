package com.java.dsa.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass {


  public static void main(String[] args) throws InterruptedException {
    Abc a1 = new Abc();
    a1.setBookingIds("1,2,3,4");
    Abc a2 = new Abc();
    a2.setBookingIds("6,66,66,99");
    List <Abc> list = List.of(a1,a2);
    String ids = list.stream().map(abc->abc.getBookingIds())
        .collect(Collectors.joining(","));
    System.out.println(ids);

  }
}

class  Abc{
  private String bookingIds;

  public String getBookingIds() {
    return bookingIds;
  }

  public void setBookingIds(String bookingIds) {
    this.bookingIds = bookingIds;
  }
}