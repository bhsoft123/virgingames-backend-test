Feature: Virgingames application asserting response data

  As a user, I should be able to verify response data for different requests

Scenario:Verify response data for different requests
  When  I send a GET request to user endpoint
  Then  I verify the response code is 200

Scenario Outline: Verify response data for different path and query parameters
  And   I send different query parameters "<query parameter key>"  "<query parameter value>"
  Then  I verify the response code is 200
  Then  I verify for each id "<id>" currency "<currency>" is displayed correctly
  And   I verify for each id "<id>" name "<name>" is displayed correctly
  Examples:
    |query parameter key    |query parameter value    |id   |currency         |name               |
    |currency               |GBP                      |309  | GBP             |virgingamessession |
    |currency               |EUR                      |3544 | EUR             |80BallBingoVGN     |
    |currency               |SEK                      |5323 | SEK             |CloudVGN           |

