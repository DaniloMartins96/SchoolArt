package com.example.tarde.schoolart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.tarde.schoolart.dao.AlunoDAO;
import com.example.tarde.schoolart.helper.AlunoHelper;
import com.example.tarde.schoolart.model.Aluno;

public class cadastroActivity extends AppCompatActivity {

    private AlunoHelper helper;
    private AlunoDAO alunoDAO;
    private Button btnCadastrarAluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastrarAluno = findViewById(R.id.btnCadastrarAluno);
        helper = new AlunoHelper(this);
        alunoDAO = new AlunoDAO(this);

        btnCadastrarAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Aluno aluno = helper.getAluno();
                if(alunoDAO.inserir(aluno)==-1){
                    Toast.makeText(cadastroActivity.this,
                            "Não inseriu",Toast.LENGTH_LONG).show();
                }else{
                    finish();
                }
            }
        });
    }
}
