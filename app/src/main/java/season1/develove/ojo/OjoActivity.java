package season1.develove.ojo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class OjoActivity extends AppCompatActivity {

    // UI references.
    private AutoCompleteTextView mInputView;
    private EditText mAnswerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ojo);
        // Set up the login form.
        mInputView = (AutoCompleteTextView) findViewById(R.id.input);
        mAnswerView = (EditText) findViewById(R.id.answer);

        Button mCalculateButton = (Button) findViewById(R.id.calculateButton);
        mCalculateButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }


    private void calculate() {
        String literal = mInputView.getText().toString();

        char first = '=';
        int charCount = 0;
        String answer = "";

        if (literal.length() == 0) {
            mAnswerView.setText("");
            return;
        }

        for (int i = 0; i < literal.length(); ++i) {
            if (first == literal.charAt(i)) {
                charCount++;
            } else {
                if (first != '=') {
                    answer = answer + first + charCount;
                }
                first = literal.charAt(i);
                charCount = 1;
            }
        }
        answer = answer + first + charCount;

        mAnswerView.setText(answer);
    }
}

