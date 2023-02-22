package com.designpattern.creational;

public class BuilderPatternExample {
	
	public static void main(String[] args) {
		User user = new User.UserBuilder("rakesh","singh")
				        .age(30)
				        .contactNo("8877664345")
				        .build();
		
		System.out.println(user);
	}

}

class User{
	private final String fName;
	private final String lName;
	private final int age;
	private final String contactNo;
	
	private User(UserBuilder builder) {
		
		fName = builder.fName;
		lName = builder.lName;
		age = builder.age;
		contactNo = builder.contactNo;
	}
	
	
	
	public String getlName() {
		return lName;
	}



	public int getAge() {
		return age;
	}



	public String getContactNo() {
		return contactNo;
	}



	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", age=" + age + ", contactNo=" + contactNo + "]";
	}



	public static class UserBuilder{
		private final String fName;
		private final String lName;
		private int age;
		private String contactNo;
		
		public UserBuilder(String fName, String lName) {
			this.fName = fName;
			this.lName = lName;
		}
		
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		
		public UserBuilder contactNo(String contactNo) {
			this.contactNo = contactNo;
			return this;
		}
		
	   public User build() {
		   User user = new User(this);
		   return user;
	   }
	}
	
	
}