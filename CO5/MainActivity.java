package com.example.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //references to buttons and other controls of the layout
    Button btnadd,btnview;
    EditText cust,age;
    Switch status;
    ListView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cust=findViewById(R.id.pt1);
        age=findViewById(R.id.pt2);
        btnadd=findViewById(R.id.button2);
        btnview=findViewById(R.id.button);
        status=findViewById(R.id.switch1);
        l1=findViewById(R.id.list);


        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"View All Button",Toast.LENGTH_LONG).show();
            }

        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer custmr = new Customer();
                try {
                    custmr = new Customer(1, Integer.parseInt(age.getText().toString()), cust.getText().toString(), status.isChecked());
                    Toast.makeText(MainActivity.this, custmr.toString(), Toast.LENGTH_LONG).show();
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
                Db_Connect db= new Db_Connect(MainActivity.this);
                boolean result= db.addone(custmr);
                Toast.makeText(MainActivity.this,"Success="+result,Toast.LENGTH_LONG).show();
            }
        });

    }
}