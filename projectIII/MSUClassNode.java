package projectIII;

public class MSUClassNode {

	private int numSeats;
	private int numSections;
	
	private boolean lecture = false;
	
	private String title;
	private String classID;
	private String instructor;
	private String instrFirst;
	private String location;
	private String time;
	
	public MSUClassNode(String line) {
		int i = 0;
		String[] lineElems;

		lineElems = line.split(",");

		if ((lineElems[13].charAt(0) == 'L' && lineElems[13].charAt(1) == 'a')
				|| (lineElems[14].charAt(0) == 'L' && lineElems[14].charAt(1) == 'a')) {
			// System.out.println("Lab omitted"); //Debug statement
		} else if ((lineElems[13].charAt(0) == 'R' && lineElems[13].charAt(1) == 'e')
				|| (lineElems[14].charAt(0) == 'R' && lineElems[14].charAt(1) == 'e')) {
			// System.out.println("Recitation omitted"); //Debug statement
		} else {
			lineElems[7] = lineElems[7].replace("\"", "");
			lineElems[8] = lineElems[8].replace("\"", "");

			this.classID = lineElems[1];
			this.title = lineElems[2];
			this.numSections = Integer.valueOf("1");
			this.numSeats = Integer.valueOf(lineElems[4]);
			this.instructor = lineElems[7];
			this.instrFirst = lineElems[8];
			this.location = lineElems[16];
			this.time = lineElems[15];
			this.lecture = true;
		}
	}
	
	public boolean isLecture() {
		return this.lecture;
	}
	
	public String getClassID() {
		return this.classID;
	}
	
	public String getInstructor() {
		return this.instructor;
	}
	
	public String getInstructorFull() {
		return (this.instructor + "," + this.instrFirst);
	}
	
	public String getInstructorFullInOrder() {
		return (this.instrFirst + " " + this.instructor);
	}
	
	public String getClassTitle() {
		return this.title;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public int getSections() {
		return this.numSections;
	}
	
	public int getNumSeats() {
		return this.numSeats;
	}
	
	public void incrumentSection(int seats) {
		this.numSections++;
		this.numSeats += seats;
	}
	
	/**
	 * 
	 * @param ID
	 * @return
	 * 		returns false if they are not equal
	 * 		returns true if they are equal
	 */
	public boolean compareClassID(String ID) {
		for(int i = 5; i <= 8; i++) {
			if(this.classID.charAt(i) == ID.charAt(i)) {
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
	
	public boolean compareLocation(String loc) {
		if(loc.length() != this.location.length()) {
			return false;
		}else {
			for(int i = 0; i < loc.length(); i++) {
				if(this.location.charAt(i) == loc.charAt(i)) {
					continue;
				}else {
					return false;
				}
			}
			return true;
		}
	}
	
	public boolean compareInstructor(String name) {
		if(name.length() != this.instructor.length()) {
			return false;
		}else {
			for(int i = 0; i < name.length(); i++) {
				if(this.instructor.charAt(i) == name.charAt(i)) {
					continue;
				}else {
					return false;
				}
			}
			return true;
		}
	}
}
