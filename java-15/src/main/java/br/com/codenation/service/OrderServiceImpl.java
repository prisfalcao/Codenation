package br.com.codenation.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().mapToDouble(orderItem -> productRepository.findById(orderItem.getProductId())
				.map(product -> product.getIsSale() ? (product.getValue() * 0.8) : product.getValue())
				.orElse(0.0) * orderItem.getQuantity())
				.sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
				.map(id -> productRepository.findById(id))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderItem>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream().mapToDouble(this::calculateOrderValue).sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream().map(aLong -> productRepository.findById(aLong))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.groupingBy(Product::getIsSale));
	}

}