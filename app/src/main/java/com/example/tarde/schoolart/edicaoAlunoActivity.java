package com.example.tarde.schoolart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tarde.schoolart.helper.AlunoHelper;
import com.example.tarde.schoolart.model.Aluno;

public class edicaoAlunoActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private Button btnCadastrarAluno;
    private AlunoHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtTitulo = findViewById(R.id.txtTituloCadAluno);
        txtTitulo.setText("Detalhe de Aluno");

        helper = new AlunoHelper(this);

        btnCadastrarAluno = findViewById(R.id.btnCadastrarAluno);

        btnCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = helper.getAluno();
            }
        });

        Intent intent = getIntent();
        Aluno aluno = (Aluno)intent.getSerializableExtra(MainActivity.MAIN_ALUNO);

        AlunoHelper alunoHelper = new AlunoHelper(this);
        alunoHelper.carregaCampos(aluno);


    }
}
