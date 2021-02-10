package lib.vqui.de.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import lib.vqui.de.model.dto.GuestBookEntryDto;
import lib.vqui.de.model.dto.ReturnDto;
import lib.vqui.de.model.entity.GuestBookEntry;
import lib.vqui.de.repository.GuestBookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class MongoDatabaseService {

  @Autowired
  private EMailService emailService;

  @Value("${spring.data.mongodb.host}")
  String mongodbHost;

  @Autowired
  GuestBookEntryRepository guestBookEntryRepository;

  public ReturnDto addEntry(GuestBookEntryDto entry) {
    ReturnDto thisReturn = new ReturnDto(Long.parseLong(entry.getUserId()));

    try {

      GuestBookEntry guestBookEntry = new GuestBookEntry(entry);
      SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
      guestBookEntry.setCreationDateTime(sdf.format(new Date()));
      guestBookEntryRepository.save(guestBookEntry);

    } catch (Exception e) {

      thisReturn.setId(-1);
      thisReturn.setMessage("Entry not saved:  " + e.getClass().getName());

    }

    return thisReturn;

  }

  public List<GuestBookEntryDto> getAllEntries() {

    List<GuestBookEntryDto> entries = new LinkedList<>();
    guestBookEntryRepository.findAll(Sort.by(Direction.DESC, "creationDateTime"))
        .forEach(entry -> entries.add(
            new GuestBookEntryDto(entry)
        ));
    return entries;
  }

}
