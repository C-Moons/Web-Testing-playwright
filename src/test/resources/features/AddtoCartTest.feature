Feature: Test Case Add to cart Inventory saucedemo

    Scenario Outline: Menambah satu produk ke keranjang belanja
    Given Saya sudah login dengan username "standard_user" & password "secret_sauce" dan berada di halaman Invetory.
    When Saya menekan tombol Add to cart pada produk "<product>".
    Then Ikon keranjang belanja menunjukkan angka "<value>".

    Examples:
    | product | value |
    |Sauce Labs Backpack| 1 |
    |Sauce Labs Bike Light| 2 |