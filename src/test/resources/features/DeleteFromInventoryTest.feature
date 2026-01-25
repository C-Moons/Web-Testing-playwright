Feature: Test Case Remove Product Inventory saucedemo

  Scenario Outline: Menghapus satu produk dari keranjang belanja
    Given Saya melakukan login dengan username "standard_user" & password "secret_sauce" dan berada di halaman Invetory.
    When Saya menekan tombol Add to cart pada produk "<product>".
    And Saya menekan tombol Remove pada produk "<product>".
    Then Ikon keranjang belanja menunjukkan "<value>".

    Examples:
      | product               | value |
      | Sauce Labs Backpack   |       |
      | Sauce Labs Bike Light |       |
