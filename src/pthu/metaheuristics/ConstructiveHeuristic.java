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

			do {
				// Gera um dia aleatório e um horário aleatório dentro dos intervalos válidos
				int dayId = random.nextInt(instance.getDAYS_OF_WEEK());
				int scheduleId = random.nextInt(validScheduleEnd - validScheduleBegin) + validScheduleBegin;
				
				for (int classId = validClassroomBegin; classId < validClassroomEnd; classId++) {
					AllocationPoint point = new AllocationPoint(classId, scheduleId, dayId);
					
					if (solution.canAllocate(instance, point, offer)) {
						solution.allocate(point, offer);
						allocated = true;
						break;
					}
				}
			} while (!allocated);
	    }

		return solution;

	}

}
