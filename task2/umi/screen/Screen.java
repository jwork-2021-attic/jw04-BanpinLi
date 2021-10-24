package task2.umi.screen;

import java.awt.event.KeyEvent;

import task2.asciiPanel.AsciiPanel;

public interface Screen {
    public void displayOutput(AsciiPanel terminal);

    public Screen respondToUserInput(KeyEvent keyEvent);
}
