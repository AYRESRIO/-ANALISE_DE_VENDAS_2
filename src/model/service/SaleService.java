package model.service;

import java.util.List;
import java.util.function.Predicate;

import entities.Sale;

public class SaleService {

	public Double filteredSum(List<Sale> list, Predicate<Sale> criteria) {

		Double sum = 0.00;
		for (Sale p : list) {
			if (criteria.test(p)) {
				sum = sum + p.getTotal();
			}
		}

		return sum;
	}

}
