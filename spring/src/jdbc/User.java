package jdbc;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class User {
    private String username;
    private String password;
    private Timestamp reg_time;
    private String reg_ip;
    private Boolean status;
    private Timestamp login_time;
    private String login_ip;
    private int phone;
    private int role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Timestamp getReg_time() {
        return reg_time;
    }

    public String getReg_ip() {
        return reg_ip;
    }

    public boolean getStatus() {
        return status;
    }

    public Timestamp getLogin_time() {
        return login_time;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public int getPhone() {
        return phone;
    }

    public int getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReg_time(Timestamp reg_time) {
        this.reg_time = reg_time;
    }

    public void setReg_ip(String reg_ip) {
        this.reg_ip = reg_ip;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setLogin_time(Timestamp login_time) {
        this.login_time = login_time;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    /**
     * 判断是否有空参数， true 有  false 没有
     * @return
     */
    public boolean AllNull() {
        if (username == null || username.length() <= 0)
            return true;
        if (password == null || password.length() <= 0)
            return true;
        if (reg_time == null)
            return true;
        if (reg_ip == null || reg_ip.length() <= 0)
            return true;
        if (status == null)
            return true;
        if (login_time == null)
            return true;
        if (login_ip == null || login_ip.length() <= 0)
            return true;
        if (phone <= 0)
            return true;
        if (phone < 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", reg_time=" + reg_time +
                ", reg_ip='" + reg_ip + '\'' +
                ", status='" + status + '\'' +
                ", login_time=" + login_time +
                ", login_ip='" + login_ip + '\'' +
                ", phone=" + phone +
                ", role=" + role +
                '}';
    }

}
