package pthu.metaheuristics;

import java.util.Random;

import pthu.Instance;
import pthu.Solution;
import pthu.entities.ClassOffer;
import pthu.entities.enums.ClassroomEnum;
import pthu.entities.enums.ShiftEnum;
import pthu.entities.utils.AllocationPoint;

public class ConstructiveHeuristic {

	private Solution solution;
	private Random random;

	public ConstructiveHeuristic() {
		random = new Random();
	}

	public Solution constructSolution(Instance instance) {
		solution = new Solution(instance);

		// Itera sobre as ofertas de aula
		for (ClassOffer offer : instance.getClassOffers().values()) {
			boolean allocated = false;

			ShiftEnum shift = offer.getShift();
			int validScheduleBegin = (shift == ShiftEnum.NIGHT) ? (9) : (0);
			int validScheduleEnd = (shift == ShiftEnum.NIGHT) ? (14) : (8);

			ClassroomEnum type = offer.getType();
			int validClassroomBegin = (type == ClassroomEnum.CLASSROOM) ? (0) : (8);
			int validClassroomEnd = (type == ClassroomEnum.CLASSROOM) ? (7) : (13);

			for (int dayId = 0; dayId < instance.getDAYS_OF_WEEK(); dayId++) {
				for (int scheduleId = validScheduleBegin; scheduleId < validScheduleEnd; scheduleId++) {
					do {
						int classId = random.nextInt((validClassroomEnd - validClassroomBegin) + 1)
								+ validClassroomBegin;

						AllocationPoint point = new AllocationPoint(classId, scheduleId, dayId);

						if (solution.canAllocate(instance, point, offer)) {
							solution.allocate(point, offer);
							allocated = true;
						}
					} while (!allocated);
					
					if (allocated)
						break;
				}
				if (allocated)
					break;
			}

			if (!allocated) {
				System.out.println("Warning: Offer " + offer.getId() + " could not be allocated.");
			}
		}

		return solution;

	}

}
