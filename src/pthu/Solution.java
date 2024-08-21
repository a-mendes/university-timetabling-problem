package pthu;

import pthu.entities.ClassOffer;
import pthu.entities.utils.AllocationPoint;
import pthu.metaheuristics.Restricter;

public class Solution {

    private final Instance instance;
    
    private int[][][] timetabling;
    private int fo;

    public Solution(int daysOfWeek, int schedules, int classrooms, Instance instance) {
        this.instance = instance;
        
        this.timetabling = new int[classrooms][schedules][daysOfWeek];
        initialTimetabling();
    }
    
    public Solution(Instance instance) {
        this.instance = instance;
        
        this.timetabling = new int[instance.getCLASSROOMS()][instance.getSCHEDULES()][instance.getDAYS_OF_WEEK()];
        initialTimetabling();
    }

    public void printTimetabling() {
    	for (int i = 0; i < instance.getCLASSROOMS(); i++) {
    		System.out.println("-------------------------------------");
            System.out.println("Classroom " + i + "\n");
            //Header
            System.out.print("\t");
            for (int k = 0; k < instance.getDAYS_OF_WEEK(); k++) 
            	System.out.print("Day "+ k + "\t");
            
            System.out.println();
            
            for (int j = 0; j < instance.getSCHEDULES(); j++) {
                System.out.print(j + "h" + "\t");
                for (int k = 0; k < instance.getDAYS_OF_WEEK(); k++) {
                	if(timetabling[i][j][k] >= 0)
                		System.out.print(timetabling[i][j][k] + "\t");
                	else
                		System.out.print(" - \t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
    
    public boolean canAllocate(Instance instance, AllocationPoint point, ClassOffer offer) {
		
    	if(point.scheduleId + offer.getClassHrs() -1 > instance.getSCHEDULES())
    		return false;
    	
    	for (int i = 0; i < offer.getClassHrs(); i++) {
	        AllocationPoint auxPoint = new AllocationPoint(point.classId, point.scheduleId + i, point.dayId);
	        boolean cantAllocate = Restricter.hasClassroomConflicts(instance, this, auxPoint)
	        					|| Restricter.hasProfessorConflicts(instance, this, auxPoint, offer)
	                            || Restricter.hasClassroomCapacity(instance, auxPoint, offer)
	                            || Restricter.hasClassroomType(instance, auxPoint, offer) 
	                            || Restricter.hasClassConflicts()
	                            || Restricter.hasShiftConflicts()
	                            || Restricter.isSpecialSubjects();
	        
	        if (cantAllocate) 
	            return false;
	        
	    }
		
	    return true;
	}
    
    public void allocate(AllocationPoint point, ClassOffer offer) {
		for (int i = 0; i < offer.getClassHrs(); i++) 
			timetabling[point.classId][point.scheduleId+i][point.dayId] = offer.getId();
		
		printTimetabling();
	}
    
	public int[][][] getTimetabling() {
		return timetabling;
	}

	public void setTimetabling(int[][][] timetabling) {
		this.timetabling = timetabling;
	}    

	private void initialTimetabling() {
	 for (int i = 0; i < this.timetabling.length; i++) {
            for (int j = 0; j < timetabling[i].length; j++) {
                for (int k = 0; k < timetabling[i][j].length; k++) {
                	timetabling[i][j][k] = -1;
                }
            }
        }
	}
	
	
}
