package Score;

public class Tv {

    private boolean power;
    private int channel;

    boolean getPower(){
        return this.power;
    }

    int getChannel(){
        return this.channel;
    }

    void power(){
        power = !power;
    }

    void channelUp(){
        channel++;
    }

    void channelDown(){
        channel--;
    }

}
