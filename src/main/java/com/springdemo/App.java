package com.springdemo;

import java.util.Scanner;
import functions.Methods;

public class App {
	public static void main(String[] args) {
		Methods m = new Methods();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome");
		while (true) {
			System.out
					.println("1-Insert \n2-Update \n3-Delete \n4-Get Student By Id \n5-Dispaly All Students \n6-Exit");
			System.out.println("Enter your choice :");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				m.insertStudent();
				break;
			case 2:
				m.updateStudent();
				break;

			case 3:
				m.deleteStudentById();
				break;

			case 4:
				m.deleteStudentById();
				break;

			case 5:
				m.displayAllStudents();
				break;

			case 6:
				System.out.println("Thank you");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
	}

}
