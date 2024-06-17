Feature: Booking
@api
Scenario: Get all bookings
  Given the booking API is available
  When a user requests all bookings
  Then the response status code should be 200
  And the response should contain bookings

  Scenario: Create a new booking with JSON
    Given the booking API is available
    When a user creates a new booking with the following JSON data:
    """
    {
      "firstname": "haluk",
      "lastname": "Ural",
      "totalprice": 115,
      "depositpaid": true,
      "bookingdates": {
        "checkin": "2024-01-01",
        "checkout": "2024-01-02"
      }
    }
    """
    Then the booking should be created successfully

  Scenario: Update a booking with JSON
    Given the booking API is available
    When a user updates the booking with id 1 with the following JSON data:
    """
    {
      "firstname": "Ural",
      "lastname": "Haluk",
      "totalprice": 110,
      "depositpaid": false,
      "bookingdates": {
        "checkin": "2024-01-03",
        "checkout": "2024-01-04"
      }
    }
    """
    Then the booking should be updated successfully

  Scenario: Delete a booking
    Given the booking API is available
    When a user deletes the booking with id 1
    Then the booking should be deleted successfully