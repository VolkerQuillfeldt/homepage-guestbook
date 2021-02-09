package lib.vqui.de;

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

	public GuestBookEntry(GuestBookEntryJSON entryJSON){
		this.userId = entryJSON.getUserId();
		this.userName = entryJSON.getUserName();
		this.content = entryJSON.getContent();
		this.creationDateTime = entryJSON.getCreationDateTime();
	}
	
}
