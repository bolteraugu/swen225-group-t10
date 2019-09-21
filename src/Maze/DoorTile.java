package Maze;

import Application.Main;

import java.awt.*;

/** Represents a door in the game. Doors can be unlocked using a key with the same color as the door. By unlocking the door
 * the player can access other parts of the map. */

public class DoorTile extends Tile {
    private String color; //The color of the door. The color can be blue, green, red or yellow
    private boolean isWalkable; //Whether the door is locked

    /** Creates a door tile with a pre-defined color.
     * @param row The row (in regards to the board) of the door
     * @param col The column (in regards to the board) of the door
     * @param color The pre-defined color of the board
     * */
    public DoorTile(int row, int col, String color) {
        super(row, col);
        this.color = color;
        this.isWalkable = false; //The door by default (i.e. when created) is locked.
    }


    //getter and setter methods
    /** Locks/unlocks the door.
     * @param isWalkable a boolean representing if the door is getting locked
     * */
    public void setWalkable(boolean isWalkable) {
        this.isWalkable = isWalkable;
    }

    /**
     * Gets the colour of the door
     * @return colour of the door
     */
    public String getColor(){
        return color;
    }


    /**
     * Returns whether a door is unlocked and therefore it can be walked through
     * @return a boolean representing if the door is unlocked and therefore can be walked through
     */
    @Override
    public boolean isWalkable() { return !isWalkable;}

    @Override
    public void interact() {
        //TODO: need to implement door being able to interact with Player
        setWalkable();

        if (isWalkable()) {
            main.getLevelBoard().replaceWithEmptyTile(this);

            //Remove key from players inventory
            for (Item i : main.getPlayer().getInventory()) {
                if (i instanceof Key) {
                    Key k = (Key) i;
                    if (k.getColor().equals(color)) {
                        main.getPlayer().removeItemFromInventory(k);
                    }
                }
            }
        }

    }

    public void setWalkable() {
        for (Item i : main.getPlayer().getInventory()) {
            if (i instanceof Key) {
                Key k = (Key) i;
                if (k.getColor().equals(color)) {
                    isWalkable = true;
                }
            }
        }
    }

}
