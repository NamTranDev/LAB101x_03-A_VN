package nam.tran.exercise2;

import nam.tran.exercise1.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerCandidate {

    List<ExperienceCandidate> experienceCandidates;
    List<FresherCandidate> fresherCandidates;
    List<InternCandidate> internCandidates;

    public ManagerCandidate() {
        experienceCandidates = new ArrayList<>();
        fresherCandidates = new ArrayList<>();
        internCandidates = new ArrayList<>();
    }

    private boolean isExist(String id) {
        for (Candidate candidate : experienceCandidates) {
            if (candidate.getId().equals(id)) {
                return true;
            }
        }
        for (Candidate candidate : fresherCandidates) {
            if (candidate.getId().equals(id)) {
                return true;
            }
        }
        for (Candidate candidate : internCandidates) {
            if (candidate.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void insertCandidate(Scanner scanner, int type) {
        while (true) {
            String id;
            while (true) {
                System.out.println("Nhập id ứng viên:");
                id = scanner.next();
                if (isExist(id)) {
                    System.out.println("Id này đã tồn tại trong hệ thống");
                } else {
                    break;
                }
            }
            System.out.println("Nhập họ ứng viên:");
            String firstName = scanner.next();
            System.out.println("Nhập tên ứng viên:");
            String lastName = scanner.next();
            String birthYear;
            while (true) {
                System.out.println("Nhập năm sinh ứng viên:");
                birthYear = scanner.next();
                if (birthYear.length() == 4) {
                    try {
                        int year = Integer.parseInt(birthYear);
                        if (year < 1990 || year > 2022) {
                            System.out.println("Năm sinh từ 1900.. đến năm hiện tại");
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Năm sinh từ 1900.. đến năm hiện tại");
                    }
                } else {
                    System.out.println("Năm sinh từ 1900.. đến năm hiện tại");
                }
            }
            System.out.println("Nhập địa chỉ ứng viên:");
            String address = scanner.next();
            String phone;
            while (true) {
                String regex = "[0-9]+";
                System.out.println("Nhập số điện thoại ứng viên:");
                phone = scanner.next();
                if (phone.length() >= 10 && phone.matches(regex)) {
                    break;
                } else {
                    System.out.println("Số điện thoại tối thiểu 10 số");
                }
            }
            String email;
            while (true) {
                String regex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
                System.out.println("Nhập email ứng viên:");
                email = scanner.next();
                if (email.matches(regex)) {
                    break;
                } else {
                    System.out.println("Nhập đúng định dạng email!!!");
                }
            }
            switch (type) {
                case 1: {
                    int yearExperience;
                    while (true) {
                        System.out.println("Nhập số năm kinh nghiệm của ứng viên:");
                        try {
                            yearExperience = Integer.parseInt(scanner.next());
                            if (yearExperience < 0 || yearExperience > 100) {
                                System.out.println("Số năm kinh nghiệm từ 0 -> 100");
                            } else {
                                break;
                            }
                        } catch (Exception e) {
                            System.out.println("Số năm kinh nghiệm từ 0 -> 100");
                        }
                    }
                    System.out.println("Nhập kỹ năng chuyên môn của ứng viên:");
                    String proSkill = scanner.next();
                    experienceCandidates.add(new ExperienceCandidate(id, firstName, lastName, birthYear, address, phone, email, yearExperience, proSkill));
                    break;
                }
                case 2: {
                    System.out.println("Nhập thời gian tốt nghiệp của ứng viên:");
                    String graduationDate = scanner.next();
                    String graduationRank = inputGraduationRank(scanner);
                    System.out.println("Nhập trường đại học ứng viên đã tốt nghiệp:");
                    String education = scanner.next();
                    fresherCandidates.add(new FresherCandidate(id, firstName, lastName, birthYear, address, phone, email, graduationDate, graduationRank, education));
                    break;
                }
                case 3: {
                    System.out.println("Nhập chuyên ngành của ứng viên:");
                    String major = scanner.next();
                    System.out.println("Nhập học kỳ của ứng viên:");
                    String semester = scanner.next();
                    System.out.println("Nhập tên trường đại học của ứng viên:");
                    String nameUniversity = scanner.next();
                    internCandidates.add(new InternCandidate(id, firstName, lastName, birthYear, address, phone, email, major, semester, nameUniversity));
                    break;
                }
            }
            System.out.println("Bạn có muốn tiếp tục (Y/N):");
            String answer = scanner.next();
            if (answer.toLowerCase().equals("n")) {
                displayCandidate();
                break;
            }
        }
    }

    public void search(Scanner scanner) {
        System.out.println("Danh sách ứng viên:");
        displayCandidate();
        System.out.println("Nhập tên ứng viên (Họ hoặc Tên):");
        String name = scanner.next();
        System.out.println("Nhập loại ứng viên:");
        int type;
        while (true) {
            try {
                type = Integer.parseInt(scanner.next());
                if (type < 1 || type > 3) {
                    System.out.println("Vui lòng chọn loại ứng viên phù hợp");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Vui lòng chọn loại ứng viên phù hợp");
            }
        }
        List<Candidate> found = new ArrayList<>();
        switch (type) {
            case 1: {
                for (Candidate candidate : experienceCandidates) {
                    if (candidate.getFirstName().toLowerCase().contains(name) || candidate.getLastName().toLowerCase().contains(name)) {
                        found.add(candidate);
                    }
                }
                break;
            }
            case 2: {
                for (Candidate candidate : fresherCandidates) {
                    if (candidate.getFirstName().toLowerCase().contains(name) || candidate.getLastName().toLowerCase().contains(name)) {
                        found.add(candidate);
                    }
                }
                break;
            }
            case 3: {
                for (Candidate candidate : internCandidates) {
                    if (candidate.getFirstName().toLowerCase().contains(name) || candidate.getLastName().toLowerCase().contains(name)) {
                        found.add(candidate);
                    }
                }
                break;
            }
        }
        if (found.isEmpty()) {
            System.out.println("Không tìm thấy ứng viên!!!");
        } else {
            for (Candidate candidate : found) {
                System.out.println(candidate.toString());
            }
        }
    }

    private void displayCandidate() {
        if (!experienceCandidates.isEmpty()) {
            System.out.println("===========ỨNG VIÊN CÓ KINH NGHIỆM============");
            for (Candidate candidate : experienceCandidates) {
                candidate.displayName();
            }
        }
        if (!fresherCandidates.isEmpty()) {
            System.out.println("==========ỨNG VIÊN FRESHER==============");
            for (Candidate candidate : fresherCandidates) {
                candidate.displayName();
            }
        }
        if (!internCandidates.isEmpty()) {
            System.out.println("===========ỨNG VIÊN THỰC TẬP SINH==============");
            for (Candidate candidate : internCandidates) {
                candidate.displayName();
            }
        }
    }

    private String inputGraduationRank(Scanner scanner) {
        String[] graduationRanks = new String[3];
        graduationRanks[0] = "Xuất sắc";
        graduationRanks[1] = "Tốt";
        graduationRanks[2] = "Khá";
        graduationRanks[3] = "Kém";
        String graduationRank = graduationRanks[0];
        boolean isCompleteChooseGraduationRank = false;
        while (!isCompleteChooseGraduationRank) {
            System.out.println("Chọn xếp loại tốt nghiệp:");

            System.out.println("1 : Xuất sắc\n2 : Tốt\n3 : Khá\n4: Kém");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1: {
                    graduationRank = graduationRanks[0];
                    isCompleteChooseGraduationRank = true;
                    break;
                }
                case 2: {
                    graduationRank = graduationRanks[1];
                    isCompleteChooseGraduationRank = true;
                    break;
                }
                case 3: {
                    graduationRank = graduationRanks[2];
                    isCompleteChooseGraduationRank = true;
                    break;
                }
                case 4: {
                    graduationRank = graduationRanks[3];
                    isCompleteChooseGraduationRank = true;
                    break;
                }
                default:
                    System.out.println("Bạn cần chọn xếp loại tốt nghiệp phù hợp!!!");
                    break;
            }
        }
        return graduationRank;
    }

}
