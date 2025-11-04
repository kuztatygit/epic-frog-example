Feature: Weather forecast

  Scenario: One day weather forecast check
    Given location coordinates:
      | latitude  | 52.52     |
      | longitude | 13.419998 |

    When we are requesting weather data

    Then main information is:
      | latitude              | 52.52              |
      | longitude             | 13.419998          |
      | generationtime_ms     | 0.0845193862915039 |
      | utc_offset_seconds    | 0                  |
      | timezone              | GMT                |
      | timezone_abbreviation | GMT                |
      | elevation             | 38.0               |

    And current units are:
      | time           | iso8601 |
      | interval       | seconds |
      | temperature_2m | °C      |
      | rain           | mm      |
      | is_day         |         |
