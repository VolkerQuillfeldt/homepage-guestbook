package lib.vqui.de;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestBookEntryRepository extends MongoRepository<GuestBookEntry,String> {

}
