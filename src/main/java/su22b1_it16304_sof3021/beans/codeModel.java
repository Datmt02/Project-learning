package su22b1_it16304_sof3021.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class codeModel {
	private String code;
	
	private String newPass;
	
	private String reNewPass; 
	private String email;
}
