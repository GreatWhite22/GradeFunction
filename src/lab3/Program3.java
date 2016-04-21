package lab3;

public class Program3 implements IProgram3 {

    private int numClasses;
    private int maxGrade;
    GradeFunction gf;

    public Program3() {
    	 this.numClasses = 0;
         this.maxGrade = 0;
         this.gf = null;
    }

    public void initialize(int n, int g, GradeFunction gf) {
    	 this.numClasses = n;
         this.maxGrade = g;
         this.gf = gf;
    }
    
    public int[] computeHours(int totalHours) {
    	  int[][] hoursSpent = new int[numClasses][totalHours];
    	  int[] computeHours = new int[numClasses];
    	  //int[] hoursSpent = new int[totalHours];
    	  int saveTime = 0;
    	  // n = number of items
    	  //maxGrade = g
    	  //gf.grade() = computesGrade received for hours spent
    	  for(int i = 0; i < numClasses; i++){
    		  for(int j = 0; j < totalHours; j++){
    			if(i == 0){
    				hoursSpent[i][j] = gf.grade(0, j);
    				//computeHours[i] = j;
    			}
    			else{
    				int grade = gf.grade(i, j);
    				if(grade >= maxGrade){
    					//saveTime = j; need to save first time this is greater than or equal to maxGrade
    					if(hoursSpent[i - 1][j - saveTime] + maxGrade > hoursSpent[i-1][j]){
    						hoursSpent[i][j] = hoursSpent[i-1][j-saveTime] + maxGrade;
    					}
    				}
    				else{
    					if(hoursSpent[i-1][j] < grade){
    						hoursSpent[i][j] = grade;
    					}
    					else{
    						hoursSpent[i][j] = hoursSpent[i-1][j];
    					}
    				}
    			}
    		  }
    	  }
    	  int hoursRemaining = totalHours;
    	  int classes = numClasses - 1;
    	  while(totalHours > 0){
    		  if(hoursSpent[classes][hoursRemaining] == hoursSpent[classes-1][hoursRemaining]){
    			  computeHours[classes] = 0;
    		  }
    		  else{
    			  //computeHours[classes] = maxGrade for this time
    		  }
    	  }
    	  
    	  return computeHours;
    }

    public int[] computeGrades(int totalHours) {

        int[] computeGrades = new int[numClasses];
        
        return computeGrades;

    }

}
