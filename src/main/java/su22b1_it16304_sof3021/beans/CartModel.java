package su22b1_it16304_sof3021.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import su22b1_it16304_sof3021.entities.Account;
import su22b1_it16304_sof3021.entities.Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
	
	private Account user;
	
	private Product product;
	
	private int available;
}
