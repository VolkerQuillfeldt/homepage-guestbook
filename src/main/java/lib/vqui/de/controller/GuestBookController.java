package lib.vqui.de.controller;

import java.util.List;
import lib.vqui.de.model.dto.GuestBookEntryDto;
import lib.vqui.de.model.dto.ReturnDto;
import lib.vqui.de.service.MongoDatabaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class GuestBookController {

	@Autowired
	MongoDatabaseService mongoService;

	@PostMapping("/addEntryGuestBook")
	public ReturnDto addEntry(@RequestBody GuestBookEntryDto entry) {
		return mongoService.addEntry(entry);
	}

	@GetMapping("/readEntriesGuestBook")
	public List<GuestBookEntryDto> readEntries() {
		return mongoService.getAllEntries();
	}

}
