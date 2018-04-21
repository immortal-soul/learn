package jdbc;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Timestamp;
import java.util.List;

public class UserDao {

    private JdbcTemplate jdbcTemplate;
    private User user;
    private PlatformTransactionManager tm;
    private DefaultTransactionDefinition def;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public User getUser() {
        return user;
    }

    public PlatformTransactionManager getTm() {
        return tm;
    }

    public DefaultTransactionDefinition getDef() {
        return def;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTm(PlatformTransactionManager tm) {
        this.tm = tm;
    }

    public void setDef(DefaultTransactionDefinition def) {
        this.def = def;
    }

    /**
     * 测试事务回滚
     * @param user
     */
//    @Transactional
//    public void test(User user){
//        String sql = "INSERT INTO user " +
//                "(username,password,reg_time,reg_ip,status,login_time,login_ip,phone,role) " +
//                "VALUE (?,?,?,?,?,?,?,?,?)";
//        Object[] o = new Object[]{user.getUsername(), user.getPassword(), user.getReg_time(),
//                user.getReg_ip(), user.getStatus(), user.getLogin_time(), user.getLogin_ip(),
//                user.getPhone(), user.getRole()};
//        jdbcTemplate.update(sql,o);
//        System.out.println(getDataForUsername(user.getUsername()));
//        Object[] o1 = new Object[]{user.getUsername(), user.getPassword(), user.getReg_time(),
//                user.getReg_ip(), user.getStatus(), user.getLogin_time(), user.getLogin_ip(),
//                user.getPhone()};
//        jdbcTemplate.update(sql,o1);
//    }

    /**
     * 用户名登陆
     *
     * @param username
     * @param password
     */
    public void loginUserForUsername(String username, String password, String login_ip) {
        User sqlUser = getDataForUsername(username);
        if (sqlUser == null) {
            System.out.println("UserDao loginUser() : The username does not exist");
            return;
        }
        if (!sqlUser.getPassword().equals(password)) {
            System.out.println("UserDao loginUser() : Password error");
            return;
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        TransactionStatus ts = tm.getTransaction(def);
        try {
            String sql = "UPDATE user SET login_ip = ?,login_time = ? WHERE username = ?";
            System.out.println(sql);
            jdbcTemplate.update(sql, "123", timestamp, username);
            tm.commit(ts);
        } catch (InvalidResultSetAccessException e) {
            e.printStackTrace();
            System.out.println("loginUserForUsername() : Failure of information update");
            tm.rollback(ts);
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("loginUserForUsername() : Failure of information update");
            tm.rollback(ts);
        }
        System.out.println("登陆成功");
    }

    /**
     * 注册用户
     *
     * @param user 用户模型
     */
    public void regUser(User user) {
        if (user.AllNull()) {
            System.out.println("UserDao regUser() : The User class Lacks parameters");
            return;
        }
        if (getDataForUsername(user.getUsername()) != null) {
            System.out.println("UserDao regUser() : User name already existed");
            return;
        }
        TransactionStatus ts = tm.getTransaction(def);
        try {
            String sql = "INSERT INTO user " +
                    "(username,password,reg_time,reg_ip,status,login_time,login_ip,phone,role) " +
                    "VALUE (?,?,?,?,?,?,?,?,?)";
            Object[] o = new Object[]{user.getUsername(), user.getPassword(), user.getReg_time(),
                    user.getReg_ip(), user.getStatus(), user.getLogin_time(), user.getLogin_ip(),
                    user.getPhone(), user.getRole()};
            jdbcTemplate.update(sql, o);
            tm.commit(ts);
        } catch (InvalidResultSetAccessException e) {
            tm.rollback(ts);
            e.printStackTrace();
        } catch (DataAccessException e) {
            tm.rollback(ts);
            e.printStackTrace();
        }
    }

    /**
     * 根据用户名获取用户所有信息
     *
     * @param username
     * @return
     */
    public User getDataForUsername(String username) {
        String sql = "SELECT * FROM user WHERE username='" + username + "'";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        if (!isNull(users))
            return users.get(0);
        else
            return null;
    }

    /**
     * 获取userbiao中所有数据
     */
    public void getAll() {
        String sql = "SELECT * FROM user";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sql, rowMapper);
        if (!isNull(users)) {
            for (User user : users) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("UserDao getAll() : The result of the query is empty");
        }
    }

    /**
     * 判断查询结果是否为空
     *
     * @param users true 为空  false 不为空
     * @return
     */
    private boolean isNull(List<User> users) {
        if (users != null && users.size() > 0)
            return false;
        else
            return true;
    }

    public String getMethodName() {
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }
}
