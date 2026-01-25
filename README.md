# Automation Testing Project with Playwright & Cucumber

Proyek ini adalah kerangka kerja otomatisasi pengujian web untuk situs **Sauce Demo** (https://www.saucedemo.com/) menggunakan **Java**, **Playwright**, dan **Cucumber**. Proyek ini mendemonstrasikan penerapan **Page Object Model (POM)** dan **Behavior Driven Development (BDD)**.

## 📋 Daftar Isi

- [Teknologi yang Digunakan](#-teknologi-yang-digunakan)
- [Struktur Proyek](#-struktur-proyek)
- [Fitur & Test Case](#-fitur--test-case)
- [Prasyarat](#-prasyarat)
- [Cara Menjalankan Test](#-cara-menjalankan-test)
- [Laporan Pengujian](#-laporan-pengujian)

## 🛠 Teknologi yang Digunakan

Proyek ini dibangun menggunakan teknologi dan pustaka berikut:

- **Bahasa Pemrograman**: Java 21
- **Build Tool**: Maven
- **Browser Automation**: [Microsoft Playwright](https://playwright.dev/java/) (v1.49.0)
- **Testing Framework**: [TestNG](https://testng.org/) (v7.10.2)
- **BDD Framework**: [Cucumber JVM](https://cucumber.io/) (v7.15.0)
- **Reporting**:
  - ExtentReports (Grasshopper Adapter)
  - Maven Cucumber Reporting

## 📂 Struktur Proyek

Struktur direktori proyek mengikuti standar Maven dengan pemisahan yang jelas antara logika halaman (Page Objects) dan definisi langkah pengujian (Step Definitions).

```text
testing_using_playwright/
├── src/
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── testing/
│       │           ├── Page/               # Page Object Model (POM) Classes
│       │           │   ├── components/     # Komponen UI yang dapat digunakan kembali (Header, Navbar)
│       │           │   ├── LoginPage.java
│       │           │   ├── InventoryPage.java
│       │           │   ├── CartPage.java
│       │           │   └── ...
│       │           ├── definition/         # Cucumber Step Definitions
│       │           │   ├── LoginTestDefiniton.java
│       │           │   ├── AddToCartTestDefinition.java
│       │           │   └── ...
│       │           ├── runner/             # TestNG Runner Class
│       │           │   └── RunnerTest.java
│       │           └── utils/              # Utility Classes (Driver setup)
│       └── resources/
│           ├── features/                   # File Gherkin (.feature)
│           │   ├── LoginTest.feature
│           │   ├── ShoppingCart.feature
│           │   └── ...
│           └── testng.xml                  # Konfigurasi Suite TestNG
├── pom.xml                                 # Dependensi dan Konfigurasi Maven
└── README.md                               # Dokumentasi Proyek
```

## ✅ Fitur & Test Case

Berikut adalah skenario pengujian yang dicakup dalam proyek ini:

### 1. Login (`LoginTest.feature`)

Menguji fungsionalitas login dengan berbagai kondisi:

- Login dengan username dan password kosong (Negative).
- Login dengan username valid tetapi password salah (Negative).
- Login dengan akun yang terkunci (Negative).
- Login dengan kredensial yang valid (Positive).

### 2. Manajemen Keranjang Belanja (`AddtoCartTest.feature` & `DeleteFromInventoryTest.feature`)

- **Tambah ke Keranjang**: Verifikasi produk berhasil ditambahkan dan ikon keranjang diperbarui.
- **Hapus dari Keranjang**: Verifikasi produk dapat dihapus dari halaman inventaris dan ikon keranjang diperbarui (kembali kosong).

### 3. Pengurutan Produk (`SortingTest.feature`)

Memastikan fitur sorting di halaman inventaris berfungsi:

- Harga: Rendah ke Tinggi (Low to High).
- Harga: Tinggi ke Rendah (High to Low).
- Nama: Z ke A.

### 4. Checkout Produk (`CheckoutProduct.feature`)

Pengujian alur akhir-ke-akhir (End-to-End) pembelian produk:

1. Login.
2. Menambah beberapa produk ke keranjang.
3. Masuk ke halaman keranjang.
4. Melakukan Checkout.
5. Mengisi informasi pengiriman (Nama, Kode Pos).
6. Menyelesaikan pesanan (Finish) dan memverifikasi halaman sukses.


## 💻 Prasyarat

Sebelum menjalankan proyek, pastikan Anda telah menginstal:

- **Java JDK 21** atau lebih baru.
- **Maven**.
- **Git**.

## 🚀 Cara Menjalankan Test

### Menjalankan Semua Test

Gunakan perintah berikut di terminal:

```bash
mvn clean test
```

### Menjalankan Test Tertentu (Menggunakan Tag atau Runner)

Anda dapat menjalankan file runner spesifik:

```bash
mvn test -Dtest=RunnerTest
```

## 📊 Laporan Pengujian

Setelah pengujian selesai, laporan akan dibuat secara otomatis di direktori `target/`.

- **Cucumber HTML Report**: `target/cucumber-report-html/cucumber-html-reports/overview-features.html`
- **Extent Report**: `ExtentReports/`.
- **Surefire Reports**: `target/surefire-reports/`.

---

