package object;

import characters.gameObject;
import main.GamePanel;

public class OBJ_Heart extends gameObject {

    GamePanel gp;

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        name = "Heart";
        value = 2;
        image = setup("/objects/heart_full", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/heart_half", gp.tileSize, gp.tileSize);
        image3 = setup("/objects/heart_blank", gp.tileSize, gp.tileSize);
        down1 = image;

        }
    public void use(gameObject gameObject){
        gp.playSE(2);
        gp.ui.addMessage("Mana +" + value);
        gp.player.life += value;
    }
}

