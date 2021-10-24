package task2.umi.screen;

import java.awt.event.KeyEvent;

import task2.asciiPanel.AsciiPanel;
import task2.umi.Creature;
import task2.umi.Hero;
import task2.umi.World;

public class WorldScreen implements Screen {

    private World world;

    public WorldScreen() {
        // 创建整个游戏世界
        world = new World();

        // 创建人物
        Hero hero = new Hero(world);
        world.setCreature(hero);
        // 把人物放到迷宫里面
        world.put(hero, 1, 0);
    }

    @Override
    public void displayOutput(AsciiPanel terminal) {
        for (int i = 0; i < World.WIDTH; i++) {
            for (int j = 0; j < World.HEIGHT; j++) {
                terminal.write(world.get(i, j).getGlyph(), j, i, world.get(i, j).getColor());
            }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_U) {
            // 持续按下u键，表示自动走
            try {
                Hero hero = (Hero) world.getCreatrue();
                hero.autoMove();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(
                        "You can't finish the game in this way! Please use 'W A S D' to control the caracter!");
            }
            return this;
        }

        Creature creature = world.getCreatrue();
        try {
            ((Hero) creature).abandonMazeSolution();
        } catch (Exception e) {
        }
        int xPos = creature.getTile().getxPos();
        int yPos = creature.getTile().getyPos();
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_W:
                xPos -= 1;
                break;
            case KeyEvent.VK_S:
                xPos += 1;
                break;
            case KeyEvent.VK_A:
                yPos -= 1;
                break;
            case KeyEvent.VK_D:
                yPos += 1;
                break;
        }
        creature.moveTo(xPos, yPos);
        return this;
    }
}
