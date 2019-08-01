Feature: Coders Guru

  Scenario Outline: user can create private Coders Guru account
    Given an open browser on Coders Guru main page https://tester.codersguru.pl/
    When button 'Załóż konto' is clicked
    Then new page with text 'Zarejestruj się' is appeared
    When button 'Prywatnie' is clicked
    And enter e-mail adress "<email>" in 'E-mail' field
    And enter name "<name>" in 'Imię' field
    And enter surname "<surname>" in 'Nazwisko' field
    And enter password "<password>" in 'Hasło' field
    And re-enter password "<password>" in 'Powtórz hasło' field
    And enter city "<city>" in 'Miasto' field
    And enter zip code "<zip code>" in 'Kod pocztowy' field
    And enter street name "<street>" in 'Ulica' field
    And enter house number "<house number>" in 'Numer domu/lokalu' field
    And click checkbox 'Zapoznałem się z Regulaminem'
    And button 'Zarejestruj' is clicked
    Then new page is opened with "<name>" in the upper right corner

    Examples:
    |email           |name          |surname   |password      |city    |zip code|street        |house number |
    |piotr10@test.com |Kulfoniasty   |Krzaczasty|piotrkowalski|Warszawa |03-980  |Bema          |9/7          |
    |pawel10@test.com |Pawel         |Maciejka  |pawelmaciejka |Kielce  |25-373  |Rechniewskiego|7/12         |


