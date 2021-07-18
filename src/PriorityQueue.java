/*
input format
ENTER name CGPA id: The student to be inserted into the priority queue.
SERVED: The highest priority student in the queue was served.


12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED

output
Dan
Ashley
Shafaet
Maria

Explanation 0

In this case, the number of events is 12. Let the name of the queue be Q.

John is added to Q. So, it contains (John, 3.75, 50).
Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).
Shafaet is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Shafaet, 3.7, 35).
Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Shafaet, 3.7, 35).
John is served next as he has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
Samiha is added to Q. So, it contains (Shafaet, 3.7, 35) and (Samiha, 3.85, 36).
Samiha is served as she has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
Now, four more students are added to Q. So, it contains (Shafaet, 3.7, 35), (Ashley, 3.9, 42), (Maria, 3.6, 46), (Anik, 3.95, 49), and (Dan, 3.95, 50).
Anik is served because though both Anil and Dan have the highest CGPA but Anik comes first when sorted in alphabetic order. So, Q contains (Dan, 3.95, 50), (Ashley, 3.9, 42), (Shafaet, 3.7, 35), and (Maria, 3.6, 46).
As all events are completed, the name of each of the remaining students is printed on a new line.

 */
import java.util.*;
import java.io.*;

public class PriorityQueue {
    private final static Priorities priorities = new Priorities();

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        //int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();
        events.add("ENTER John 3.75 50");
        events.add("ENTER Mark 3.8 24");
        events.add("ENTER Shafaet 3.7 35");
        events.add("SERVED");
        events.add("SERVED");
        events.add("ENTER Samiha 3.85 36");
        events.add("SERVED");
        events.add("ENTER Ashley 3.9 42");
        events.add("ENTER Maria 3.6 46");
        events.add("ENTER Anik 3.95 49");
        events.add("ENTER Dan 3.95 50");
        events.add("SERVED");

        /*
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }*/

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

final class Priorities{
    public List<Student> studentList = new ArrayList<>();
    public java.util.PriorityQueue<Student> pq = new java.util.PriorityQueue<>();
    public List<Student> getStudents(List<String> events) {

        for(int i=0;i<events.size();i++){
            String event = events.get(i);
            String oper = event.split("\\s")[0];
            if(oper.equals("ENTER")){
                String name = event.split("\\s")[1];
                float cgpa = Float.parseFloat(event.split("\\s")[2]);
                int id = Integer.parseInt(event.split("\\s")[3]);
                Student s = new Student(name,cgpa,id);
                pq.add(s);
                studentList.add(s);
            }
            else if(oper.equals("SERVED")){
                pq.poll();
            }
        }

        return studentList;
    }
}

class Student implements Comparable<Student> {
    String name;
    int id;
    float cgpa;

    public Student(String name, float cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public int compareTo(Student other) {
        return this.getName().compareTo(other.getName());
    }
}
