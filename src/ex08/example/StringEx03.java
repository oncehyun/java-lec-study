package ex08.example;

class ContractInfo {
    private int money;
    private final String addr;
    private String name;
    private String tel;
    private String email;

    public ContractInfo(int money, String addr, String name, String tel, String email) {
        this.money = money;
        this.addr = addr;
        this.name = name;
        this.tel = tel;
        this.email = email;

    }

    @Override
    public String toString() {
        return "ContractInfo{" +
                "money=" + money +
                ", addr='" + addr + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getMoney() {
        return money;
    }

    public String getAddr() {
        return addr;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }
}

public class StringEx03 {
    public static void main(String[] args) {
        // 문서 데이터는 : 으로 구분된다.
        // 0 : 계약금
        // 1 : 주소
        // 2 : 이름
        // 3 : 전화번호
        // 4 : 이메일


        // System.out.println(money);
       // System.out.println(c.getMoney());



     //   this.money = money;
     //   this.addr = addr;
     //   this.name = name;
     //   this.tel = tel;
     //   this.email = email;

       String data = "100:서울분당:이창호:01033338888:hello@nate.com";
       String[] parse = data.split(":");
       // 100:서울분당:이창호:01033338888:hello@nate.com

       System.out.println(parse[0]);
       System.out.println(parse[1]);
       System.out.println(parse[2]);
       System.out.println(parse[3]);
       System.out.println(parse[4]);

        int money = Integer.parseInt(parse[0]);
        ContractInfo c = new ContractInfo(money, parse[1], parse[2], parse[3], parse[4]);
        ContractInfo c1 = new ContractInfo(Integer.parseInt(parse[0]), parse[1], parse[2], parse[3], parse[4]);
        //ContractInfo d = new ContractInfo(Integer.parseInt(parse[0]));
        System.out.println(c);
        System.out.println(c1);




    }
}