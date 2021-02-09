package lib.vqui.de;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class GuestbookVquiApplication {



	public static void main(String[] args) {
		SpringApplication.run(GuestbookVquiApplication.class, args);
	}
}
