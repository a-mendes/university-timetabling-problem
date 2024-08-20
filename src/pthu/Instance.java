package pthu;

import java.util.List;
import java.util.Map;

import pthu.entities.ClassOffer;
import pthu.entities.Classroom;
import pthu.entities.CourseClass;
import pthu.entities.Professor;
import pthu.entities.Schedule;
import pthu.entities.Subject;

public class Instance {

	//TODO: converter para hashmap
    private List<Classroom> classrooms;
    private List<Subject> subjects;
    private List<Professor> professors;
    private List<CourseClass> classes;
    private Map<Integer, ClassOffer> classOffers;
    private List<Schedule> schedules;
    
    private final int STRONG_RESTRICTIONS = 7;
    private final int WEAK_RESTRICTIONS = 10;
    
    private final int DAYS_OF_WEEK;
    private final int SCHEDULES;
    private final int CLASSROOMS; 
    
    private int nClassrooms;
    private int nSubjects;
    private int nProfessors;
    private int nClasses;
    private int nClassOffers;
    private int nSchedules;
    
    
    public Instance(String pathClassrooms, String pathSubjects, String pathProfessors, String pathClasses, String pathOffer, String pathSchedule) {
        loadData(pathClassrooms, pathSubjects, pathProfessors, pathClasses, pathOffer, pathSchedule);
        
        this.DAYS_OF_WEEK = 5; // Considerando uma semana de 5 dias úteis
        this.SCHEDULES = nSchedules;
        this.CLASSROOMS = nClassrooms;
    }

    private void loadData(String pathClassrooms, String pathSubjects, String pathProfessors, String pathClasses, String pathOffer, String pathSchedule) {
        classrooms = Classroom.readClassroomsFromFile(pathClassrooms);
        nClassrooms = classrooms.size();
        
        subjects = Subject.readSubjectsFromFile(pathSubjects);
        nSubjects = subjects.size();
        
        professors = Professor.readProfessorsFromFile(pathProfessors);
        nProfessors = professors.size();
        
        classes = CourseClass.readClassesFromFile(pathClasses);
        nClasses = classes.size();
        
        classOffers = ClassOffer.readClassOffersFromFile(pathOffer);
        nClassOffers = classOffers.size();
        
        schedules = Schedule.readSchedulesFromFile(pathSchedule);
        nSchedules = schedules.size();
    }

    public void printData() {
        System.out.println("Classrooms:");
        for (Classroom classroom : classrooms) {
            System.out.println(classroom);
        }
        
        System.out.println("\nSubjects:");
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
        
        System.out.println("\nClasses:");
        for (CourseClass courseClass : classes) {
            System.out.println(courseClass);
        }
        
        System.out.println("\nProfessors:");
        for (Professor professor : professors) {
            System.out.println(professor);
        }
        
        System.out.println("\nClass Offers:");
        for (Map.Entry<Integer, ClassOffer> entry : classOffers.entrySet()) {
            System.out.println(entry.getValue());
        }
        
        System.out.println("\nSchedules:");
        for (Schedule schedule : schedules) {
            System.out.println(schedule);
        }
    }

	public List<Classroom> getClassrooms() {
		return classrooms;
	}

	public void setClassrooms(List<Classroom> classrooms) {
		this.classrooms = classrooms;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public List<CourseClass> getClasses() {
		return classes;
	}

	public void setClasses(List<CourseClass> classes) {
		this.classes = classes;
	}

	public Map<Integer, ClassOffer> getClassOffers() {
		return classOffers;
	}

	public void setClassOffers(Map<Integer, ClassOffer> classOffers) {
		this.classOffers = classOffers;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public int getSTRONG_RESTRICTIONS() {
		return STRONG_RESTRICTIONS;
	}

	public int getWEAK_RESTRICTIONS() {
		return WEAK_RESTRICTIONS;
	}

	public int getnClassrooms() {
		return nClassrooms;
	}

	public int getnSubjects() {
		return nSubjects;
	}

	public int getnProfessors() {
		return nProfessors;
	}

	public int getnClasses() {
		return nClasses;
	}

	public int getnClassOffers() {
		return nClassOffers;
	}

	public int getnSchedules() {
		return nSchedules;
	}

	public int getDAYS_OF_WEEK() {
		return DAYS_OF_WEEK;
	}

	public int getSCHEDULES() {
		return SCHEDULES;
	}

	public int getCLASSROOMS() {
		return CLASSROOMS;
	}
	
	

}
