@MahasiswaFeature
Feature: Testing Mahasiswa API

  Scenario: Insert mahasiswa and verify mahasiswa inserted
    Given I have mahasiswa data
      | firstName | lastName  | major            | nim   |
      | argo      | triwidodo | computer science | 55555 |
      | dennis    | sandjaya  | hotel management | 12345 |
    When I insert mahasiswa data
    Then mahasiswa data should be inserted successfully