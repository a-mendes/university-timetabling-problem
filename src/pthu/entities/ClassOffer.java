package pthu.entities;

import pthu.entities.enums.ClassroomEnum;
import pthu.entities.enums.ShiftEnum;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassOffer {

    private int id;
    private int subjectId;
    private int numberClasses;
    private int[] classes;
    private int studentsPerClass;
    private ShiftEnum shift;
    private int professorId;
    private ClassroomEnum type;
    private int classHrs;

    public ClassOffer(int id, int subjectId, int numberClasses, int[] classes, int studentsPerClass, ShiftEnum shift, int professorId, ClassroomEnum type, int classHrs) {
        this.id = id;
        this.subjectId = subjectId;
        this.numberClasses = numberClasses;
        this.classes = classes;
        this.studentsPerClass = studentsPerClass;
        this.shift = shift;
        this.professorId = professorId;
        this.type = type;
        this.classHrs = classHrs;
    }

    public static List<ClassOffer> readClassOffersFromFile(String fileName) {
        List<ClassOffer> classOffers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                int id = Integer.parseInt(parts[0]);
                int subjectId = Integer.parseInt(parts[1]);
                int numberClasses = Integer.parseInt(parts[2]);

                int[] classes = new int[numberClasses];
                for (int i = 0; i < numberClasses; i++) {
                    classes[i] = Integer.parseInt(parts[3 + i]);
                }

                int studentsPerClass = Integer.parseInt(parts[3 + numberClasses]);
                int shiftCode = Integer.parseInt(parts[4 + numberClasses]);
                ShiftEnum shift = ShiftEnum.fromCode(shiftCode);

                int professorId = Integer.parseInt(parts[5 + numberClasses]);
                int typeCode = Integer.parseInt(parts[6 + numberClasses]);
                ClassroomEnum type = (typeCode == 0) ? ClassroomEnum.CLASSROOM : ClassroomEnum.LABORATORY;
                
                int classHrs = Integer.parseInt(parts[7 + numberClasses]);

                ClassOffer classOffer = new ClassOffer(id, subjectId, numberClasses, classes, studentsPerClass, shift, professorId, type, classHrs);
                classOffers.add(classOffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classOffers;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getNumberClasses() {
		return numberClasses;
	}

	public void setNumberClasses(int numberClasses) {
		this.numberClasses = numberClasses;
	}

	public int[] getClasses() {
		return classes;
	}

	public void setClasses(int[] classes) {
		this.classes = classes;
	}

	public int getStudentsPerClass() {
		return studentsPerClass;
	}

	public void setStudentsPerClass(int studentsPerClass) {
		this.studentsPerClass = studentsPerClass;
	}

	public ShiftEnum getShift() {
		return shift;
	}

	public void setShift(ShiftEnum shift) {
		this.shift = shift;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public ClassroomEnum getType() {
		return type;
	}

	public void setType(ClassroomEnum type) {
		this.type = type;
	}

	public int getClassHrs() {
		return classHrs;
	}

	public void setClassHrs(int classHrs) {
		this.classHrs = classHrs;
	}

	@Override
	public String toString() {
		return "ClassOffer [id=" + id + ", subjectId=" + subjectId + ", numberClasses=" + numberClasses + ", classes="
				+ Arrays.toString(classes) + ", studentsPerClass=" + studentsPerClass + ", shift=" + shift
				+ ", professorId=" + professorId + ", type=" + type + ", classHrs=" + classHrs + "]";
	}
	
	
}
