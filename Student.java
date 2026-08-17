class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}
Collections.sort(studentList, new Comparator<Student>() {

    public int compare(Student a, Student b) {

        if (Double.compare(a.getCgpa(), b.getCgpa()) != 0) {
            return Double.compare(b.getCgpa(), a.getCgpa());
        }

        if (!a.getName().equals(b.getName())) {
            return a.getName().compareTo(b.getName());
        }

        return Integer.compare(a.getId(), b.getId());
    }
});