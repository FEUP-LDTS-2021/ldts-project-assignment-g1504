

public class SnakeModel {
    private boolean ateApple = false;
    private boolean SnakeCollided = false;
    private Powers power;
    private boolean SnakeAlive = true;
    private int speed = 10;




    public SnakeModel(){

    }


    public boolean isSnakeAlive(){
        return SnakeAlive;
    }
    public void kill(){
        this.SnakeAlive = false;
    }

    public boolean isSnakeCollided(){
        return SnakeCollided;
    }
    public void setAte(boolean ate){
        this.ateApple = ate;
    }
    public boolean getAte(){
        return ateApple;
    }
    public int getSpeed(){return speed;}
    public void setSpeed(int speed){this.speed = speed;}
    public Powers getPower(){return power;}
    public void setPower(Powers power) {
        this.power = power;

        if(power == Powers.SPEED){
            setSpeed(20);
            //Timer.
        }

        else {setSpeed(10);}
    }
}
