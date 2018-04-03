package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.*;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;

/**
 * Created by ImbFe1233046 on 2018-03-27.
 */
public class FirstStep extends Activity implements OnTouchListener {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firststep);
        mp=MediaPlayer.create(this,R.raw.main_song);
        mp.setLooping(true);
        mp.start();
        RelativeLayout layout= (RelativeLayout)findViewById(R.id.ecranStart);
        layout.setOnTouchListener(this);
    }
    public boolean onTouch(View v, MotionEvent event) {
        Intent intent = new Intent(this, PopUp.class);
        startActivity(intent);
        return true;}
    }
