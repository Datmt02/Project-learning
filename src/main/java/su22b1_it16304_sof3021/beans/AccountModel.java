package su22b1_it16304_sof3021.beans;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {
	
	@NotBlank(message="Không được để trống FullName")
	private String fullname;
	@NotBlank(message="Không được để trống Email")
	private String email;
	@NotBlank(message="Không được để trống user name")
	private String username;
	@NotBlank(message="Không được để trống password")
	private String password;
	
	private String rePassword;
	private String code;
	@NotBlank(message="Không được để trống Photo")
	private String photo;
	private int admin;
}
