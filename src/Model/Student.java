package Model;

public class Student {
    private String id;
    private String name;
    private String course;

    public Student(String id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }

    @Override
    public String toString() {
        return id + "," + name + "," + course;
    }

    public static Student fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Student(parts[0], parts[1], parts[2]);
    }
}
