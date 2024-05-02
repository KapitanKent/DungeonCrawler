package object;

import characters.gameObject;
import main.GamePanel;

//REVIEWED 13APR2022
//
// KEY OBJECT
public class OBJ_Key extends gameObject {

    public OBJ_Key(GamePanel gp) {
        super(gp);

        name = "Key";
        down1 = setup("/objects/key", gp.tileSize, gp.tileSize);
        description = "[" + name + "]\nOpens a door.";
        }}


