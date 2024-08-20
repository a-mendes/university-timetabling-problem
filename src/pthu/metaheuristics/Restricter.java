package pthu.metaheuristics;

import pthu.Instance;
import pthu.Solution;
import pthu.entities.ClassOffer;
import pthu.entities.Classroom;
import pthu.entities.utils.AllocationPoint;

public class Restricter {

    /**
     * Restrições Fortes
     */ 
     

    public static boolean checkProfessorConflicts(Instance instance, Solution solution, AllocationPoint point, ClassOffer offer) {
    	int timetabling[][][] = solution.getTimetabling();
    	boolean hasConflict = false;
    	
    	for (int i = 0; i < instance.getnClassrooms(); i++) {
			int idOfferAllocated = timetabling[i][point.scheduleId][point.dayId];
			
			if(idOfferAllocated < 0)
				continue;
			
			ClassOffer offerAlocated = instance.getClassOffers().get(idOfferAllocated);
			
			if(offer.getProfessorId() == offerAlocated.getProfessorId()) {
				hasConflict = true;
				break;
			}
		}
    	
        return hasConflict;
    }

    public static boolean checkClassConflicts(Instance instance, Solution solution, AllocationPoint point, ClassOffer offer) {
    	// uma turma não poderá assistir a mais de uma aula no mesmo dia e horário;
    	// Ofertas incluem uma lista de turmas. Elaborar uma forma de representar isso na solução
    	return false;
    }

    public static boolean checkClassroomConflicts() {
        // O fluxo de implementação já impede que a sala esteja alocada para duas aulas ao mesmo tempo
        return false;
    }

    public static boolean checkShiftConflicts() {
        // Verifica se as aulas estão sendo alocadas fora do turno da oferta
        // Retorna a quantidade de conflitos encontrados
        return false;
    }

    public static boolean checkClassroomCapacity(Instance instance, AllocationPoint point, ClassOffer offer) {
    	Classroom classroom = instance.getClassrooms().get(point.classId);

    	return offer.getStudentsPerClass() > classroom.getCapacity();
    }

    public static boolean checkClassroomType(Instance instance, AllocationPoint point, ClassOffer offer){
    	Classroom classroom = instance.getClassrooms().get(point.classId);

    	return offer.getType() != classroom.getType();
    }

    public static boolean checkSpecialSubjects() {
        // Verifica disciplinas especiais
        // Retorna a quantidade de conflitos encontrados
        return false;
    }
    

    /**
     * Restrições Fracas
     */

    // Métodos de verificação de restrições fracas
    public static int minimizeTeacherWorkingDays() {
        // Minimiza o intervalo de trabalho do professor
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int minimizeClassGaps() {
        // Minimiza janelas de horário
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int minimizePreferredPeriod() {
        // Minimiza disciplinas ofertadas fora do período preferencial
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int avoidSequentialClasses() {
        // Evita aulas seguidas da mesma disciplina
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int minimizeNightToMorningTransitions() {
        // Minimiza transições de aulas noturnas para diurnas
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int avoidSequentialDifficultClasses() {
        // Evita aulas difíceis em horários sequenciais
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int avoidDifficultClassesAtLastPeriod() {
        // Evita aulas difíceis no último horário do dia
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int avoidEvenHourClassesAtFirstPeriod() {
        // Evita aulas com carga horária par no primeiro horário do dia
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int avoidClassesAroundLunch() {
        // Evita aulas imediatamente antes ou depois do horário de almoço
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

    public static int avoidNonStandardStartTimes() {
        // Evita aulas com início fora do horário padrão
        // Retorna a quantidade de conflitos encontrados
        return 0;
    }

}
