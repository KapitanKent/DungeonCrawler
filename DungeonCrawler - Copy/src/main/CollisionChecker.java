package main;

import characters.gameObject;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(gameObject gameObject){

//IDENTIFY - game coordinates
        int entityLeft = gameObject.worldX + gameObject.solidArea.x;
        int entityRight = entityLeft + gameObject.solidArea.width;
        int entityTop = gameObject.worldY + gameObject.solidArea.y;
        int entityBottom = entityTop + gameObject.solidArea.height;

//IDENTIFY - entity row and column on worldmap;
        int entityLeftCol = entityLeft/ gp.tileSize;
        int entityRightCol = entityRight/ gp.tileSize;
        int entityTopRow = entityTop/ gp.tileSize;
        int entityBottomRow = entityBottom/ gp.tileSize;

        int tileNum1 = 0, tileNum2 = 0;

//DETECT - collision between entity box and tiles
        switch(gameObject.direction) {
            case "up":
                entityTopRow = (entityTop - gameObject.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                break;
            case "down":
                entityBottomRow = (entityBottom - gameObject.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                break;
            case "left":
                entityLeftCol = (entityLeft - gameObject.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                break;
            case "right":
                entityRightCol = (entityRight - gameObject.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                break;
        }
        if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true) {
            gameObject.collisionOn = true;
        }

    }

    public int checkObject(gameObject gameObject, boolean player){
        int index = 999;

        for(int i=0;i<gp.obj.length;i++){
            if(gp.obj[i] != null){
                //get entity solid area
                gameObject.solidArea.x = gameObject.worldX + gameObject.solidArea.x;
                gameObject.solidArea.y = gameObject.worldY + gameObject.solidArea.y;

                //get object solid area
                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch (gameObject.direction) {
                    case "up": gameObject.solidArea.y -= gameObject.speed; break;
                    case "down": gameObject.solidArea.y += gameObject.speed; break;
                    case "left": gameObject.solidArea.x -= gameObject.speed; break;
                    case "right": gameObject.solidArea.x += gameObject.speed; break;
                }
                if(gameObject.solidArea.intersects(gp.obj[i].solidArea)) {
                    if(gp.obj[i].collision ==true){
                        gameObject.collisionOn = true;
                    }
                    if(player == true){
                        index = i;
                    }
                }
                gameObject.solidArea.x = gameObject.solidAreaDefaultX;
                gameObject.solidArea.y = gameObject.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
            }
        }

        return index;
    }

    public int checkEntity(gameObject gameObject, gameObject[] target) {
        int index = 999;

        for(int i=0;i<target.length;i++){
            if(target[i] != null){
                //get entity solid area
                gameObject.solidArea.x = gameObject.worldX + gameObject.solidArea.x;
                gameObject.solidArea.y = gameObject.worldY + gameObject.solidArea.y;

                //get object solid area
                target[i].solidArea.x = target[i].worldX + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldY + target[i].solidArea.y;

                switch (gameObject.direction) {
                    case "up": gameObject.solidArea.y -= gameObject.speed; break;
                    case "down": gameObject.solidArea.y += gameObject.speed; break;
                    case "left": gameObject.solidArea.x -= gameObject.speed; break;
                    case "right": gameObject.solidArea.x += gameObject.speed; break;
                }
                if(gameObject.solidArea.intersects(target[i].solidArea)) {
                    if(target[i] != gameObject) {
                        gameObject.collisionOn = true;
                        index = i;}
                }
                gameObject.solidArea.x = gameObject.solidAreaDefaultX;
                gameObject.solidArea.y = gameObject.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;
            }
        }

        return index;
    }
    public boolean checkPlayer(gameObject gameObject){

        boolean contactPlayer = false;
        gameObject.solidArea.x = gameObject.worldX + gameObject.solidArea.x;
        gameObject.solidArea.y = gameObject.worldY + gameObject.solidArea.y;

        //get object solid area
        gp.player.solidArea.x = gp.player.worldX + gp.player.solidArea.x;
        gp.player.solidArea.y = gp.player.worldY + gp.player.solidArea.y;

        switch (gameObject.direction) {
            case "up":
                gameObject.solidArea.y -= gameObject.speed;
                break;
            case "down":
                gameObject.solidArea.y += gameObject.speed;
                break;
            case "left":
                gameObject.solidArea.x -= gameObject.speed;
                break;
            case "right":
                gameObject.solidArea.x += gameObject.speed;
                break;
        }
        if(gameObject.solidArea.intersects(gp.player.solidArea)) {
            gameObject.collisionOn = true;
            contactPlayer = true;
        }

        gameObject.solidArea.x = gameObject.solidAreaDefaultX;
        gameObject.solidArea.y = gameObject.solidAreaDefaultY;
        gp.player.solidArea.x = gp.player.solidAreaDefaultX;
        gp.player.solidArea.y = gp.player.solidAreaDefaultY;

        return contactPlayer;
    }
}
