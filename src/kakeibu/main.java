package kakeibu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
 public static void main(String[] args) {
  method m = new method();
  int num = m.menu();
  while (!(num == 6)) {
   try {
    if (num == 1) {
     System.out.println("日付を入力してください");
     int Date = new Scanner(System.in).nextInt();
     System.out.println("収入を書いてください");
     int Income = new Scanner(System.in).nextInt();
     System.out.println("支出を書いてください");
     int Expense = new Scanner(System.in).nextInt();
     System.out.println("コメントを残してください");
     String Details = new Scanner(System.in).nextLine();
     //     java.util.Date date = new java.util.Date();
     //     java.sql.Date now = new java.sql.Date(date.getTime());
     m.insert(Date, Income, Expense, Details);
     num = m.menu();
    } else if (num == 2) {
     System.out.println("削除する番号を入力してください");
     int id = new Scanner(System.in).nextInt();
     m.delete(id);
     num = m.menu();
    } else if (num == 3) {
     System.out.println("変更する項目を入力してください");
     System.out.println("1.日付,2.収入3.支出4.コメント5.全体");
    num = new Scanner(System.in).nextInt();
    if (num == 1) {
     System.out.println("変更する管理番号を記入してください");
     int id2 = new Scanner(System.in).nextInt();
     System.out.println("変更する日付を記入してください");
     int Date2 = new Scanner(System.in).nextInt();
     m.update(id2, Date2);
     num = m.menu();
    } else if (num == 2) {
     System.out.println("変更する管理番号を記入してください");
     int id2 = new Scanner(System.in).nextInt();
     System.out.println("変更する収入金額を記入してください");
     int Income2 = new Scanner(System.in).nextInt();
     m.update1(id2, Income2);
     num = m.menu();
    } else if (num == 3) {
     System.out.println("変更する管理番号を記入してください");
     int id2 = new Scanner(System.in).nextInt();
     System.out.println("変更する支出金額を記入してください");
     int Expense2 = new Scanner(System.in).nextInt();
     m.update2(id2, Expense2);
     num = m.menu();
    } else if (num == 4) {
     System.out.println("変更する管理番号を記入してください");
     int id2 = new Scanner(System.in).nextInt();
     System.out.println("コメントを残してください");
     String Details2 = new Scanner(System.in).nextLine();
     m.update3(id2, Details2);
     num = m.menu();
    } else if (num == 5) {
     System.out.println("変更する管理番号を記入してください");
     int id2 = new Scanner(System.in).nextInt();
     System.out.println("変更する日付を記入してください");
     int Date2 = new Scanner(System.in).nextInt();
     System.out.println("変更する収入金額を記入してください");
     int Income2 = new Scanner(System.in).nextInt();
     System.out.println("変更する支出金額を記入してください");
     int Expense2 = new Scanner(System.in).nextInt();
     System.out.println("コメントを残してください");
     String Details2 = new Scanner(System.in).nextLine();
     m.update4(id2, Date2, Income2, Expense2, Details2);
     num = m.menu();
    }}
    else if (num == 4) {
     m.print();
     num = m.menu();
    } else if (num == 5) {
     m.total();
     num = m.menu();
    }
//    else if (num ==7) {
//      //検索メソッド
//      System.out.println("検索する項目を入れてください");
//      System.out.println("1.DATE, 2.INCOME,3.EXPENSE");
//
//      num = new Scanner(System.in).nextInt();
//      if(num==1) {
//      int Date3 = new Scanner(System.in).nextInt();
//      m.search(Date3);}
    //全件表示メソッド
   } catch (InputMismatchException e) {
    System.out.println("数字を入れてください");
    num = m.menu();
   }
  }
 }
}
