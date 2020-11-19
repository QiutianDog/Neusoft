package mysql.select;

import lombok.Data;

import java.sql.Date;

@Data
public class Employee {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private Date hiredate;
    private Integer sal;
    private Integer comm;
    private Integer deptno;

    public Employee() {
    }

    public Employee(Integer empno, String ename, String job, Integer mgr, Date hiredate, Integer sal, Integer comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return String.format("Employee{ empno=%-5d, ename=%-8s, job=%-10s, mgr=%-5d, hiredate=%s, sal=%-5d, comm=%-5d, deptno=%-4d}"
        ,empno, ename, job, mgr, hiredate, sal, comm, deptno);
    }
}
