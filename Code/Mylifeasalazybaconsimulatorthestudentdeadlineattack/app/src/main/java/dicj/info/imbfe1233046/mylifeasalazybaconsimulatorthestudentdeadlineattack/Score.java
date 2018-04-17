package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import java.io.Serializable;

/**
 * Created by ImbFe1233046 on 2018-04-13.
 */

public class Score implements Serializable {
    private Integer id,lvl,score;
    private String time,user;

    public void setTime(String time) {        this.time = time;    }

    public String getTime() {        return time;    }

    public String getUser() {        return user;    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {        return id;    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getlvl() {
        return lvl;
    }

    public void setlvl(Integer lvl) {
        this.lvl = lvl;
    }



}
