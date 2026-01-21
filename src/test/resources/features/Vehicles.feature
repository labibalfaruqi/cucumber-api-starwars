@VehiclesFeature
Feature: Vehicles Feature

  @Component @GetAllVehicles @Regression
  Scenario Outline: Get All Vehicles Data with name '<name>'
    Given prepare get all 'Vehicles' data
    When  send get all 'Vehicles' data
    Then  verify 'name' for id number '<id>' is '<name>'
    And   verify 'model' for id number '<id>' is '<model>'
    And   verify 'manufacturer' for id number '<id>' is '<manufacturer>'
    And   verify 'costInCredits' for id number '<id>' is '<costInCredits>'
    And   verify 'length' for id number '<id>' is '<length>'
    And   verify 'maxAtmospheringSpeed' for id number '<id>' is '<maxAtmospheringSpeed>'
    And   verify 'crew' for id number '<id>' is '<crew>'
    And   verify 'passengers' for id number '<id>' is '<passengers>'
    And   verify 'cargoCapacity' for id number '<id>' is '<cargoCapacity>'
    And   verify 'consumables' for id number '<id>' is '<consumables>'
    And   verify 'vehicleClass' for id number '<id>' is '<vehicleClass>'
    Examples:
      | id | name           | model          | manufacturer                | costInCredits | length | maxAtmospheringSpeed | crew | passengers | cargoCapacity | consumables | vehicleClass  |
      | 4  | Sand Crawler   | Digger Crawler | Corellia Mining Corporation | 150000        | 36.8   | 30                   | 46   | 30         | 50000         | 2 months    | wheeled       |
      | 6  | T-16 skyhopper | T-16 skyhopper | Incom Corporation           | 14500         | 10.4   | 1200                 | 1    | 1          | 50            | 0           | repulsorcraft |

  @Component @GetSpecificVehicles @Regression
  Scenario Outline: Get Specific Vehicles Data with name '<name>'
    Given prepare get specific 'Vehicles' data with id <id>
    When  send get specific 'Vehicles' data
    Then  verify 'name' for id number '<id>' is '<name>'
    And   verify 'model' for id number '<id>' is '<model>'
    And   verify 'manufacturer' for id number '<id>' is '<manufacturer>'
    And   verify 'costInCredits' for id number '<id>' is '<costInCredits>'
    And   verify 'length' for id number '<id>' is '<length>'
    And   verify 'maxAtmospheringSpeed' for id number '<id>' is '<maxAtmospheringSpeed>'
    And   verify 'crew' for id number '<id>' is '<crew>'
    And   verify 'passengers' for id number '<id>' is '<passengers>'
    And   verify 'cargoCapacity' for id number '<id>' is '<cargoCapacity>'
    And   verify 'consumables' for id number '<id>' is '<consumables>'
    And   verify 'vehicleClass' for id number '<id>' is '<vehicleClass>'
    Examples:
      | id | name           | model          | manufacturer                | costInCredits | length | maxAtmospheringSpeed | crew | passengers | cargoCapacity | consumables | vehicleClass  |
      | 4  | Sand Crawler   | Digger Crawler | Corellia Mining Corporation | 150000        | 36.8   | 30                   | 46   | 30         | 50000         | 2 months    | wheeled       |
      | 6  | T-16 skyhopper | T-16 skyhopper | Incom Corporation           | 14500         | 10.4   | 1200                 | 1    | 1          | 50            | 0           | repulsorcraft |