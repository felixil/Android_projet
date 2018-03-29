package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class EcranStart extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;

              /*  case R.id.navigation_learderboard:
                    mTextMessage.setText(R.string.title_learderboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_lvl1:
                    mTextMessage.setText(R.string.title_lvl1);
                    return true;
                case R.id.navigation_lvl2:
                    mTextMessage.setText(R.string.title_lvl2);
                    return true;
                case R.id.navigation_lvl3:
                    mTextMessage.setText(R.string.title_lvl3);
                    return true;
                case R.id.navigation_lvl4:
                    mTextMessage.setText(R.string.title_lvl4);
                    return true;
                case R.id.navigation_lvl5:
                    mTextMessage.setText(R.string.title_lvl5);
                    return true;

                case R.id.navigation_profil_option:
                    mTextMessage.setText(R.string.title_profil_option);
                    return true;*/

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecranstart);

      //  mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
