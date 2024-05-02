package object;

import characters.gameObject;
import main.GamePanel;

public class OBJ_Potion_Red extends gameObject {
    GamePanel gp;

    public OBJ_Potion_Red(GamePanel gp){
        super(gp);

        this.gp = gp;
        value = 3;
        type = type_consumable;
        name = "Red Potion";
        down1 = setup("/objects/potion_red",gp.tileSize, gp.tileSize);
        description = "[Red Potion]\nRestores Life by " + value + ".";
    }

    public void use(gameObject gameObject){
        gp.gameState = gp.dialogueState;
        gp.ui.currentDialogue = "You drink the " + name + "!\n" +
                                "Your have restored " + value + " health!";
        gameObject.life += value;
        if(gp.player.life > gp.player.maxLife){
            gp.player.life = gp.player.maxLife;
        }
        gp.playSE(2);
    }
}
