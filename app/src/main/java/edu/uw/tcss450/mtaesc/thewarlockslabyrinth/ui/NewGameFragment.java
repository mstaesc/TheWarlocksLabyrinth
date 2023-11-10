package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.MainActivity;
import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.databinding.FragmentHomeBinding;
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
    private TextView questionText;

    private int correctAns = 0;
    private int currentQuestionIndex = 0; //current index of question in q array

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
                if (currentQuestionIndex < 5) {
                    currentQuestionIndex++;

                    if (currentQuestionIndex == 4) { //reached last door
                        questionText.setText(getString(R.string.endGood, correctAns));
//                        falseBtn.setVisibility(View.INVISIBLE);
//                        trueBtn.setVisibility(View.INVISIBLE);
                        nextBtn.setVisibility(View.INVISIBLE);
                        prevBtn.setVisibility(View.INVISIBLE);

                        //if failed majority of questions, TODO: add accurate # of q's
                        if (correctAns == 0) {
                            questionText.setText(getString(R.string.endBad));
                        }
                    } else {
                        updateDoor();
                    }
                }
                break;
            case R.id.prev_button:
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex = (currentQuestionIndex--) % q.length;
                    updateDoor();
                }

        }
    }

    /**
     * Updates the door that the user is looking at and gives new question from q[].
     */
    private void updateDoor() {
        Log.d("Current", "onClick: " + currentQuestionIndex);
        questionText.setText(q[currentQuestionIndex].getQuestionID());

        //switch case to set TextView with new question
        switch (currentQuestionIndex) {
            case 1: //north
                doorImage.setImageResource(R.drawable.door_1);
                break;
            case 2: //east
                doorImage.setImageResource(R.drawable.door_2);
                break;
            case 3: //south
                doorImage.setImageResource(R.drawable.door_3);
                break;
            case 4: //west
                doorImage.setImageResource(R.drawable.door_4);
                break;
        }
    }
}