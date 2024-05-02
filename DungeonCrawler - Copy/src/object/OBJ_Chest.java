package object;

import characters.gameObject;
import main.GamePanel;

//REVIEWED 13APR2022
//
// CHEST OBJECT
public class OBJ_Chest extends gameObject {

    public OBJ_Chest(GamePanel gp) {
        super(gp);
        name = "Chest";
        down1 = setup("/objects/chest", gp.tileSize, gp.tileSize);
    }}
