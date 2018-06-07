package factorialconexion.example.omen.factorialconexion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btn = (Button) findViewById(R.id.btn1);
        final EditText edt = (EditText) findViewById(R.id.edt1);
        final TextView txtview = (TextView) findViewById(R.id.txtview1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://192.168.84.45/ejemplojson/imprimejson.php?numero=" + edt.getText().toString();
                JsonObjectRequest peticion = new JsonObjectRequest
                        (
                                Request.Method.GET,
                                url,
                                null,
                                new Response.Listener<JSONObject>()
                                {
                                    @Override
                                    public void onResponse(JSONObject response)
                                    {
                                        try {
                                            txtview.setText("" + response.getInt("factorial"));

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                , new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(PrincipalActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                            }
                        });
                RequestQueue x = Volley.newRequestQueue(PrincipalActivity.this);
                x.add(peticion);

            }
        });
    }
}