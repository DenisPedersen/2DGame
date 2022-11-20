package entities;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 -(gp.tileSize/2);
        screenY = gp.screenHeight/2 -(gp.tileSize/2);

        solidArea = new Rectangle(8,16, 32, 32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction ="down";
    }

    public void getPlayerImage() {

        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_2.png")));
            up3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_3.png")));
            up4 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_4.png")));
            up5 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_5.png")));
            up6 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_6.png")));
            up7 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_7.png")));
            up8 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_8.png")));
            up9 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_up_9.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_2.png")));
            down3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_3.png")));
            down4 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_4.png")));
            down5 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_5.png")));
            down6 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_6.png")));
            down7 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_7.png")));
            down8 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_8.png")));
            down9 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_down_9.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_2.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_3.png")));
            left4 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_4.png")));
            left5 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_5.png")));
            left6 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_6.png")));
            left7 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_7.png")));
            left8 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_8.png")));
            left9 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_left_9.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_2.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_3.png")));
            right4 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_4.png")));
            right5 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_5.png")));
            right6 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_6.png")));
            right7 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_7.png")));
            right8 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_8.png")));
            right9 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("player/wolf_right_9.png")));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if(keyH.upPressed || keyH.downPressed || keyH.rightPressed || keyH.leftPressed) {

        if(keyH.upPressed) {
            direction = "up";
        }
        else if (keyH.downPressed) {
            direction = "down";
        }
        else if(keyH.leftPressed){
            direction = "left";
        }
        else if(keyH.rightPressed) {
            direction = "right";
        }
        //Check tile-collision
        collisionOn = false;
        gp.cChecker.checkTile(this);

        //if collision is false, player can move
        if(collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }

        spriteCounter++;
        if(spriteCounter > 10) {
            if (spriteNum ==1) {
                spriteNum = 2;
            }
            else if(spriteNum == 2) {
                spriteNum = 3;
            }
            else if(spriteNum == 3) {
                spriteNum = 4;
            }
            else if(spriteNum == 4) {
                spriteNum = 5;
            }
            else if(spriteNum == 5) {
                spriteNum = 6;
            }
            else if(spriteNum == 6) {
                spriteNum = 7;
            }
            else if(spriteNum == 7) {
                spriteNum = 8;
            }
            else if(spriteNum == 8) {
                spriteNum = 9;
            }
            spriteCounter = 0;
        }
        }
        else {
            spriteNum=1;  //Not really sure about this solution.... works in a Mickey Mouse way
        }
    }

    public void  draw(Graphics2D g2) {

  /*      g2.setColor(Color.white);
        g2.fillRect(x,y,gp.tileSize,gp.tileSize);*/

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if(spriteNum == 1) {
                image = up1;
                }
                if(spriteNum == 2) {
                    image = up2;
                }
                if(spriteNum == 3) {
                    image = up3;
                }
                if(spriteNum == 4) {
                    image = up4;
                }
                if(spriteNum == 5) {
                    image = up5;
                }
                if(spriteNum == 6) {
                    image = up6;
                }
                if(spriteNum == 7) {
                    image = up7;
                }
                if(spriteNum == 8) {
                    image = up8;
                }
                if(spriteNum == 9) {
                    image = up9;
                }
                break;
            case "down":
                if(spriteNum == 1) {
                    image=down1;
                }
                if(spriteNum == 2) {
                    image=down2;
                }
                if(spriteNum == 3) {
                    image=down3;
                }
                if(spriteNum == 4) {
                    image=down4;
                }
                if(spriteNum == 5) {
                    image=down5;
                }
                if(spriteNum == 6) {
                    image=down6;
                }
                if(spriteNum == 7) {
                    image=down7;
                }
                if(spriteNum == 8) {
                    image=down8;
                }
                if(spriteNum == 9) {
                    image=down9;
                }
                break;
            case "left":
                if(spriteNum == 1) {
                    image=left1;
                }
                if(spriteNum == 2) {
                    image=left2;
                }
                if(spriteNum == 3) {
                    image=left3;
                }
                if(spriteNum == 4) {
                    image=left4;
                }
                if(spriteNum == 5) {
                    image=left5;
                }
                if(spriteNum == 6) {
                    image=left6;
                }
                if(spriteNum == 7) {
                    image=left7;
                }
                if(spriteNum == 8) {
                    image=left8;
                }
                if(spriteNum == 9) {
                    image=left9;
                }
                break;
            case "right":
                if(spriteNum == 1) {
                    image=right1;
                }
                if(spriteNum == 2) {
                    image=right2;
                }
                if(spriteNum == 3) {
                    image=right3;
                }
                if(spriteNum == 4) {
                    image=right4;
                }
                if(spriteNum == 5) {
                    image=right5;
                }
                if(spriteNum == 6) {
                    image=right6;
                }
                if(spriteNum == 7) {
                    image=right7;
                }
                if(spriteNum == 8) {
                    image=right8;
                }
                if(spriteNum == 9) {
                    image=right9;
                }
                break;
        }
        g2.drawImage(image, screenX,screenY, gp.tileSize, gp.tileSize, null);
    }
}
