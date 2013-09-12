
public class program{
	
	public static void main (String[] args){
		
		soundNote mySounds = new soundNote();
		
		//  Just playing a couple of notes.  After programming this I am quickly realizing why people
		//  prefer to use wav handling rather than midi generation...
		
		mySounds.play(40,68);
		mySounds.play(40,72);
		mySounds.play(40,75);
		
	}

}
