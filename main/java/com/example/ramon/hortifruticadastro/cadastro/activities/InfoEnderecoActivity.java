package com.example.ramon.hortifruticadastro.cadastro.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.ramon.hortifruticadastro.R;

/**
 * Created by Ramon on 27/05/2017.
 */

public class InfoEnderecoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Informações de Endereço");
        setContentView(R.layout.cadastro2);
    }
}
