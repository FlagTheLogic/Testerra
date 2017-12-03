package com.flagthelogic.testerra.activities;

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
 import com.flagthelogic.testerra.database.entities.Questions;

 import java.util.List;


public class TestActivity extends AppCompatActivity implements View.OnClickListener{
    TextView loadedTestTV;
    Button undoBtn;
    RadioGroup radioGroup;

    private static final String TAG = "Test Actually";
    private List<Questions>  questions = null;
    private SparseIntArray results = new SparseIntArray();
    private int currentQId = -1;
    boolean isStepAfterBack = false;
    int testId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        loadedTestTV = findViewById(R.id.textView3);
        radioGroup = findViewById(R.id.radioGroup);
        undoBtn = findViewById(R.id.undoBtn);

        undoBtn.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id) {
                Log.e(TAG, "rb  checked, isStepAfterBack: " + isStepAfterBack);
                if (!isStepAfterBack) {
                    saveQuestionResult(currentQId, id);
                    fillViews(false);
                } else {
                    isStepAfterBack = false;
                }
            }
        });
//        testId = TODO
        new Thread(new Runnable() {
            @Override
            public void run() {
                questions = App.getDB().questionsDao().getQuestionsForTest(testId);
                fillViews(false);
            }
        }).start();
    }

    void fillViews(final boolean isBackStep){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isBackStep) {
                    currentQId--;
                    isStepAfterBack = true;
                } else currentQId++;
                if (!questions.isEmpty() && currentQId >= 0 && currentQId < questions.size()) {
                    Log.e(TAG, "FILL");
                    loadedTestTV.setText(questions.get(currentQId).getQuestion());
                    radioGroup.removeAllViews();
                    for (Questions.Options o : questions.get(currentQId).getOptions()) {
                        RadioButton radioButton = new RadioButton(getBaseContext());
                        radioButton.setText(o.getTitle());
                        radioButton.setId(o.getId());
                        if (isBackStep && results.get(currentQId) == o.getId())
                            radioButton.setChecked(true);
                        radioGroup.addView(radioButton);
                    }
                } else if (currentQId >= questions.size()){
                    Log.e(TAG, "ACTIVITY CHANGE - to Result screen");
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

    }

    // TODO
    // переход к описанию теста testId
    private void toTestDescription() {
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
//    final Questions question = new Questions();
//        question.setqId(2);
//        question.settId(1);
//        question.setQuestion("question 2");
//
//        final ArrayList<Questions.Options> options1 = new ArrayList<>();
//        options1.add(new Questions.Options(1,"t1"));
//        options1.add(new Questions.Options(2,"t2"));
//        options1.add(new Questions.Options(3,"t3"));
//        question.setOptions(options1);
