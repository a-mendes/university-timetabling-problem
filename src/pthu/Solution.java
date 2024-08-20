package pthu;

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
                	if(timetabling[i][j][k] > 0)
                		System.out.print(timetabling[i][j][k] + "\t");
                	else
                		System.out.print(" - \t");
                }
                System.out.println();
            }
            System.out.println();
        }
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
