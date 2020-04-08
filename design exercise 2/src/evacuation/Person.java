package evacuation;

public class Person {

	private String name, firstName, lastName, streetNum, zipCode, state, country, city, additionalInfo, date;

	public Person() {
		name = "N/A";
		firstName = "N/A";
		lastName = "N/A";
		streetNum = "N/A";
		zipCode = "N/A";
		state = "N/A";
		country = "N/A";
		city = "N/A";
		additionalInfo = "N/A";
		date = "N/A";
	}

	public String getName() {
		return name;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getStreetNum() {
		return streetNum;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public String getDate() {
		return date;
	}

	public void setAll(String[] array) {
		setFirstName(array[0]);
		setLastName(array[1]);
		streetNum = array[2];
		city = array[3];
		state = array[4];
		country = array[5];
		zipCode = array[6];
		additionalInfo = array[7];
	}

	public void setFirstName(String s) {
		firstName = s;
		name = firstName + (lastName.equals("N/A") ? "" : " " + lastName);
	}

	public void setLastName(String s) {
		lastName = s;
		name = (firstName.equals("N/A") ? "" : firstName + " ") + lastName;
	}

	public void setStreetNum(String s) {
		streetNum = s;
	}

	public void setZipCode(String s) {
		zipCode = s;
	}

	public void setState(String s) {
		state = s;
	}

	public void setCountry(String s) {
		country = s;
	}

	public void setCity(String s) {
		city = s;
	}

	public void setAdditionalInfo(String s) {
		additionalInfo = s;
	}

	public void setDate(String s) {
		date = s;
	}

	@Override
	public String toString() {
		String result = "";
		result += "First Name: " + firstName + "\n";
		result += "Last Name: " + lastName + "\n";
		result += "Street Number: " + streetNum + "\n";
		result += "City: " + city + "\n";
		result += "State: " + state + "\n";
		result += "Country: " + country + "\n";
		result += "Zip Code: " + zipCode + "\n";
		result += "Additional Information: " + additionalInfo + "\n";
		result += "Date Added: " + date + "\n\n";
		return result;
	}

}
