package object;

import characters.gameObject;
import main.GamePanel;

public class OBJ_Boots extends gameObject {

    public OBJ_Boots(GamePanel gp) {
        super(gp);
        name = "Boots";
        down1 = setup("/objects/boots", gp.tileSize, gp.tileSize);
    }
}
