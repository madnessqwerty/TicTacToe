public class Board {
    private int[] progress;
    public static char[][] board = {
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}
    };

    public Board (){
        this.progress = new int[9];
        for (int i = 0; i < 9; i++) 
                progress[i] = 0;
    }    
    

    public void printBoard(){
        System.out.println(" " + symbol(progress[0]) + " | " +symbol(progress[1]) + " | " + symbol(progress[2]));
        System.out.println("---+---+---");
        System.out.println(" " + symbol(progress[3]) + " | " + symbol(progress[4]) + " | " + symbol(progress[5]));
        System.out.println("---+---+---");
        System.out.println(" " + symbol(progress[6]) + " | " + symbol(progress[7]) + " | " + symbol(progress[8]));
    }

    private String symbol(int n){
        if(n == 1)
            return "X";
        else if(n == 2)
            return "O";
        else return " " ;  
    }
    
    public int checkTie(){
        int finish = 0;
        for(int i = 0;i<9; i++){
            if(progress[i]== 0)     //if it finds an empty spot, game is nt finished
                finish = 1;
        }
        return finish;  //return finish = 0, when game is finished
    }

    public void setField(int index, int nextPlayer) {
        progress[index] = nextPlayer;
    }

    public int getField(int index2) {
        return progress[index2];
    }
}
