package com.biradar.sidagond;

public class SpeakerFactory {

	public Speakers getSpeakerFactory(String speakerName) {
		if (speakerName == null) {
			return null;
		}
		if (speakerName.equalsIgnoreCase("SONY"))
			return new SonySpeakers();
		else if (speakerName.equalsIgnoreCase("Bose"))
			return new BoseSpeaker();
		else
			return null;

	}

}
