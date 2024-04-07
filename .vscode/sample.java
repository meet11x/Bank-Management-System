import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;

class run {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        BankManagement bank = new BankManagement();
        bank.defaultadd();

        System.out.println();
        System.out.println("                                    WELCOME TO BANK ");
        System.out.println("                                   ----------------- ");
        System.out.println("\033[0;31m                                   ENTER YOUR CHOICE : \033[0;0m");
        System.out.println();
        while (true) {
            System.out.println();
            System.out.println("                                   1 : DEPOSIT AMOUNT");
            System.out.println("                                   2 : WITHDRAW AMOUNT");
            System.out.println("                                   3 : SHOW TRANSACTION HISTORY");
            System.out.println("                                   4 : TRANSFER AMOUNT");
            System.out.println("                                   5 : SHOW ALL USER DETAIL");
            System.out.println("                                   6 : SEARCH ACCOUNT");
            System.out.println("                                   7 : UPDATE USER DETAIL");
            System.out.println("                                   8 : CLOSE USER ACCOUNT");
            System.out.println("                                   9 : EXIT");
            System.out.println();
            System.out.println("                                   ----------------- ");
            System.out.println();
            System.out.print("\033[0;31m                                  -->  ENTER CHOICE : \033[0;0m");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    bank.DepositMoney();
                    break;
                case 2:
                    bank.WITHDRAWMoney();
                    break;
                case 3:
                    bank.HISTORY();
                    break;
                case 4:
                    bank.TRANSFER();
                    break;
                case 5:
                    bank.print();
                    break;
                case 6:
                    System.out.println();
                    System.out.println("ENTER ACCOUNT NUMBER FOR SEARCH : ");
                    String AccNo = sc.nextLine();
                    bank.ONLYUSERPRINT(AccNo);
                    break;
                case 7:
                    int c;
                    do {
                        System.out.println("  UPDATE DETAIL : ");
                        System.out.println();
                        System.out.println("                                   1 : SECURITY PIN");
                        System.out.println("                                   2 : NAME");
                        System.out.println("                                   3 : MOBILE NUMBER");
                        System.out.println("                                   4 : GO BACK");
                        System.out.println();
                        System.out.print("\u001B[31m                                  -->  ENTER CHOICE : \u001B[0m");
                        c = sc.nextInt();
                        sc.nextLine();

                        switch (c) {
                            case 1:
                                System.out.println();
                                System.out.println("ENTER ACCOUNT NUMBER FOR UPDATE : ");
                                String accno = sc.nextLine();
                                bank.UPDATEPIN(accno);
                                break;
                            case 2:
                                System.out.println();
                                System.out.println("ENTER ACCOUNT NUMBER FOR UPDATE : ");
                                String accno1 = sc.nextLine();
                                bank.UPDATENAME(accno1);
                                break;
                            case 3:
                                System.out.println();
                                System.out.println("ENTER ACCOUNT NUMBER FOR UPDATE : ");
                                String accno2 = sc.nextLine();
                                bank.UPDATENAME(accno2);
                                break;
                            case 4:
                                break;

                            default:
                                System.out.print("                                  -->  ENTER VALID CHOICE : ");
                        }
                    } while (c != 4);
                    break;
                case 8:
                    System.out.println();
                    System.out.println("ENTER ACCOUNT NUMBER TO CLOSE ACCOUNT  : ");
                    String accno1 = sc.nextLine();
                    bank.CLOSEACCOUNT(accno1);
                    break;
                case 9:
                    System.out.println();
                    System.out.println("                               --- THANK YOU FOR VISIT ...");
                    System.exit(0);
                    break;
                default:
                    System.out.print("                                  -->  ENTER VALID CHOICE : ");
            }
        }

    }
}

class Bank {
    String name;
    double balance;
    String accno;
    String phoneno;
    int pin;

    public Bank(String type, String name, double balance, String accno, long phoneno2) {
        this.pin = type;
        this.name = name;
        this.balance = balance;
        this.accno = accno;
        this.phoneno = phoneno2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "Name =" + name + "\n Balance =" + balance + "\n Account Number =" + accno + "\n phone no =" + phoneno;
    }

}

class BankManagement {
    Scanner sc = new Scanner(System.in);
    HashMap<String, Bank> mybank;
    int i = 1;

    BankManagement() {

        mybank = new HashMap<>();

    }

    void defaultadd() throws Exception {
        String Driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(Driver);

        String url = "jdbc:mysql://localhost:3306/lj";
        String user = "root";
        String pass = "";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();

        Bank b = new Bank(1311, "MEET", 5000.0, "112201", "9328936902");
        mybank.put("112201", b);

        Bank b2 = new Bank(1108, "MIT", 9000.0, "112202", "9328936901");
        mybank.put("112202", b2);

        Bank b3 = new Bank(1109, "MAYUR", 5000.0, "112203", "9328936903");
        mybank.put("112203", b3);

        Bank b4 = new Bank(1110, "PRIT", 10000.0, "112204", "9328936904");
        mybank.put("112204", b4);

        Bank b5 = new Bank(1111, "PRINCE", 15000.0, "112205", "9328936802");
        mybank.put("112205", b5);

        Bank b6 = new Bank(1112, "RAHUL", 50000.0, "112206", "9328936992");
        mybank.put("112206", b6);

        Bank b7 = new Bank(1113, "DARSHAN", 53000.0, "112207", "9328931902");
        mybank.put("112207", b7);

        Bank b8 = new Bank(1114, "JAY", 25000.0, "112208", "9328996902");
        mybank.put("112208", b8);

        Bank b9 = new Bank(1115, "SHUBH", 5000.0, "112209", "9326736902");
        mybank.put("112209", b9);

    }

    void UPDATEPIN(String accno) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
        if (mybank.containsKey(accno)) {
            BufferedWriter br = new BufferedWriter(new FileWriter((accno + ".txt"), true));
            Bank b = mybank.get(accno);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            boolean flag = false;
            if (b.pin == pin) {
                System.out.println("                               --- ACCOUNT SUCCESSFULLY VERIFIED ");
                System.out.println();
                System.out.println("PIN FORMAT :");
                System.out.println("----------");
                System.out.println();
                System.out.println("~> PIN CONTAINS ONLY NUMBERS ");
                System.out.println("~> PIN LENGTH SHOULD BE 4");
                String newpin;
                do {
                    System.out.println("ENTER NEW PIN : ");
                    newpin = sc.nextLine();
                    if (newpin.length() == 4) {
                        for (int i = 0; i < newpin.length(); i++) {
                            if (newpin.charAt(i) >= '0' && newpin.charAt(i) <= '9') {
                                flag = true;
                                break;
                            } else {
                                System.out.println("                               --- INVALID FORMAT");
                            }
                        }
                    } else {
                        System.out.println("                               --- INVALID LENGTH");
                        System.out.println();
                    }
                } while (flag == false);
                System.out.println("                               --- PIN SUCCESSFULLY VERIFIED");
                int mypin = Integer.valueOf(newpin);
                System.out.println("RE-ENTER THE PIN TO CONFIRM : ");
                int pin1 = sc.nextInt();
                if (mypin == pin1) {
                    Statement st = con.createStatement();
                    String sql = "UPDATE BankDataBase SET PIN = " + pin1 + " WHERE AccNo = '" + accno + "'";
                    int r = st.executeUpdate(sql);
                    b.setPin(pin1);
                    mybank.put(accno, b);
                    System.out.println("                               --- PIN SUCCESSFULLY CHANGED");
                    br.write("PIN CHANGED FROM : " + pin + " TO -> " + pin1);
                    br.newLine();
                    br.flush();
                } else {
                    System.out.println("                               --- SECURITY PIN NOT MATCHING");
                    System.out.println();
                }
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                        THANK YOU !!!");
                System.out.println("                                       ------------");
                System.out.println();
            }
        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                         THANK YOU !!!");
            System.out.println("                                         ------------");
            System.out.println();
        }
    }

    void CLOSEACCOUNT(String accno) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
        if (mybank.containsKey(accno)) {
            BufferedWriter br = new BufferedWriter(new FileWriter((accno + ".txt"), true));
            Bank b = mybank.get(accno);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            if (b.pin == pin) {

                System.out.println("                               --- ACCOUNT SUCCESSFULLY VERIFIED ");
                System.out.println();
                System.out.print("ARE YOU SURE WANT TO CLOSE ACCOUNT : [ YES OR NO ] --> ");
                String ans = sc.nextLine();
                if (ans.equalsIgnoreCase("yes")) {
                    String sql = " DELETE FROM BankDataBase WHERE AccNo = " + accno;
                    Statement st = con.createStatement();
                    int r = st.executeUpdate(sql);
                    mybank.remove(accno);
                    System.out.println("                               --- ACCOUNT HAS BEEN CLOSED !");
                } else {
                    System.out.println();
                    System.out.println("                               --- YEAH !!! YOU CAN CONTINUE ...");
                    System.out.println();
                }
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                        THANK YOU !!!");
                System.out.println("                                       ------------");
                System.out.println();
            }
        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                         THANK YOU !!!");
            System.out.println("                                         ------------");
            System.out.println();
        }
    }

    void UPDATENAME(String accno) throws Exception {
        if (mybank.containsKey(accno)) {
            BufferedWriter br = new BufferedWriter(new FileWriter((accno + ".txt"), true));
            Bank b = mybank.get(accno);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            if (b.pin == pin) {

                System.out.println("                               --- ACCOUNT SUCCESSFULLY VERIFIED ");
                System.out.println();
                System.out.println("ENTER NEW NAME :");
                String name = sc.nextLine();

                String n = b.name;
                b.setName(name);
                mybank.put(accno, b);
                String sql = "UPDATE BankDataBase SET Name = '" + name + "' WHERE AccNo = '" + accno + "'";

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
                Statement st = con.createStatement();
                int r = st.executeUpdate(sql);
                System.out.println("                               --- NAME SUCCESSFULLY CHANGED");
                br.write("NAME CHANGED FROM : " + n + " TO -> " + name);
                br.newLine();
                br.flush();
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                        THANK YOU !!!");
                System.out.println("                                       ------------");
                System.out.println();
            }
        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                         THANK YOU !!!");
            System.out.println("                                         ------------");
            System.out.println();
        }
    }

    void UPDATEPHONENO(String accno) throws Exception {
        if (mybank.containsKey(accno)) {
            BufferedWriter br = new BufferedWriter(new FileWriter((accno + ".txt"), true));
            Bank b = mybank.get(accno);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            if (b.pin == pin) {
                System.out.println("                               --- ACCOUNT SUCCESSFULLY VERIFIED ");
                System.out.println();
                System.out.println("ENTER NEW PHONE NUMBER :");
                String name = sc.nextLine();

                String n = b.phoneno;
                b.setPhoneno(name);
                mybank.put(accno, b);
                String sql = "UPDATE BankDataBase SET PhoneNo = " + name + " WHERE AccNo = '" + accno + "'";
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
                Statement st = con.createStatement();
                int r = st.executeUpdate(sql);
                System.out.println("                               --- PHONE NUMBER SUCCESSFULLY CHANGED");
                br.write("PHONE NUMBER CHANGED FROM : " + n + " TO -> " + name);
                br.newLine();
                br.flush();
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                        THANK YOU !!!");
                System.out.println("                                       ------------");
                System.out.println();
            }
        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                          THANK YOU !!!");
            System.out.println("                                          ------------");
            System.out.println();
        }
    }

    void print() throws Exception {
        String Driver = "com.mysql.cj.jdbc.Driver";
        Class.forName(Driver);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
        Statement st = con.createStatement();
        String sql = "select * from BankDataBase";
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println();
            System.out.println("                                   ACCOUNT NO :- " + rs.getString(2));
            System.out.println("                                         NAME :- " + rs.getString(3));
            System.out.println("                                      BALANCE :- " + rs.getDouble(4));
            System.out.println("                                     PHONE NO :- " + rs.getLong(5));
            System.out.println();
        }
    }

    void TRANSFER() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER ACCOUNT NUMBER : ");
        String accno = sc.nextLine();
        System.out.println();
        if (mybank.containsKey(accno)) {
            Bank b2 = mybank.get(accno);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            if (b2.pin == pin) {

                BufferedWriter br = new BufferedWriter(new FileWriter((accno + ".txt"), true));
                System.out.println("                               --- ACCOUNT SUCCESSFULLY VERIFIED ");
                System.out.println();
                System.out.print("-> ENTER ACCOUNT NUMBER TO GET TRANSFERED AMOUNT :");
                String accno1 = sc.nextLine();
                if (mybank.containsKey(accno1)) {
                    Bank b1 = mybank.get(accno1);
                    System.out.println("ENTER SECURITY PIN : ");
                    int pin2 = sc.nextInt();
                    sc.nextLine();
                    if (b1.pin == pin2) {

                        BufferedWriter br1 = new BufferedWriter(new FileWriter((accno1 + ".txt"), true));
                        System.out.println("                               --- SECOND ACCOUNT SUCCESSFULLY VERIFIED ");
                        System.out.println();
                        System.out.print("ENTER AMOUNT TO TRANSFER  :");
                        double amount = sc.nextDouble();

                        if (b2.balance > amount) {
                            b2.balance = b2.balance - amount;
                            br.write("AMOUNT OF : " + amount + " /- TRANSFERED TO --> ACCOUNT :" + accno1);
                            br.newLine();

                            b1.balance = b1.balance + amount;
                            br1.write("AMOUNT OF : " + amount + " /-  CREDITED FROM ACCOUNT :" + accno);
                            br1.newLine();

                            String sql = "UPDATE BankDataBase SET Balance = " + b2.balance + "where AccNo = '" + accno
                                    + "'";
                            String sql2 = "UPDATE BankDataBase SET Balance = " + b1.balance + "where AccNo = '" + accno1
                                    + "'";

                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
                            Statement st = con.createStatement();
                            int r = st.executeUpdate(sql);
                            int s = st.executeUpdate(sql2);
                        } else {
                            System.out.println(
                                    "                               --- USER HAVE INEFFICIENT AMOUNT TO TRANSFER :");
                            System.out.println("                                              THANK YOU !!!");
                        }

                        br.flush();
                        br1.flush();
                    } else {
                        System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                        System.out.println("                                        THANK YOU !!!");
                        System.out.println("                                       ------------");
                        System.out.println();
                    }
                } else {
                    System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
                    System.out.println("                                          THANK YOU !!!");
                    System.out.println("                                          ------------");
                    System.out.println();
                }
            } else {
                System.out.println();
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                       THANK YOU !!!");
                System.out.println("                                      ------------");
                System.out.println();
            }
        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                         THANK YOU !!!");
            System.out.println("                                        ------------");
            System.out.println();
        }

    }

    void DepositMoney() throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter br;

        System.out.println("ENTER ACCOUNT NUMBER : ");
        String accno = sc.nextLine();
        System.out.println();
        if (mybank.containsKey(accno)) {
            Bank b1 = mybank.get(accno);
            System.out.println("ENTER SECURITY PIN : ");
            int pin2 = sc.nextInt();
            sc.nextLine();
            if (b1.pin == pin2) {
                br = new BufferedWriter(new FileWriter((accno + ".txt"), true));
                System.out.println("                               --- ACCOUNT SUCCESSFULLY VERIFIED ");
                System.out.println();
                System.out.print("ENTER AMOUNT TO DEPOSIT  :");
                double amount = sc.nextDouble();
                Bank b = mybank.get(accno);
                b.balance = b.balance + amount;
                br.write("ACCOUNT CREDITED BY : " + amount + " /- ");
                br.newLine();

                double newamount = b.balance;
                System.out.println("                               --- BALANCE DEPOSITED SUCCESSFULLY ");
                System.out.println("                                        THANK YOU !!!");
                System.out.println("                                       -------------             ");
                String sql = "UPDATE BankDataBase SET Balance = " + newamount + "where AccNo = '" + accno + "'";

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
                Statement st = con.createStatement();
                int r = st.executeUpdate(sql);
                br.flush();
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                       THANK YOU !!!");
                System.out.println("                                     ------------");
                System.out.println();
            }

        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                          THANK YOU !!!");
            System.out.println("                                         ------------");
            System.out.println();
        }

    }

    void WITHDRAWMoney() throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER ACCOUNT NUMBER : ");
        String accno = sc.nextLine();
        System.out.println();
        if (mybank.containsKey(accno)) {
            Bank b2 = mybank.get(accno);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            if (b2.pin == pin) {
                BufferedWriter br = new BufferedWriter(new FileWriter((accno + ".txt"), true));
                System.out.println("                               --- ACCOUNT SUCCESSFULLY VERIFIED ");
                System.out.println();
                System.out.print("ENTER AMOUNT TO WITHDRAW  :");
                double amount = sc.nextDouble();
                Bank b = mybank.get(accno);
                if (b.balance < amount) {

                    System.out.println("                               --- USER HAVE INEFFICIENT AMOUNT TO WITHDRAW ");
                    System.out.println("                                             THANK YOU !!! ");
                    System.out.println("                                          --------------------             ");
                } else {
                    br.write("ACCOUNT DEBITED BY : " + amount + " /-");
                    br.newLine();

                    b.balance = b.balance - amount;
                    double newamount = b.balance;
                    System.out.println("                               --- AMOUNT WITHDRAW SUCCESSFULLY DONE");
                    System.out.println("                                          THANK YOU !!!");
                    System.out.println("                                        --------------------             ");
                    String sql = "UPDATE BankDataBase SET Balance = " + newamount + "where AccNo = '" + accno + "'";
                    String url = "jdbc:mysql://localhost:3306/lj";
                    String user = "root";
                    String pass = "";
                    Connection con = DriverManager.getConnection(url, user, pass);
                    Statement st = con.createStatement();
                    int r = st.executeUpdate(sql);
                }
                br.flush();
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                      THANK YOU !!!");
                System.out.println("                                     ------------");
                System.out.println();
            }

        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                          THANK YOU !!!");
            System.out.println("                                          ------------");
            System.out.println();
        }
    }

    void ONLYUSERPRINT(String AccNo) throws Exception {
        if (mybank.containsKey(AccNo)) {
            Bank b2 = mybank.get(AccNo);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            if (b2.pin == pin) {
                String Driver = "com.mysql.cj.jdbc.Driver";
                Class.forName(Driver);
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lj", "root", "");
                Statement st = con.createStatement();
                String sql = "select * from BankDataBase where AccNo = '" + AccNo + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    String color = "\u001B[0m";
                    String close = "\u001B31m";
                    System.out.println();
                    System.out.println(
                            color + "                                   ACCOUNT NO :- " + rs.getString(2));
                    System.out.println(
                            color + "                                         NAME :- " + rs.getString(3));
                    System.out.println(
                            color + "                                      BALANCE :- " + rs.getDouble(4));
                    System.out.println(
                            color + "                                     PHONE NO :- " + rs.getLong(5));
                    System.out.println();
                }
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                        THANK YOU !!!");
                System.out.println("                                        ------------");
                System.out.println();
            }
        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                          THANK YOU !!!");
            System.out.println("                                         ------------");
            System.out.println();
        }
    }

    void HISTORY() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("ENTER ACCOUNT NUMBER : ");
        String accno = sc.nextLine();
        if (mybank.containsKey(accno)) {
            Bank b2 = mybank.get(accno);
            System.out.print("ENTER SECURITY PIN : ");
            int pin = sc.nextInt();
            sc.nextLine();
            if (b2.pin == pin) {
                BufferedReader bw = new BufferedReader(new FileReader(accno + ".txt"));
                String line;
                while ((line = bw.readLine()) != null) {
                    System.out.println("--- " + line);
                }
            } else {
                System.out.println("                               --- SECURITY PIN NOT MATCHING  ");
                System.out.println("                                       THANK YOU !!!");
                System.out.println("                                       ------------");
                System.out.println();
            }
        } else {
            System.out.println("                               --- ACCOUNT NOT EXIST IN DATABASE ");
            System.out.println("                                         THANK YOU !!!");
            System.out.println("                                         ------------");
            System.out.println();
        }
    }
}