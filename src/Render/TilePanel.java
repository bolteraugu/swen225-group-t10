package Render;

import Maze.Item;
import Maze.Tile;

import javax.swing.*;
import java.awt.*;

public class TilePanel extends JPanel {
    private Tile tile;
    private JLabel image;

    public TilePanel(Tile tile) {
        setLayout(new GridLayout(1,1));
        this.tile = tile;
    }

    public void redraw() {
        removeAll();
        if(tile.getImage() == null) throw new RuntimeException(tile.getClass().getName() + "Tile image was null");

        image = new JLabel(new ImageIcon(tile.getImage()));
        add(image);

        setVisible(true);
    }

    public Tile getTile() {
        return tile;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (tile.hasItem()) {
            for (Item i : tile.getItems()) {
//            if (tile.getItems().get(0) == null) throw new RuntimeException("WRONG ITEM!!");
                if (i != null) {
                    g.drawImage(i.getImage(), 0, 0, this);
                }
            }
        }
    }
}
