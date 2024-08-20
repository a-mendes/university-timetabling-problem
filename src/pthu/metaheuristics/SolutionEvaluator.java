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
        weakRestrictions[0] = Restricter.minimizeTeacherWorkingDays();
        weakRestrictions[1] = Restricter.minimizeClassGaps();
        weakRestrictions[2] = Restricter.minimizePreferredPeriod();
        weakRestrictions[3] = Restricter.avoidSequentialClasses();
        weakRestrictions[4] = Restricter.minimizeNightToMorningTransitions();
        weakRestrictions[5] = Restricter.avoidSequentialDifficultClasses();
        weakRestrictions[6] = Restricter.avoidDifficultClassesAtLastPeriod();
        weakRestrictions[7] = Restricter.avoidEvenHourClassesAtFirstPeriod();
        weakRestrictions[8] = Restricter.avoidClassesAroundLunch();
        weakRestrictions[9] = Restricter.avoidNonStandardStartTimes();
	}
    
  
}
   
