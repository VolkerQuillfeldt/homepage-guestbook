package lib.vqui.de;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Component("MongoDbWorker")
public class MongoDbWorker {

	protected MongoClient mongoClient = null;
	protected DBCollection guestBookEntries = null;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	@PostConstruct
	public void init() {
		String mongoUrl = "mongodb://guestBookEditor:guestBookEdit@localhost:27017/";
		MongoClientURI connectionString = new MongoClientURI(mongoUrl);
		mongoClient = new MongoClient(connectionString);
		DB database = mongoClient.getDB("guestbook");
		guestBookEntries = database.getCollection("entries");
		if (guestBookEntries == null) {
			guestBookEntries = database.createCollection("entries", null);
		}
	}

	public void addEnry(GuestBookEntryJSON entry) {
		BasicDBObject doc = new BasicDBObject();
		doc.put("userId", entry.getUserId());
		doc.put("userName", entry.getUserName());
		doc.put("content", entry.getContent());
		doc.put("created", sdf.format(new Date()));

		guestBookEntries.insert(doc);
		
		
	}

	public List getAllEntries() {
		BasicDBObject sortObj = new BasicDBObject("_id",-1);
		return guestBookEntries.find().sort(sortObj).toArray();
	}

}
