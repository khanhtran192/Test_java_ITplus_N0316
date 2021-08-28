package bai2;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Product {
    static List<Product> SanPham = new ArrayList<Product>();
    public static void main(String[] args) throws IOException {
        List<Product> danhSachSanPham = new ArrayList<>();
        File fileSanPham = new File("Product.txt");
        if (!fileSanPham.exists()) {
            System.out.println("File khong ton tai");
            fileSanPham.createNewFile();
       }
       FileReader fileReader = new FileReader(fileSanPham);
        Scanner scanner = new Scanner(fileReader);
        while(scanner.hasNextLine()) {
            String stringProduct = scanner.nextLine();
            String[] thongTinSanPham = stringProduct.split(";");
            Product product = new Product();
            product.setProductId(Long.parseLong(thongTinSanPham[0]));
            product.setProductName(thongTinSanPham[1]);
            product.setPrice(Integer.parseInt(thongTinSanPham[2]));
            danhSachSanPham.add(product);
        }

        FileWriter fileWriter = new FileWriter(fileSanPham);
        try (fileWriter) {
         for (int i = 0; i < danhSachSanPham.size(); i++) {
            Product product = danhSachSanPham.get(i);
            String thongTinSanpham = product.getProductId() + ";" + product.getProductName() + ";" + product.getPrice();
            fileWriter.write(thongTinSanpham);
        }    
            fileWriter.flush();
        } catch (Exception e) {
            System.out.println("Ghi file ");
        }
        System.out.println("So san pham:" + danhSachSanPham.size());
        for(int i = 1; i <= danhSachSanPham.size(); i++){
            System.out.println(danhSachSanPham.get(i).getProductId());
            System.out.println(danhSachSanPham.get(i).getProductName());
            System.out.println(danhSachSanPham.get(i).getPrice());
        }
        int temp = danhSachSanPham.get(0);
        for(int i = 0; i < danhSachSanPham.size(); i++){
            for(int j = i+1; j < danhSachSanPham.size(); j++){
                if(danhSachSanPham.get(i).getPrice()>danhSachSanPham.get(j).getPrice()){
                    temp = danhSachSanPham.get(j).getPrice();
                    danhSachSanPham.get(j) = danhSachSanPham.get(i);
                    danhSachSanPham.get(i) = temp;
            }
            System.out.println(danhSachSanPham.get(i).getPrice() + " ");
        }
    }
}
