package main;

import main.pages.Fields;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Play {

    public Fields fields = PageFactory.initElements(Utils.driver, Fields.class);
    Actions actions = new Actions(Utils.driver);

    public void play(){
        fields.playField[2][2].click();
        flagScanAll();
        if (fields.playField[2][17]!=null && fields.playField[2][17].getAttribute("class").contains("hd_closed")){
            fields.playField[2][17].click();
            flagScanAll();
        }
        if (fields.playField[17][2]!=null && fields.playField[17][2].getAttribute("class").contains("hd_closed")){
            fields.playField[17][2].click();
            flagScanAll();
        }
        if (fields.playField[17][17]!=null && fields.playField[17][17].getAttribute("class").contains("hd_closed")){
            fields.playField[17][17].click();
            flagScanAll();
        }
        if (fields.playField[9][9]!=null && fields.playField[9][9].getAttribute("class").contains("hd_closed")){
            fields.playField[9][9].click();
            flagScanAll();
        }
        flagScanAll();
        while(true){
            int x = (int) ((Math.random() * (17)) + 2);
            int y = (int) ((Math.random() * (17)) + 2);
            if (fields.playField[x][y]!=null && fields.playField[x][y].getAttribute("class").contains("hd_closed")){
                fields.playField[x][y].click();
                flagScanAll();
            }
        }

    }

    public void flagCheck(int x, int y, int bombs){
        int counter = 0;
        for (int tempx = x-1;tempx<x+2;tempx++){
            for (int tempy = y-1;tempy<y+2;tempy++){
                if (fields.getPlayField()[tempx][tempy]==null ||
                        fields.getPlayField()[tempx][tempy].getAttribute("class").equals("cell size24 hd_closed")){
                    counter++;
                }
            }
        }
        if ((x==17||x==2)&&(y==17||y==2)){
            counter-=5;
        } else if (x==17||x==2||y==17||y==2){
            counter-=3;
        }
        if (counter==bombs){
            for (int tempx = x-1;tempx<x+2;tempx++){
                for (int tempy = y-1;tempy<y+2;tempy++){
                    if (fields.getPlayField()[tempx][tempy]==null){
                        continue;
                    }
                    if (fields.getPlayField()[tempx][tempy].getAttribute("class").equals("cell size24 hd_closed")){
                        fields.playField[tempx][tempy] = null;
                        safeCheck(tempx,tempy);
                    }
                }
            }
        }
    }

    private void safeCheck(int x, int y) {
        for (int tempx = x-1;tempx<x+2;tempx++){
            for (int tempy = y-1;tempy<y+2;tempy++){
                if (fields.getPlayField()[tempx][tempy]==null || fields.getPlayField()[tempx][tempy].getAttribute("class").equals("cell size24 hd_closed")){
                    continue;
                }
                int counter = Integer.parseInt(String.valueOf(fields.getPlayField()[tempx][tempy].getAttribute("class").charAt(fields.getPlayField()[tempx][tempy].getAttribute("class").length()-1)));
                for (int tempx2 = tempx-1;tempx2<tempx+2;tempx2++){
                    for (int tempy2 = tempy-1;tempy2<tempy+2;tempy2++){
                        if (fields.getPlayField()[tempx2][tempy2]==null){
                            counter--;
                        }
                    }
                }
                if ((tempx==17||tempx==2)&&(tempy==17||tempy==2)){
                    counter+=5;
                } else if (tempx==17||tempx==2||tempy==17||tempy==2){
                    counter+=3;
                }
                if (counter==0){
                    for (int tempx2 = tempx-1;tempx2<tempx+2;tempx2++){
                        for (int tempy2 = tempy-1;tempy2<tempy+2;tempy2++){
                            if (fields.getPlayField()[tempx2][tempy2]==null){
                                continue;
                            }
                            if (fields.getPlayField()[tempx2][tempy2].getAttribute("class").equals("cell size24 hd_closed")){
                                fields.playField[tempx2][tempy2].click();
                                flagScanA25(tempx2,tempy2);
                            }
                        }
                    }
                }
            }
        }
    }

    public void flagScanA25(int x, int y) {
        for (int tempx = x-2;tempx<x+3;tempx++){
            for (int tempy = y-2;tempy<y+3;tempy++){
                if (fields.getPlayField()[tempx][tempy]!=null && fields.getPlayField()[tempx][tempy].getAttribute("class").contains("opened") && !fields.getPlayField()[tempx][tempy].getAttribute("class").contains("0")) {
                    int bombs = Integer.parseInt(String.valueOf(fields.getPlayField()[tempx][tempy].getAttribute("class").charAt(fields.getPlayField()[tempx][tempy].getAttribute("class").length() - 1)));
                    flagCheck( tempx,  tempy,  bombs);
                }
            }
        }
    }


    public void flagScanAll() {
        for (int y = 2; y < 17; y++) {
            for (int x = 2; x < 17; x++) {
                if (fields.getPlayField()[x][y]!=null && fields.getPlayField()[x][y].getAttribute("class").contains("opened") && !fields.getPlayField()[x][y].getAttribute("class").contains("0")) {
                    int bombs = Integer.parseInt(String.valueOf(fields.getPlayField()[x][y].getAttribute("class").charAt(fields.getPlayField()[x][y].getAttribute("class").length() - 1)));
                    flagCheck( x,  y,  bombs);
                }
            }
        }
    }

    public void viewAll(){
        for (int y = 2; y<17; y++){
            for (int x = 2; x<17; x++){
                if (fields.getPlayField()[x][y]==null){
                    System.out.print("F ");
                } else if (fields.getPlayField()[x][y].getAttribute("class").contains("opened")){
                    System.out.print(fields.getPlayField()[x][y].getAttribute("class").charAt(fields.getPlayField()[x][y].getAttribute("class").length()-1) + " ");
                } else if (fields.getPlayField()[x][y].getAttribute("class").equals("cell size24 hd_closed")){
                    System.out.print("☐ ");
                } else{
                    System.out.print("x ");
                }
            }
            System.out.print("\n");
        }
    }
}
