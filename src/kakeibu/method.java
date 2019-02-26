package kakeibu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class method {
 public int menu() {
  System.out.println("実行するMenuの番号を押してください");
  System.out.println("1.UPLOAD");
  System.out.println("2.DELETE");
  System.out.println("3.UPDATE");
  System.out.println("4.FULLVIEW");
  System.out.println("5.CURRENT BALANCE");
  System.out.println("6.EXIT");

  int num = new Scanner(System.in).nextInt();
  return num;
 }

 Connection con = null;

 //接続メソッド
 public void connection() {
  try {
   Class.forName("com.mysql.jdbc.Driver");
   con = DriverManager.getConnection("jdbc:mysql://localhost/a?useSSL=false",
     "root", "root");
  } catch (ClassNotFoundException e) {
   e.printStackTrace();
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }

 //切断メソッド
 public void disconnection() {
  try {
   con.close();
  } catch (SQLException e) {
   e.printStackTrace();
  }
 }

 //追加メソッド
 public void insert(int Date, int Income, int Expense, String Details) {
  connection();
  if (con != null) {
   //SQL文作成、insert命令

   String sql = "insert into b(Date,Income,Expense,Details) values(?,?,?,?)";

   try {
    //変数作成して、接続情報にSQL文をわたす。
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setInt(1, Date);
    //    ps.setDate(1, date);
    //    ps.setDate(1, new Date(date.getTime()));
    ps.setInt(2, Income);
    ps.setInt(3, Expense);
    ps.setString(4, Details);
    //実行
    ps.executeUpdate();

    System.out.println("SUCCESS");
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

 //削除メソッド
 public void delete(int id) {
  connection();
  if (con != null) {
   String sql = "delete from b where id =?";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setInt(1, id);
    ps.executeUpdate();
    System.out.println("SUCCESS");
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

 public void update(int id, int Date) {
  connection();
  if (con != null) {
   String sql = "update b set Date=? where id =?";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setInt(1, Date);
    ps.setInt(2, id);

    ps.executeUpdate();
    System.out.println("SUCCESS");
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

 public void update1(int id, int Income) {
  connection();
  if (con != null) {
   String sql = "update b set Income=? where id =?";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setInt(1, Income);
    ps.setInt(2, id);

    ps.executeUpdate();
    System.out.println("SUCCESS");
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

 public void update2(int id, int Expense) {
  connection();
  if (con != null) {
   String sql = "update b set Expense=? where id =?";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setInt(1, Expense);
    ps.setInt(2, id);

    ps.executeUpdate();
    System.out.println("SUCCESS");
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

 public void update3(int id, String Details) {
  connection();
  if (con != null) {
   String sql = "update b set Details=? where id =?";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    ps.setString(1, Details);
    ps.setInt(2, id);

    ps.executeUpdate();
    System.out.println("SUCCESS");
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

 public void update4(int id, int Date, int Income, int Expense, String Details) {
  connection();
  if (con != null) {
   String sql = "update b set Date=?,Income=?,Expense=?,Details=? where id =?";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);

    ps.setInt(1, Date);
    ps.setInt(2, Income);
    ps.setInt(3, Expense);
    ps.setString(4, Details);
    ps.setInt(5, id);

    ps.executeUpdate();
    System.out.println("SUCCESS");
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

//// 検索するメソッド
//  public void search(int Income) {
//   connection();
//   if (con != null) {
//    String sql = "select * from amaimono where id =?";
//    try {
//     PreparedStatement ps;
//     ps = con.prepareStatement(sql);
//     ps.setInt(1,id);
//
//     ResultSet rs = ps.executeQuery();
//     while (rs.next()) {
//      System.out.println("お探しのものは" + rs.getString("name") + "かな？");
//     }
//     ps.close();
//    } catch (SQLException e) {
//     e.printStackTrace();
//    } finally {
//     disconnection();
//    }
//   }
//  }

 //全件表示するメソッド
 public void print() {
  connection();
  if (con != null) {
   String sql = "select * from b";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    //select命令はexecuteQueryで実行  結果はResultSet(表形式のデータ)で返ってくる
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
     System.out.print("管理番号：" + rs.getInt("id"));
     System.out.print("日付：" + rs.getInt("Date"));
     System.out.println("収入：" + rs.getInt("Income"));
     System.out.println("支出：" + rs.getInt("Expense"));
     System.out.println("ディティール：" + rs.getString("Details"));
    }
    rs.close();
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }

 public void total() {
  connection();
  if (con != null) {
   String sql = "select * from b";

   try {
    PreparedStatement ps;
    ps = con.prepareStatement(sql);
    //select命令はexecuteQueryで実行  結果はResultSet(表形式のデータ)で返ってくる
    ResultSet rs = ps.executeQuery();
    int sum1 = 0;
    int sum2 = 0;

    while (rs.next()) {
     sum1 += rs.getInt("Income");
     sum2 += rs.getInt("Expense");
    }

    int total = (sum1) - (sum2);
    if (total > 0) {
     System.out.println("現在" + total + "円持っています。");
    } else {
     System.out.println("現在" + total + "円、赤字です。");
    }

    rs.close();
    ps.close();
   } catch (SQLException e) {
    e.printStackTrace();
   } finally {
    disconnection();
   }
  }
 }
}