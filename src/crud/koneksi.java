/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author acer
 */
public class koneksi {
   private String database_name = "2210010133";
   private String username = "root";
   private String password = "";
   public Connection koneksiDB;
   
   public koneksi(){
   
       try {
           String lokasi = "jdbc:mysql://localhost/"+ database_name;
           Class.forName("com.mysql.jdbc.Driver");
           koneksiDB= DriverManager.getConnection(lokasi, username, password);
           System.out.println("Database Terkoneksi");
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
   public void createUser(String id_user, String nama_user, String user_name, String password, String email) {
        String sql = "INSERT INTO tb_user (id_user, nama_user, user_name, password, email) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_user);
            perintah.setString(2, nama_user);
            perintah.setString(3, user_name);
            perintah.setString(4, password);
            perintah.setString(5, email);
            perintah.executeUpdate();
            System.out.println("User created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void readUser(String id_user) {
    String sql = "SELECT * FROM tb_user WHERE id_user = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_user);
            ResultSet rs = perintah.executeQuery();
            while (rs.next()) {
                System.out.println("ID User: " + rs.getString("id_user"));
                System.out.println("Nama User: " + rs.getString("nama_user"));
                System.out.println("Username: " + rs.getString("user_name"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("Email: " + rs.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void updateUser(String id_user, String nama_user, String user_name, String password, String email) {
    String sql = "UPDATE tb_user SET nama_user = ?, user_name = ?, password = ?, email = ? WHERE id_user = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, nama_user);
            perintah.setString(2, user_name);
            perintah.setString(3, password);
            perintah.setString(4, email);
            perintah.setString(5, id_user);
            perintah.executeUpdate();
            System.out.println("User updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void deleteUser(String id_user) {
    String sql = "DELETE FROM tb_user WHERE id_user = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_user);
            perintah.executeUpdate();
            System.out.println("User deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void GetRecordUser(){
       try {
           String sql = "SELECT * FROM tb_user ORDER BY id_user asc";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           while (data.next()){
               System.out.println(
               data.getString("id_user") + " | " +
               data.getString("nama_user") + " | " +
               data.getString("user_name") + " | " +
               data.getString("password") + " | " +
               data.getString("email")
               );
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
   public int JumlahRecordUser(){
       int jumlah = 0;
       try {
           String sql = "SELECT * FROM tb_user ORDER BY id_user ASC";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           
           while(data.next()){
               jumlah = jumlah + 1;
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return jumlah;
   }
   
   
   public void createBukuTamu(String id_bukutamu, String id_user, String nama_tamu, String email, String perihal) {
        String sql = "INSERT INTO tb_bukutamu ( id_bukutamu, id_user, nama_tamu, email, perihal) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_bukutamu);
            perintah.setString(2, id_user);
            perintah.setString(3, nama_tamu);
            perintah.setString(4, email);
            perintah.setString(5, perihal);
            perintah.executeUpdate();
            System.out.println("BukuTamu created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void readBukuTamu(String id_bukutamu) {
    String sql = "SELECT * FROM tb_bukutamu WHERE id_bukutamu = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_bukutamu);
            ResultSet rs = perintah.executeQuery();
            while (rs.next()) {
                System.out.println("ID BukuTamu: " + rs.getString("id_bukutamu"));
                System.out.println("ID User: " + rs.getString("id_user"));
                System.out.println("Nama Tamu: " + rs.getString("nama_tamu"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Perihal: " + rs.getString("perihal"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void updateBukuTamu(String id_bukutamu, String id_user, String nama_tamu, String email, String perihal) {
    String sql = "UPDATE tb_bukutamu SET id_user = ?, nama_tamu = ?, email = ?, perihal = ? WHERE id_bukutamu = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_user);
            perintah.setString(2, nama_tamu);
            perintah.setString(3, email);
            perintah.setString(4, perihal);
            perintah.setString(5, id_bukutamu);
            perintah.executeUpdate();
            System.out.println("BukuTamu updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void deleteBukuTamu(String id_bukutamu) {
    String sql = "DELETE FROM tb_bukutamu WHERE id_bukutamu = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_bukutamu);
            perintah.executeUpdate();
            System.out.println("BukuTamu deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void GetRecordBukuTamu(){
       try {
           String sql = "SELECT * FROM tb_bukutamu ORDER BY id_user asc";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           while (data.next()){
               System.out.println(
               data.getString("id_bukutamu") + " | " +
               data.getString("id_user") + " | " +
               data.getString("nama_tamu") + " | " +
               data.getString("email") + " | " +
               data.getString("perihal")
               );
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
   public int JumlahRecordBukuTamu(){
       int jumlah = 0;
       try {
           String sql = "SELECT * FROM tb_bukutamu ORDER BY id_user ASC";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           
           while(data.next()){
               jumlah = jumlah + 1;
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return jumlah;
   }
   
   public void createAdmin(String id_admin, String nama_admin, String kategori, String telepon, String username, String password, String level, String column ) {
        String sql = "INSERT INTO tb_admin ( id_admin, nama_admin, nama_tamu, kategori, telepon, username, password, level, column) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_admin);
            perintah.setString(2, nama_admin);
            perintah.setString(3, kategori);
            perintah.setString(4, telepon);
            perintah.setString(5, username);
            perintah.setString(6, password);
            perintah.setString(7, level);
            perintah.setString(8, column);
            perintah.executeUpdate();
            System.out.println("Admin created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void readAdmin(String id_admin) {
    String sql = "SELECT * FROM tb_admin WHERE id_admin = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_admin);
            ResultSet rs = perintah.executeQuery();
            while (rs.next()) {
                System.out.println("ID Admin: " + rs.getString("id_admin"));
                System.out.println("Nama Admin: " + rs.getString("nama_admin"));
                System.out.println("Kategori: " + rs.getString("kategori"));
                System.out.println("Telepon: " + rs.getString("telepon"));
                System.out.println("Username: " + rs.getString("username"));
                System.out.println("Password: " + rs.getString("password"));
                System.out.println("Level: " + rs.getString("level"));
                System.out.println("Column: " + rs.getString("column"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void updateAdmin(String id_admin, String nama_admin, String kategori, String telepon, String username, String password, String level, String column) {
    String sql = "UPDATE tb_admin SET nama_admin = ?, kategori = ?, telepon = ?, username = ?, password = ?, level = ?, column = ? WHERE id_admin = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, nama_admin);
            perintah.setString(2, kategori);
            perintah.setString(3, telepon);
            perintah.setString(4, username);
            perintah.setString(5, password);
            perintah.setString(6, level);
            perintah.setString(7, column);
            perintah.setString(8, id_admin);
            perintah.executeUpdate();
            System.out.println("Admin updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void deleteAdmin(String id_admin) {
    String sql = "DELETE FROM tb_admin WHERE id_admin = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_admin);
            perintah.executeUpdate();
            System.out.println("Admin deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void GetRecordAdmin(){
       try {
           String sql = "SELECT * FROM tb_admin ORDER BY id_user asc";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           while (data.next()){
               System.out.println(
               data.getString("id_admin") + " | " +
               data.getString("nama_admin") + " | " +
               data.getString("kategori") + " | " +
               data.getString("telepon") + " | " +
               data.getString("username") + " | " +
               data.getString("password") + " | " +
               data.getString("level") + " | " +
               data.getString("column")
               );
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
   public int JumlahRecordAdmin(){
       int jumlah = 0;
       try {
           String sql = "SELECT * FROM tb_admin ORDER BY id_user ASC";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           
           while(data.next()){
               jumlah = jumlah + 1;
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return jumlah;
   }
   
   
   public void createKategoriAdmin(String id_kategori, String nama_kategori, String hak_akses) {
        String sql = "INSERT INTO tb_kategori_admin ( id_kategori, nama_kategori, hak_akses) VALUES (?, ?, ?)";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_kategori);
            perintah.setString(2, nama_kategori);
            perintah.setString(3, hak_akses);      
            perintah.executeUpdate();
            System.out.println("Kategori Admin created");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void readKategoriAdmin(String id_kategori) {
    String sql = "SELECT * FROM tb_kategori_admin WHERE id_kategori = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_kategori);
            ResultSet rs = perintah.executeQuery();
            while (rs.next()) {
                System.out.println("ID Kategori: " + rs.getString("id_kategori"));
                System.out.println("Nama Kategori: " + rs.getString("nama_kategori"));
                System.out.println("Hak Akses: " + rs.getString("hak_akses"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void updateKategoriAdmin(String id_kategori, String nama_kategori, String hak_akses) {
    String sql = "UPDATE tb_kategori_admin SET nama_kategori = ?, hak_akses = ? WHERE id_kategori = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, nama_kategori);
            perintah.setString(2, hak_akses);
            perintah.setString(3, id_kategori);
            perintah.executeUpdate();
            System.out.println("Kategori Admin updated");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void deleteKategoriAdmin(String id_kategori) {
    String sql = "DELETE FROM tb_kategori_admin WHERE id_kategori = ?";
        try (PreparedStatement perintah = koneksiDB.prepareStatement(sql)) {
            perintah.setString(1, id_kategori);
            perintah.executeUpdate();
            System.out.println("Kategori Admin deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
   public void GetRecordKategoriAdmin(){
       try {
           String sql = "SELECT * FROM tb_kategori_admin ORDER BY id_user asc";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           while (data.next()){
               System.out.println(
               data.getString("id_kategori") + " | " +
               data.getString("nama_kategori") + " | " +
               data.getString("hak_akses")
               );
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
   public int JumlahRecordKategoriAdmin(){
       int jumlah = 0;
       try {
           String sql = "SELECT * FROM tb_kategori_admin ORDER BY id_user ASC";
           Statement perintah = koneksiDB.createStatement();
           
           ResultSet data = perintah.executeQuery(sql);
           
           while(data.next()){
               jumlah = jumlah + 1;
           }
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return jumlah;
   }

}
