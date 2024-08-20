package pthu.metaheuristics;

import pthu.Instance;
import pthu.Solution;

public class SolutionEvaluator {

    private Instance instance;
    private Solution solution;
    
    //private int strongRestrictions[];
    private int weakRestrictions[];
    
    //private final int STRONG_CONSTRAINT_PENALTY = 5;
    private final int WEAK_CONSTRAINT_PENALTY = 1;
    
	public SolutionEvaluator(Instance instance, Solution solution) {
		this.instance = instance;
		this.solution = solution;
		
//		strongRestrictions = new int[instance.getSTRONG_RESTRICTIONS()];
//		for (int i = 0; i < strongRestrictions.length; i++) 
//			strongRestrictions[i] = 0;
		
		
		weakRestrictions = new int[instance.getWEAK_RESTRICTIONS()];
		for (int i = 0; i < weakRestrictions.length; i++) 
			weakRestrictions[i] = 0;
	}
    
	public int calculateObjectiveFunction() {
		checkViolations();
		
        int fo = 0;

//        for (int i = 0; i < strongRestrictions.length; i++)
//			fo += strongRestrictions[i] * STRONG_CONSTRAINT_PENALTY;
//		
        
        for (int i = 0; i < weakRestrictions.length; i++) 
			fo += weakRestrictions[i] * WEAK_CONSTRAINT_PENALTY;

        return fo;
    }

	private void checkViolations() {
        /**
         *  Restrições Fortes
         */
//        strongRestrictions[0] = checkProfessorConflicts();
//        strongRestrictions[1] = checkClassConflicts();
//        strongRestrictions[2] = checkClassroomConflicts();
//        strongRestrictions[3] = checkShiftConflicts();
//        strongRestrictions[4] = checkClassroomCapacity();
//        strongRestrictions[5] = checkClassroomType();
//        strongRestrictions[6] = checkSpecialSubjects();

        /**
         *  Restrições Fracas
         */
        weakRestrictions[0] = minimizeTeacherWorkingDays();
        weakRestrictions[1] = minimizeClassGaps();
        weakRestrictions[2] = minimizePreferredPeriod();
        weakRestrictions[3] = avoidSequentialClasses();
        weakRestrictions[4] = minimizeNightToMorningTransitions();
        weakRestrictions[5] = avoidSequentialDifficultClasses();
        weakRestrictions[6] = avoidDifficultClassesAtLastPeriod();
        weakRestrictions[7] = avoidEvenHourClassesAtFirstPeriod();
        weakRestrictions[8] = avoidClassesAroundLunch();
        weakRestrictions[9] = avoidNonStandardStartTimes();
	}
	
	
       
    /**
     * Restrições Fracas
     */

    // Métodos de verificação de restrições fracas
    private int minimizeTeacherWorkingDays() {
        // Minimiza o intervalo de trabalho do professor
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int minimizeClassGaps() {
        // Minimiza janelas de horário
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int minimizePreferredPeriod() {
        // Minimiza disciplinas ofertadas fora do período preferencial
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int avoidSequentialClasses() {
        // Evita aulas seguidas da mesma disciplina
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int minimizeNightToMorningTransitions() {
        // Minimiza transições de aulas noturnas para diurnas
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int avoidSequentialDifficultClasses() {
        // Evita aulas difíceis em horários sequenciais
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int avoidDifficultClassesAtLastPeriod() {
        // Evita aulas difíceis no último horário do dia
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int avoidEvenHourClassesAtFirstPeriod() {
        // Evita aulas com carga horária par no primeiro horário do dia
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int avoidClassesAroundLunch() {
        // Evita aulas imediatamente antes ou depois do horário de almoço
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    private int avoidNonStandardStartTimes() {
        // Evita aulas com início fora do horário padrão
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }
}
   
