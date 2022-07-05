package su22b1_it16304_sof3021.beans;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuyModel {
	@NotBlank(message="Không được để trống FullName")
	private String fullname;
	@NotBlank(message="Không được để trống address")
	private String address;
	@NotNull(message="Không được để trống available")
	@Min(value = 1,message="availible phải lớn hơn 1")
	private int available;
	@NotNull(message="Không được để trống createdDate")
	private Date createdDate;
}
