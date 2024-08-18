package pthu;

import java.util.List;

import pthu.entities.ClassOffer;
import pthu.entities.Classroom;
import pthu.entities.CourseClass;
import pthu.entities.Professor;
import pthu.entities.Schedule;
import pthu.entities.Subject;

public class Instance {

    private List<Classroom> classrooms;
    private List<Subject> subjects;
    private List<Professor> professors;
    private List<CourseClass> classes;
    private List<ClassOffer> classOffers;
    private List<Schedule> schedules;

    public Instance(String pathClassrooms, String pathSubjects, String pathProfessors, String pathClasses, String pathOffer, String pathSchedule) {
        loadData(pathClassrooms, pathSubjects, pathProfessors, pathClasses, pathOffer, pathSchedule);
    }

    private void loadData(String pathClassrooms, String pathSubjects, String pathProfessors, String pathClasses, String pathOffer, String pathSchedule) {
        classrooms = Classroom.readClassroomsFromFile(pathClassrooms);
        subjects = Subject.readSubjectsFromFile(pathSubjects);
        professors = Professor.readProfessorsFromFile(pathProfessors);
        classes = CourseClass.readClassesFromFile(pathClasses);
        classOffers = ClassOffer.readClassOffersFromFile(pathOffer);
        schedules = Schedule.readSchedulesFromFile(pathSchedule);
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
        for (ClassOffer classOffer : classOffers) {
            System.out.println(classOffer);
        }
        
        System.out.println("\nSchedules:");
        for (Schedule schedule : schedules) {
            System.out.println(schedule);
        }
    }
}
