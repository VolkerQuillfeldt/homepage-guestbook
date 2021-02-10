package lib.vqui.de.model.entity;

import lib.vqui.de.model.dto.GuestBookEntryDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "entries")
@Data
@NoArgsConstructor
public class GuestBookEntry {

	String userId;
	String userName;
	String content;
	@Id
	String creationDateTime;

	public GuestBookEntry(GuestBookEntryDto entryJSON) {
		userId = entryJSON.getUserId();
		userName = entryJSON.getUserName();
		content = entryJSON.getContent();
		creationDateTime = entryJSON.getCreationDateTime();
	}

}
