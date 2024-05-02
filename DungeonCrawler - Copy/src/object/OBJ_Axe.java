package object;

import characters.gameObject;
import main.GamePanel;

public class OBJ_Axe extends gameObject {

    public OBJ_Axe(GamePanel gp){
        super(gp);

        type = type_axe;
        name = "Woodcutter's Axe!";
        down1 = setup("/objects/axe", gp.tileSize, gp.tileSize);
        attackValue = 1;
        attackArea.width = 30;
        attackArea.height = 30;
        description = "A bit rusty but can\n still cut some trees.";
    }
}
