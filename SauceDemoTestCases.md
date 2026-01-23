# Test Case untuk Aplikasi SauceDemo

Di bawah ini adalah kumpulan test case yang mencakup berbagai fungsionalitas dari aplikasi `saucedemo`, mulai dari pengujian positif (happy path) hingga pengujian negatif (negative path).

---

## **Feature: Fungsionalitas Login**

### Skenario Positif
```gherkin
  Skenario: Login berhasil menggunakan kredensial yang valid
    Given Saya berada di halaman login
    When Saya memasukkan username "standard_user" dan password "secret_sauce"
    And Saya menekan tombol Login
    Then Saya berhasil masuk dan diarahkan ke halaman inventaris
```

### Skenario Negatif
```gherkin
  Skenario: Login gagal karena password salah
    Given Saya berada di halaman login
    When Saya memasukkan username "standard_user" dan password "password_salah"
    And Saya menekan tombol Login
    Then Saya gagal masuk dan melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  Skenario: Login gagal karena username tidak terdaftar
    Given Saya berada di halaman login
    When Saya memasukkan username "user_tidak_terdaftar" dan password "secret_sauce"
    And Saya menekan tombol Login
    Then Saya gagal masuk dan melihat pesan error "Epic sadface: Username and password do not match any user in this service"

  Skenario: Login gagal karena input dikosongkan
    Given Saya berada di halaman login
    When Saya tidak memasukkan username dan password
    And Saya menekan tombol Login
    Then Saya gagal masuk dan melihat pesan error "Epic sadface: Username is required"
```

---

## **Feature: Fungsionalitas Inventaris dan Keranjang Belanja**

### Skenario Positif
```gherkin
  Skenario: Menambah satu produk ke keranjang belanja
    Given Saya sudah login dan berada di halaman inventaris
    When Saya menekan tombol "Add to cart" pada produk "Sauce Labs Backpack"
    Then Ikon keranjang belanja menunjukkan angka "1"

  Skenario: Menambah beberapa produk ke keranjang belanja
    Given Saya sudah login dan berada di halaman inventaris
    When Saya menekan tombol "Add to cart" pada produk "Sauce Labs Backpack"
    And Saya menekan tombol "Add to cart" pada produk "Sauce Labs Bike Light"
    Then Ikon keranjang belanja menunjukkan angka "2"

  Skenario: Menghapus produk dari halaman inventaris
    Given Saya sudah menambahkan "Sauce Labs Backpack" ke keranjang
    When Saya menekan tombol "Remove" pada produk "Sauce Labs Backpack" di halaman inventaris
    Then Ikon keranjang belanja tidak lagi menunjukkan angka (atau kembali ke 0)

  Skenario: Menghapus produk dari halaman keranjang belanja
    Given Saya sudah menambahkan "Sauce Labs Backpack" ke keranjang dan berada di halaman keranjang
    When Saya menekan tombol "Remove" pada produk "Sauce Labs Backpack" di halaman keranjang
    Then Produk "Sauce Labs Backpack" tidak lagi tampil di daftar keranjang
```
### Skenario Negatif
*(Tidak ada skenario negatif yang jelas untuk menambah/menghapus item dari UI selain bug fungsional)*

---

## **Feature: Fungsionalitas Pengurutan Produk**

### Skenario Positif
```gherkin
  Skenario: Mengurutkan produk berdasarkan harga dari tinggi ke rendah
    Given Saya sudah login dan berada di halaman inventaris
    When Saya memilih opsi urutan "Price (high to low)"
    Then Produk pertama yang tampil adalah "Sauce Labs Fleece Jacket" dengan harga "$49.99"

  Skenario: Mengurutkan produk berdasarkan nama dari Z ke A
    Given Saya sudah login dan berada di halaman inventaris
    When Saya memilih opsi urutan "Name (Z to A)"
    Then Produk pertama yang tampil adalah "Test.allTheThings() T-Shirt (Red)"
```

---

## **Feature: Fungsionalitas Checkout**

### Skenario Positif
```gherkin
  Skenario: Berhasil menyelesaikan proses checkout
    Given Saya sudah menambahkan produk ke keranjang dan berada di halaman checkout
    When Saya mengisi nama depan "John", nama belakang "Doe", dan kode pos "12345"
    And Saya menekan tombol "Continue"
    And Saya menekan tombol "Finish" di halaman ringkasan checkout
    Then Saya melihat halaman konfirmasi dengan pesan "THANK YOU FOR YOUR ORDER"
```

### Skenario Negatif
```gherkin
  Skenario: Gagal melanjutkan checkout karena informasi tidak lengkap
    Given Saya sudah menambahkan produk ke keranjang dan berada di halaman checkout
    When Saya hanya mengisi nama depan "John"
    And Saya menekan tombol "Continue"
    Then Saya melihat pesan error "Error: Last Name is required"

  Skenario: Gagal mengakses halaman checkout dengan keranjang kosong
    Given Saya sudah login dan keranjang saya kosong
    When Saya mencoba mengakses halaman checkout secara langsung
    Then Saya tetap berada di halaman inventaris (atau halaman keranjang) dan tidak bisa melanjutkan
```

---

## **Feature: Keamanan dan Alur Pengguna**

### Skenario Negatif
```gherkin
  Skenario: Gagal mengakses halaman inventaris tanpa login
    Given Saya belum login ke aplikasi
    When Saya mencoba mengakses URL halaman inventaris secara langsung
    Then Saya diarahkan kembali ke halaman login dan melihat pesan error "Epic sadface: You can only access '/inventory.html' when you are logged in."

  Skenario: Logout berhasil
    Given Saya sudah login dan berada di halaman inventaris
    When Saya membuka menu navigasi
    And Saya menekan tombol "Logout"
    Then Saya berhasil keluar dan diarahkan kembali ke halaman login
```
