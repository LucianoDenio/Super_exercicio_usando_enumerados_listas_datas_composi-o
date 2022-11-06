package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter departement's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter woker data :");
		System.out.print("name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary :");
		double  baseSalary = sc.nextDouble();
		
		Worker worker = new Worker (workerName, WorkerLevel.valueOf(workerLevel), baseSalary,new Department(departmentName));
		
		System.out.print("How many contracts to the worker ? ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Enter contracts #"+i+" data: ");
			System.out.print("Date dd/MM/yyyy : ");
			Date dateContract = sdf.parse(sc.next());
			System.out.print("Value per hour : ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hour) : ");
			int hours = sc.nextInt();
			
			System.out.println();
			
			HourContract contract = new HourContract (dateContract, valuePerHour, hours);
			worker.addContract(contract);
			
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name : " + worker.getName());
		System.out.println("Department : " + worker.getDepartment().getName());
		System.out.print("Income for " + monthAndYear + ":  " + String.format("%.2f",worker.income(year, month)));
		

		sc.close();

	}

}
