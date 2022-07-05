package su22b1_it16304_sof3021.beans;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import su22b1_it16304_sof3021.entities.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

	@NotBlank(message="Không được để trống tên")
	private String name;
	@NotBlank(message="Không được để trống image")
	private String image;
	@NotNull(message="Không được để trống price")
	@Min(value = 1000,message="price phải lớn hơn 1000 đ")
	private double price;
	@NotNull(message="Không được để trống available")
	@Min(value = 1,message="availible phải lớn hơn 1")
	private int available;
	@NotNull(message="Không được để trống category")
	private Category category;
	@NotNull(message="Không được để trống createdDate")
	private Date createdDate;
	@NotBlank(message="Không được để trống mô tả")
	private String mota;
}
