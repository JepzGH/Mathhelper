package com.study.mathhelper.calculator;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    TextView field;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        field=(TextView)findViewById(R.id.textView);
        field.setText("0"); // Установили 0 поумолчанию
    }

    //delete this comment
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    static boolean isempty=true;
    public void num_Clicked(View send)
    {
        Button bt=(Button)send;
        if(field.getText().length()>7)return;
        if(isempty)
        {
            field.setText(bt.getText());
            isempty=false;
        }
        else
        {
            field.append(bt.getText());
        }
    }


    static int collector=0;
    static int toDo=0;
    public void op_Clicked(View send)
    {
        Button bt=(Button)send;
        switch (toDo)
        {
            case 0:
                collector+=Integer.parseInt(field.getText().toString());
            break;
            case 1:
                collector-=Integer.parseInt(field.getText().toString());
            break;
            case 2:
                  collector/=Integer.parseInt(field.getText().toString());
            //    collector/=Float.parseFloat(field.getText().toString());
            break;
            case 3:
                collector*=Integer.parseInt(field.getText().toString());
            break;
            case 4:
                collector=Integer.parseInt(field.getText().toString());
            break;
            // C
            case 5:
                collector=0;
            break;
            // undo
            case 6:
                String Cancel = field.getText().toString();
                if(Cancel.length() > 1)
                {
                    collector = Integer.parseInt(Cancel.substring(0, Cancel.length() - 1));
                }
                else
                {
                    collector=0;
                }

                break;
            // +-
            case 7:
                collector=Integer.parseInt(field.getText().toString());
                collector*=-1;
            break;
        }
        field.setText(Integer.toString(collector));
        if(bt.getText().toString().equals("+")) toDo=0;
        if(bt.getText().toString().equals("-")) toDo=1;
        if(bt.getText().toString().equals("/")) toDo=2;
        if(bt.getText().toString().equals("*")) toDo=3;
        if(bt.getText().toString().equals("=")) toDo=4;
        if(bt.getText().toString().equals("C")) toDo=5;
        if(bt.getText().toString().equals("Undo")) toDo=6;
        if(bt.getText().toString().equals("+-")) toDo=7;
        isempty=true;

    }

}