package lib.vqui.de;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GuestBookEntryJSON {
		
	String userId;
	String userName;
	String content;
	String creationDateTime;

	public GuestBookEntryJSON(GuestBookEntry entry){
		this.userId = entry.getUserId();
		this.userName = entry.getUserName();
		this.content = entry.getContent();
		this.creationDateTime = entry.getCreationDateTime();
	}

}
