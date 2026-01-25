Feature: Test Case Checkout Product saucedemo

    Scenario Outline: Checkout produk saucedemo
    Given Saya akses web dan login ke halaman Inventory dengan username "standard_user" dan password "secret_sauce".
    When Saya menekan tombol Add to cart pada produk "<product>".
    And saya menekan keranjang belanja.
    And saya menekan tombol Checkout di halaman keranjang.
    And Saya input nama depan "<first_name>", belakang "<last_name>", dan kode pos "<postal_code>".
    And Saya menekan tombol continue.
    Then Saya menekan tombol finish.

    Examples:
    | product |first_name | last_name | postal_code |
    | Sauce Labs Backpack & Sauce Labs Bike Light| Andrew | Garfield | 231244 |
    