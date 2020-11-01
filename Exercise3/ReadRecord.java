
/** 
 
 * 01/11/2020
 * Completed by: Sanyam/Neha
 */

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadRecord {

	private ObjectInputStream input;
	static final long serialVersionUID = 42L;

	/**
	 * opens an ObjectInputStream using a FileInputStream
	 */

	private void readObjectsFromFile(String name) {
		MusicRecord record;

		try {
			input = new ObjectInputStream(new FileInputStream(name));
		} catch (IOException ioException) {
			ioException.printStackTrace();
			System.err.println("Error opening file.");
		}

		/*
		 * The following loop is supposed to use readObject method of ObjectInputSteam
		 * to read a MusicRecord object from a binary file that contains several
		 * records. Loop should terminate when an EOFException is thrown.
		 */

		try {
			while (true) {
				record = (MusicRecord) input.readObject();
				System.out.println(record.getYear() + "\n" + record.getSongName() + "\n" + record.getSingerName() + "\n"
						+ record.getPurchasePrice());
				System.out.println("--------------------");
				// TO BE COMPLETED BY THE STUDENTS

			} // END OF WHILE
		} catch (EOFException e) {
			System.err.println("File has ended");
		} catch (IOException ioException) {
			ioException.printStackTrace();
			
			System.err.println("Error opening file");
		}
		// ADD NECESSARY catch CLAUSES HERE
		catch (ClassNotFoundException e) {
			System.err.println("Class not found exception is thrown");
		}

		try {
			if (input != null) {
				input.close();
			}

		} catch (IOException ioException) {
			System.err.println("Error while closing file");
			System.exit(1);
		}

	} // END OF METHOD

	public static void main(String[] args) {
		ReadRecord d = new ReadRecord();
		d.readObjectsFromFile("allSongs.ser");
	}
}