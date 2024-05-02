package characters;

import main.GamePanel;

import java.util.Random;

public class NPC_OldMan extends gameObject {

    public NPC_OldMan(GamePanel gp){
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();
    }

    public void getImage() {
        up1 = setup("/npc/npcUp", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/npcUp2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/npcdown", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/npcDown2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/npcLeft", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/npcLeft2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/npcRight", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/npcRight3", gp.tileSize, gp.tileSize);
    }

    public void setDialogue(){
        dialogues[0] = "Good Day!";
        dialogues[1] = "Are you HERE to find \nTREASURE?";
        dialogues[2] = "I used to be a GREAT wizard \n...until I took a spell\nto the knee.";
        dialogues[3] = "Alrighty then, \nmay luck find you!";
    }

    public void setAction(){
        actionLockCounter++;
        if(actionLockCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) direction = "up";
            if (i > 25 && i <= 50) direction = "down";
            if (i > 50 && i <= 75) direction = "left";
            if (i > 75 && i < 100) direction = "right";
            actionLockCounter = 0;
        }
    }

    public void speak(){
        super.speak();
    }
}
