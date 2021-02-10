package lib.vqui.de.repository;

import java.util.List;
import lib.vqui.de.model.entity.GuestBookEntry;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface GuestBookEntryRepository extends MongoRepository<GuestBookEntry, String> {

  @Override
  List<GuestBookEntry> findAll(Sort sort);
}
