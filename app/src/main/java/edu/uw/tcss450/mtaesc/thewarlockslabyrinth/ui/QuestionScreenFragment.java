package edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui;

import static android.app.PendingIntent.getActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.R;
import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.databinding.FragmentNewGameBinding;
import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.databinding.FragmentQuestionsScreenBinding;
import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game.Door;
import edu.uw.tcss450.mtaesc.thewarlockslabyrinth.ui.game.Question;

public class QuestionScreenFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = NewGameFragment.class.getSimpleName();

    /*
    TODO: where questions are displayed for chosen door.
        -Displays question, has buttons to choose true/false
        -EX: it's like the user's contact chosen from the contact list in TCSS450 proj
     */

    private ImageButton questionPic;
    private Button falseBtn;
    private Button trueBtn;

    //TODO: implement:
    private Button goBackBtn;
    private Button goForwardBtn;

    private TextView questionText;

    private int correctAns = 0;
    private int currentQuestionIndex = 0; //current index of question in q array

    // TODO: Make index of room to change door color. Start default at 0, when enter another room in any direction add 1 to change to different color. When move to different room the index is subtracted back to 0 and changed to the original color.
    int[] evenDoors = {R.drawable.door_1, R.drawable.door_2, R.drawable.door_3, R.drawable.door_4};

    int[] oddDoors = {R.drawable.door_1_alt, R.drawable.door_2_alt, R.drawable.door_3_alt, R.drawable.door_4_alt};

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

//    Door door = new Door(evenDoors, oddDoors, q);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_questions_screen);
    // Fragment locked in landscape screen orientation
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions_screen, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //TODO: register buttons to listen to click events
        falseBtn = (Button) getView().findViewById(R.id.falseBtn);
        trueBtn = (Button) getView().findViewById(R.id.trueBtn);
        falseBtn.setOnClickListener(this);
        trueBtn.setOnClickListener(this);

        goBackBtn = (Button) getView().findViewById(R.id.goBackBtn);
        goForwardBtn = (Button) getView().findViewById(R.id.goForwardBtn);
        goBackBtn.setOnClickListener(this);
        goForwardBtn.setOnClickListener(this);
        //default invisible until question is answered
        goForwardBtn.setVisibility(View.INVISIBLE);
        goForwardBtn.setVisibility(View.INVISIBLE);

        questionText = (TextView) getView().findViewById(R.id.answerText);
//        questionPic = (ImageButton) getView().findViewById(R.id.questions_background);

        FragmentQuestionsScreenBinding binding = FragmentQuestionsScreenBinding.bind(requireView());

        //TODO: back button to prev room
        binding.goBackBtn.setOnClickListener(button ->
                Navigation.findNavController(requireView()).navigate(
                        QuestionScreenFragmentDirections.actionNavigationQuestionScreenFragmentToNavigationNewGame()));

        //TODO: enter button to new room
        binding.goForwardBtn.setOnClickListener(button ->
                Navigation.findNavController(requireView()).navigate(
                        QuestionScreenFragmentDirections.actionNavigationQuestionScreenFragmentToNavigationNewGame()));
    }

    @Override
    public void onClick(View view) {
        //check what button the user clicks w/ switch case
        switch (view.getId()) {
            case R.id.falseBtn:
                checkUserAnswer(false);
                endResults();
                break;
            case R.id.trueBtn:
                checkUserAnswer(true);
                endResults();
                break;
            case R.id.goBackBtn:
                //todo
//
                break;
            case R.id.goForwardBtn:
                //todo
        }
    }

    /**
     * TODO: get question from q[], based on what door the user is at.
     * @return
     */
    private int getQuestion() {
        //TODO: right now, just 1 question
        Question que = new Question(R.string.questionText, q[0].getAnswerTrue());
        return que.getQuestionID();
    }

    /**
        TODO: Shows if user won the game or not, based on doors locked. For now just check number of answers guessed correctly
     */
    private void endResults() {
        //go to next door, only 4 doors
        if (currentQuestionIndex < 5) {
            currentQuestionIndex++;
            //if failed majority of questions, TODO: add accurate # of q's
            if (correctAns == 0) {
                questionText.setText(getString(R.string.endBad));
                falseBtn.setVisibility(View.INVISIBLE);
                trueBtn.setVisibility(View.INVISIBLE);
                goBackBtn.setVisibility(View.VISIBLE);

            } else {
                questionText.setText(getString(R.string.endGood, correctAns));
                falseBtn.setVisibility(View.INVISIBLE);
                trueBtn.setVisibility(View.INVISIBLE);
                goForwardBtn.setVisibility(View.VISIBLE);
                goBackBtn.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * Based on result of question gives buttons on leaving or entering the door.
     *      - If answered correct, then get option to go back or go forward.
     *      - If answered incorrectly, then get only a go back button and update background to locked_question_background.jpg
     */
    private void btnsAfterQuestionAnswered() {

    }

    /**
     * checks if user answered correctly and pops up message of success or not.
     *
     * @param userCorrectAns
     */
    private void checkUserAnswer(boolean userCorrectAns) {
        boolean trueAns = q[currentQuestionIndex].getAnswerTrue();
        int toastMessageID;

        if (userCorrectAns == trueAns) {
            toastMessageID = R.string.correct_answer;
            correctAns++; //increase counter of answers that user got right
        } else {
            toastMessageID = R.string.wrong_answer;
        }

        Toast.makeText(getActivity(), toastMessageID, Toast.LENGTH_SHORT).show(); //pop up to inform user if what answer they chose was correct or not
    }
}
