@author:thaitth @Add_Product_To_cart
Feature:  Search product , and add product into cart with qty


  @Add_Product_To_cart01
  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới 01 sản phẩm vào giỏ hàng thành công.
    Given Go to "homePage" url
    And User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed
      | productName                                | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 1        |

#  @Add_Product_To_cart02
#  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới 01 sản phẩm vào giỏ hàng thành công.
#    Given Go to "homePage" url
#    When User Login with "<username>" and "<password>"
#    Then User logs in "<result>" and return message is "<message>"
#    When User remove cart
#    And User searches product and adds the first item in list result to cart
#      | product | quantity | message                                        |
#      | cotton  | 1        | Success! Item was successfully added to cart.. |
#    Then Products in cart should be displayed
#      | productName                                | price   | quantity |
#      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 1        |

#  @Add_Product_To_cart02
#  Scenario:Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm vào giỏ hàng thành công.
#    Given Go to "homePage" url
#  @Add_Product_To_cart03
#  Scenario: Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm ở trang chủ vào giỏ hàng thành công.
#    Given Go to "homePage" url
#
#    @Add_Product_To_cart04
#  Scenario:Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm ở trang chủ vào giỏ hàng thành công.
#    Given Go to "homePage" url
#
#
#    @Add_Product_To_cart05
#  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới  02 sản phẩm khác loại vào giỏ hàng thành công
#    Given Go to "homePage" url

#
#  @Add_Product_To_cart02
#  Scenario:Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm vào giỏ hàng thành công.
#    Given Go to "homePage" url
#
#  @Add_Product_To_cart06
#  Scenario: Khách hàng đăng nhập vào hệ thống và thêm mới 02 sản phẩm khác loại vào giỏ hàng thành công
#    Given Go to "homePage" url
#
#    @Add_Product_To_cart07
#  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới 2 lần 2 sản phẩm cùng loại vào giỏ hàng thành công.
#    Given Go to "homePage" url
#
#    @Add_Product_To_cart08
#  Scenario: Khách hàng đăng nhập vào hệ thống và thêm mới 2 lần 2 sản phẩm cùng loại vào giỏ hàng thành công.
#    Given Go to "homePage" url
#
#    @Add_Product_To_cart09
#  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới  01 sản phẩm vào giỏ hàng không thành công do không đủ hàng trong kho
#    Given Go to "homePage" url
#
#    @Add_Product_To_cart10
#  Scenario:Khách hàng đăng nhập vào hệ thống và thêm mới  01 sản phẩm vào giỏ hàng không thành công do không đủ hàng trong kho
#    Given Go to "homePage" url
##
#  @Add_Product_To_cart03
#  Scenario: Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm ở trang chủ vào giỏ hàng thành công.
#    Given Go to "homePage" url
#    And User searches product and adds the first item in list result to cart
#      | product | quantity | message                                        |
#      | cotton  | 1        | Success! Item was successfully added to cart.. |
#    And User continues to add a same product
#    Then User should see a message is "Success! Item was successfully added to cart.."
#    And Products in cart should be displayed
#      | productName                                | price   | quantity |
#      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 2        |
##    And Cleare local storage
#    Given Go to "homePage" url
#
#  @Add_Product_To_cart04
#  Scenario:Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm ở trang chủ vào giỏ hàng thành công.
#    Given Go to "homePage" url

#    When User remove cart
#    And User searches product and adds the first item in list result to cart
#      | product | quantity | message                                        |
#      | cotton  | 1        | Success! Item was successfully added to cart.. |
#    And User continues to add a same product
#    Then User should see a message is "Success! Item was successfully added to cart.."
#    And Products in cart should be displayed
#      | productName                                | price   | quantity |
#      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 2        |
#    And Cleare local storage



  @Add_Product_To_cart02
  Scenario Outline:Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm vào giỏ hàng thành công.
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
    When User remove cart
    And User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed
      | productName                                | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 1        |
    And Cleare local storage
    Examples:
      | username           | password | result | message |
      | hongthai@gmail.com | 123456   | pass   |         |

#
  @Add_Product_To_cart3
  Scenario: Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm ở trang chủ vào giỏ hàng thành công.
    Given Go to "homePage" url
    When User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed
      | productName                                | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 1        |

  @Add_Product_To_cart4
  Scenario Outline:Khách hàng đăng nhập vào hệ thống và thêm mới 01 sản phẩm ở trang chủ vào giỏ hàng thành công.
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
#    When User remove cart
#    And User searches product and adds the first item in list result to cart
#      | product | quantity | message                                        |
#      | cotton  | 1        | Success! Item was successfully added to cart.. |
#    And User continues to add a same product
#    Then User should see a message is "Success! Item was successfully added to cart.."
#    And Products in cart should be displayed
#      | productName                                | price   | quantity |
#      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 2        |
#    And Cleare local storage
    Examples:
      | username           | password | result | message |
      | hongthai@gmail.com | 123456   | pass   |         |

  @Add_Product_To_cart05
  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới  02 sản phẩm khác loại vào giỏ hàng thành công
    Given Go to "homePage" url
    When User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
      | pan     | 2        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed
      | productName                                      | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set       | $590.00 | 1        |
      | WOMEN Ultra Stretch Denim Cropped Leggings Pants | $780.00 | 2        |

  @Add_Product_To_cart06
  Scenario Outline: Khách hàng đăng nhập vào hệ thống và thêm mới 02 sản phẩm khác loại vào giỏ hàng thành công
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
    When User remove cart
    When User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
      | pan     | 2        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed
      | productName                                      | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set       | $590.00 | 1        |
      | WOMEN Ultra Stretch Denim Cropped Leggings Pants | $780.00 | 2        |
    And Cleare local storage
    Examples:
      | username           | password | result | message |
      | hongthai@gmail.com | 123456   | pass   |         |

  @Add_Product_To_cart07
  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới 2 lần 2 sản phẩm cùng loại vào giỏ hàng thành công.
    Given Go to "homePage" url
    And User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
    And User continues to add a same product
    Then User should see a message is "Success! Item was successfully added to cart.."
    And Products in cart should be displayed
      | productName                                | price     | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set | $1,180.00 | 2        |

  @Add_Product_To_cart08
  Scenario Outline: Khách hàng đăng nhập vào hệ thống và thêm mới 2 lần 2 sản phẩm cùng loại vào giỏ hàng thành công.
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
    When User remove cart
    And User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
    And User continues to add a same product
    Then User should see a message is "Success! Item was successfully added to cart.."
    Then Products in cart should be displayed
      | productName                                | price     | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set | $1,180.00 | 2        |
    And Cleare local storage
    Examples:
      | username           | password | result | message |
      | hongthai@gmail.com | 123456   | pass   |         |
#
  @Add_Product_To_cart09
  Scenario: Khách hàng không đăng nhập vào hệ thống và thêm mới  01 sản phẩm vào giỏ hàng không thành công do không đủ hàng trong kho
    Given Go to "homePage" url
    And User searches product and adds the first item in list result to cart
      | product | quantity | message                                                                    |
      | cotton  | 6        | Warning! The requested quantity is not available, please try again later.. |

  @Add_Product_To_cart10
  Scenario Outline:Khách hàng đăng nhập vào hệ thống và thêm mới  01 sản phẩm vào giỏ hàng không thành công do không đủ hàng trong kho
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
    When User remove cart
    And User searches product and adds the first item in list result to cart
      | product | quantity | message                                                                    |
      | cotton  | 6        | Warning! The requested quantity is not available, please try again later.. |
    Examples:
      | username           | password | result | message |
      | hongthai@gmail.com | 123456   | pass   |         |

