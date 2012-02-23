package com.wordglass.db;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

public class DBAccess {

	private static DBAccess dbaccess;
	private DB db;

	public DB mongodb() {
		return db;
	}

	private DBAccess() throws MongoException, UnknownHostException {
		// URI mongoURI = new URI(System.getenv("MONGOHQ_URL"));

		MongoURI mongoURI = new MongoURI(System.getenv("MONGOHQ_URL"));
		db = mongoURI.connectDB();
		db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());
	}

	public static DBAccess getInstance() {
		if (dbaccess == null)
			try {
				dbaccess = new DBAccess();
			} catch (Exception e) {
				throw new IllegalStateException(
						"Error occurred getting MongoDB connection. "
								+ e.getMessage());
			}
		return dbaccess;
	}

	public Set<String> collections() {
		// Use the db object to talk to MongoDB
		Set<String> colls = db.getCollectionNames();
		return colls;
	}

}
