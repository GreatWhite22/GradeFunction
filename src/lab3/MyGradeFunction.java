
import java.util.Random;

public class MyGradeFunction implements GradeFunction {
	
	private int numClasses;
    private int maxGrade;

    public MyGradeFunction(int n, int g){
	    this.numClasses = n;
	    this.maxGrade = g;
    }
    //checks case where grade obtained for spending all time on one class is maxGrade
    //but the best grade you can obtain is from spending part of time on one class
    //and the other part on another
    public int grade(int classID, int hours){
    	if(classID == 0 && hours == 40){
    		return maxGrade;
    	}
    	if(classID == 0 && hours == 1){
    		return 3;
    	}
    	else if(classID == 1 && hours == 39){
    		return maxGrade - 1;
    	}
    	else if(classID == 2 && hours == 1){
    		return 2;
    	}
    	return 0;
    }
}
