package Maze;

/**
 * Type of enemy
 */
public class RedEnemy extends Enemy {
    public RedEnemy(int row, int col, String direction) {
        super(row, col, direction);
    }


    public void interact() {
        main.getFrame().displayInfo("Watch out for Charizards!");
        main.restartLevel();
    }

    public Fireblast shoot(){
        Fireblast fb = new Fireblast(getRow(), getCol(), direction.toString(), main);
        fb.setCurrentPos(main.getLevelBoard().getBoard()[getRow()][getCol()]);
        fb.moveBlast();
        return fb;
    }


}
