package com.example.tarde.schoolart.helper;

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.example.tarde.schoolart.R;
import com.example.tarde.schoolart.cadastroActivity;
import com.example.tarde.schoolart.edicaoAlunoActivity;
import com.example.tarde.schoolart.model.Aluno;

public class AlunoHelper {

    private EditText txtNome;
    private EditText txtTelefone;
    private EditText txtEmail;
    private EditText txtSite;
    private RatingBar rbarNota;

    public AlunoHelper(cadastroActivity activity){
       carregaCampos(activity);
    }


    public AlunoHelper(edicaoAlunoActivity activity) {
        carregaCampos(activity);
    }


    private void carregaCampos(Activity activity) {
        txtNome = activity.findViewById(R.id.txtNome);
        txtTelefone = activity.findViewById(R.id.txtTelefone);
        txtEmail = activity.findViewById(R.id.txtEmail);
        txtSite = activity.findViewById(R.id.txtSite);
        rbarNota = activity.findViewById(R.id.rbarNota);
    }

    public Aluno getAluno() {
        String nome = txtNome.getText().toString();
        String telefone = txtTelefone.getText().toString();
        String email = txtEmail.getText().toString();
        String site = txtSite.getText().toString();
        double nota = rbarNota.getRating();

        return new Aluno(nome, telefone, email, site, nota);
    }

    public void carregaCampos(Aluno aluno){
        txtNome.setText(aluno.getNome());
        txtTelefone.setText(aluno.getTelefone());
        txtEmail.setText(aluno.getEmail());
        txtSite.setText(aluno.getSite());
        rbarNota.setRating((float)aluno.getNota());

    }
}
