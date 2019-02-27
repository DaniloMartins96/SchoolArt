package com.example.tarde.schoolart.dao;

//SQLITE RELACIONAL
//SHARED PREFENRECES
//API - FIREBASE(ORIENTADOS A ARQUIVOS)

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tarde.schoolart.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends SQLiteOpenHelper {
    public AlunoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    //Chamado quando o banco de dados é criado pela primeira vez.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table alunos(" +
                " idAluno INTEGER PRIMARY KEY AUTOINCREMENT," +
                " nome text not null," +
                " telefone TEXT NOT null," +
                " email text NOT null UNIQUE," +
                " site TEXT," +
                " nota DECIMAL not null)";
        db.execSQL(sql);
    }

    //Chamado quando o banco de dados precisa ser atualizado
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long inserir(Aluno aluno){
        ContentValues dados = new ContentValues();
        dados.put("nome",aluno.getNome());
        dados.put("telefone",aluno.getTelefone());
        dados.put("email",aluno.getEmail());
        dados.put("site",aluno.getSite());
        dados.put("nota",aluno.getNota());

        SQLiteDatabase db = getWritableDatabase();
        return db.insert("alunos",null ,dados);
    }

    public List<Aluno> listaTodosAlunos(){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM alunos";
        Cursor cursor = db.rawQuery(sql,null);

        List<Aluno> listaAlunos = new ArrayList<>();

        while (cursor.moveToNext()){
            long idAluno = cursor.getLong(cursor.getColumnIndex("idAluno"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String site = cursor.getString(cursor.getColumnIndex("site"));
            double nota = cursor.getDouble(cursor.getColumnIndex("nota"));

            Aluno aluno = new Aluno(idAluno,nome,telefone,email,site,nota);
            listaAlunos.add(aluno);
        }

        return listaAlunos;
    }
}
