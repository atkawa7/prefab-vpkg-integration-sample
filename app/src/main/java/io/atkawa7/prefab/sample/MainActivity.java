package io.atkawa7.prefab.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.show_json_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView firstName = findViewById(R.id.first_name_text_view);
                        TextView lastName = findViewById(R.id.last_name_text_view);

                        TextView textView = findViewById(R.id.json_text_view);
                        textView.setText(new User(firstName.getText().toString(), lastName.getText().toString()).toJson());
                    }
                });

    }

}
