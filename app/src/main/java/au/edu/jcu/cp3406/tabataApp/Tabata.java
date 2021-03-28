package au.edu.jcu.cp3406.tabataApp;

import androidx.annotation.NonNull;

import java.util.Locale;

public class Tabata {
    private final int workTime, restTime;
    public int roundsToWork, round, tickW, tickR, time;

    public Tabata(int roundsToWork, int workTime, int restTime) { //default constructor.
        this.roundsToWork = roundsToWork;
        this.workTime = workTime;
        this.restTime = restTime;
    }

    public Tabata(int roundsToWork, int workTime, int restTime, int time, int tickW, int tickR, int round) { //Saved instance constructor.
        this.roundsToWork = roundsToWork;
        this.workTime = workTime;
        this.restTime = restTime;
        this.time = time;
        this.tickW = tickW;
        this.tickR = tickR;
        this.round = round;
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

    public int getWorkTime() { //workTime getter.
        return workTime;
    }

    public int getRestTime() { //restTime getter.
        return restTime;
    }

    public int getRoundsToWork() { //roundsToWork getter.
        return roundsToWork;
    }

    public int getTime() { //time getter.
        return time;
    }

    public int getTickW() { //tickW getter.
        return tickW;
    }

    public int getTickR() { //tickR getter.
        return tickR;
    }
    public int getRound() { //round getter
        return round;
    }

    @NonNull
    @Override
    public String toString() { //returns a string format of the current time.
        return String.format(Locale.getDefault(), "%02d:%02d", (time / 60), (time % 60));
    }
}
