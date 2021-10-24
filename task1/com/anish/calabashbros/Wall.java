package task1.com.anish.calabashbros;

import task1.asciiPanel.AsciiPanel;

public class Wall extends Thing {

    Wall(World world) {
        super(AsciiPanel.cyan, (char) 177, world);
    }

}
