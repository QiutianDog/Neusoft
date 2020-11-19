package mysql.select;

import lombok.Data;

import java.util.Date;

// 学生对象
@Data
public class Student {

    // 学生信息
    private String id;
    private String name;
    private Integer age;
    private String gender;
    private Date insertTime;

    // 学生方法
    public Student() {
    }

    public Student(String id, String name, Integer age, String gender, Date insertTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.insertTime = insertTime;
    }

}
