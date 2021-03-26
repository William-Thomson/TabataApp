package au.edu.jcu.cp3406.tabataApp;

import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Locale;

public class Tabata {
    private final int roundToWork, workTime, restTime;
    public int workSeconds, round, tick;

    public Tabata(int roundToWork, int workTime, int restTime) {
        this.roundToWork = roundToWork;
        this.workTime = workTime;
        this.restTime = restTime;
        round = 0;
        this.tick = 0;
    }


    //TODO Tick()
    //TODO toString()


    public void tick() { //Ticks through Work time, then rest time, to add round.
        tick++;
        if (tick == workTime) {

        }
        }

//        workSeconds--;
//        if (workSeconds == 0) {
//            if (workMinutes > 0) {
//                workMinutes--;
//                workSeconds = 60;
//            } else { // TODO change display to rest time
//                restSeconds--;
//                if (restSeconds == 0) {
//
//                    if (restMinutes > 0) {
//                        restMinutes--;
//                        restSeconds = 60;
//                    } else { //TODO add round and restart timer
//                        round++;
//                        if (round < roundToWork) {
//                            convertWorkTime();
//                            convertRestTime();
//                        }
//                    }
//                }
//            }
//        }
//    }

        @NonNull
        @Override
        public String toString () {
            return String.format(Locale.getDefault(),"%02d:%02d", (tick/60), (tick%60) );
        }
    }
