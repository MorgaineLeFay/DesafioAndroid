package com.example.ramon.hortifruticadastro.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

	private static ClienteDAO instance;

    private SQLiteDatabase db;

	public static ClienteDAO getInstance(Context context) {
		if (instance == null) {
			instance = new ClienteDAO(context.getApplicationContext());
		}
		return instance;
	}

	private ClienteDAO(Context context) {
		DBHelper dbHelper = DBHelper.getInstance(context);
        db = dbHelper.getWritableDatabase();
	}

	@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public List<Cliente> list() {

        String[] columns = {
                ClientesContract.Columns._ID,
                ClientesContract.Columns.EMAIL,
                ClientesContract.Columns.NOME_INSTITUICAO,
                ClientesContract.Columns.CNPJ,
                ClientesContract.Columns.TELEFONE,
                ClientesContract.Columns.PASSWORD,
        };

        List<Cliente> clientes = new ArrayList<>();

        try (Cursor c = db.query(ClientesContract.TABLE_NAME, columns, null, null, null, null, ClientesContract.Columns.EMAIL)) {
            if (c.moveToFirst()) {
                do {
                    Cliente cliente = ClienteDAO.fromCursor(c);
                    clientes.add(cliente);
                } while (c.moveToNext());
            }

            return clientes;
        }

	}

    private static Cliente fromCursor(Cursor c) {
        int id = c.getInt(c.getColumnIndex(ClientesContract.Columns._ID));
         String email = c.getString(c.getColumnIndex(ClientesContract.Columns.EMAIL));
         String nomeInstituicao = c.getString(c.getColumnIndex(ClientesContract.Columns.EMAIL));
         String cnpj = c.getString(c.getColumnIndex(ClientesContract.Columns.EMAIL));
         String telefone = c.getString(c.getColumnIndex(ClientesContract.Columns.EMAIL));
         String password = c.getString(c.getColumnIndex(ClientesContract.Columns.EMAIL));

        return new Cliente(email, nomeInstituicao, cnpj, telefone, password);
    }

	public void save(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put(ClientesContract.Columns.EMAIL, cliente.getEmail());
        values.put(ClientesContract.Columns.NOME_INSTITUICAO, cliente.getNomeInstituicao());
        values.put(ClientesContract.Columns.CNPJ, cliente.getCnpj());
        values.put(ClientesContract.Columns.TELEFONE, cliente.getTelefone());
        values.put(ClientesContract.Columns.PASSWORD, cliente.getPassword());

        long id = db.insert(ClientesContract.TABLE_NAME, null, values);
        cliente.setId((int) id);
	}

//	public void update(Produto produto) {
//        ContentValues values = new ContentValues();
//        values.put(ClientesContract.Columns.NOME, produto.getNome());
//        values.put(ClientesContract.Columns.VALOR, produto.getValor());
//        db.update(ClientesContract.TABLE_NAME, values, ClientesContract.Columns._ID + " = ?", new String[]{ String.valueOf(produto.getId()) });
//	}
//
//	public void delete(Produto produto) {
//        db.delete(ClientesContract.TABLE_NAME, ClientesContract.Columns._ID + " = ?", new String[]{ String.valueOf(produto.getId()) });
//	}
}
