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

public class Cadastro1 extends AppCompatActivity {
    EditText edtNome, edtUser, edtPass1, edtPass2;
    Button btnSalvar;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        db = new DBHelper(this);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtUser= (EditText) findViewById(R.id.edtUsuario);
        edtPass1 = (EditText) findViewById(R.id.edtSenha);
        edtPass2 = (EditText) findViewById(R.id.edtRepSenha);

        btnSalvar = (Button) findViewById(R.id.btnCadastrar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUser.getText().toString();
                String pas1 = edtPass1.getText().toString();
                String pas2 = edtPass2.getText().toString();

                if (userName.equals("")) {
                    Toast.makeText(Cadastro1.this, "Insira o LOGIN DE USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (pas1.equals("")) {
                    Toast.makeText(Cadastro1.this, "Insira a SENHA DE USUÁRIO", Toast.LENGTH_SHORT).show();
                } else if (pas1.equals(pas2)) {
                    Toast.makeText(Cadastro1.this, "As senhas não correspondem ao login de usuário", Toast.LENGTH_SHORT).show();
                } else {
                    long res = db.criarUtilizador(userName,pas1);
                    if (res > 0) {
                        Toast.makeText(Cadastro1.this, "Registro OK", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Cadastro1.this, "Senha Inválida", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}














