package model.entities;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Seller implements Serializable {
    public static final long serialVersionUID = 1L;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer id;
    private String name;
    private String email;
    private Date birthDate;
    private Double baseSalary;
    private Department department;

    public Seller(Double baseSalary, Date birthDate, Department department, String email, Integer id, String name) {
        this.baseSalary = baseSalary;
        this.birthDate = birthDate;
        this.department = department;
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Seller seller)) return false;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String toString(){
        return "Seller [Name = " + name + ", Id = " + id + ", birthDate = " + sdf.format(birthDate) + ", Salary = " + baseSalary + ", Department = " + department + "]";
    }
}
