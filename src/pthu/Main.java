package pthu;

public class Main {

	private final String PATH_FOLDER = "res/instance/";
	
    private final String PATH_CLASSROOMS = PATH_FOLDER + "locais.txt";
    private final String PATH_SUBJECTS = PATH_FOLDER + "disciplinas.txt";
    private final String PATH_PROFESSORS = PATH_FOLDER + "professores.txt";
    private final String PATH_CLASSES = PATH_FOLDER + "turmas.txt";
    private final String PATH_OFFER = PATH_FOLDER + "ofertas.txt";
    private final String PATH_SCHEDULE = PATH_FOLDER + "horarios.txt";

    private Instance instance;
    
	public static void main(String[] args) {
        Main main = new Main();
		
		main.loadInstance();
    }
	
	private void loadInstance() {
		instance = new Instance(PATH_CLASSROOMS, PATH_SUBJECTS, PATH_PROFESSORS, PATH_CLASSES, PATH_OFFER, PATH_SCHEDULE);
        instance.printData();
	}
}
