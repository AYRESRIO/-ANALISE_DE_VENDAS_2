package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import entities.Sale;
import model.service.SaleService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Sale> list = new ArrayList<>();
			Set<String> set = new LinkedHashSet<>();

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				list.add(new Sale(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), fields[2],
						Integer.parseInt(fields[3]), Double.parseDouble(fields[4])));

				line = br.readLine();

			}

			String name;

			for (Sale s : list) {

				name = s.getSeller();
				set.add(name);

			}

			Double sum = 0.00;

			System.out.println();

			System.out.println("Total de Vendas por Vendedor: ");

			for (String s : set) {

				SaleService ss = new SaleService();

				sum = ss.filteredSum(list, p -> p.getSeller().equals(s));

				System.out.println(s + " - " + String.format("R$ %.2f ", sum));

			}

		} catch (IOException e) {
			System.out.println("Error:" + e.getMessage());

		}

		sc.close();

	}

}
