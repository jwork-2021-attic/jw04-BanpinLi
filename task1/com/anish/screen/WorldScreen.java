package task1.com.anish.screen;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;

import task1.com.anish.calabashbros.SelectSorter;
import task1.com.anish.calabashbros.Calabash;
import task1.com.anish.calabashbros.World;

import task1.asciiPanel.AsciiPanel;

public class WorldScreen implements Screen {

    private World world;
    private Calabash[][] bros;
    String[] sortSteps;

    public WorldScreen() {
        world = new World();

        bros = new Calabash[16][16];
        int rank = 0;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                bros[i][j] = new Calabash(new Color(255, i * 17, j * 17), rank++, world);
            }
        }
        shuffle(bros);

        int x = 10;
        int y = 10;
        for (Calabash[] bro : bros) {
            for (Calabash br : bro) {
                world.put(br, x, y);
                x += 2;
            }
            x = 10;
            y += 2;
        }

        SelectSorter<Calabash> b = new SelectSorter<>();
        b.load(bros);
        b.sort();

        sortSteps = this.parsePlan(b.getPlan());
    }

    private <T> void shuffle(T[][] a) {
        Random r = new Random();
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = a[0].length - 1; j >= 0; j--) {
                int row = r.nextInt(a.length);
                int col = r.nextInt(a[0].length);
                T temp = a[i][j];
                a[i][j] = a[row][col];
                a[row][col] = temp;
            }
        }
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(Calabash[][] bros, String step) {
        String[] couple = step.split("<->");
        getBroByRank(bros, Integer.parseInt(couple[0])).swap(getBroByRank(bros, Integer.parseInt(couple[1])));
    }

    private Calabash getBroByRank(Calabash[][] bros, int rank) {
        for (Calabash[] bro : bros) {
            for (Calabash b : bro) {
                if (b.getRank() == rank) {
                    return b;
                }
            }
        }
        return null;
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {

        for (int x = 0; x < World.WIDTH; x++) {
            for (int y = 0; y < World.HEIGHT; y++) {

                terminal.write(world.get(x, y).getGlyph(), x, y, world.get(x, y).getColor());

            }
        }
    }

    int i = 0;

    @Override
    public Screen respondToUserInput(KeyEvent key) {

        if (i < this.sortSteps.length) {
            this.execute(bros, sortSteps[i]);
            i++;
        }

        return this;
    }

}
