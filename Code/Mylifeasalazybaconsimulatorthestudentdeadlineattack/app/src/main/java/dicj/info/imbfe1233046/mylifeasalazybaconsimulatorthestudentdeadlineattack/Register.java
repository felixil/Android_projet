package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ImbFe1233046 on 2018-04-16.
 */

public class Register  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        Button btnRegist = (Button) findViewById(R.id.btn_Inscription);
        final UserDataSource userDataSource = new UserDataSource(this);


        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText login = (EditText) findViewById(R.id.txtNewPseudo);
                EditText name = (EditText) findViewById(R.id.txtNewNom);
                EditText password = (EditText) findViewById(R.id.txtNewPassword);

                if((login!= null)&&(name!= null)&&(password!= null)) {

                    User user = userDataSource.createUser(login.getText().toString(),password.getText().toString(),name.getText().toString());

                    Intent intent2 = new Intent(Register.this, EcranStart.class);
                    intent2.putExtra("user", user);
                    startActivity(intent2);
                }
            }

        });
    }
}