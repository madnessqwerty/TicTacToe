package op02;
import java.io.*; 

public class TicTacToe extends Game{
    private int nextPlayer ; // 1= X , 2= O
    private static BufferedReader stdin ; // to read from console

    // remember : class Game has attribute " board "
    //X is 1
    //O is 2

    // constructor
    public TicTacToe () {
        nextPlayer =1; // X starts
    }

    // overriding abstract methods starts now
    @Override
    public void makeMove (Board b) {
        System.out.println( " Player " + nextPlayer + " , " +
        " make your move (0 -8)  : " );

        Boolean success = false ;
            do {
                try {
                    // read a line from console
                    String line = stdin.readLine();
                    // convert to integer
                      int index = Integer.parseInt(line);
                    
                    if (index <9 && index >=0 && b.getField(index) == 0 ) {
                        // found legal empty field
                        System.out.println ( " conditions met " );
                        b. setField (index , nextPlayer ); // set piece
                        b. printBoard (); // output to console
                        success = true ;
                        nextPlayer = 3 - nextPlayer ; // nice trick ; -)
                    }
                    else {
                        System.out.println ( " make a legal move (0-8) " );
                    }
                }
                // read might throw an exception
                catch (NumberFormatException ex) {
                    System.out.println("Input must be a valid integer.");
                }
                catch (Exception ex) { 
                    System.out.println ( " Wrong input " );
                }

        } while (! success );
    }

   @Override
    public Board startGame() {
        return getBoard();
    }
    //check conditions for winning
    @Override
    public Boolean isFinished(Board b) {
        if((b.getField(0)  == 1) && (b.getField(1)  == 1) && (b.getField(2)  == 1))
            return true;
        else if((b.getField(0)  == 2) && (b.getField(1)  == 2) && (b.getField(2)  == 2))
            return true;

        else if((b.getField(3)  == 1) && (b.getField(4)  == 1) && (b.getField(5)  == 1))
            return true;
        else if((b.getField(3)  == 2) && (b.getField(4)  == 2) && (b.getField(5)  == 2))
            return true;

        else if((b.getField(6)  == 1) && (b.getField(7)  == 1) && (b.getField(8)  == 1))
            return true;
        else if((b.getField(6)  == 2) && (b.getField(7)  == 2) && (b.getField(8)  == 2))
            return true;

        else if((b.getField(0)  == 1) && (b.getField(3)  == 1) && (b.getField(6)  == 1))
            return true;
        else if((b.getField(0)  == 2) && (b.getField(3)  == 2) && (b.getField(6)  == 2))
            return true;

        else if((b.getField(1)  == 1) && (b.getField(4)  == 1) && (b.getField(7)  == 1))
            return true;
        else if((b.getField(1)  == 2) && (b.getField(4)  == 2) && (b.getField(7)  == 2))
            return true;

        else if((b.getField(2)  == 1) && (b.getField(5)  == 1) && (b.getField(8)  == 1))
            return true;
        else if((b.getField(2)  == 2) && (b.getField(5)  == 2) && (b.getField(8)  == 2))
            return true;

        else if((b.getField(0)  == 1) && (b.getField(4)  == 1) && (b.getField(8)  == 1))
            return true;
        else if((b.getField(0)  == 2) && (b.getField(4)  == 2) && (b.getField(8)  == 2))
            return true;

        else if((b.getField(6)  == 1) && (b.getField(7)  == 1) && (b.getField(8)  == 1))
            return true;
        else if((b.getField(6)  == 2) && (b.getField(7)  == 2) && (b.getField(8)  == 2))
            return true;
        else if (b.checkTie() == 0)
            return true;
        else 
            return false;
    }

    @Override
    public void declareResult(Board b) {
        System .out . println ("The Winner is");
        if(b.checkTie()==0)
            System.out.println("nobody won!"); 
        else if(this.nextPlayer == 2)
            System.out.println("Player 1,'X'!");
        else if(this.nextPlayer == 1)
            System.out.println("Player 2, 'O'!");

    }
    // overriding abstract methods ends here
    
    public static void main ( String [] args ) {
        // creating a buffer to read from console
        stdin = new BufferedReader(new InputStreamReader(System.in));
        TicTacToe ttt = new TicTacToe();
        ttt.play();
    }
}
