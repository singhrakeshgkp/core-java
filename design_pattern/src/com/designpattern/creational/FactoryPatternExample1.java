package com.designpattern.creational;

public class FactoryPatternExample1 {

	public static void main(String[] args) {

		/*
		 * 1. Notification interface 2. SMS, Email and Push Notification implements
		 * Notifications Interface 3. NotificationFactory- will have creation logic, it
		 * uses NotificationChannel
		 * 
		 * 
		 */
		NotificationFactory notificationFactory = new NotificationFactory();
		Notification notification = notificationFactory.getInstance(NotificationChannel.SMS);
		notification.notify("sms notification");
	}
}

interface Notification {

	public void notify(String msg);
}

class SMSNotification implements Notification {

	@Override
	public void notify(String msg) {
		System.out.println("sending notification[ "+msg+" ] via sms ");

	}
}

class EmailNotificaition implements Notification {

	@Override
	public void notify(String msg) {
		System.out.println("sending notification notification [ "+msg+" ] via email");

	}
}

class PushNotification implements Notification {

	@Override
	public void notify(String msg) {
		System.out.println("sending push notification [  "+msg+" ]");

	}
}

enum NotificationChannel {
	SMS, EMAIL, PUSH
}

class NotificationFactory {
	Notification getInstance(NotificationChannel channel) {
		if (channel == null)
			return null;

		switch (channel) {
		case SMS:
			return new SMSNotification();
		case EMAIL:
			return new EmailNotificaition();
		case PUSH:
			return new PushNotification();
		default:
			throw new IllegalArgumentException("Not a valid channel");
		}

	}
}