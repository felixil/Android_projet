package dicj.info.imbfe1233046.mylifeasalazybaconsimulatorthestudentdeadlineattack;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ImbFe1233046 on 2018-04-03.
 */

public class User implements Serializable {
    private Integer lvl;
    private String name,password,img,id;
    private List listFriend = new LinkedList();
    public long getLvl() {        return lvl;    }

    public void setLvl(Integer lvl) {
        this.lvl = lvl;
    }

    public String getImg() {        return img;    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {        return id;    }

    public void setId(String id) {
        this.id = id;
    }

    public List getListFriend() {        return listFriend;    }

    public void setListFriend(List listFriend) {
        this.listFriend = listFriend;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
