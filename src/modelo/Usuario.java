package modelo;

import java.sql.Date;

public class Usuario {
    private String nickname;
    private String pass;
    private Date fechaN;
    private String correo;
    private String tipoU;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoU() {
        return tipoU;
    }

    public void setTipoU(String tipoU) {
        this.tipoU = tipoU;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nickname=" + nickname + ", pass=" + pass + ", fechaN=" + fechaN + ", correo=" + correo + ", tipoU=" + tipoU + '}';
    }
}
