 

package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale.Category;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import enums.TypeId;
import enums.TypeUser;
import models.Person;
import models.User;
import utils.Constants;


public class FileOperations {

	public ArrayList<User> readUsersFile(String pathFile) throws JsonParseException, IOException {
		JsonParser jsonParser = new JsonFactory().createParser(new File(pathFile));
		ArrayList<User> users = new ArrayList<User>();
		while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
			User user = new User();
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				if (jsonParser.getCurrentName() != null) {
					switch (jsonParser.getCurrentName()) {
						case "nickName":
							jsonParser.nextToken();
							user.setNickName(jsonParser.getText());
							break;
						case "password":
							user.setNickName(jsonParser.getText());
							break;
						case "client":
							jsonParser.nextToken();
							user.setClient(readPerson(jsonParser, user.getTypeUser()));
							break;
						case "typeUser":
							jsonParser.nextToken();
							user.setTypeUser(TypeUser.valueOf(jsonParser.getText()));
							break;
					}
				}
			}
			users.add(user);
		}
		return users;
	}
		
	private Person readPerson(JsonParser jsonParser) throws JsonParseException, IOException {
		Person person = new Person();
		while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
			if (jsonParser.getCurrentName() != null) {
				switch (jsonParser.getCurrentName()) {
				case "id":
					jsonParser.nextToken();
					person.setNumberId(jsonParser.getIntValue());
					break;
				case "name":
					jsonParser.nextToken();
					person.setName(jsonParser.getText());
					break;
				case "typeId":
					jsonParser.nextToken();
					person.setTypeId(TypeId.valueOf(jsonParser.getText()));
					break;
				case "lastName":
					jsonParser.nextToken();
					person.setLastName(jsonParser.getText());
					break;
				}
			}
		}
		return person;
	}
	
	public ArrayList<User> reaNotesFile(String pathFile) throws JsonParseException, IOException {
		JsonParser jsonParser = new JsonFactory().createParser(new File(pathFile));
		ArrayList<User> users = new ArrayList<User>();
		while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
			User user = new User();
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				if (jsonParser.getCurrentName() != null) {
					switch (jsonParser.getCurrentName()) {
						case "nickName":
							jsonParser.nextToken();
							user.setNickName(jsonParser.getText());
							break;
						case "password":
							user.setNickName(jsonParser.getText());
							break;
						case "client":
							jsonParser.nextToken();
							user.setClient(readPerson(jsonParser));
							break;
						case "typeUser":
							jsonParser.nextToken();
							user.setTypeUser(TypeUser.valueOf(jsonParser.getText()));
							break;
					}
				}
			}
			users.add(user);
		}
		return users;
	}

	

	
}
