package com.example.ramon.hortifruticadastro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ramon.hortifruticadastro.cadastro.activities.InfoEnderecoActivity;
import com.example.ramon.hortifruticadastro.database.Cliente;
import com.example.ramon.hortifruticadastro.database.ClienteDAO;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText nomeInstituicao;
    private EditText cnpj;
    private EditText ddd;
    private EditText fone;
    private String telefone;
    private EditText password;

    public Cliente cliente;
    public ClienteDAO clienteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cadastro1);
        setTitle("Informações de Acesso");
        obterViews();
    }

    public void chamarCadastro2Onclick(View view){

        telefone = ddd.getText().toString() + " " + fone.getText().toString();

        cliente = new Cliente(email.getText().toString(),
                nomeInstituicao.getText().toString(),
                cnpj.getText().toString(),
                telefone,
                password.getText().toString());

        Toast.makeText(this, cliente.toString(), Toast.LENGTH_LONG).show();

        clienteDAO = ClienteDAO.getInstance(this);
        clienteDAO.save(cliente);
        Intent intent = new Intent(this, InfoEnderecoActivity.class);
        startActivity(intent);
    }


    public void obterViews(){
        email = (EditText)findViewById(R.id.id_cadastro_emailEdt);
        nomeInstituicao = (EditText)findViewById(R.id.id_cadastro_instituicaoEdt);
        cnpj = (EditText)findViewById(R.id.id_cadastro_cnpjEdt);
        ddd = (EditText)findViewById(R.id.id_cadastro_DDDfone1Edt);
        fone = (EditText)findViewById(R.id.id_cadastro_fone1Edt);
        telefone = ddd.getText().toString();
        password = (EditText)findViewById(R.id.id_cadastro_passwordEdt);
    }
}
