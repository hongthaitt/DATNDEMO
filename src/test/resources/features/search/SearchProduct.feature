@SearchProduct
Feature:  Tìm kiếm sản phẩm

  @SearchProduct_4_5_6
  Scenario Outline: Khách hàng đăng nhập và tìm kiếm sản phẩm theo tên
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
    And Click button "homeButton"
    And User searches "<productName>" and verify "<listResult>" display
    Examples:
      | username           | password | result | message | productName | listResult  |
      | hongthai@gmail.com | 123456   | pass   |         | cotton      | have result |
      | hongthai@gmail.com | 123456   | pass   |         | !@#$%       | no result   |
      | hongthai@gmail.com | 123456   | pass   |         | mobile      | no result   |

  @SearchProduct_1_2_3
  Scenario Outline: Khách hàng không đăng nhập và tìm kiếm sản phẩm theo tên
    Given Go to "homePage" url
    Then User searches "<productName>" and verify "<listResult>" display
    Examples:
      | productName | listResult  |
      | cotton      | have result |
      | !@#$%       | no result   |
      | mobile      | no result   |

