

import java.util.Scanner;

//to get the date and time  and validate them
public class DateTime {
	static Scanner sc = new Scanner(System.in);
	// patter checker is used to get valid and formatted input from user
	String yearChecker = "[2-9]\\d{3}";
	String monthChecker = "(0[1-9]|1[0-2])";
	String dateChecker = "((1|2)\\d|3(0|1)|0[1-9]|[1-9])";

	String hourChecker = "([0|1]\\d|2[0-4])";
	String minuteChecker = "([0-5]\\d|60)";

	private int year;
	private int month;
	private int date;
	private int hour;
	private int minute;

	// split the taken date and store separately
	public void setDate(String userDate) {
		if (userDate.matches(yearChecker + "\\/" + monthChecker + "\\/" + dateChecker)) {
			String[] dateSeperater = (userDate.split("\\/"));
			year = Integer.parseInt(dateSeperater[0]);
			month = Integer.parseInt(dateSeperater[1]);
			date = Integer.parseInt(dateSeperater[2]);
		} else if (userDate.matches(dateChecker + "\\/" + monthChecker + "\\/" + yearChecker)) {
			String[] dateSeperater = (userDate.split("\\/"));
			year = Integer.parseInt(dateSeperater[2]);
			month = Integer.parseInt(dateSeperater[1]);
			date = Integer.parseInt(dateSeperater[0]);
		} else {
			System.out.println("invalid date,please enter date on \"DD/MM/YYYY\" or \"YYYY/MM/DD\" format ");
			setDate(sc.next());
		}
	}

	// get the time and store separately
	public void setTime(String userTime) {
		if (userTime.matches(hourChecker + "\\:" + minuteChecker)) {
			String[] timeSeperater = (userTime.split("\\:"));
			hour = Integer.parseInt(timeSeperater[0]);
			minute = Integer.parseInt(timeSeperater[1]);

		} else {
			System.out.println("invalid time,please enter time on \"HH:mm\" format ");
			setTime(sc.next());
		}
	}

	// to get the year
	public int getYear() {
		return year;
	}

	// to get the month
	public int getMonth() {
		return month;
	}

	// to get the date
	public int getDate() {
		return date;
	}

	// to get the hour
	public int getHour() {
		return hour;
	}

	// to get the minute
	public int getMinute() {
		return minute;
	}

	// to get the date time in string format
	public String toString() {
		return String.format(" DATE: %d/%d/%d @ TIME: %d:%dH", year, month, date, hour, minute);
	}

}
