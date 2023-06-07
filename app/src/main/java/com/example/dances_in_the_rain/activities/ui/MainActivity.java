package com.example.dances_in_the_rain.activities.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dances_in_the_rain.R;

public class MainActivity extends AppCompatActivity {
    Button btnCam;
    ImageView imageaddimage;
    int SELECT_PIC=200;

    void imagechooser(){

        Intent i =new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,"select pic"),SELECT_PIC);
    }
    public void onActivityResult(int requestCode,int resultCcode,Intent data){

      super.onActivityResult(requestCode,resultCcode,data);
      if(resultCcode == RESULT_OK){
          if (requestCode == SELECT_PIC){
              Uri selectedimageUri=data.getData();
              if (null!=selectedimageUri){
                  imageaddimage.setImageURI(selectedimageUri);
              }
          }

      }
    }

    public static final int REQUEST_CODE_ADD_NOTE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageaddnotemain = findViewById(R.id.imageaddnotemain);
        imageaddnotemain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                startActivityForResult(
                        new Intent(getApplicationContext(), createnoteactivity.class),
                        REQUEST_CODE_ADD_NOTE
                );
            }

        });
        ImageView dailygift = findViewById(R.id.imageaddweblink);
        dailygift.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Uri web = Uri.parse("https://www.poetryfoundation.org/poems/poem-of-the-day");
                Intent intent = new Intent(Intent.ACTION_VIEW, web);
                startActivity(intent);
            }

        });
        ImageView imageaddimage = findViewById(R.id.imageaddimage);
        //Button btnCam = findViewById(R.id.btnCam);
        imageaddimage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               imagechooser();
            }

        });




    }






}