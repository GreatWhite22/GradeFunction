package lab3;

import java.util.ArrayList;

public class Program3 implements IProgram3 {

    private int numClasses;
    private int maxGrade;
    GradeFunction gf;
    int[][] grades;

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
          int[] computeHours = new int[numClasses];
          int[][] grades = new int[numClasses + 1][totalHours + 1];
          int[][] hours = new int[numClasses + 1][totalHours + 1];

          for(int i = 1; i <= numClasses; i++){
              for(int j = 0; j <= totalHours; j++){
                  int bestGrade = 0;
                  int hour = 0;
                  for(int k = 0; k <= j; k++){
                      int grade = grades[i-1][j-k] + gf.grade(i-1, k);
                      if(grade >= bestGrade){
                          bestGrade = grade;
                          hour = k;
                      }
                  }
                 if(bestGrade > grades[i-1][j]){
                     grades[i][j] = bestGrade;
                     hours[i][j] = hour;
                 }
                 else{
                     grades[i][j] = grades[i-1][j];
                     hours[i][j] = -1;
                 }
              }
          }
          int classesRemaining = numClasses;
              while(classesRemaining >= 0){
                  if(hours[classesRemaining][totalHours] >= 0){
                      break;
                  }
                  classesRemaining--;
              }
              while(classesRemaining > 0 && hours[classesRemaining][totalHours] >= 0){
                  computeHours[classesRemaining - 1] = hours[classesRemaining][totalHours];
                  totalHours = totalHours - hours[classesRemaining][totalHours];
                  classesRemaining--;
              }
              
              return computeHours;
    }
         
    public int[] computeGrades(int totalHours) {
        int[] computeHours = computeHours(totalHours);
        int[] computeGrades = new int[numClasses];
        
        for(int i = 0; i < numClasses; i++){
            computeGrades[i] = gf.grade(i, computeHours[i]);
        }
        return computeGrades;

    }

}
