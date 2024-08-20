package pthu.metaheuristics;

import java.util.Random;

import pthu.Instance;
import pthu.Solution;
import pthu.entities.ClassOffer;
import pthu.entities.utils.AllocationPoint;

public class ConstructiveHeuristic {

	private final Instance instance;
	private final Solution solution;
	private final Random random;

	public ConstructiveHeuristic(Instance instance) {
		this.instance = instance;
		this.solution = new Solution(instance);
		this.random = new Random();
	}

	public Solution constructSolution(Instance instance) {
		Solution solution = new Solution(instance);

		// Itera sobre as ofertas de aula
		for (ClassOffer offer : instance.getClassOffers().values()) {
			boolean allocated = false;

			for (int dayId = 0; dayId < instance.getDAYS_OF_WEEK(); dayId++) {
				for (int scheduleId = 0; scheduleId < instance.getSCHEDULES(); scheduleId++) {
					for (int classId = 0; classId < instance.getCLASSROOMS(); classId++) {
						AllocationPoint point = new AllocationPoint(classId, scheduleId, dayId);

						if (canAllocate(instance, solution, point, offer)) {
							allocate(solution, point, offer);
							allocated = true;
							break; 
						}
					}
					if (allocated) break; 
				}
				if (allocated) break;
			}

			if (!allocated) {
				System.out.println("Warning: Offer " + offer.getId() + " could not be allocated.");
			}
		}

		return solution;
	}

	private static boolean canAllocate(Instance instance, Solution solution, AllocationPoint point, ClassOffer offer) {

		return Restricter.checkProfessorConflicts(instance, solution, point, offer)
				&& Restricter.checkClassConflicts(instance, solution, point, offer)
				&& Restricter.checkClassroomCapacity(instance, point, offer)
				&& Restricter.checkClassroomType(instance, point, offer) 
				&& Restricter.checkShiftConflicts()
				&& Restricter.checkSpecialSubjects();
	}

	private static void allocate(Solution solution, AllocationPoint point, ClassOffer offer) {
		solution.getTimetabling()[point.classId][point.scheduleId][point.dayId] = offer.getId();
	}
}
