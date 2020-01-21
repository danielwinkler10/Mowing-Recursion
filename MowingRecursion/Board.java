import java.util.Scanner;
import java.util.regex.Pattern;

public class Board {

    private int height;
    private int width;
    private int start_y;
    private int start_x;
    private Cell[][] board;
    private boolean[][] visited;

    public void initialize(Scanner scanner) {
        this.height = scanner.nextInt();
        this.width = scanner.nextInt();
        this.start_y = scanner.nextInt();
        this.start_x = scanner.nextInt();

        this.board = new Cell[this.height][this.width];

        for(int row=0; row<this.height; row++){
            for(int col=0; col<this.width; col++){
                String current_cell = scanner.next(Pattern.compile("[.T]"));
                if(current_cell.equals(".")){
                    this.board[row][col] = Cell.EMPTY;
                } else if(current_cell.equals("T")){
                    this.board[row][col] = Cell.TREE;
                }
            }
        }
    }

    public void print(){
        for(int row=0; row<this.height; row++){
            for(int col=0; col<this.width; col++){
                switch (this.board[row][col]){
                    case EMPTY:
                        System.out.print(".");
                        break;
                    case CUT:
                        System.out.print("C");
                        break;
                    case TREE:
                        System.out.print("T");
                        break;
                }
                if(col<this.width){
                    System.out.print(" ");
                }
            }
            if(row<this.height-1){
                System.out.print("\n");
            }
        }
        System.out.println();
    }

    private boolean canCut(int x, int y){
        if(x==0 || y==0 || x==this.width-1 || y==this.height-1){
            return false;
        }

        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(this.board[y+i][x+j] == Cell.TREE){
                    return false;
                }
            }
        }

        return true;
    }

    private void cutGrass(int x, int y){
        // Assumes we can cut the grass
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                this.board[y+i][x+j] = Cell.CUT;
            }
        }
    }

    private void solveRecursive(int x, int y){
        if(!canCut(x,y) || this.visited[y][x]){
            return;
        }
        this.visited[y][x] = true;
        cutGrass(x,y);

        solveRecursive(x+1,y);
        solveRecursive(x-1,y);
        solveRecursive(x,y+1);
        solveRecursive(x,y-1);
    }

    public void solve(){
        this.visited = new boolean[this.height][this.width];
        for(int row=0; row<this.height; row++){
            for(int col=0; col<this.width; col++){
                this.visited[row][col] = false;
            }
        }
        solveRecursive(this.start_x,this.start_y);
    }
}
