package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.databinding.FragmentNewGameBinding;
import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game.Question;
import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.R;
//import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game.MainThread;

/**
 * A simple {@link Fragment} subclass.
 * SOURCE: https://www.geeksforgeeks.org/how-to-create-a-quiz-app-in-android/
 */
public class NewGameFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = NewGameFragment.class.getSimpleName();

//    private Button falseBtn;
//    private Button trueBtn;
    private ImageButton nextBtn;
    private ImageButton prevBtn;
    private ImageButton doorImage;
    private int currentDoorIndex = 0; //current index of door user is looking at

    /**
     set up array of questions w/ objects of Question class.
     EX: Question(Question ID text, correct answer boolean)
    */
    private Question[] q = new Question[] {
            //TODO: hook up database and put questions in QuestionID
            new Question(R.string.questionText, true), //QuestionID from string.xml
            new Question(R.string.questionText2, false),
            new Question(R.string.questionText3, true),
            new Question(R.string.questionText4, false),
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.fragment_new_game);

        // Fragment locked in landscape screen orientation
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //TODO: connect buttons with IDs (in activity)
//        falseBtn = (Button) getView().findViewById(R.id.falseBtn);
//        trueBtn = (Button) getView().findViewById(R.id.trueBtn);
        nextBtn = (ImageButton) getView().findViewById(R.id.next_button);
        prevBtn = (ImageButton) getView().findViewById(R.id.prev_button);

        //register buttons to listen to click events

//        questionText = (TextView) getView().findViewById(R.id.answerText);
        doorImage = (ImageButton) getView().findViewById(R.id.imagep);

//        falseBtn.setOnClickListener(this);
//        trueBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);

        FragmentNewGameBinding binding = FragmentNewGameBinding.bind(requireView());
        binding.imagep.setOnClickListener(button ->
                Navigation.findNavController(requireView()).navigate(
                        NewGameFragmentDirections.actionNavigationNewGameToNavigationQuestionScreenFragment()));
    }


    @Override
    public void onClick(View view) {
        //check what button the user clicks w/ switch case
        switch (view.getId()) {
            case R.id.next_button:
                //go to next door, only 4 doors
                if (currentDoorIndex < 3) {
                    currentDoorIndex++;
                    updateDoor();
                } else { //hit next when on door 4 (the last door) -> next goes back to beginning
                    currentDoorIndex = 0; //reset index to first door
                    updateDoor();
                }
                break;
            case R.id.prev_button:
                if (currentDoorIndex == 0) {
                    currentDoorIndex = 3; //last door
                    updateDoor();
                } else {
                    currentDoorIndex--;
                    updateDoor();
                }

        }
    }

    /**
     * Updates the door that the user is looking at and gives new question from q[].
     */
    private void updateDoor() {
        Log.d("Current", "onClick: " + currentDoorIndex);

        //switch case to set TextView with new question
        switch (currentDoorIndex) {
            case 0: //north
                doorImage.setImageResource(R.drawable.door_1);
                break;
            case 1: //east
                doorImage.setImageResource(R.drawable.door_2);
                break;
            case 2: //south
                doorImage.setImageResource(R.drawable.door_3);
                break;
            case 3: //west
                doorImage.setImageResource(R.drawable.door_4);
                break;
        }
    }
}