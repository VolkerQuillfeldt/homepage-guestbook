package lib.vqui.de.model.dto;

import lib.vqui.de.model.entity.GuestBookEntry;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor
public class GuestBookEntryDto {

	String userId;
	String userName;
	String content;
	@MongoId
	String creationDateTime;

	public GuestBookEntryDto(GuestBookEntry entry) {
		userId = entry.getUserId();
		userName = entry.getUserName();
		content = entry.getContent();
		creationDateTime = entry.getCreationDateTime();
	}

}
