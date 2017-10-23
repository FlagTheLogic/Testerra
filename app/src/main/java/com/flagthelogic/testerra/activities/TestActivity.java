package com.flagthelogic.testerra.activities;

 import android.arch.persistence.room.Room;
 import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.TextView;

 import com.flagthelogic.testerra.R;
 import com.flagthelogic.testerra.database.AppDatabase;
 import com.flagthelogic.testerra.database.entities.Questions;
 import com.flagthelogic.testerra.database.entities.Tests;

 import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    Button loadBTN;
    EditText loadET;
    EditText loadET2;
    TextView loadTestTEXT;
    TextView loadQuestionTEXT;
    Button saveBTN;
    Button loadQuestion;
    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final AppDatabase db =
                Room
                        .databaseBuilder(
                                getApplicationContext(),
                                AppDatabase.class, "db.name")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();

        loadBTN = findViewById(R.id.button);
        loadET = findViewById(R.id.editText);
        loadET2 = findViewById(R.id.editText2);
        loadTestTEXT = findViewById(R.id.textView);
        loadQuestionTEXT = findViewById(R.id.textView2);
        loadBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = db.testsDao().getTestById(Integer.parseInt(loadET.getText().toString())).toString();
                loadTestTEXT.setText(s);
            }
        });
        saveBTN = findViewById(R.id.button2);
        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int new_test_id = Integer.parseInt(loadET2.getText().toString());
                Tests test = new Tests();
                test.setId(new_test_id);
                test.setAuthor("author");
                test.setCategory(1);
                test.setDescription("description");
                test.setInstruction("instruction");
                test.setLogicType(2);
                test.setParameters(new Tests.Params("param1", 1));
                test.setTestCompleted(100500);
                test.setTitle("test title");
                db.testsDao().insertNewTest(test);

                Questions question = new Questions();
                question.setqId(1);
                question.settId(new_test_id);
                question.setQuestion("question 1");

                ArrayList<Questions.Options> options1 = new ArrayList<>();
                options1.add(new Questions.Options(1,"t1"));
                options1.add(new Questions.Options(2,"t2"));
                options1.add(new Questions.Options(3,"t3"));
                question.setOptions(options1);

                db.questionsDao().insertQuestions(question);
            }
        });
        loadQuestion = findViewById(R.id.button3);
        loadQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                List<Questions> arrayList = db.questionsDao().getQuestionsForTest(Integer.parseInt(loadET.getText().toString()));
//                String s = "";
//                for (Questions q: arrayList) {
//                    s += q.toString();
//                }
                String s = db.questionsDao()
                        .getQuestionsForTest(Integer.parseInt(loadET.getText().toString())).get(0).toString();
                loadQuestionTEXT.setText(s);
            }
        });
    }
}
