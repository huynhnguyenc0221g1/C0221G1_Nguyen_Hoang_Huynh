package controllers;

import commons.IOFile;
import commons.IOString;
import commons.Validators;
import models.DanhBa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainControllers {
    public static Scanner scanner = new Scanner(System.in);
    public static List<DanhBa> listDanhBa = new ArrayList<>();
    public static final String DANHBA = "contacts";

    public static void displayMainMenu() {
        String choice = null;
        do {
            System.out.println("Mời chọn:");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    xemDanhSach();
                    displayMainMenu();
                    break;
                case "2":
                    themMoi();
                    break;
                case "3":
                    capNhat();
                    break;
                case "4":
                    xoa();
                    break;
                case "5":
                    timKiem();
                    break;
                case "6":
                    docTuFile(DANHBA);
                    break;
                case "7":
                    ghiVaoFile(DANHBA);
                    break;

                case "8":
                    System.exit(0);
                default:
                    System.out.println("Not a valid input!");
                    break;
            }
        } while (!choice.equals("8"));

    }

    private static void ghiVaoFile(String fileName) {
        IOFile.setFilePath(fileName);
        String choice = null;
        System.out.println("Nhập Y nhận lại dữ liệu  file contacts.csv!");
        choice = scanner.nextLine();
        if (choice.equals("Y") || choice.equals("y")) {
            for (DanhBa danhBa : listDanhBa) {
                IOFile.writeFile(new String[]{danhBa.getSoDientThoai(), danhBa.getNhomDanhBa(), danhBa.getTen(),
                        danhBa.getGioiTinh(), danhBa.getDiaChi(), danhBa.getNgaySinh(), danhBa.getEmail()});
            }
        }else {
            displayMainMenu();
        }
    }

    private static List<DanhBa> docDanhBa(String fileName) {
        IOFile.setFilePath(fileName);
        List<String> dataDanhBa = IOFile.readFile();
        List<DanhBa> listDanhBaTuFile = new ArrayList<>();
        String[] dataElements;
        DanhBa danhBa = null;
        for (String data : dataDanhBa) {
            dataElements = data.split(IOString.COMMA);
            danhBa = new DanhBa();
            danhBa.setSoDientThoai(dataElements[0]);
            danhBa.setNhomDanhBa(dataElements[1]);
            danhBa.setTen(dataElements[2]);
            danhBa.setGioiTinh(dataElements[3]);
            danhBa.setDiaChi(dataElements[4]);
            danhBa.setNgaySinh(dataElements[5]);
            danhBa.setEmail(dataElements[6]);
            listDanhBaTuFile.add(danhBa);
        }
        return listDanhBaTuFile;
    }

    private static void docTuFile(String fileName) {
        String choice = null;
        System.out.println("Nhập Y nếu bạn muốn xóa hết dữ liệu gốc và nhận lại dữ liệu từ file contacts.csv!");
        choice = scanner.nextLine();
        if (choice.equals("Y") || choice.equals("y")) {
            listDanhBa.clear();
            for (DanhBa danhBa : docDanhBa(fileName)) {
                danhBa.showInfo();
                listDanhBa.add(danhBa);
            }
        } else {
            displayMainMenu();
        }
    }


    private static void timKiem() {
        String choice = null;
        int count = 0;
        do {
            System.out.println("Bạn có tìm kiếm theo:?");
            System.out.println("1. Số điện thoại");
            System.out.println("2. Tên");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    String soDienThoaiTimKiem = null;
                    System.out.println("Nhập số điện thoại cần tìm kiếm:");
                    soDienThoaiTimKiem = scanner.nextLine();
                    for (DanhBa danhBa : listDanhBa) {
                        if (danhBa.getSoDientThoai().contains(soDienThoaiTimKiem)) {
                            System.out.println("Có tìm thấy số điện thoại gần đúng:");
                            danhBa.showInfo();
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Không tìm thấy số điện thoại " + soDienThoaiTimKiem);
                    }
                    break;
                case "2":
                    String tenTimKiem = null;
                    System.out.println("Nhập têm cần tìm kiếm:");
                    tenTimKiem = scanner.nextLine();
                    for (DanhBa danhBa : listDanhBa) {
                        if (danhBa.getTen().contains(tenTimKiem)) {
                            System.out.println("Có tìm thấy tên gần đúng:");
                            danhBa.showInfo();
                            count++;
                        }
                    }
                    if (count == 0) {
                        System.out.println("Không tìm thấy tên " + tenTimKiem);
                    }
                    break;
                default:
                    System.out.println("Phải chọn 1 hoặc 2!");
                    break;
            }
            if (choice.equals("2")) {
                break;
            }
        } while (!choice.equals("2"));
    }

    private static void xoa() {
        String soDienThoaiXoa = null;
        int index = 0;
        int count = 0;
        System.out.println("Mời nhập số điện thoại cần xóa:");
        soDienThoaiXoa = scanner.nextLine();
        for (DanhBa danhBa : listDanhBa) {
            if (soDienThoaiXoa.equals(danhBa.getSoDientThoai())) {
                index = listDanhBa.indexOf(danhBa);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không tìm thấy số điện thoại! Mời nhập lại!");
        } else {
            String choice = null;
            System.out.println("Nhập Y nếu bạn chắc chắn muốn xóa!");
            choice = scanner.nextLine();
            if (choice.equals("Y")) {
                listDanhBa.remove(index);
            } else {
                displayMainMenu();
            }
        }
    }

    private static void capNhat() {
        String soDienThoaiCapNhat = null;
        int index = 0;
        int count = 0;
        do {
            System.out.println("Mời nhập số điện thoại cần cập nhật:");
            soDienThoaiCapNhat = scanner.nextLine();
        } while (!Validators.inputValidate(soDienThoaiCapNhat,Validators.PHONE_NUMBER_REGEX));
        for (DanhBa danhBa : listDanhBa) {
            if (soDienThoaiCapNhat.equals(danhBa.getSoDientThoai())) {
                index = listDanhBa.indexOf(danhBa);
                count++;
            }
            if (count == 0) {
                System.out.println("Không tìm thấy số điện thoại! Mời nhập lại!");
            } else {
                String nhomDanhBa = null;
                do {
                    System.out.println("Mời nhập nhóm Danh bạ:");
                    nhomDanhBa = scanner.nextLine();
                } while (!Validators.inputValidate(nhomDanhBa, Validators.EMPTY));
                listDanhBa.get(index).setNhomDanhBa(nhomDanhBa);
                String ten = null;
                do {
                    System.out.println("Mời nhập tên::");
                    ten = scanner.nextLine();
                } while (!Validators.inputValidate(ten, Validators.EMPTY));
                listDanhBa.get(index).setTen(ten);
                String gioiTinh = null;
                do {
                    System.out.println("Mời nhập giới tính::");
                    gioiTinh = scanner.nextLine();
                } while (!Validators.inputValidate(gioiTinh, Validators.EMPTY));
                listDanhBa.get(index).setGioiTinh(gioiTinh);
                String diaChi = null;
                do {
                    System.out.println("Mời nhập địa chỉ::");
                    diaChi = scanner.nextLine();
                } while (!Validators.inputValidate(diaChi, Validators.EMPTY));
                listDanhBa.get(index).setDiaChi(diaChi);
                String ngaySinh = null;
                do {
                    System.out.println("Mời nhập ngày sinh::");
                    ngaySinh = scanner.nextLine();
                } while (!Validators.inputValidate(ngaySinh, Validators.EMPTY));
                listDanhBa.get(index).setNgaySinh(ngaySinh);
                String email = null;
                do {
                    System.out.println("Mời nhập email::");
                    email = scanner.nextLine();
                } while (!Validators.inputValidate(email,Validators.EMAIL_REGEX));
                listDanhBa.get(index).setEmail(email);
                ;
            }
        }
    }

    private static void themMoi() {
        String soDienThoai = null;
        do {
            System.out.println("Mời nhập số điện thoại:");
            soDienThoai = scanner.nextLine();
        } while (!Validators.inputValidate(soDienThoai, Validators.PHONE_NUMBER_REGEX));
        String nhomDanhBa = null;
        do {
            System.out.println("Mời nhập nhóm Danh bạ:");
            nhomDanhBa = scanner.nextLine();
        } while (!Validators.inputValidate(nhomDanhBa, Validators.EMPTY));
        String ten = null;
        do {
            System.out.println("Mời nhập tên::");
            ten = scanner.nextLine();
        } while (!Validators.inputValidate(ten, Validators.EMPTY));
        String gioiTinh = null;
        do {
            System.out.println("Mời nhập giới tính::");
            gioiTinh = scanner.nextLine();
        } while (!Validators.inputValidate(gioiTinh, Validators.EMPTY));
        String diaChi = null;
        do {
            System.out.println("Mời nhập địa chỉ::");
            diaChi = scanner.nextLine();
        } while (!Validators.inputValidate(diaChi, Validators.EMPTY));
        String ngaySinh = null;
        do {
            System.out.println("Mời nhập ngày sinh::");
            ngaySinh = scanner.nextLine();
        } while (!Validators.inputValidate(ngaySinh,Validators.EMPTY));
        String email = null;
        do {
            System.out.println("Mời nhập email::");
            email = scanner.nextLine();
        } while (!Validators.inputValidate(email, Validators.EMAIL_REGEX));
        DanhBa danhBaMoi = new DanhBa(soDienThoai, nhomDanhBa, ten, gioiTinh, diaChi, ngaySinh, email);
        listDanhBa.add(danhBaMoi);
    }

    private static void xemDanhSach() {
        String choice = null;
        do {
            System.out.println("Bạn có muốn thêm mới danh bạ không?");
            System.out.println("1. Có");
            System.out.println("2. Không");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    themMoi();
                    break;
                case "2":
                    break;
                default:
                    System.out.println("Phải chọn 1 hoặc 2!");
                    break;
            }
            if (choice.equals("2")) {
                break;
            }
        } while (!choice.equals("2"));
        System.out.println("Số điện thoại:");
        for (DanhBa danhBa : listDanhBa) {
            System.out.println(danhBa.getSoDientThoai());
        }
        scanner.nextLine();
        System.out.println("Nhóm:");
        for (DanhBa danhBa : listDanhBa) {
            System.out.println(danhBa.getNhomDanhBa());
        }
        scanner.nextLine();
        System.out.println("Họ tên:");
        for (DanhBa danhBa : listDanhBa) {
            System.out.println(danhBa.getTen());
        }
        scanner.nextLine();
        System.out.println("Giới tính:");
        for (DanhBa danhBa : listDanhBa) {
            System.out.println(danhBa.getGioiTinh());
        }
        scanner.nextLine();
        System.out.println("Địa chỉ:");
        for (DanhBa danhBa : listDanhBa) {
            System.out.println(danhBa.getDiaChi());
        }
        System.out.println("****************");
        System.out.println("Bấm enter để về lại menu chính!");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
