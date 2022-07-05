package su22b1_it16304_sof3021.beans;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
	@NotBlank(message="Không được để trống Email")
	private String email;
	@NotBlank(message="Không được để trống password")
	private String password;
}
