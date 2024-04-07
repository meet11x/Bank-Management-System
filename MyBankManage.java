import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

class main {
    public static void main(String[] args) throws Exception {
        BankManage obj = new BankManage();
        obj.defaultadd();
    }
}

class BankDetail {
    String name, accno;
    long phoneno;
    int sId;
    double balance;

    public BankDetail(String name, String accno, long phoneno, int sId, double balance) {
        this.name = name;
        this.accno = accno;
        this.phoneno = phoneno;
        this.sId = sId;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankDetail [name=" + name + ", accno=" + accno + ", phoneno=" + phoneno + ", sId=" + sId + ", balance="
                + balance + "]";
    }
}

class BankManage {
    HashMap<String, BankDetail> bank;

    BankManage() throws Exception {

        bank = new HashMap<>();

    }

    void defaultadd() throws Exception {
        String Driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(Driver);
        System.out.println("Driver loaded");

        String url = "jdbc:mysql://localhost:3306/lj";
        String user = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();

        String sql = "INSERT INTO BankManagement values(1,'112201','MEET',5000.0,9328936902)\n(2,'112202','MIT',6000.0,9087654312)\n(3,'112203','PRIT',10000.0,9078563412)";
        int x = st.executeUpdate(sql);
    }

}

 void add() throws Exception {
        Scanner sc = new Scanner(System.in);
        // Statement st = con.createStatement();
        String Driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(Driver);
        System.out.println("Driver loaded");

        String url = "jdbc:mysql://localhost:3306/lj";
        String user = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
        System.out.println();

        System.out.println("ENTER NAME OF USER :");
        String name = sc.nextLine();
        boolean flag = false;
        String accno;
        System.out.println(
                "ENTER ACCOUNT NUMBER :  IN THE PROPER FORMET \n --> NO CHARACTER ALLOWED \n DIGIT LENGTH SHOULD BE 6");
        do {
            accno = sc.nextLine();
            if (accno.length() == 6) {
                for (int i = 0; i < accno.length(); i++) {
                    if (accno.charAt(i) >= '0' && accno.charAt(i) <= '9') {
                        System.out.println("ACCOUNT NUMBER SUCCESSFULLY VERIFIED");
                        flag = true;
                        break;
                    } else {
                        flag = false;
                        System.out.println("INVALID ACCOUNT NUMBER \n ENTER AGAIN --->");
                        break;
                    }
                }
            } else {
                System.out.println("INVALID LENGTH \n ENTER AGAIN -->");
            }
        } while (flag == false);
        System.out.println("ENTER ACCOUNT TYPE : \n  [1]-SAVING [2]-CURRENT ACCOUNT");
        String type = sc.nextLine();
        System.out.println("ENTER BALANCE :");
        double balance = sc.nextDouble();
        sc.nextLine();
        System.out.println("ENTER MOBILE NUMBER :");
        long phoneno = sc.nextLong();
        sc.nextLine();

        Bank obj = new Bank(type, name, balance, accno, phoneno);
        mybank.put(accno, obj);

        String sql = "insert into BankManagement values(" + i + ",'" + accno + "','" + type + "'," + balance + ","
                + phoneno
                + ")";
        i++;
        int r = st.executeUpdate(sql);
    }
