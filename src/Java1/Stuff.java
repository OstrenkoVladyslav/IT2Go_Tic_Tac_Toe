package Java1;


public class Stuff {
    private String fio;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Stuff(String fio, String position, String email, String phone, double salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "FIO " + fio + ", position " + position + ", email " + email + ", phone " + phone + ", salary " + salary + ", age " + age;
    }

    public static void main(String[] args) {
        Stuff[] stuff = new Stuff[5];
        stuff[0] = new Stuff("Ivanov", "CEO", "ivanov@mail.ru", "380501112233", 70000, 35);
        stuff[1] = new Stuff("Petrov", "FCO", "petrov@mail.ru", "380501112233", 50000, 45);
        stuff[2] = new Stuff("Sidorov", "engineer", "sidorov@mail.ru", "380501112233", 70000, 40);
        stuff[3] = new Stuff("Kurochkin", "miner", "kurochkin@mail.ru", "380501112233", 70000, 31);
        stuff[4] = new Stuff("Gusev", "driver", "gusev@mail.ru", "380501112233", 70000, 57);
        for (Stuff s: stuff){
            if (s.getAge()>40){
                System.out.println(s);
            }
        }
    }
}

