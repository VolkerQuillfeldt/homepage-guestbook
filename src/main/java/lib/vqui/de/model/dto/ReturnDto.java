package lib.vqui.de.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReturnDto {

	long id;
	String message;
	boolean isAdmin;
	String userName;

	public ReturnDto(Long id) {
		this.id = id;
	}

}
