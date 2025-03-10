Feature: VAT Calculation
  As a user,
  I want to calculate VAT,
  So that I can determine the net and VAT amounts.

  Scenario Outline: Calculate VAT with Gross Amount and VAT Rate
    Given I am on the VAT Calculator page
    When I enter "<gross_amount>" into the Gross Amount field
    And I select "<vatrate>" the VAT Rate
    Then the calculated VAT should be "<vatamount>"
    And the calculated Net Amount should be "<netamount>"

    Examples:
      | gross_amount | vatrate | vatamount | netamount |
      | 100          | 20%      | 20.00      | 83.33      |
      | 200          | 20%      | 33.33      | 166.67     |
      | 50           | 5%       | 2.38       | 47.62      |




  Scenario Outline: Calculate VAT with Net Amount and VAT Rate
    Given I am on the VAT Calculator page
    When I enter "<net_amount>" into the Net Amount field
    And I select "<vat_rate>" VAT Rate
    Then the calculated VAT should be "<vat_amount>"
    And the calculated Gross Amount should be "<gross_amount>"

    Examples:
      | net_amount | vat_rate | vat_amount | gross_amount |
      | 100        | 20%      | 20.00      | 120.00       |
      | 200        | 20%      | 40.00      | 240.00       |
      | 50         | 5%       | 2.50       | 52.50        |



  Scenario Outline: Calculate VAT amount with Gross Amount, Net Amount, and VAT Rate
    Given I am on the VAT Calculator page
    When I enter "<gross_amount>" into the Gross Amount field
    And I enter "<net_amount>" into the Net Amount field
    And I select "<vat_rate>" the VAT Rate
    Then the calculated VAT should be "<vat_amount>"

    Examples:
      | gross_amount | net_amount | vat_rate | vat_amount |
      | 240          | 200        | 20%      | 40.00      |
      | 52.50        | 50         | 5%       | 2.50       |
