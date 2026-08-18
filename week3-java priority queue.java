import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * Create the Student and Priorities classes here.
 */
 import java.util.PriorityQueue;
class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> pq = new PriorityQueue<>(
            (a, b) -> {
                // Higher CGPA first
                int result = Double.compare(b.getCGPA(), a.getCGPA());

                if (result != 0) {
                    return result;
                }

                // Same CGPA -> alphabetical name
                result = a.getName().compareTo(b.getName());

                if (result != 0) {
                    return result;
                }

                // Same name -> smaller ID first
                return Integer.compare(a.getID(), b.getID());
            }
        );

        for (String event : events) {

            String[] data = event.split(" ");

            if (data[0].equals("ENTER")) {
                String name = data[1];
                double cgpa = Double.parseDouble(data[2]);
                int id = Integer.parseInt(data[3]);

                pq.add(new Student(id, name, cgpa));

            } else if (data[0].equals("SERVED")) {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            }
        }

        List<Student> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}