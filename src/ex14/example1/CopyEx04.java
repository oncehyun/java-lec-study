package ex14.example1;

class User {
    private int id;
    private String name;
    private String tel;

    public static User copy(User user){
        return new User(user);
    }


    // 생성자
    public User(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.tel = user.getTel();
    }

    // 생성자
    public User(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }

    // 값 확인
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }
}

public class CopyEx04 {
    public static void main(String[] args) {
        User u1 = new User(1, "ssar", "0102222");

        // 1. 통째로 복사
        //User u2 = new User(u1.getId(), u1.getName(),u1.getTel());
        User u2 = new User(u1); // 사용자 관점에서 쓰기 좋은 코드


        // 2. 부분변경 복사
        User u3 = new User(u1.getId(), u1.getName(), "0103333");


    }
}
