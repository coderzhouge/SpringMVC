package xyz.zhouge.converter.bean;

/**
 * @BelongsProject: SpringMVC
 * @BelongsPackage: xyz.zhouge.converter.bean
 * @CreateTime: 2022-04-09  23:38
 * @Description: TODO
 * @Version: 1.0
 * @Author：zhouge
 */
public class User {

    private Integer id ;
    private String username ;
    private String password ;
    private Integer age ;
    private String gender ;

    public User() {
    }

    public User(Integer id, String username, String password, Integer age, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
