Feature: Test Case Sorting Inventory saucedemo

    Scenario Outline: Mengurutkan produk di halaman Inventory.
    Given Saya akses web dan login dengan username "standard_user" & password "secret_sauce" dan berada di halaman Invetory.
    When Saya memilih opsi urutan "<urutan>"
    Then Produk pertama yang tampil adalah "<produk>" dengan harga "<harga>".

    Examples: 
    | urutan | produk | harga |
    |Price (high to low)| Sauce Labs Fleece Jacket| $49.99 |
    |Name (Z to A)| Test.allTheThings() T-Shirt (Red) | $15.99 |
    |Price (low to high) | Sauce Labs Onesie | $7.99 | 