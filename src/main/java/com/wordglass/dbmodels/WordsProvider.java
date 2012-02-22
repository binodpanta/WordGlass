package com.wordglass.dbmodels;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.wordglass.db.DBAccess;

public class WordsProvider {

	private static Logger logger = LoggerFactory.getLogger(WordsProvider.class);

	/**
	 * Return the lists of words
	 * 
	 * @return
	 */
	public List<String> getWordlist() {
		DBCollection coll = DBAccess.getInstance().mongodb()
				.getCollection("word");

		List<String> words = new ArrayList<String>();
		DBCursor cursor = coll.find();

		//logger.info("Found " + cursor.length() + " words");

		while (cursor.hasNext()) {
			DBObject l = cursor.next();
			logger.info(l.toString());
			words.add((String) l.get("word"));
		}
		return words;

	}
}
