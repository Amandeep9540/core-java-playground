package Reflection;

class Teacher {

    public String name;
    public final String schoolName;
    private String qualification;
    private Integer experiance;
    public Integer age;
    private Double salary;

    public Teacher() {
        this.schoolName = null;
    }

    public Teacher(String schoolName) {
        this.schoolName = schoolName;
    }

    public Teacher(String name, String schoolName, Double salary) {
        this.name = name;
        this.schoolName = schoolName;
        this.salary = salary;
    }


    private Double calculateSalary(){
        System.out.println("calculating the salary of current month");
        return this.salary*30;
    }

    public Integer getExperiance(){
        System.out.println("calculating the salary of current month");
        return this.experiance;
    }
}