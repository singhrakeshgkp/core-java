package com.designpattern.creational;

public class AbstractFactoryPatternExample {

	public static void main(String[] args) {
	/*Reference from javatpoint, refer GOF page no 88
	 * 1. Create a Bank Interface
	 * 2. Create concrete class HDFC, SBI, ICICI
	 * 3. Create Loan abstract class
	 * 4. Create concrete class that extends Loan class such as HomeLoan, PersonalLoan etc
	 * 5. Create an abstract class (Abstract Factory) to get the factories for Bank and Loan Class
	 * 6. Create BankFactory and LoandFactory(extending abstract factory class) to get bank and loan obj
	 * 7. Create a factory creator class
	 * */
	Bank bank = FactoryCreator.getFactory("Bank").getBank("HDFC");
	System.out.println(bank.getName());
	Loan loan = FactoryCreator.getFactory("Loan").getLoan("HomeLoan");
	loan.calculateLoanPayment(1222222, 2);
	}
}

interface Bank{
	String getName();
}

class HDFC implements Bank{

	private final String bankName;
	
	public HDFC() {
		bankName = "HDFC Bank";
	}
	@Override
	public String getName() {
		
		return bankName;
	}
	
}

class SBI implements Bank{

	private final String bankName;
	
	public SBI() {
		bankName = "SBI Bank";
	}
	@Override
	public String getName() {
		return bankName;
	}
	
}

abstract class Loan{
	protected double rate;
	abstract void getInterestRate(double rate);
	public void calculateLoanPayment(double loanAmount, int years){
		
		double emi;
		int n;
		n = years*12;
		rate = rate/1200;
		emi=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanAmount;  
		System.out.println("EMI "+emi+" for the amount "+loanAmount);
	}
	
}
class HomeLoan extends Loan{

	@Override
	void getInterestRate(double rate) {

		this.rate = rate;
	}
	
}

class PersonalLoan extends Loan{

	@Override
	void getInterestRate(double rate) {
		this.rate = rate;
		
	}
	
}

abstract class AbstractFactory{
	
	public abstract Bank getBank(String bank);
	public abstract Loan getLoan(String loan);
}

class BankFactory extends AbstractFactory{

	@Override
	public Bank getBank(String bank) {
		if(bank == null)
		return null;
		switch(bank) {
		case "HDFC":
			return new HDFC();
		case "SBI":
			return new SBI();
		default:
			return null;
		
		}
	}

	@Override
	public Loan getLoan(String loan) {
		return null;
	}
	
	
}

class LoanFactory extends AbstractFactory{

	@Override
	public Bank getBank(String bank) {
		return null;
	}

	@Override
	public Loan getLoan(String loan) {
		switch(loan) {
		case "HomeLoan":
			return new HomeLoan();
		case "PersonalLoan":
			return new PersonalLoan();
		default:
			return null;
		}
	}
	
}

class FactoryCreator{
	public static AbstractFactory getFactory(String input) {
		if(input.equalsIgnoreCase("Bank"))
			return new BankFactory();
		else if(input.equalsIgnoreCase("Loan"))
			return new LoanFactory();
	   else 
		return null;
	}
}