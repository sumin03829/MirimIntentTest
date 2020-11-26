package kr.hs.emirim.s2019s38.mirimintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    RadioGroup rg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.et1);
        ed2=findViewById(R.id.et2);
        rg=findViewById(R.id.rg);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(listenerBtn);
    }
    View.OnClickListener listenerBtn=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("input1", ed1.getText().toString());
            intent.putExtra("input2", ed2.getText().toString());
            switch (rg.getCheckedRadioButtonId()){
                case R.id.plus:
                    intent.putExtra("op", "+");
                    break;
                case R.id.minus:
                    intent.putExtra("op", "-");
                    break;
                case R.id.multipli:
                    intent.putExtra("op", "*");
                    break;
                case R.id.division:
                    intent.putExtra("op", "/");
                    break;
            }
            startActivity(intent);
        }
    };
}