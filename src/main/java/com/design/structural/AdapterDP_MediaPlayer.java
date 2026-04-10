package com.design.structural;

//https://www.tutorialspoint.com/design_pattern/adapter_pattern.htm
interface MediaPlayer {
	public void play(String audioType, String filename);
}

interface AdvancedMediaPlayer {
	void playVLC(String fileName);

	void playMP4(String fileName);
}

class VLCPlayer implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fileName) {
		System.out.println("Play vlc File " + fileName);

	}

	@Override
	public void playMP4(String fileName) {
		// do nothing

	}
}

class MP4Player implements AdvancedMediaPlayer {

	@Override
	public void playVLC(String fileName) {
		// do nothing

	}

	@Override
	public void playMP4(String fileName) {
		System.out.println("Play mp4 fILE :" + fileName);

	}

}

class MediaAdapter implements MediaPlayer {

	AdvancedMediaPlayer advancedMediaPlayer;

	public MediaAdapter(String audioType) {
		if (audioType.equalsIgnoreCase("vlc"))
			advancedMediaPlayer = new VLCPlayer();
		else if (audioType.equalsIgnoreCase("mp4"))
			advancedMediaPlayer = new MP4Player();
	}

	@Override
	public void play(String audioType, String filename) {
		if (audioType.equalsIgnoreCase("vlc"))
			advancedMediaPlayer.playVLC(filename);
		else if (audioType.equalsIgnoreCase("mp4"))
			advancedMediaPlayer.playMP4(filename);

	}
}

class AudioPlayer implements MediaPlayer {
	
	MediaAdapter adapter;

	@Override
	public void play(String audioType, String filename) {
		//support in built function
		if(audioType.equalsIgnoreCase("mp3"))
			System.out.println("Playing MP3 music "+filename);
		else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			adapter=new MediaAdapter(audioType);
			adapter.play(audioType, filename);
		}		
	}
}


public class AdapterDP_MediaPlayer {

	public static void main(String[] args) {
		 AudioPlayer audioPlayer = new AudioPlayer();

	      audioPlayer.play("mp3", "beyond the horizon.mp3");
	      audioPlayer.play("mp4", "alone.mp4");
	      audioPlayer.play("vlc", "far far away.vlc");
	      audioPlayer.play("avi", "mind me.avi");

	}

}
