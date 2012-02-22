package com.wordglass.dbmodels;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.wordglass.db.DBAccess;

public class WordsProvider {

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

		while (cursor.hasNext()) {
			DBObject l = cursor.next();
			words.add((String) l.get("word"));
		}
		return words;

	}
}
