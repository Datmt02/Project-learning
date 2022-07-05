package su22b1_it16304_sof3021.beans;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import su22b1_it16304_sof3021.entities.Order;
import su22b1_it16304_sof3021.entities.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailModel {
	
	@NotNull(message="Không được để trống order")
	private Order order;
	@NotNull(message="Không được để trống Product")
	private Product product;
	@NotNull(message="Không được để trống Price")
	@Min(value=1000,message="Price phải lớn hơn 1000 đ")
	private double price;
	@NotNull(message="Không được để trống Quantity")
	@Min(value=1 ,message="Quantity phải hớn hơn 1")
	private int quantity;
}
