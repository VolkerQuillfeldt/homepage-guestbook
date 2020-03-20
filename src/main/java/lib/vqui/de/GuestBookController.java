package lib.vqui.de;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@ComponentScan("lib.vqui.de")
public class GuestBookController {
	
	@Autowired
	MongoDbWorker mongoService;
			
	@PostMapping("/addEntryGuestBook")
	public  ReturnJSON addEntry(@RequestBody GuestBookEntryJSON entry) {
		return mongoService.addEntry(entry);
	}

	@GetMapping("/readEntriesGuestBook")
	public List readEntries() {
		return mongoService.getAllEntries();
	}
	
	@PostConstruct
	public void init() {

	}

}
