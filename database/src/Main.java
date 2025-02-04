import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void q1(String url,String username,String password) throws SQLException {
        JFrame frame = new JFrame("Query Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String query = "select studentnumber from regestercourses";

        DefaultTableModel model = new DefaultTableModel(new String[]{"studentnumber"}, 0);
        JTable table = new JTable(model);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int studentnumber=resultSet.getInt("studentnumber");
            model.addRow(new Object[]{studentnumber});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void q2(String url,String username,String password) throws SQLException {
        JFrame frame = new JFrame("Query Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String query = "select courseid from regestercourses " +
                "Group By courseid " +
                "Having count(studentnumber)>1";

        DefaultTableModel model = new DefaultTableModel(new String[]{"courseid"}, 0);
        JTable table = new JTable(model);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int courseid=resultSet.getInt("courseid");
            model.addRow(new Object[]{courseid});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void q3(String url,String username,String password) throws SQLException {
        JFrame frame = new JFrame("Query Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String query = "select studentnumber,sum(result*grade)/sum(grade) as avgg from regestercourses join " +
                "course " +
                "group by studentnumber";

        DefaultTableModel model = new DefaultTableModel(new String[]{"studentnumber","avgg"}, 0);
        JTable table = new JTable(model);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int studentnumber=resultSet.getInt("studentnumber");
            int avgg=resultSet.getInt("avgg");
            model.addRow(new Object[]{studentnumber,avgg});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void q4(String url,String username,String password) throws SQLException {
        JFrame frame = new JFrame("Query Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String query = "select * from lecturer " +
                "where id in (select id from course join lecturerschedule " +
                "group by id " +
                "having Sum(grade)>70)";

        DefaultTableModel model = new DefaultTableModel(new String[]{"id","name","rankk","phone","birth","employeeid","deptid"}, 0);
        JTable table = new JTable(model);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id=resultSet.getInt("id");
            String name=resultSet.getString("name");
            String rank=resultSet.getString("rankk");
            String phone=resultSet.getString("phone");
            String birth=resultSet.getString("birth");
            int employeeid=resultSet.getInt("employeeid");
            int deptid=resultSet.getInt("deptid");
            model.addRow(new Object[]{id,name,rank,phone,birth,employeeid,deptid});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void q5(String url,String username,String password) throws SQLException {
        JFrame frame = new JFrame("Query Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String query = "select name from take2 join book " +
                "group by name " +
                "having count(take2.bookid)>4";

        DefaultTableModel model = new DefaultTableModel(new String[]{"name"}, 0);
        JTable table = new JTable(model);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String name=resultSet.getString("name");
            model.addRow(new Object[]{name});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void q6(String url,String username,String password) throws SQLException {
        JFrame frame = new JFrame("Query Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String query = "select * from lecturerschedule" +
                "where lecturer_id in( select lecturer_id from lecturerschedule join regestercourses " +
                "group by lecturerschedule.lecturer_id,regestercourses.courseid " +
                "having count(studentnumber)>20;";

        DefaultTableModel model = new DefaultTableModel(new String[]{"coursesection_tr","courseid","lecturer_id","coursesection_year","section-code"}, 0);
        JTable table = new JTable(model);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int courseid=resultSet.getInt("courseid");
            int lecturer_id=resultSet.getInt("lecturer_id");
            int section_code=resultSet.getInt("section-code");
            int coursesection_year=resultSet.getInt("coursesection_year");
            int coursesection_tr=resultSet.getInt("coursesection_tr");
            model.addRow(new Object[]{coursesection_tr,courseid,lecturer_id,coursesection_year,section_code});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void q7(String url,String username,String password) throws SQLException {
        JFrame frame = new JFrame("Query Output");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String query = "select * from student join student2 " +
                "where studentnumber not in (select studentnumber from regestercourses)";

        DefaultTableModel model = new DefaultTableModel(new String[]{"studentnumber","id","magor","name","level"}, 0);
        JTable table = new JTable(model);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int studentnumber=resultSet.getInt("studentnumber");
            int id=resultSet.getInt("id");
            String magor=resultSet.getString("magor");
            String name=resultSet.getString("name");
            int level=resultSet.getInt("level");

            model.addRow(new Object[]{studentnumber,id,magor,name,level});
        }

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void t1(String url,String username,String password) throws SQLException {
        String trigger="DELIMITER $$ "+
       " CREATE TRIGGER before_regestercourses_insert "+
       " BEFORE INSERT ON regestercourses "+
        "FOR EACH ROW "+
         "       BEGIN "+
        "DECLARE total_credits INT; "+
       " SELECT COALESCE(SUM(c.credit), 0) + (SELECT credit FROM course WHERE courseid = NEW.courseid) "+
       " INTO total_credits "+
        "FROM regestercourses rc "+
        "JOIN course c ON rc.courseid = c.courseid "+
        "WHERE rc.studentnumber = NEW.studentnumber "+
        "AND rc.coursesection_year = NEW.coursesection_year "+
        "AND rc.coursesection_tr = NEW.coursesection_tr; "+

        "IF total_credits < 12 THEN "+
        "SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Total credits for the semester must be at least 12'; "+
        "END IF; "+
        "END$$ "+
         "       DELIMITER ; "
       ;

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.execute(trigger);
    }
    public static void t2(String url,String username,String password) throws SQLException {
        String trigger="DELIMITER $$ " +
                "CREATE TRIGGER trg_check_professor_schedule " +
                "BEFORE INSERT ON lecturerschedule  " +
                "FOR EACH ROW " +
                "BEGIN " +
                "    DECLARE count_classes INT; " +

                "    SELECT COUNT(*) " +
                "    INTO count_classes " +
                "    FROM lecturerschedule join coursesection " +
                "    WHERE lecturer_id = NEW.lecturer_id " +
                "    AND `timee` = `NEW.timee` and `day`=`new.day`; " +
                "    IF count_classes > 0 THEN " +
                "        SIGNAL SQLSTATE '45000' " +
                "        SET MESSAGE_TEXT = 'Professor already has a class scheduled at this time'; " +
                "    END IF; " +
                "END$$ " +
                "DELIMITER ;"
                ;

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        statement.execute(trigger);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            String url = "jdbc:mysql://localhost:3306/pouya";
            String username = "root";
            String password = "pouyaomid2018@";

            JFrame fframe = new JFrame("Query select");
            fframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fframe.setSize(600, 400);
            JPanel ffframe=new JPanel(new BorderLayout());
            JPanel botton =new JPanel();
            botton.setLayout(new BoxLayout(botton,BoxLayout.PAGE_AXIS));

            JButton q11=new JButton("query1");
            JButton q22=new JButton("query2");
            JButton q33=new JButton("query3");
            JButton q44=new JButton("query4");
            JButton q55=new JButton("query5");
            JButton q66=new JButton("query6");
            JButton q77=new JButton("query7");
            JButton t1=new JButton("trigger1");
            JButton t2=new JButton("trigger2");

            q11.setBounds(50,50,50,75);

            t1.setBackground(Color.cyan);
            t2.setBackground(Color.cyan);
            botton.add(q11);
            botton.add(q22);
            botton.add(q33);
            botton.add(q44);
            botton.add(q55);
            botton.add(q66);
            botton.add(q77);
            botton.add(t1);
            botton.add(t2);


            ffframe.add(botton,BorderLayout.CENTER);
            fframe.add(ffframe);
            fframe.setVisible(true);



            q11.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        q1(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            q22.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        q2(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            q33.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        q3(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            q44.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        q4(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            q55.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        q5(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            q66.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        q6(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            q77.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        q7(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            t1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        t1(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

            t2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        t2(url,username,password);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });

        });
    }
}

