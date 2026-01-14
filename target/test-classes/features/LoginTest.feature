Feature: Test Case Login saucedemo

    Scenario Outline: Login berhasil dengan akun yang terdaftar.
    Given Saya membuka browser dan mengakses halaman login.
    When Saya memasukkan kredensial yang valid berupa "<username>" dan "<password>".
    And Saya menekan tombol Login.
    Then Pengujian ini berdasarkan "<status>" dengan pesan "<error>".

    Examples:
| username | password | error | status |
| standard_user | | Epic sadface: Password is required | invalid |
| | | Epic sadface: Username is required | invalid |
| standard_user | invalid_password | Epic sadface: Username and password do not match any user in this service | invalid |
| invalid_user | secret_sauce | Epic sadface: Username and password do not match any user in this service | invalid |
| standard_user | secret_sauce | | valid |