
/**
 * @Fabien 
 * This class implements a simplified version of a Map class for strings
 */
public class SimpleStringMap {
	
	/**
	 *  Creates a new SimpleStringMap with no key/value pairs
	 */
	public SimpleStringMap(){
		bucketArray = new HashEntry[N_BUCKETS];
	}
	
	/**
	 * Sets the value associated witk key. Any previous value for key is lost.
	 * @param key The key used to refer to this value
	 * @param value The new value to be associated with key
	 */
	public void put(String key, String value){
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if (entry==null){
			entry = new HashEntry(key, value);
			entry.setLink(bucketArray[bucket]);
			bucketArray[bucket] = entry;
		} else{
			entry.setValue(value);
		}
	}
	
	
	/**
	 * Retrieves the value associated with key, or null if no such value exists.
	 * @param key The key used to look up the value
	 * @return The value associated with key, or null if no such value exists
	 */
	public String get(String key){
		int bucket = Math.abs(key.hashCode()) % N_BUCKETS;
		HashEntry entry = findEntry(bucketArray[bucket], key);
		if(entry == null){
			return null;
		} else{
			return entry.getValue();
		}
	}
	
	/*Scans the entry chain looking for an entry that matches the specified key.
	 * If no such entry exists, finfEntry returns null
	*/
	private HashEntry findEntry(HashEntry entry, String key){
		while(entry != null){
			if(entry.getKey().equals(key)) return entry;
			entry = entry.getLink();
		}
		return null;
	}
	
	// Private constants
	private static final int N_BUCKETS = 7;
	
	// Private instance variables
	private HashEntry[] bucketArray;

}
