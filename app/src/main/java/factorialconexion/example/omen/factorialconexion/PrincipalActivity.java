package factorialconexion.example.omen.factorialconexion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btn = (Button) findViewById(R.id.btn1);
        EditText edt = (EditText) findViewById(R.id.edt1);
        TextView txtview = (TextView) findViewById(R.id.txtview1);
    }
}
