package task1.com.anish.screen;

import java.awt.event.KeyEvent;

import task1.asciiPanel.AsciiPanel;

public interface Screen {

    public void displayOutput(AsciiPanel terminal);

    public Screen respondToUserInput(KeyEvent key);
}
