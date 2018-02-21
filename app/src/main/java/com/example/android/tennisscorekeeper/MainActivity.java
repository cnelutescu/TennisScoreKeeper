package com.example.android.tennisscorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int serve = 0;
    int setLim = 2;        // 2 = 2/3,  3 = 3/5
    int setsWinPlayerA = 0;
    int setsWinPlayerB = 0;
    int gameOver = 0;
    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int acePlayerA = 0;
    int acePlayerB = 0;
    int faultPlayerA = 0;
    int faultPlayerB = 0;
    int doublePlayerA = 0;
    int doublePlayerB = 0;
    int nrSet = 1;
    int set1PlayerA = 0;
    int set2PlayerA = 0;
    int set3PlayerA = 0;
    int set4PlayerA = 0;
    int set5PlayerA = 0;
    int set1PlayerB = 0;
    int set2PlayerB = 0;
    int set3PlayerB = 0;
    int set4PlayerB = 0;
    int set5PlayerB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // display all zero:
        TextView scoreView = findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(scorePlayerA));
        scoreView = findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(scorePlayerB));
        scoreView = findViewById(R.id.player_a_ace);
        scoreView.setText(String.valueOf(acePlayerA));
        scoreView = findViewById(R.id.player_b_ace);
        scoreView.setText(String.valueOf(acePlayerB));
        scoreView = findViewById(R.id.player_a_fault);
        scoreView.setText(String.valueOf(faultPlayerA));
        scoreView = findViewById(R.id.player_b_fault);
        scoreView.setText(String.valueOf(faultPlayerB));
        scoreView = findViewById(R.id.player_a_double);
        scoreView.setText(String.valueOf(doublePlayerA));
        scoreView = findViewById(R.id.player_b_double);
        scoreView.setText(String.valueOf(doublePlayerB));
        scoreView = findViewById(R.id.playerA_set1);
        scoreView.setText(String.valueOf(set1PlayerA));
        scoreView = findViewById(R.id.playerA_set2);
        scoreView.setText(String.valueOf(set2PlayerA));
        scoreView = findViewById(R.id.playerA_set3);
        scoreView.setText(String.valueOf(set3PlayerA));
        scoreView = findViewById(R.id.playerA_set4);
        scoreView.setText(String.valueOf(set4PlayerA));
        scoreView = findViewById(R.id.playerA_set5);
        scoreView.setText(String.valueOf(set5PlayerA));
        scoreView = findViewById(R.id.playerB_set1);
        scoreView.setText(String.valueOf(set1PlayerB));
        scoreView = findViewById(R.id.playerB_set2);
        scoreView.setText(String.valueOf(set2PlayerB));
        scoreView = findViewById(R.id.playerB_set3);
        scoreView.setText(String.valueOf(set3PlayerB));
        scoreView = findViewById(R.id.playerB_set4);
        scoreView.setText(String.valueOf(set4PlayerB));
        scoreView = findViewById(R.id.playerB_set5);
        scoreView.setText(String.valueOf(set5PlayerB));
        //------ Player A serve
        ImageView ima = findViewById(R.id.team_a_serve);
        ima.setVisibility(View.VISIBLE);
        ImageView imb = findViewById(R.id.team_b_serve);
        imb.setVisibility(View.INVISIBLE);
    }

    /**
     * Increase the score for Player A by 1 point.
     */
    public void setPointPlayerA(View v) {
        RadioButton radioButton = findViewById(R.id.yes_radio_button);     // get 2/3
        if (radioButton.isChecked()) {
            setLim = 2;     // match 2/3
        } else {
            setLim = 3;     // match 3/5
        }
        if (gameOver == 0) {
            TextView scoreViewA = findViewById(R.id.player_a_score);
            TextView scoreViewB = findViewById(R.id.player_b_score);
            switch (scorePlayerA) {
                case 0:
                    scorePlayerA = 15;
                    scoreViewA.setText(String.valueOf(scorePlayerA));
                    break;
                case 15:
                    scorePlayerA = 30;
                    scoreViewA.setText(String.valueOf(scorePlayerA));
                    break;
                case 30:
                    scorePlayerA = 40;
                    scoreViewA.setText(String.valueOf(scorePlayerA));
                    break;
                case 40:
                    if (scorePlayerB == 40) {           // Advantage
                        scorePlayerA = 50;
                        scoreViewA.setText(R.string.advantage);
                        break;
                    } else if (scorePlayerB == 50) {    //40 love
                        scorePlayerB = 40;
                        scoreViewB.setText(String.valueOf(scorePlayerB));
                        break;
                    }       // Continue to case 50 -->
                case 50:    // Player A win the game!
                    // init after win the game
                    scorePlayerA = 0;
                    scoreViewA.setText(String.valueOf(scorePlayerA));
                    scorePlayerB = 0;
                    scoreViewB.setText(String.valueOf(scorePlayerB));
                    displayServe();
                    switch (nrSet) {    // Increment game nr. and Check if current Set ended
                        case 1:
                            set1PlayerA = set1PlayerA + 1;
                            if (set1PlayerA > 5 && ((set1PlayerA - set1PlayerB) >= 2)) {
                                nrSet = 2;
                                setsWinPlayerA = setsWinPlayerA + 1;
                            }
                            break;
                        case 2:
                            set2PlayerA = set2PlayerA + 1;
                            if (set2PlayerA > 5 && ((set2PlayerA - set2PlayerB) >= 2)) {
                                nrSet = 3;
                                setsWinPlayerA = setsWinPlayerA + 1;
                                if (setsWinPlayerA == setLim) {
                                    displayGameOver();  // Player A win the match!
                                }
                            }
                            break;
                        case 3:
                            set3PlayerA = set3PlayerA + 1;
                            if (set3PlayerA > 5 && ((set3PlayerA - set3PlayerB) >= 2)) {
                                nrSet = 4;
                                setsWinPlayerA = setsWinPlayerA + 1;
                                if (setsWinPlayerA == setLim) {
                                    displayGameOver();  // Player A win the match!
                                }
                            }
                            break;
                        case 4:
                            set4PlayerA = set4PlayerA + 1;
                            if (set4PlayerA > 5 && ((set4PlayerA - set4PlayerB) >= 2)) {
                                nrSet = 5;
                                setsWinPlayerA = setsWinPlayerA + 1;
                                if (setsWinPlayerA == setLim) {
                                    displayGameOver();  // Player A win the match!
                                }
                            }
                            break;
                        case 5:
                            set5PlayerA = set5PlayerA + 1;
                            if (set5PlayerA > 5 && ((set5PlayerA - set5PlayerB) >= 2)) {
                                nrSet = 6;
                                setsWinPlayerA = setsWinPlayerA + 1;
                                if (setsWinPlayerA == 3) {
                                    displayGameOver();     // Player A win the match!
                                }
                            }
                            break;
                    }
            }
            displaySets();
        }
    }

    /**
     * Increase the score for Player B by 1 point.
     */
    public void setPointPlayerB(View v) {
        RadioButton radioButton = findViewById(R.id.yes_radio_button);     // get 2/3
        if (radioButton.isChecked()) {
            setLim = 2;     // match 2/3
        } else {
            setLim = 3;     // match 3/5
        }
        if (gameOver == 0) {
            TextView scoreViewA = findViewById(R.id.player_a_score);
            TextView scoreViewB = findViewById(R.id.player_b_score);
            switch (scorePlayerB) {
                case 0:
                    scorePlayerB = 15;
                    scoreViewB.setText(String.valueOf(scorePlayerB));
                    break;
                case 15:
                    scorePlayerB = 30;
                    scoreViewB.setText(String.valueOf(scorePlayerB));
                    break;
                case 30:
                    scorePlayerB = 40;
                    scoreViewB.setText(String.valueOf(scorePlayerB));
                    break;
                case 40:
                    if (scorePlayerA == 40) {           // Advantage
                        scorePlayerB = 50;
                        scoreViewB.setText(R.string.advantage);
                        break;
                    } else if (scorePlayerA == 50) {    //40 love
                        scorePlayerA = 40;
                        scoreViewA.setText(String.valueOf(scorePlayerA));
                        break;
                    }       // Continue to case 50 -->
                case 50:    // Player B win the game!
                    // init after win the game
                    scorePlayerA = 0;
                    scoreViewA.setText(String.valueOf(scorePlayerA));
                    scorePlayerB = 0;
                    scoreViewB.setText(String.valueOf(scorePlayerB));
                    displayServe();
                    switch (nrSet) {
                        case 1:      // Increment game nr. and Check if current Set ended
                            set1PlayerB = set1PlayerB + 1;
                            if (set1PlayerB > 5 && ((set1PlayerB - set1PlayerA) >= 2)) {
                                nrSet = 2;
                                setsWinPlayerB = setsWinPlayerB + 1;
                            }
                            break;
                        case 2:
                            set2PlayerB = set2PlayerB + 1;
                            if (set2PlayerB > 5 && ((set2PlayerB - set2PlayerA) >= 2)) {
                                nrSet = 3;
                                setsWinPlayerB = setsWinPlayerB + 1;
                                if (setsWinPlayerB == setLim) {
                                    displayGameOver();    // Player B win the match!
                                }
                            }
                            break;
                        case 3:
                            set3PlayerB = set3PlayerB + 1;
                            if (set3PlayerB > 5 && ((set3PlayerB - set3PlayerA) >= 2)) {
                                nrSet = 4;
                                setsWinPlayerB = setsWinPlayerB + 1;
                                if (setsWinPlayerB == setLim) {
                                    displayGameOver();    // Player B win the match!
                                }
                            }
                            break;
                        case 4:
                            set4PlayerB = set4PlayerB + 1;
                            if (set4PlayerB > 5 && ((set4PlayerB - set4PlayerA) >= 2)) {
                                nrSet = 5;
                                setsWinPlayerB = setsWinPlayerB + 1;
                                if (setsWinPlayerB == setLim) {
                                    displayGameOver();      // Player B win the match!
                                }
                            }
                            break;
                        case 5:
                            set5PlayerB = set5PlayerB + 1;
                            if (set5PlayerB > 5 && ((set5PlayerB - set5PlayerA) >= 2)) {
                                nrSet = 6;
                                setsWinPlayerB = setsWinPlayerB + 1;
                                if (setsWinPlayerB == 3) {
                                    displayGameOver();    // Player B win the match!
                                }
                            }
                            break;
                    }
            }
            displaySets();
        }
    }

    /**
     * Increase the aces for Player A by 1 point.
     */
    public void setAcePlayerA(View v) {
        if (gameOver == 0) {
            acePlayerA = acePlayerA + 1;
            TextView scoreView = findViewById(R.id.player_a_ace);
            scoreView.setText(String.valueOf(acePlayerA));
        }
    }

    /**
     * Increase the aces for Player B by 1 point.
     */
    public void setAcePlayerB(View v) {
        if (gameOver == 0) {
            acePlayerB = acePlayerB + 1;
            TextView scoreView = findViewById(R.id.player_b_ace);
            scoreView.setText(String.valueOf(acePlayerB));
        }
    }

    /**
     * Increase the faults for Player A by 1 point.
     */
    public void setFaultPlayerA(View v) {
        if (gameOver == 0) {
            faultPlayerA = faultPlayerA + 1;
            TextView scoreView = findViewById(R.id.player_a_fault);
            scoreView.setText(String.valueOf(faultPlayerA));
        }
    }

    /**
     * Increase the faults for Player B by 1 point.
     */
    public void setFaultPlayerB(View v) {
        if (gameOver == 0) {
            faultPlayerB = faultPlayerB + 1;
            TextView scoreView = findViewById(R.id.player_b_fault);
            scoreView.setText(String.valueOf(faultPlayerB));
        }
    }

    /**
     * Increase the doubles for Player A by 1 point.
     */
    public void setDoublePlayerA(View v) {
        if (gameOver == 0) {
            doublePlayerA = doublePlayerA + 1;
            TextView scoreView = findViewById(R.id.player_a_double);
            scoreView.setText(String.valueOf(doublePlayerA));
        }
    }

    /**
     * Increase the doubles for Player B by 1 point.
     */
    public void setDoublePlayerB(View v) {
        if (gameOver == 0) {
            doublePlayerB = doublePlayerB + 1;
            TextView scoreView = findViewById(R.id.player_b_double);
            scoreView.setText(String.valueOf(doublePlayerB));
        }
    }

    /**
     * Reset scorePlayerA and scorePlayerB.
     */
    public void resetScore(View v) {
        setsWinPlayerA = 0;
        setsWinPlayerB = 0;
        gameOver = 0;
        scorePlayerA = 0;
        scorePlayerB = 0;
        acePlayerA = 0;
        acePlayerB = 0;
        faultPlayerA = 0;
        faultPlayerB = 0;
        doublePlayerA = 0;
        doublePlayerB = 0;
        nrSet = 1;
        set1PlayerA = 0;
        set2PlayerA = 0;
        set3PlayerA = 0;
        set4PlayerA = 0;
        set5PlayerA = 0;
        set1PlayerB = 0;
        set2PlayerB = 0;
        set3PlayerB = 0;
        set4PlayerB = 0;
        set5PlayerB = 0;
        TextView scoreView = findViewById(R.id.player_a_score);
        scoreView.setText(String.valueOf(scorePlayerA));
        scoreView = findViewById(R.id.player_b_score);
        scoreView.setText(String.valueOf(scorePlayerB));
        scoreView = findViewById(R.id.player_a_ace);
        scoreView.setText(String.valueOf(acePlayerA));
        scoreView = findViewById(R.id.player_b_ace);
        scoreView.setText(String.valueOf(acePlayerB));
        scoreView = findViewById(R.id.player_a_fault);
        scoreView.setText(String.valueOf(faultPlayerA));
        scoreView = findViewById(R.id.player_b_fault);
        scoreView.setText(String.valueOf(faultPlayerB));
        scoreView = findViewById(R.id.player_a_double);
        scoreView.setText(String.valueOf(doublePlayerA));
        scoreView = findViewById(R.id.player_b_double);
        scoreView.setText(String.valueOf(doublePlayerB));
        scoreView = findViewById(R.id.playerA_set1);
        scoreView.setText(String.valueOf(set1PlayerA));
        scoreView = findViewById(R.id.playerA_set2);
        scoreView.setText(String.valueOf(set2PlayerA));
        scoreView = findViewById(R.id.playerA_set3);
        scoreView.setText(String.valueOf(set3PlayerA));
        scoreView = findViewById(R.id.playerA_set4);
        scoreView.setText(String.valueOf(set4PlayerA));
        scoreView = findViewById(R.id.playerA_set5);
        scoreView.setText(String.valueOf(set5PlayerA));
        scoreView = findViewById(R.id.playerB_set1);
        scoreView.setText(String.valueOf(set1PlayerB));
        scoreView = findViewById(R.id.playerB_set2);
        scoreView.setText(String.valueOf(set2PlayerB));
        scoreView = findViewById(R.id.playerB_set3);
        scoreView.setText(String.valueOf(set3PlayerB));
        scoreView = findViewById(R.id.playerB_set4);
        scoreView.setText(String.valueOf(set4PlayerB));
        scoreView = findViewById(R.id.playerB_set5);
        scoreView.setText(String.valueOf(set5PlayerB));
        //------ Display Player A and Player B
        TextView playerAView = findViewById(R.id.player_a);
        playerAView.setText(R.string.player_a);
        TextView playerBView = findViewById(R.id.player_b);
        playerBView.setText(R.string.player_b);
        //------ Player A serve
        ImageView ima = findViewById(R.id.team_a_serve);
        ima.setVisibility(View.VISIBLE);
        ImageView imb = findViewById(R.id.team_b_serve);
        imb.setVisibility(View.INVISIBLE);
    }

    /**
     * Display  sets for Player A and B
     */
    public void displaySets() {
        TextView scoreView = findViewById(R.id.playerA_set1);
        scoreView.setText(String.valueOf(set1PlayerA));
        scoreView = findViewById(R.id.playerA_set2);
        scoreView.setText(String.valueOf(set2PlayerA));
        scoreView = findViewById(R.id.playerA_set3);
        scoreView.setText(String.valueOf(set3PlayerA));
        scoreView = findViewById(R.id.playerA_set4);
        scoreView.setText(String.valueOf(set4PlayerA));
        scoreView = findViewById(R.id.playerA_set5);
        scoreView.setText(String.valueOf(set5PlayerA));
        scoreView = findViewById(R.id.playerB_set1);
        scoreView.setText(String.valueOf(set1PlayerB));
        scoreView = findViewById(R.id.playerB_set2);
        scoreView.setText(String.valueOf(set2PlayerB));
        scoreView = findViewById(R.id.playerB_set3);
        scoreView.setText(String.valueOf(set3PlayerB));
        scoreView = findViewById(R.id.playerB_set4);
        scoreView.setText(String.valueOf(set4PlayerB));
        scoreView = findViewById(R.id.playerB_set5);
        scoreView.setText(String.valueOf(set5PlayerB));
    }

    /**
     * Display  ball for player to serve
     */
    public void displayServe() {
        if (serve == 0) {
            serve = 1;
            //------ Player B serve
            ImageView ima = findViewById(R.id.team_a_serve);
            ima.setVisibility(View.INVISIBLE);
            ImageView imb = findViewById(R.id.team_b_serve);
            imb.setVisibility(View.VISIBLE);
        } else {
            serve = 0;
            //------ Player A serve
            ImageView ima = findViewById(R.id.team_a_serve);
            ima.setVisibility(View.VISIBLE);
            ImageView imb = findViewById(R.id.team_b_serve);
            imb.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Display  Game Over and sets score
     */
    public void displayGameOver() {
        gameOver = 1;
        TextView playerAView = findViewById(R.id.player_a);
        playerAView.setText(R.string.game);
        TextView playerBView = findViewById(R.id.player_b);
        playerBView.setText(R.string.over);
        TextView scoreViewA = findViewById(R.id.player_a_score);
        scoreViewA.setText(String.valueOf(setsWinPlayerA));
        TextView scoreViewB = findViewById(R.id.player_b_score);
        scoreViewB.setText(String.valueOf(setsWinPlayerB));
    }

}
