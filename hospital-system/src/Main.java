import java.util.*;
public class Main {
    static Scanner sc = new Scanner(System.in);
    // -------- Storage --------
    static List<Patient> patients = new ArrayList<>();
    static List<Doctor> doctors = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Bill> bills = new ArrayList<>();
    // -------- Patient Class --------
    static class Patient {
        String id, name, gender, phone;
        int age;
        Patient(String id, String name, int age, String gender, String phone) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.phone = phone;
        }
    }
    // -------- Doctor Class --------
    static class Doctor {
        String id, name, department, phone;
        Doctor(String id, String name, String department, String phone) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.phone = phone;
        }
    }
    // -------- Appointment Class --------
    static class Appointment {
        String appointmentId;
        String patientId;
        String doctorId;
        String date;
        String time;
        Appointment(String appointmentId, String patientId, String doctorId, String date, String time) {
            this.appointmentId = appointmentId;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.date = date;
            this.time = time;
        }
    }
    // -------BILL CLASS ---------
    static class Bill {
        String billId;
        String appointmentId;
        double consultationFee;
        double medicineFee;
        double total;
        Bill(String billId, String appointmentId, double consultationFee, double medicineFee) {
            this.billId = billId;
            this.appointmentId = appointmentId;
            this.consultationFee = consultationFee;
            this.medicineFee = medicineFee;
            this.total = consultationFee + medicineFee;
        }
    }
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===============================");
            System.out.println("  HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("===============================");
            System.out.println("1. Patient Module");
            System.out.println("2. Doctor Module");
            System.out.println("3. Appointment Module");
            System.out.println("4. Billing Module");
            System.out.println("5. Exit");
            System.out.println("===============================");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> patientMenu();
                case 2 -> doctorMenu();
                case 3 -> appointmentMenu();
                case 4 -> billingMenu();
                case 5 -> {
                    System.out.println("System exited.");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    // ================= PATIENT MODULE =================
    static void patientMenu() {
        while (true) {
            System.out.println("\n--- Patient Module ---");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> registerPatient();
                case 2 -> viewPatients();
                case 3 -> searchPatient();
                case 4 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    static void registerPatient() {
        System.out.println("\n--- Register Patient ---");
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        patients.add(new Patient(id, name, age, gender, phone));
        System.out.println("Patient registered successfully.");
    }
    static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (Patient p : patients) {
            System.out.println("---------------------------");
            System.out.println("ID: " + p.id);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Gender: " + p.gender);
            System.out.println("Phone: " + p.phone);
        }
    }
    static void searchPatient() {
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();
        for (Patient p : patients) {
            if (p.id.equals(id)) {
                System.out.println("Patient Found: " + p.name);
                return;
            }
        }
        System.out.println("Patient not found.");
    }
    // ================= DOCTOR MODULE =================
    static void doctorMenu() {
        while (true) {
            System.out.println("\n--- Doctor Module ---");
            System.out.println("1. Register Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Search Doctor");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> registerDoctor();
                case 2 -> viewDoctors();
                case 3 -> searchDoctor();
                case 4 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    static void registerDoctor() {
        System.out.println("\n--- Register Doctor ---");
        System.out.print("Enter Doctor ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();
        doctors.add(new Doctor(id, name, dept, phone));
        System.out.println("Doctor registered successfully.");
    }
    static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        for (Doctor d : doctors) {
            System.out.println("---------------------------");
            System.out.println("ID: " + d.id);
            System.out.println("Name: " + d.name);
            System.out.println("Department: " + d.department);
            System.out.println("Phone: " + d.phone);
        }
    }
    static void searchDoctor() {
        System.out.print("Enter Doctor ID: ");
        String id = sc.nextLine();
        for (Doctor d : doctors) {
            if (d.id.equals(id)) {
                System.out.println("Doctor Found: " + d.name);
                return;
            }
        }
        System.out.println("Doctor not found.");
    }
    // ================= APPOINTMENT MODULE =================
    static void appointmentMenu() {
        while (true) {
            System.out.println("\n--- Appointment Module ---");
            System.out.println("1. Book Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Search Appointment");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> bookAppointment();
                case 2 -> viewAppointments();
                case 3 -> searchAppointment();
                case 4 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    static void bookAppointment() {
        System.out.println("\n--- Book Appointment ---");
        System.out.print("Enter Appointment ID: ");
        String aid = sc.nextLine();
        System.out.print("Enter Patient ID: ");
        String pid = sc.nextLine();
        System.out.print("Enter Doctor ID: ");
        String did = sc.nextLine();
        System.out.print("Enter Date (DD-MM-YYYY): ");
        String date = sc.nextLine();
        System.out.print("Enter Time (HH:MM): ");
        String time = sc.nextLine();
        appointments.add(new Appointment(aid, pid, did, date, time));
        System.out.println("Appointment booked successfully.");
    }
    static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        for (Appointment a : appointments) {
            System.out.println("---------------------------");
            System.out.println("Appointment ID: " + a.appointmentId);
            System.out.println("Patient ID    : " + a.patientId);
            System.out.println("Doctor ID     : " + a.doctorId);
            System.out.println("Date          : " + a.date);
            System.out.println("Time          : " + a.time);
        }
    }
    static void searchAppointment() {
        System.out.print("Enter Appointment ID: ");
        String id = sc.nextLine();
        for (Appointment a : appointments) {
            if (a.appointmentId.equals(id)) {
                System.out.println("\nAppointment Found:");
                System.out.println("Patient ID: " + a.patientId);
                System.out.println("Doctor ID : " + a.doctorId);
                System.out.println("Date      : " + a.date);
                System.out.println("Time      : " + a.time);
                return;
            }
        }
        System.out.println("Appointment not found.");
    }
    // ================= BILLING MODULE =================
    static void billingMenu() {
        while (true) {
            System.out.println("\n--- Billing Module ---");
            System.out.println("1. Generate Bill");
            System.out.println("2. View Bills");
            System.out.println("3. Search Bill");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1 -> generateBill();
                case 2 -> viewBills();
                case 3 -> searchBill();
                case 4 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }
    static void generateBill() {
    System.out.println("\n--- Generate Bill ---");

    System.out.print("Enter Bill ID: ");
    String bid = sc.nextLine();

    System.out.print("Enter Appointment ID: ");
    String aid = sc.nextLine();

    System.out.print("Consultation Fee: ");
    double cf = sc.nextDouble();

    System.out.print("Medicine Fee: ");
    double mf = sc.nextDouble();
    sc.nextLine();

    bills.add(new Bill(bid, aid, cf, mf));

    System.out.println("Bill generated successfully.");
}

static void viewBills() {
    if (bills.isEmpty()) {
        System.out.println("No bills found.");
        return;
    }

    for (Bill b : bills) {
        System.out.println("---------------------------");
        System.out.println("Bill ID        : " + b.billId);
        System.out.println("Appointment ID : " + b.appointmentId);
        System.out.println("Consultation   : " + b.consultationFee);
        System.out.println("Medicine       : " + b.medicineFee);
        System.out.println("Total          : " + b.total);
    }
}

static void searchBill() {
    System.out.print("Enter Bill ID: ");
    String id = sc.nextLine();

    for (Bill b : bills) {
        if (b.billId.equals(id)) {
            System.out.println("Bill Found → Total: " + b.total);
            return;
        }
    }
    System.out.println("Bill not found.");
}
}