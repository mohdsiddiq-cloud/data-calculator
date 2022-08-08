package com.example.android.p_project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String history="";
    int i1=0;
    String st1="";
    String st2="";
    String op="";
    String help="";
    float ans=0;
    float check=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView=findViewById(R.id.printer);

        Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st1="";
                st2="";
                help="";
                op="";
                check=0;
                textView.setText("00");
            }
        });
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(st2=="" && st1=="" && op=="")
                    ans=ans;

                else if(st2==""){
                    if(op=="") {
                        st1 = st1.substring(0, st1.length() - 1);
                    }
                    else {
                        op = "";
                    }
                    help=help.substring(0,help.length()-1);
                    textView.setText(help);
                }
                else{
                    st2=st2.substring(0,st2.length()-1);
                    help=help.substring(0,help.length()-1);
                    textView.setText(help);
                }
            }
        });
        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st2==""){
                    help=st1+"/";
                    textView.setText(help);
                    check=1;
                    op="/";
                }
                else{
                    ans=Integer.valueOf(st1)/Integer.valueOf(st2);
                    help=ans+"/";
                    textView.setText(help);
                    check=1;
                    st1=String.valueOf(ans);
                    op="/";
                    st2="";
                }
            }
        });
        Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st2==""){
                    help=st1+"%";
                    textView.setText(help);
                    check=1;
                    op="%";
                }
                else{
                    ans=Integer.valueOf(st1)%Integer.valueOf(st2);
                    help=ans+"%";
                    textView.setText(help);
                    check=1;
                    st1=String.valueOf(ans);
                    op="%";
                    st2="";
                }
            }
        });

        Button button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "1";
                    help=help+"1";
                    textView.setText(help);
                }
                else{
                    st2=st2+"1";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });
        Button button6=findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "2";
                    help=help+"2";
                    textView.setText(help);
                }
                else{
                    st2=st2+"2";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });
        Button button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "3";
                    help=help+"3";
                    textView.setText(help);
                }
                else{
                    st2=st2+"3";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });
        Button button8=findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st2==""){
                    help=st1+"x";
                    textView.setText(help);
                    check=1;
                    op="x";
                }
                else{
                    ans=Integer.valueOf(st1)*Integer.valueOf(st2);
                    help=ans+"x";
                    textView.setText(help);
                    check=1;
                    st1=String.valueOf(ans);
                    op="x";
                    st2="";
                }
            }
        });
        Button button9=findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "4";
                    help=help+"4";
                    textView.setText(help);
                }
                else{
                    st2=st2+"4";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });  Button button10=findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "5";
                    help=help+"5";
                    textView.setText(help);
                }
                else{
                    st2=st2+"5";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });  Button button11=findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "6";
                    help=help+"6";
                    textView.setText(help);
                }
                else{
                    st2=st2+"6";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });
        Button button12=findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st2==""){
                    help=st1+"-";
                    textView.setText(help);
                    check=1;
                    op="-";
                }
                else{
                    ans=Integer.valueOf(st1)-Integer.valueOf(st2);
                    help=ans+"-";
                    textView.setText(help);
                    check=1;
                    st1=String.valueOf(ans);
                    op="-";
                    st2="";
                }
            }
        });
        Button button13=findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "7";
                    help=help+"7";
                    textView.setText(help);
                }
                else{
                    st2=st2+"7";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });
        Button button14=findViewById(R.id.button14);
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "8";
                    help=help+"8";
                    textView.setText(help);
                }
                else{
                    st2=st2+"8";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });
        Button button15=findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "9";
                    help=help+"9";
                    textView.setText(help);
                }
                else{
                    st2=st2+"9";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });


        Button button16=findViewById(R.id.button16);
        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st2==""){
                    help=st1+"+";
                    textView.setText(help);
                    check=1;
                    op="+";
                }

                else{
                    ans=Integer.valueOf(st1)+Integer.valueOf(st2);
                    help=ans+"+";
                    textView.setText(help);
                    check=1;
                    st1=String.valueOf(ans);
                    op="+";
                    st2="";
                }

            }
        });

        Button button17=findViewById(R.id.button17);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SaverActivity.class);
                intent.putExtra("my-data",history);
                startActivity(intent);
            }
        });
        Button button18=findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + "0";
                    help=help+"0";
                    textView.setText(help);
                }
                else{
                    st2=st2+"0";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });
        Button button19=findViewById(R.id.button19);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check==0) {
                    st1 = st1 + ".";
                    help=help+".";
                    textView.setText(help);
                }
                else{
                    st2=st2+".";
                    help=st1+op+st2;
                    textView.setText(help);
                }
            }
        });

        Button button20=findViewById(R.id.button20);
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(st1=="")
                    st1="0";
                if(st2=="")
                    st2="0";

                switch (op){
                    case "+":
                        ans=Float.valueOf(st1)+Float.valueOf(st2);
                        break;
                    case "-":
                        ans=Float.valueOf(st1)-Float.valueOf(st2);
                        break;
                    case "x":
                        ans=Float.valueOf(st1)*Float.valueOf(st2);
                        break;
                    case "/":
                        ans=Float.valueOf(st1)/Float.valueOf(st2);
                        break;
                    case "%":
                        ans=Float.valueOf(st1)%Float.valueOf(st2);
                        break;
                    default:ans=ans;
                }

                if(st1.contains(".")==false && st2.contains(".")==false){
                    i1=(int)ans;
                    history=history+help+"="+i1+" ,  ";
                    textView.setText(String.valueOf(i1));
                    st1=String.valueOf(i1);
                    st2="";
                    help=String.valueOf(i1);
                    op="";
                }

                else {
                    textView.setText(String.valueOf(ans));
                    history=history+help+"="+ans;
                    st1 = String.valueOf(ans);
                    st2 = "";
                    help = String.valueOf(ans);
                    op = "";
                }
            }
        });
        Button button=findViewById(R.id.history);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,History.class);
                startActivity(intent);
            }
        });
    }
}
