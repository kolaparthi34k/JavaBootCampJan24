package com.zeta.core;
class Apple extends Thread {

	public void run()
	{
		System.out.println("Thread started running..."+currentThread().getName());
		try {
			Thread.sleep(3457);
			System.out.println("Thread stopped running..."
			+currentThread().getName()+currentThread().getPriority());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class SampleThread1  {

	public static void main(String... a) {

		try {

			System.out.println("New born is about to create");
			if (a[0].equals("zeta")) {
				Apple ap = new Apple();
				Apple ap1 = new Apple();
				ap.setName("One");
				ap1.setName("Two");
				ap.start();
				ap1.start();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
