package com.example.mobileuploadapirest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private final int CODEIMAGE = 1;

    private ImageView imageView;
    private EditText editText;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);


        button.setOnClickListener(view ->{

        });


        imageView.setOnClickListener(view -> {
            openGalery();
        });


    }

    public void openGalery(){
        //? URI - aponta para algo (externo - manda para fora, ou seja, manda para a api)
        //? URI - universal resource identify
        //abre as imagens
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        //
        startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODEIMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == this.RESULT_CANCELED){
            return;
        }

        if (requestCode == CODEIMAGE){

            if (data != null){
                Uri uri = data.getData();
                //?Imagens vetoriais - desenhso que conseguimos adicionar cor, mudar forma, aumentar e diminuir componentes sem perda de resolução
                //? Imagens de bitMap - Quando tiramos uma foto, quando ela é realista e estática (resolucao da a densidade de pixels na imagem)

                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                    imageView.setImageBitmap(bitmap);

                    Log.d("imagem", "onActivityResult: imagem alterada");

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("imagem", e.getMessage());
                }
            }
        }
    }

    //    public void openGalery(){
//
//        //criamos uma variavel com
//        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//
//        //qual o tipo de recurso que quero pegar
//        intent.setType("image/*");
//
//        //abrir a activity responsavel por exibir as imagens, na qual retornará o conteudo selecionado para o nosso app
//        this.startActivityForResult(Intent.createChooser(intent, "Escolha uma foto"), CODE_IMAGE);
//    }
}