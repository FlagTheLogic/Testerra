package com.flagthelogic.testerra.activities;

 import android.arch.persistence.room.Room;
 import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.ListView;
 import android.widget.TextView;

 import com.flagthelogic.testerra.R;
 import com.flagthelogic.testerra.database.AppDatabase;
 import com.flagthelogic.testerra.database.dao.QuestionsDao;
 import com.flagthelogic.testerra.database.dao.TestsDao;
 import com.flagthelogic.testerra.database.entities.Questions;
 import com.flagthelogic.testerra.database.entities.Tests;
 import com.flagthelogic.testerra.objs.Question;

 import java.util.ArrayList;
 import java.util.List;

public class TestActivity extends AppCompatActivity {
    Button btn;
    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db.name").build();

        btn = findViewById(R.id.button);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(db.testsDao().getTestById(Integer.parseInt(editText.getText().toString())).toString());
                textView.setText(db.questionsDao().getQuestionsForTest(Integer.parseInt(editText.getText().toString())).toString());
            }
        });

        Tests test = new Tests();
        test.setId(1);
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
        question.settId(1);
        question.setQuestion("question 1");
        Questions.POJOOptions.Option op1 = new Questions.POJOOptions.Option();
        op1.setId(1);
        op1.setTitle("title 1");
        Questions.POJOOptions.Option op2 = new Questions.POJOOptions.Option();
        op2.setId(2);
        op2.setTitle("title 2");
        List<Questions.POJOOptions.Option> opts1 = new ArrayList<>();
        Questions.POJOOptions q = new Questions.POJOOptions(opts1);
        question.setOptions(q);
        Questions question1 = new Questions();
        question1.setqId(2);
        question1.settId(1);
        question1.setQuestion("question 1");
        Questions.POJOOptions.Option op11 = new Questions.POJOOptions.Option();
        op11.setId(1);
        op11.setTitle("title 1");
        Questions.POJOOptions.Option op22 = new Questions.POJOOptions.Option();
        op22.setId(2);
        op22.setTitle("title 2");
        List<Questions.POJOOptions.Option> opts11 = new ArrayList<>();
        Questions.POJOOptions q1 = new Questions.POJOOptions(opts11);
        question1.setOptions(q1);
        db.questionsDao().insertQuestions(question, question1);


    }
}
