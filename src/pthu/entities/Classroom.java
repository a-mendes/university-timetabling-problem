package pthu.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pthu.entities.enums.ClassroomEnum;

public class Classroom {

	private int id;
	private int classroomNumber;
	private String building;
	private ClassroomEnum type;
	private int capacity;
	
    public Classroom(int id, String building, ClassroomEnum type, int classroomNumber, int capacity) {
        this.id = id;
        this.building = building;
        this.type = type;
        this.classroomNumber = classroomNumber;
        this.capacity = capacity;
    }

    public static List<Classroom> readClassroomsFromFile(String fileName) {
        List<Classroom> classrooms = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int id = Integer.parseInt(parts[0]);
                String building = parts[1];
                int typeValue = Integer.parseInt(parts[2]);
                ClassroomEnum type = (typeValue == 0) ? ClassroomEnum.CLASSROOM : ClassroomEnum.LABORATORY;
                int classroomNumber = Integer.parseInt(parts[3]);
                int capacity = Integer.parseInt(parts[4]);

                Classroom classroom = new Classroom(id, building, type, classroomNumber, capacity);
                classrooms.add(classroom);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classrooms;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public ClassroomEnum getType() {
		return type;
	}

	public void setType(ClassroomEnum type) {
		this.type = type;
	}
	
	public int getClassroomNumber() {
		return classroomNumber;
	}

	public void setClassroomNumber(int classroomNumber) {
		this.classroomNumber = classroomNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", classroomNumber=" + classroomNumber + ", building=" + building + ", type="
				+ type + ", capacity=" + capacity + "]";
	}
	
}
