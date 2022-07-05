package su22b1_it16304_sof3021.beans;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class updatePassModel {
	@NotBlank(message="Không được để trống mật khẩu cũ")
	private String oldPass;
	@NotBlank(message="Không được để trống mật khẩu mới")
	private String newPass;
	@NotBlank(message="Không được để trống nhập lại mật khẩu mới")
	private String reNewPass;
}
