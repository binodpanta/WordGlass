package com.wordglass.dbmodels;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.wordglass.db.DBAccess;

public class UsersProvider {

	private static Logger logger = LoggerFactory.getLogger(UsersProvider.class);

	/**
	 * Return the lists of users
	 * 
	 * @return
	 */
	public List<String> getUserlist() {
		DBCollection coll = DBAccess.getInstance().mongodb()
				.getCollection("users");

		List<String> words = new ArrayList<String>();
		DBCursor cursor = coll.find();

		//logger.info("Found " + cursor.length() + " words");

		while (cursor.hasNext()) {
			DBObject l = cursor.next();
			words.add((String) l.toString());
		}
		return words;

	}
}
