package com.hms.generic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * This method to generate random number from 0 to 500
	 * 
	 * @return int randomnumber
	 */

	public int getRandomNumber() {
		Random random = new Random();
		int data = random.nextInt(500);
		return data;
	}

	/**
	 * This method is used to get System date and time in IST format
	 * 
	 * @return String date
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		String tdate = date.toString();
		return tdate;
	}

	/**
	 * This method is used to get System date in "YYYY-MM-dd" format
	 * 
	 * @return String Date
	 */
	public String getSystemDateWithFormat() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String tdate = format.format(date);
		return tdate;
	}
	/**
	 * This method is used to get System date in "YYYY-MM-dd HH-mm-ss" format
	 * @return String Date
	 */
	public String getSystemDateWithFormatForScreenShot() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String tdate = format.format(date);
		return tdate;
	}
	/**
	 * This method to generate random character from a to z
	 * @return char character
	 */
	public String getRandomAlphabet() {
		Random random = new Random();
		char ch = (char) (65+random.nextInt(26));
		char ch1 = (char) (97+random.nextInt(26));
		char ch2 = (char) (65+random.nextInt(26));
	String s=""+ch+ch1+ch2;
		return s; 
	}


}
