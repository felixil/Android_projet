package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ImbFe1233046 on 2018-03-28.
 */

public class PopUp extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // MySQLiteHelper  mySQLiteHelper;
     //   mySQLiteHelper = new MySQLiteHelper(this);
        final UserDataSource userDataSource = new UserDataSource(this);
        setContentView(R.layout.login);
        DisplayMetrics dim = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dim);

        int width = dim.widthPixels;
        int height=dim.heightPixels;
        getWindow().setLayout((int)(width*.85),(int)(height*.85));
        Button btnGuest = (Button) findViewById(R.id.btn_play_guess);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnRegist = (Button) findViewById(R.id.btn_register);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText login = (EditText) findViewById(R.id.txtUsername);
                EditText password = (EditText) findViewById(R.id.txtPassword);
                if((login.getText().toString()!="")&&(password.getText().toString()!=""))
                {
                    User user =userDataSource.getUser(login.getText().toString(),password.getText().toString());
                    if(user != null) {
                        Intent intent2 = new Intent(PopUp.this, EcranStart.class);
                        startActivity(intent2);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Veuillez entrez tous les champs !", Toast.LENGTH_LONG).show();
                }
            }

        });
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent2 = new Intent(PopUp.this, EcranStart.class);
                    startActivity(intent2);
            }

        });
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    Intent intent2 = new Intent(PopUp.this, Register.class);
                    startActivity(intent2);

            }

        });

    }

    }

