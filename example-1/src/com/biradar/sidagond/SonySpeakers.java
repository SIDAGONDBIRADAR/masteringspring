package com.biradar.sidagond;

public class SonySpeakers implements Speakers {

	@Override
	public void makeSound() {
		System.out.println( "playing audio from Sony speakers");
	}

}
