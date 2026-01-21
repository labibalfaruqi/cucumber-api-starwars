@FilmsFeature
Feature: Films Feature

  @Component @GetAllFilms @Regression
  Scenario Outline: Get All Films Data with title '<title>'
    Given prepare get all 'films' data
    When  send get all 'films' data
    Then  verify 'title' for id number '<id>' is '<title>'
    And   verify 'episodeId' for id number '<id>' is '<episodeId>'
    And   verify 'director' for id number '<id>' is '<director>'
    And   verify 'producer' for id number '<id>' is '<producer>'
    And   verify 'releaseDate' for id number '<id>' is '<releaseDate>'
    Examples:
      | id | title                   | episodeId | director       | producer                  | releaseDate |
      | 1  | A New Hope              | 4         | George Lucas   | Gary Kurtz, Rick McCallum | 1977-05-25  |
      | 2  | The Empire Strikes Back | 5         | Irvin Kershner | Gary Kurtz, Rick McCallum | 1980-05-17  |

  @Component @GetSpecificFilms @Regression
  Scenario Outline: Get Specific Films Data with title '<title>'
    Given prepare get specific 'films' data with id <id>
    When  send get specific 'films' data
    Then  verify 'title' for id number '<id>' is '<title>'
    And   verify 'episodeId' for id number '<id>' is '<episodeId>'
    And   verify 'director' for id number '<id>' is '<director>'
    And   verify 'producer' for id number '<id>' is '<producer>'
    And   verify 'releaseDate' for id number '<id>' is '<releaseDate>'
    Examples:
      | id | title                   | episodeId | director       | producer                  | releaseDate |
      | 1  | A New Hope              | 4         | George Lucas   | Gary Kurtz, Rick McCallum | 1977-05-25  |
      | 2  | The Empire Strikes Back | 5         | Irvin Kershner | Gary Kurtz, Rick McCallum | 1980-05-17  |