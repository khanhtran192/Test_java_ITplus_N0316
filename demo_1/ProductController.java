package demo_1;

import java.util.ArrayList;
import java.util.List;

public class ProductController extends Input implements Activity, Shopping {

    static List<Product> SanPham = new ArrayList<Product>();
    static List<Product> GioHang = new ArrayList<Product>();

    // them san pham moi vao danh sach
    @Override
    public void init() {
        Product sanPham = new Product();
        System.out.println("Nhap so san pham muon them");
        long soSanPham = inputScannerInt();
        for (int i = 1; i <= soSanPham; i++) {
            System.out.println("Ma san pham muon them thu " + i + " : ");
            sanPham.setProductId(inputScannerInt());
            System.out.println("Ten san pham muon them thu " + i + " : ");
            sanPham.setProductName(inputScannerString());
            System.out.println("Gia san pham muon them thu " + i + " : ");
            sanPham.setPrice((int) inputScannerInt());
            SanPham.add(sanPham);
        }
    }

    // hien thi toan bo san pham
    @Override
    public void viewAll() {
        if (SanPham.isEmpty()) {
            System.out.println("Danh sach rong");
            System.out.println("Them san pham vao danh sach");
            init();
        } else {
            for (int i = 1; i <= SanPham.size(); i++) {
                System.out.println("Ten san pham thu " + i + " : " + SanPham.get(i).getProductName());
                System.out.println("Ma san pham thu " + i + " : " + SanPham.get(i).getProductId());
                System.out.println("Gia san pham thu " + i + " : " + SanPham.get(i).getPrice());
            }
        }
        menu();
    }

    // Them san pham vao gio
    @Override
    public void addCart() {
        // List<Product> GioHang = new ArrayList<Product>();
        Product sanPham = new Product();
        System.out.println("Nhap so loai san pham muon them vao gio: ");
        int soloai = (int) inputScannerInt();
        for (int i = 1; i <= soloai; i++) {
            System.out.println("Ma san pham muon them vao gio thu " + i + " :");
            sanPham.setProductId(inputScannerInt());
            for (int j = 1; j <= SanPham.size(); j++) {
                if (SanPham.get(j).getProductId() == sanPham.getProductId()) {
                    sanPham = SanPham.get(j);
                    System.out.println("So luong san pham muon them vao gio");
                    SanPham.get(j).setProductNumber((int) inputScannerInt());
                    GioHang.add(sanPham);
                }

                else {
                    System.out.println("Khong trung ma");
                }
            }
        }
        for (int i = 1; i <= soloai; i++) {
            System.out.println("Ten san pham trong gio thu " + i + " :" + GioHang.get(i).getProductName());
            System.out.println("So luong san pham trong gio thu " + i + " :" + GioHang.get(i).getProductNumber());
        }
        menu();

    }

    // Hien thi hoa don
    @Override
    public void bill() {
        if (GioHang.isEmpty()) {
            System.out.println("Danh sach rong");
            System.out.println("Them san pham vao gio");
            addCart();
        } else {
            System.out.println("Danh sach gio hang");
            for (int i = 1; i <= GioHang.size(); i++) {
                System.out.println("Ten san pham " + i + " :" + GioHang.get(i).getProductName());
                System.out.println("Gia luong san pham " + i + " :" + GioHang.get(i).getPrice());
                System.out.println("So luong san pham " + i + " :" + GioHang.get(i).getProductNumber());
            }

            Product sanPham = new Product();
            for (int i = 1; i <= GioHang.size(); i++) {
                sanPham.setTotalPrice(GioHang.get(i).getPrice() * GioHang.get(i).getProductNumber());
            }
            System.out.println("Tong tien: " + sanPham.getTotalPrice());
        }
        menu();

    }

    // Menu
    static boolean isNotExit = true;

    public void menu() {
        System.out.println("1. Them san pham vao danh sach");
        System.out.println("2. Hien thi toan bo danh sach san pham");
        System.out.println("3. Them san pham vao gio hang");
        System.out.println("4. Hien thi hoa don");
        System.out.println("5. Thoat");

        int seleted = (int) inputScannerInt();
        switch (seleted) {
            case 1:
                init();
                break;
            case 2:
                viewAll();
                break;
            case 3:
                addCart();
                break;
            case 4:
                bill();
                break;
            case 5:
                isNotExit = false;
                break;
        }
    }
}
