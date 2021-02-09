package lib.vqui.de;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@ComponentScan("lib.vqui.de")
@Component("MongoDbWorker")
public class MongoDbWorker {

  @Autowired
  private EMailService emailService;

  @Value("${spring.data.mongodb.host}")
  String mongodbHost;

  protected MongoClient mongoClient = null;
  protected DBCollection guestBookEntries = null;
  private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

  @Autowired
  GuestBookEntryRepository guestBookEntryRepository;

  final static String collection = "entries";
	
	/*@PostConstruct
	public void init() {
		System.out.println(mongodbHost);
		String mongoUrl = "mongodb://guestBookEditor:guestBookEdit@"+mongodbHost+":27018/";
		MongoClientURI connectionString = new MongoClientURI(mongoUrl);
		mongoClient = new MongoClient(connectionString);
		DB database = mongoClient.getDB("guestbook");
		guestBookEntries = database.getCollection("entries");
		if (guestBookEntries == null) {
			guestBookEntries = database.createCollection("entries", null);
		}
	}*/

  public ReturnJSON addEntry(GuestBookEntryJSON entry) {
    ReturnJSON thisReturn = new ReturnJSON();
    thisReturn.setId(Long.parseLong(entry.getUserId()));

    try {

      System.out.println("json" + entry);
      GuestBookEntry guestBookEntry = new GuestBookEntry(entry);
      guestBookEntry.setCreationDateTime(sdf.format(new Date()));
      guestBookEntryRepository.save(guestBookEntry);

    } catch (Exception e) {

      thisReturn.setId(-1);
      thisReturn.setMessage("Entry not saved:  " + e.getClass().getName());

    }

    return thisReturn;

  }

  public List getAllEntries() {

    LinkedList<GuestBookEntryJSON> entries = new LinkedList<>();
        guestBookEntryRepository.findAll().forEach(entry -> entries.add(
          new GuestBookEntryJSON(entry)
        ));
        
    return entries;
  }

}
