
import javax.sound.midi.*;

public class soundNote {

	public void play(int instrument, int note){
		
		try {
			
			// Initializing the midi sequencer and opening it up
			
			Sequencer player = MidiSystem.getSequencer(); 
			player.open(); 
			
			// Creating new sequence
			
			Sequence seq = new Sequence(Sequence.PPQ, 4); 
			
			// Creating a track and associating it to the sequence
			
			Track track = seq.createTrack(); 
			
			// setting MidiEvent to null so it won't add to the track
			@SuppressWarnings("unused")
			MidiEvent event = null;
			
			ShortMessage first = new ShortMessage();
			first.setMessage(192, 1, instrument, 0);
			MidiEvent changeInstrument = new MidiEvent(first, 1); 
			track.add(changeInstrument);
			
			// Add the start of the note to the MIDI track
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144, 1, note, 100);
			MidiEvent noteOn = new MidiEvent(a, 1); 
			track.add(noteOn);
			
			// Cut the note off 			
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, note, 100);
			MidiEvent noteOff = new MidiEvent(b, 16); 
			track.add(noteOff);
			
			// Play the track
			
			player.setSequence(seq); 
			player.start();
			
			
			} catch (Exception ex) {ex.printStackTrace();}
		
	}

} 
