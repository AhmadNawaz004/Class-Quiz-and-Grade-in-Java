import java.util.*;


public class temp {

    static Scanner in = new Scanner(System.in);

    public static void main(){
        menu();
    }

    public static void menu(){
        int numStudents = 0;
        int numQuizzes = 0;
        int[][] array = null;
        String choice = null;
        boolean fFlag = false;
        boolean dFlag = false;

        while(choice!="q" || choice!="Q"){
            System.out.println("Please enter a command.");
            choice = in.next();

            if(choice=="h" || choice=="H"){
                help();
            }

            else if(choice=="s" || choice=="S"){
                setParams(numStudents, numQuizzes);
                fFlag = true;
            }

            else if( choice=="f" || choice=="F"){
                if(fFlag){
                    fillArray(numStudents, numQuizzes, array);
                    dFlag = true;
                }
                else{
                    System.out.println("Please set paramaters before filling the array.");
                    clear();
                }
            }

            else if(choice=="d" || choice=="D"){
                if(dFlag){
                displayResults(numStudents, numQuizzes, array);
                }
                else{
                    System.out.println("Please fill the array before displaying");
                    clear();
                }
            }

            else if(choice=="q" | choice=="Q"){

            }
            else{
                System.out.println("Invalid command. Please enter a valid command.");
            }
        }
    }

    public static void help(){
        System.out.println("S sets paramaters for program operation, etc, etc.");
        System.out.println("F fills array, etc, etc.");
        System.out.println("D displays results, etc, etc.");
        System.out.println("H brings up the help menu, etc, etc.");
        System.out.println("Q quits the program, etc, etc.");

        clear();

    }

    public static void setParams(int numStudents, int numQuizzes){
        System.out.println("How many students are in the class?");
        numStudents = in.nextInt();
        while(numStudents > 50 || numStudents < 0){
            System.out.println("Please use a number between 0-50.");
            numStudents = in.nextInt();
        }

        System.out.println("How many quizzes are in the class?");
        numQuizzes = in.nextInt();

        while(numQuizzes > 5 || numQuizzes < 0){
            System.out.println("Please use a number between 0-5.");
            numQuizzes = in.nextInt();
        }

        clear();
    }

    public static void fillArray(int numStudents, int numQuizzes, int[][] array){
        Random gen = new Random();
        array = new int[numStudents][numQuizzes];

        for(int i = 0; i<numStudents; i++){
            for(int j = 0; j<numQuizzes; j++){
                array[i][j] = gen.nextInt(100);
            }
        }

        System.out.println("Data entry complete...");
        clear();    

    }

    public static void displayResults(int numStudents, int numQuizzes, int[][] array){
        int[] tempQuiz = new int[numStudents];

        for(int i = 0; i < numQuizzes; i++){
            for(int j = 0; j < numStudents; j++){
                tempQuiz[j] = array[j][i];
            }

            sort(tempQuiz); //wtf blizz
            float average = 0;
            for(int k = 0; k < numStudents; k++){
                average += tempQuiz[k];
            }
            average = average/numStudents;

            System.out.println("Quiz "+ i+1 +":");
            System.out.println("Lowest Grade: "+ tempQuiz[0]);
            System.out.println("Highest Grade: "+ tempQuiz[numStudents-1]);
            System.out.println("Average Grade: "+ average);
            System.out.println("Medium Grade: "+ tempQuiz[(int) numStudents/2]);
            System.out.println();
        }

        System.out.printf("Student ID\t\t");
        for(int i = 0; i < numQuizzes; i++){
            System.out.printf("Quiz %n\t\t", i+1);
        }
        System.out.println();

        for(int i = 0; i < numStudents; i++){
            System.out.printf("%n\t\t", 75678+i);
            for(int j = 0; j< numQuizzes; j++){
                System.out.printf("%n\t\t", array[i][j]);
            }
            System.out.println();
        }

        clear();

    }

    private static void clear() {
        // TODO Auto-generated method stub

    }




}