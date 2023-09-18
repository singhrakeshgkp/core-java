package com.java.concurrent.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) {
		List<Hotel> hotels = new ArrayList<>();
		CountDownLatch latch = new CountDownLatch(2);
		WorkerThread workerTask1 = new WorkerThread(latch, 3,hotels);
		WorkerThread workerTask2 = new WorkerThread(latch, 5,hotels);
		Thread t1 = new Thread(workerTask1);
		Thread t2 = new Thread(workerTask2);
		t1.start();
		t2.start();
	    
		try {
			latch.await();
			System.out.println("task completed");
			System.out.println("No Of hotels present in the list are "+hotels.size());
			hotels.forEach(hotel->System.out.println(hotel.getHotelName()));
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}


class WorkerThread implements Runnable{

	private CountDownLatch latch;
	private int noofHotels;
	private List<Hotel> hotels;
	
	public WorkerThread(CountDownLatch latch, int noOfHotel, List<Hotel> hotels) {
		this.latch = latch;
		this.noofHotels = noOfHotel;
		this.hotels = hotels;
	}
	@Override
	public void run() {
		
		try {

			for(int i=0; i<noofHotels; i++) {
				Random random = new Random();
				Hotel hotel = new Hotel(random.nextInt(), random.nextInt()+" hotel");
				synchronized (hotels) {
				
					hotels.add(hotel);
				}
			}
			latch.countDown();
			
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}

class Hotel{
	
	private int id;
	private String hotelName;
	
	
	public Hotel(int id, String hotelName) {
		super();
		this.id = id;
		this.hotelName = hotelName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	
}
