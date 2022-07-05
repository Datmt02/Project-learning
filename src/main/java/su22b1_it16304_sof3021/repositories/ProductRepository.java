package su22b1_it16304_sof3021.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import su22b1_it16304_sof3021.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query("SELECT pro FROM Product pro WHERE category_id LIKE %:id% ")
	public List<Product> findProductByCate_id(@Param("id") Integer id);
}
