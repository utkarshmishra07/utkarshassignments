package Beans;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeApiDemo {

	public static void main(String[] args) {
		
		String anotherDate="04 Mar 2017";
		
		DateTimeFormatter ft=DateTimeFormatter.ofPattern("dd MMM yyyy");
		LocalDate lt=LocalDate.parse(anotherDate,ft);
		System.out.println(lt);

	}

}
