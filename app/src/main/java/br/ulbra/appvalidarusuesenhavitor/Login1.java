package br.ulbra.appvalidarusuesenhavitor;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login1 extends AppCompatActivity {
    EditText edtLogin, edtPass;
    Button btnLogin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login1);
        db = new DBHelper(this);
        edtLogin = (EditText) findViewById(R.id.edtNomeLogin);
        edtPass = (EditText) findViewById(R.id.edtSenhaLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtLogin.getText().toString();
                String password = edtPass.getText().toString();

                if (username.equals("")) {
                    Toast.makeText(Login1.this, "Usuário não inserido, por favor tente novamente!", Toast.LENGTH_SHORT).show();

                } else if (password.equals("")) {
                    Toast.makeText(Login1.this, "Senha não inserida, por favor tente novamente", Toast.LENGTH_SHORT).show();

                } else {
                    String res = db.validarLogin(username, password);

                    if (res.equals("OK")) {
                        Toast.makeText(Login1.this, "Login OK", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Login1.this, "Login ou senha errado(s)", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}













