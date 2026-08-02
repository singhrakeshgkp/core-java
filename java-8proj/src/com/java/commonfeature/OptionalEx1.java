package com.java.commonfeature;

import java.util.Optional;

public class OptionalEx1 {

  /*1. as a method return type*/
  public Optional<String> getName(){
    return Optional.of("rakesh");
  }

  /*2 when you need functional style chaining
  * a) No nested if(obj != null) checks
  * b) Cleaner fluent code
  * */
  public void chaining(){
    UserRepo userRepo = new UserRepo();
    String city = userRepo.findById(123)
        .map(User::getAddress)
        .map(Address::getCity)
        .orElse("unknown");
    System.out.println("User city is :- "+city);

  }

  /*3. When Returning Optional From Repository or Utility Layer*/
  /*4.For Value Retrieval That Is Contextually Optional*/
  public Optional<String> getHeader(String name){

    return  Optional.ofNullable(""); // Optional.ofNullable(request.getHeader(name))
  }

  public static void main(String[] args) {
    OptionalEx1 obj = new OptionalEx1();
    obj.chaining();
  }
}

class User{
private String name;
private Address address;

public User(String name, Address address){
  this.name = name;
  this.address = address;
}
  public String getName() {
    return name;
  }

  public Address getAddress() {
    return address;
  }
}

class Address{
  private String city;
  public Address(String city){
    this.city = city;
  }
  public String getCity() {
    return city;
  }

}

class UserRepo{
  public  Optional<User> findById(int id){
    Address address = new Address("GKP");
    User user = new User("rakesh",address);
   // return Optional.of(user);
    return Optional.empty();
  }
}


