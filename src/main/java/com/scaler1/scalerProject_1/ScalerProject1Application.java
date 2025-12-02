package com.scaler1.scalerProject_1;

import com.scaler1.scalerProject_1.inheritanceDemo.SingleTable.*;
import com.scaler1.scalerProject_1.inheritanceDemo.Joined.*;
import com.scaler1.scalerProject_1.inheritanceDemo.TablePerClass.*;
import com.scaler1.scalerProject_1.inheritanceDemo.MappedSuperClass.*;
import com.scaler1.scalerProject_1.models.Category;
import com.scaler1.scalerProject_1.models.Product;
import com.scaler1.scalerProject_1.repositories.CategoryRepository;
import com.scaler1.scalerProject_1.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScalerProject1Application implements CommandLineRunner {

    // ────────────────────────────
    // Single Table
    // ────────────────────────────
    private final MentorRepositorySingleTable mentorRepositorySingleTable;
    private final UserRepositorySingleTable userRepositorySingleTable;
    private final TARepositorySingleTable taRepositorySingleTable;

    // ────────────────────────────
    // Joined
    // ────────────────────────────
    private final MentorRepositoryJoined mentorRepositoryJoined;
    private final UserRepositoryJoined userRepositoryJoined;
    private final TARepositoryJoined taRepositoryJoined;

    // ────────────────────────────
    // Table Per Class
    // ────────────────────────────
    private final MentorRepositoryTPC mentorRepositoryTPC;
    private final StudentRepositoryTPC studentRepositoryTPC;
    private final TARepositoryTPC taRepositoryTPC;

    // ────────────────────────────
    // Mapped Super Class
    // ────────────────────────────
    private final MentorRepositoryMSC mentorRepositoryMSC;
    private final StudentRepositoryMSC studentRepositoryMSC;
    private final TARepositoryMSC taRepositoryMSC;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    // ------------------- Cardinality mappings ----------------

    public ScalerProject1Application(
            MentorRepositorySingleTable mentorRepositorySingleTable,
            UserRepositorySingleTable userRepositorySingleTable,
            TARepositorySingleTable taRepositorySingleTable,

            MentorRepositoryJoined mentorRepositoryJoined,
            UserRepositoryJoined userRepositoryJoined,
            TARepositoryJoined taRepositoryJoined,

            MentorRepositoryTPC mentorRepositoryTPC,
            StudentRepositoryTPC studentRepositoryTPC,
            TARepositoryTPC taRepositoryTPC,

            MentorRepositoryMSC mentorRepositoryMSC,
            StudentRepositoryMSC studentRepositoryMSC,
            TARepositoryMSC taRepositoryMSC,
            CategoryRepository categoryRepository,
            ProductRepository productRepository) {

        // Single Table
        this.mentorRepositorySingleTable = mentorRepositorySingleTable;
        this.userRepositorySingleTable = userRepositorySingleTable;
        this.taRepositorySingleTable = taRepositorySingleTable;

        // Joined
        this.mentorRepositoryJoined = mentorRepositoryJoined;
        this.userRepositoryJoined = userRepositoryJoined;
        this.taRepositoryJoined = taRepositoryJoined;

        // TablePerClass
        this.mentorRepositoryTPC = mentorRepositoryTPC;
        this.studentRepositoryTPC = studentRepositoryTPC;
        this.taRepositoryTPC = taRepositoryTPC;

        // MappedSuperClass
        this.mentorRepositoryMSC = mentorRepositoryMSC;
        this.studentRepositoryMSC = studentRepositoryMSC;
        this.taRepositoryMSC = taRepositoryMSC;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ScalerProject1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // 1) ─────────── Single Table Strategy
        MentorSingleTable m1 = new MentorSingleTable();
        m1.setName("Mentor Single A");
        m1.setEmail("mentor.st@example.com");
        m1.setAvg_rating(4.8);
        mentorRepositorySingleTable.save(m1);

        StudentSingleTable s1 = new StudentSingleTable();
        s1.setName("Student Single A");
        s1.setEmail("student.st@example.com");
        s1.setPsp(78.5);
        s1.setAttendance(90.0);
        userRepositorySingleTable.save(s1);

        TASingleTable t1 = new TASingleTable();
        t1.setName("TA Single A");
        t1.setEmail("ta.st@example.com");
        t1.setAve_rating(9.1);
        taRepositorySingleTable.save(t1);

        // 2) ─────────── Joined Strategy
        MentorJoined mj = new MentorJoined();
        mj.setName("Mentor Joined A");
        mj.setEmail("mentor.joined@example.com");
        mj.setAvg_rating(4.6);
        mentorRepositoryJoined.save(mj);

        StudentJoined sj = new StudentJoined();
        sj.setName("Student Joined A");
        sj.setEmail("student.joined@example.com");
        sj.setPsp(80.0);
        sj.setAttendance(92.5);
        userRepositoryJoined.save(sj);

        TAJoined tj = new TAJoined();
        tj.setName("TA Joined A");
        tj.setEmail("ta.joined@example.com");
        tj.setAve_rating(8.9);
        taRepositoryJoined.save(tj);

        // 3) ─────────── TablePerClass Strategy (using UUID IDs)
        MentorTPC mtpc = new MentorTPC();
        mtpc.setName("Ritik");
        mtpc.setEmail("ritik@gmail.com");
       mtpc.setAvg_rating(4.5);
        mentorRepositoryTPC.save(mtpc);

        StudentTPC stpc = new StudentTPC();
        stpc.setName("Ankit");
        stpc.setEmail("ankit@gmail.com");
        stpc.setPsp(90.5);
        stpc.setAttendance(98);
        studentRepositoryTPC.save(stpc);

        TATPC tatpc = new TATPC();
        tatpc.setName("Priyanshu");
        tatpc.setEmail("priyanshu@gmail.com");
        tatpc.setAve_rating(9.8);
        taRepositoryTPC.save(tatpc);

        // 4) ─────────── MappedSuperClass Strategy
        MentorMSC mm = new MentorMSC();
        mm.setName("Mentor MSC A");
        mm.setEmail("mentor.msc@example.com");
        mm.setAvg_rating(4.5);
        mentorRepositoryMSC.save(mm);

        StudentMSC sm = new StudentMSC();
        sm.setName("Student MSC A");
        sm.setEmail("student.msc@example.com");
        sm.setPsp(88.0);
        sm.setAttendance(96.0);
        studentRepositoryMSC.save(sm);

        TAMSC tam = new TAMSC();
        tam.setName("TA MSC A");
        tam.setEmail("ta.msc@example.com");
        tam.setAve_rating(9.0);
        taRepositoryMSC.save(tam);

        System.out.println("✔ Sample data inserted for ALL inheritance strategies.");

        // ===================== Cardinality mappings ========
        Category category = new Category();
        category.setName("cloths");
       Category saveCategory = categoryRepository.save(category);

        Product product = new Product();
        product.setTitle("new Product");
        product.setPrice(500);
        product.setDescription("this is one of important book for developer");
        product.setImage("/cloudnary/ritik/product/34");
        product.setCategory(saveCategory);
        productRepository.save(product);


    }
}
