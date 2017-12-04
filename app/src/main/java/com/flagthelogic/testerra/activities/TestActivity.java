package com.flagthelogic.testerra.activities;

 import android.content.Intent;
 import android.support.annotation.IdRes;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.util.Log;
 import android.util.SparseIntArray;
 import android.view.View;
 import android.widget.Button;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.TextView;

 import com.flagthelogic.testerra.App;
 import com.flagthelogic.testerra.R;
 import com.flagthelogic.testerra.Utils;
 import com.flagthelogic.testerra.database.entities.Question;

 import java.util.List;

 import static com.flagthelogic.testerra.App.DEFAULT_TID;


public class TestActivity extends AppCompatActivity implements View.OnClickListener{
    TextView loadedTestTV;
    Button undoBtn;
    RadioGroup radioGroup;

    private static final String TAG = "Test Actually";
    private List<Question>  questions = null;
    private SparseIntArray results = new SparseIntArray();
    private int currentQId = -1;
    boolean isProgramatycalCheck = false;
    int tid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        tid = intent.getIntExtra("tid", DEFAULT_TID);
        loadedTestTV = findViewById(R.id.textView3);
        radioGroup = findViewById(R.id.radioGroup);
        undoBtn = findViewById(R.id.undoBtn);

        undoBtn.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                Log.e(TAG, "rb  checked, isProgramatycalCheck: " + isProgramatycalCheck);
                if (!isProgramatycalCheck) {
                    saveQuestionResult(currentQId, id);
                    fillViews(false);
                } else {
                    isProgramatycalCheck = false;
                }
            }
        });
//        tid = TODO
        new Thread(new Runnable() {
            @Override
            public void run() {
                questions = App.getDB().questionsDao().getQuestionsForTest(tid);
                Log.e(TAG, "start "+questions.size());
                fillViews(false);
            }
        }).start();
    }

    void fillViews(final boolean isBackStep){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                currentQId = isBackStep ? currentQId - 1 : currentQId + 1;
                isProgramatycalCheck = results.indexOfKey(currentQId) < 0;
                if (!questions.isEmpty() && currentQId >= 0 && currentQId < questions.size()) {
                    Log.e(TAG, "FILL");
                    loadedTestTV.setText(questions.get(currentQId).getQuestion());
                    radioGroup.removeAllViews();
                    for (Question.Options o : questions.get(currentQId).getOptions()) {
                        RadioButton radioButton = new RadioButton(getBaseContext());
                        radioButton.setText(o.getTitle());
                        radioButton.setId(o.getId());
                        if (isBackStep && results.get(currentQId) == o.getId())
                            radioButton.setChecked(true);
                        radioGroup.addView(radioButton);
                    }
                } else if (currentQId >= questions.size()){
                    Log.e(TAG, "ACTIVITY CHANGE - to Result screen " + currentQId + " size: " + questions.size());
//                    Toast.makeText(getApplicationContext(), "Asdasd" + results.toString(), Toast.LENGTH_LONG).show();
                    toTestResults();
                } else {
                    Log.e(TAG, "ACTIVITY CHANGE - to Test description");
                    toTestDescription();
                }
            }
        });
    }

    // TODO
    // вызов подсчета результатов
    // переход к результату пользователя
    private void toTestResults() {
        Intent intent = new Intent(this, TestResultActivity.class);
        intent.putExtra("tid", tid);
        intent.putExtra("test_results", Utils.sparseIntArrToIntArr(results));
        startActivity(intent);
    }

    // TODO
    // переход к описанию теста tid
    private void toTestDescription() {
        Intent intent = new Intent(this, TestDescriptionActivity.class);
        intent.putExtra("tid", tid);
        startActivity(intent);
    }

    private void saveQuestionResult(int qId, int id) {
        Log.e(TAG, "saved:  {" + qId + " : " + id + "}");
        results.append(qId, id);
        Log.e(TAG, "results: " + results.toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.undoBtn:
                Log.e(TAG, "<---");
                fillViews(true);
                break;
        }
    }
}

// добавление вопроса
//    final Question question = new Question();
//        question.setqId(2);
//        question.settId(1);
//        question.setQuestion("question 2");
//
//        final ArrayList<Question.Options> options1 = new ArrayList<>();
//        options1.add(new Question.Options(1,"t1"));
//        options1.add(new Question.Options(2,"t2"));
//        options1.add(new Question.Options(3,"t3"));
//        question.setOptions(options1);
