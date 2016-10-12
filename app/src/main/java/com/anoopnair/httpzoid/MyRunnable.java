package com.anoopnair.httpzoid;


public class MyRunnable implements Runnable ,Comparable<MyRunnable>{

	enumPriority priority;
	public MyRunnable(enumPriority priority){
		this.priority = priority;
	}
	@Override
	public void run() {
		
	}
	@Override
	public int compareTo(MyRunnable another) {
		return another.priority.ordinal() - this.priority.ordinal();
	}
}
