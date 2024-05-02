package object;

import characters.gameObject;
import main.GamePanel;

//REVIEWED 13APR2022
//
// KEY OBJECT
public class OBJ_Coin_Bronze extends gameObject {
    GamePanel gp;

    public OBJ_Coin_Bronze(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickupOnly;
        value = 1;
        name = "Bronze Coin";
        down1 = setup("/objects/coin_bronze", gp.tileSize, gp.tileSize);
        }
    public void use(gameObject gameObject){
        gp.gameState = gp.dialogueState;
        gp.ui.addMessage("Coin +" + value);
        gp.player.coin += value;
        gp.playSE(1);
    }
}


