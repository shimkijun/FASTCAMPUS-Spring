package kr.co.basic.cli;

import kr.co.basic.cli.config.AppConfig;
import kr.co.basic.cli.controller.MemberController;
import kr.co.basic.cli.dao.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        createTalbe(context.getBean(DataSource.class).getConnection());

        System.out.println("이름 과 비밀번호를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름");
        String username = scanner.nextLine();
        System.out.println("비밀번호");
        String password = scanner.nextLine();
        MemberController controller = context.getBean(MemberController.class);
        controller.insert(username,password);
        controller.print();
        context.close();
    }

    public static void createTalbe(Connection connection) throws SQLException {
        connection.createStatement()
                .execute("drop table member");

        connection.createStatement()
                .execute("create table member(id int auto_increment,username varchar(255) not null , password varchar(255) not null,primary key(id))");
    }
}
