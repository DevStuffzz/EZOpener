package com.ezopener;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Corey Beaver
 *
 * EZOpener is a file io library
 * It is used to open pretty much every file
 */
public class Opener {

	/*
	 * -------------- Text Files
	 */

	/**
	 * Loads a file as a string
	 * @param fileLocation location to the file
	 * @return the file contents as a String
	 */
	public static String ezload(String fileLocation) {
		String content = "";

		try {
			Scanner scanner = new Scanner(new File(fileLocation));

			while(scanner.hasNext()) {
				content += scanner.nextLine() + "\n";
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.printf("File '%s' was not found!!\n\n\t", fileLocation);
			e.printStackTrace();
		}
		return content;
	}


	/**
	 * Asks user for a file and reads it in as a string
	 * @return the file contents as a String
	 */
	public static String ezload_userchoice() {

		JFileChooser chooser = new JFileChooser();

		int result = chooser.showOpenDialog(null);

		String fileLocation = "";

		if(result == JFileChooser.APPROVE_OPTION) {
			fileLocation = chooser.getSelectedFile().getAbsolutePath();
		}

		String content = "";

		try {
			Scanner scanner = new Scanner(new File(fileLocation));

			while(scanner.hasNext()) {
				content += scanner.nextLine() + "\n";
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.printf("File '%s' was not found!!\n\n\t", fileLocation);
			e.printStackTrace();
		}
		return content;
	}

	/**
	 * Gets an array of all words in a file
	 * @param fileLocation Location to the file
	 * @return the file contents as a string array
	 */
	public static String[] ezloadWords(String fileLocation) {
		return ezload(fileLocation).split(" ");
	}

	/**
	 * Gets all letters in a file
	 * @param fileLocation Location to the file
	 * @return the file letters
	 */
	public static char[] ezloadLetters(String fileLocation) {
		return ezload(fileLocation).toCharArray();
	}

	/**
	 * Writes a single line to a file
	 * @param location location to the file
	 * @param input Text to write to the file
	 */
	public static void ezWrite(String location, String input) {
		File file = new File(location);
		String old = ezload(location);
		try {
			FileWriter fr = new FileWriter(file);
			fr.write(old);
			fr.write(input);
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Writes a single line to a file. Includes new line statement
	 * @param location location to the file
	 * @param input Text to write to the file
	 */
	public static void ezWriteLn(String location, String input) {
		File file = new File(location);
		String old = ezload(location);
		try {
			FileWriter fr = new FileWriter(file);
			fr.write(old);
			fr.write(input + "\n");
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	/**
	 * Overrwrites a file
	 * @param location Location of the file
	 * @param input text to overwrite
	 */
	public static void ezoverrwrite(String location, String input) {
		File file = new File(location);
		try {
			FileWriter fr = new FileWriter(file);
			fr.write(input + "\n");
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Clears the file
	 * @param location Location to the file to clear
	 */
	public static void ezclear(String location) {
		File file = new File(location);
		try {
			FileWriter fr = new FileWriter(file);
			fr.write(" ");
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Creates a file at a given location
	 * @param location location to the file that you want to create
	 */
	public static void ezcreate(String location) {
		File file = new File(location);
		try {
			boolean result = file.createNewFile();
			if(!result) {
				System.err.println("EZOpener.ezcreate(): File already exists at " + file.getCanonicalPath());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ezcreate(String location, String content) {
		File file = new File(location);
		try {
			boolean result = file.createNewFile();
			if(!result) {
				System.err.println("EZOpener.ezcreate(): File already exists at " + file.getCanonicalPath());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ezWrite(location, content);
	}

	/*
	 * -------------- Images
	 */


	/**
	 * Returns a awt Image from the given String
	 * @param imageLocation Location to the Image
	 * @return
	 */
	public static Image ezloadImage(String imageLocation) {
		return new ImageIcon(imageLocation).getImage();
	}
}
