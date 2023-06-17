import java.util.*;
import java.io.*;
import javax.sound.sampled.*;
public class Test {
	
	static AudioInputStream[] mapSongs = new AudioInputStream[4];
	static ArrayList<Clip> soundEffects = new ArrayList<Clip>();
	static ArrayList<String> soundEffectNames = new ArrayList<String>();
	static  Clip settingMusic;
	static  Clip soundEffect;
	static int lastPlayedSoundEffect = 7;

	public static void main(String[] args) {
		try {
			mapSongs[0] = AudioSystem.getAudioInputStream(new File("assets/music/Title.wav"));
			mapSongs[1] = AudioSystem.getAudioInputStream(new File("assets/music/WHITESPACE2.wav"));
			mapSongs[2] = AudioSystem.getAudioInputStream(new File("assets/music/ForestChillin.wav"));
			mapSongs[3] = AudioSystem.getAudioInputStream(new File("assets/music/BLACKSPACE.wav"));
			soundEffectNames.add("scare1");
			soundEffectNames.add("scare2");
			soundEffectNames.add("getItem");
			soundEffectNames.add("heal");
			soundEffectNames.add("selectOption");
			soundEffectNames.add("unlockDoor");
			soundEffectNames.add("lockedDoor");
			soundEffectNames.add("interact");
			for (int i = 0; i < 8; i++) {
				soundEffects.add(AudioSystem.getClip());
				soundEffects.get(i).open(AudioSystem.getAudioInputStream(new File("assets/sounds/" + soundEffectNames.get(i) + ".wav")));
			}

		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (n != -1) {
			System.out.println("Play any sound effect 0-7");
			n = sc.nextInt();
			try {
				playSoundEffect(n);
			} catch (LineUnavailableException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	public static void playSettingMusic(int menuState) throws LineUnavailableException, IOException {
	    if (settingMusic != null && settingMusic.isRunning()) {
	        settingMusic.stop();
	        settingMusic.close();
	    }

	    settingMusic = AudioSystem.getClip();
	    settingMusic.open(mapSongs[menuState]);
	    settingMusic.start();
	    settingMusic.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public static void playSoundEffect(int n) throws LineUnavailableException, IOException {

		System.out.println("BLAH3");
		
	    Clip cur = soundEffects.get(n);
	    cur.setFramePosition(0);
	    cur.start();
	}

}