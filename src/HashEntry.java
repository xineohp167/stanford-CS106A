// Package-private class HashEntry

/*
This class represents a pair of a key and a value, along with a reference to
the next HashEntry in the chain. The methods exported by the class consist
only of getters and setters.
*/
public class HashEntry {
	
	// Creates a new HashEntry for the specified key/value pair
	public HashEntry(String key, String value){
		entryKey = key;
		entryValue = value;
	}
	
	// Returns the key component of a HashEntry
	public String getKey(){
		return entryKey;
	}
	
	// Returns the value component of a HahEntry
	public String getValue(){
		return entryValue;
	}
	
	// Sets the value component of a HashEntry to a new value
	public void setValue(String value){
		entryValue = value;
	}
	
	// Returns the next link in the entry chain
	public HashEntry getLink(){
		return entryLink;
	}
	
	// Sets the link to the next entry in the chain
	public void setLink(HashEntry nextEntry){
		entryLink = nextEntry;
	}
	
	
	// Private instance variables
	private String entryKey;        // The key component for this HashEntry
	private String entryValue;     // The value component for this HashEntry
	private HashEntry entryLink;  // A reference to the next entry in the chain

}
