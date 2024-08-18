package pthu.entities;

import pthu.entities.enums.ShiftEnum;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseClass {
    private int id;
    private String course;
    private int period;
    private ShiftEnum shift;

    public CourseClass(int id, String course, int period, ShiftEnum shift) {
        this.id = id;
        this.course = course;
        this.period = period;
        this.shift = shift;
    }

    public static List<CourseClass> readClassesFromFile(String fileName) {
        List<CourseClass> classes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int id = Integer.parseInt(parts[0]);
                String course = parts[1];
                int period = Integer.parseInt(parts[2]);
                int shiftCode = Integer.parseInt(parts[3]);
                ShiftEnum shift = ShiftEnum.fromCode(shiftCode);

                CourseClass courseClass = new CourseClass(id, course, period, shift);
                classes.add(courseClass);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public ShiftEnum getShift() {
		return shift;
	}

	public void setShift(ShiftEnum shift) {
		this.shift = shift;
	}

	@Override
	public String toString() {
		return "CourseClass [id=" + id + ", course=" + course + ", period=" + period + ", shift=" + shift + "]";
	}
	
}
