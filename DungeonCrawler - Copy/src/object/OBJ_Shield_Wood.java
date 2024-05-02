package object;

import characters.gameObject;
import main.GamePanel;

public class OBJ_Shield_Wood extends gameObject {
    public OBJ_Shield_Wood(GamePanel gp) {
        super(gp);

        type = type_shield;
        name = "Wood Shield";
        down1 =  setup("/objects/shield_wood", gp.tileSize, gp.tileSize);
        defenseValue = 1;
        description = "[" + name + "]\nA raggedy wood shield.";

    }
}
