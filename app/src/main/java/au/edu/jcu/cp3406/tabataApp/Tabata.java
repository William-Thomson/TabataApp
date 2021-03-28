package au.edu.jcu.cp3406.tabataApp;

import androidx.annotation.NonNull;

import java.util.Locale;

public class Tabata {
    private final int workTime, restTime;
    public int roundToWork, round, tickW, tickR, time;

    public Tabata(int roundToWork, int workTime, int restTime) {
        this.roundToWork = roundToWork;
        this.workTime = workTime;
        this.restTime = restTime;

    }

    public void tick() { //Ticks through Work time, then rest time, to add round.
        if (tickW > workTime) {
            time = tickR++;
            if (tickR > restTime) {
                round++;
                tickW = tickR = 0;
            }
        } else {
            time = tickW++;
        }
    }

    public int getWorkTime() {
        return workTime;
    }

    public int getRestTime() {
        return restTime;
    }

    public int getRoundsToWork() {
        return roundToWork;
    }

    public int getTime() {
        return time;
    }

    public int getTickW() {
        return tickW;
    }

    public int getTickR() {
        return tickR;
    }


    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%02d:%02d", (time / 60), (time % 60));
    }


}
