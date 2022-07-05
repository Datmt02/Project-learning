package su22b1_it16304_sof3021.beans;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import su22b1_it16304_sof3021.entities.Account;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
	
	@NotNull(message="Không được để trống user")
	private Account user;
	@NotNull(message="Không được để trống createdDate")
	private Date createdDate;
	@NotBlank(message="Không được để trống địa chỉ")
	private String address;
}
