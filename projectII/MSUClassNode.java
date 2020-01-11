package projectII;

public class MSUClassNode <Key extends Comparable<Key>, Value> {
	
	private String title;
	private String classID;
	private int numSeats;
	private int numSections;
	private String[] keys = new String[3];
	private Key key;
	private Value val;
	private boolean lecture;
	
	private MSUClassNode left, right;
	private int size;

	
	public MSUClassNode(String id, String title, String daysOfWeek, String time, String location, boolean lecture, int numSeats) {
		this.title = title;
		this.classID = id;
		this.numSeats = numSeats;
		this.keys[0] = daysOfWeek;
		this.keys[1] = time;
		this.keys[2] = location;
		this.numSections = 1;
		this.key = (Key) (daysOfWeek + "_" + time + "_" + location);
		String[] values = {this.classID, this.title, String.valueOf(this.numSections), String.valueOf(this.numSeats)};
		this.val = (Value) values;
		
		this.lecture = lecture;
	}
	
	public MSUClassNode (Key key, Value value, int size){
		this.key = key;
		this.val = value;
		this.size = size;
	}
	
	public Key getKey() {
		return this.key;
	}
	
	public Value getValue() {
		return this.val;
	}
	
	public void addSection(int newSeats) {
		numSections++;
		numSeats += newSeats;
	}
	
	public boolean isLecture() {
		return this.lecture;
	}
	
	public void print() {
		System.out.printf("Key: %s-%s-%s Value: %s, %d, %d",this.keys[0], this.keys[1], this.keys[2], this.title, this.numSections, this.numSeats);
	}
}
