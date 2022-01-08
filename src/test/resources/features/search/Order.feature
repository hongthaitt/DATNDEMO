@author:thaitth @Order
Feature:hi
  As a customer , I want to buy product

  @Order01
  Scenario:Khách hàng không đăng nhập vào hệ thống và mua 1 sản phẩm thành công.
    Given Go to "homePage" url
    When User searches product and adds the first item in list result to cart

      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
      | pan     | 2        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed and user checkouts
      | productName                                      | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set       | $590.00 | 1        |
      | WOMEN Ultra Stretch Denim Cropped Leggings Pants | $780.00 | 2        |
    When User inserts information to buy product
      | firstName | lastName | email  | streetAddress | city      | country | state      | zipCode  | telephone | shippingMethod | payment        | coupon |
      | validFN   | validLN  | validE | validSA       | validCity | validC  | validState | validZip | validTele | freeShipping   | cashOnDelivery | no     |
    Then User should see total and message successful.

  @Order02
  Scenario:Khách hàng đăng nhập vào hệ thống và mua 1 sản phẩm thành công.
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
    When User remove cart
    When User searches product and adds the first item in list result to cart

      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
      | pan     | 2        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed and user checkouts
      | productName                                      | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set       | $590.00 | 1        |
      | WOMEN Ultra Stretch Denim Cropped Leggings Pants | $780.00 | 2        |
    When User inserts information to buy product
      | firstName | lastName | email  | streetAddress | city      | country | state      | zipCode  | telephone | shippingMethod | payment        | coupon |
      | validFN   | validLN  | validE | validSA       | validCity | validC  | validState | validZip | validTele | freeShipping   | moneyTransfer | no     |
    Then User should see total and message successful.
  @Order03
  Scenario:Khách hàng không đăng nhập vào hệ thống và mua 1 sản phẩm thành công.
    Given Go to "homePage" url
    When User searches product and adds the first item in list result to cart

      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
      | pan     | 2        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed and user checkouts
      | productName                                      | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set       | $590.00 | 1        |
      | WOMEN Ultra Stretch Denim Cropped Leggings Pants | $780.00 | 2        |
    When User inserts information to buy product
      | firstName | lastName | email  | streetAddress | city      | country | state      | zipCode  | telephone | shippingMethod | payment        | coupon |
      | validFN   | validLN  | validE | validSA       | validCity | validC  | validState | validZip | validTele | freeShipping   | cashOnDelivery | no     |
    Then User should see total and message successful.

  @Order04
  Scenario:Khách hàng đăng nhập vào hệ thống và mua 1 sản phẩm thành công.
    Given Go to "homePage" url
    When User Login with "<username>" and "<password>"
    Then User logs in "<result>" and return message is "<message>"
    When User remove cart
    When User searches product and adds the first item in list result to cart

      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
      | pan     | 2        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed and user checkouts
      | productName                                      | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set       | $590.00 | 1        |
      | WOMEN Ultra Stretch Denim Cropped Leggings Pants | $780.00 | 2        |
    When User inserts information to buy product
      | firstName | lastName | email  | streetAddress | city      | country | state      | zipCode  | telephone | shippingMethod | payment        | coupon |
      | validFN   | validLN  | validE | validSA       | validCity | validC  | validState | validZip | validTele | freeShipping   | moneyTransfer | no     |
    Then User should see total and message successful.
  @Order06_1
  Scenario Outline:Khách hàng bỏ trống giá trị firstname
    Given Go to "homePage" url
#    When User searches product and adds the first item in list result to cart
#      | product | quantity | message                                        |
#      | cotton  | 1        | Success! Item was successfully added to cart.. |
#    Then Products in cart should be displayed and user checkouts
#      | productName                                | price   | quantity |
#      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 1        |
#    When User inserts information to validate
#      | firstName | lastName | email | streetAddress | city | country | state | zipCode | telephone | shippingMethod | payment | coupon |
#      | space     | null     | null  | null          | null | null    | null  | null    | null      | null           | null    | null   |
#
#    Then User should see the "<error>"
    Examples:
      | error             |
      | field is required |

  @Order06_2
  Scenario Outline:Khách hàng bỏ trống giá trị lastname
    Given Go to "homePage" url
    When User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed and user checkouts
      | productName                                | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 1        |
    When User inserts information to validate
      | firstName | lastName | email | streetAddress | city | country | state | zipCode | telephone | shippingMethod | payment | coupon |
      | null     | space     | null  | null          | null | null    | null  | null    | null      | null           | null    | null   |

    Then User should see the "<error>"
    Examples:
      | error             |
      | field is required |
  @Order06_3
  Scenario Outline:Khách hàng bỏ trống giá trị firstname
    Given Go to "homePage" url
    When User searches product and adds the first item in list result to cart
      | product | quantity | message                                        |
      | cotton  | 1        | Success! Item was successfully added to cart.. |
    Then Products in cart should be displayed and user checkouts
      | productName                                | price   | quantity |
      | GIRLS AIRism Cotton Blend Short Sleeve Set | $590.00 | 1        |
    When User inserts information to validate
      | firstName | lastName | email | streetAddress | city | country | state | zipCode | telephone | shippingMethod | payment | coupon |
      | null     | space     | null  | null          | null | null    | null  | null    | null      | null           | null    | null   |

    Then User should see the "<error>"
    Examples:
      | error             |
      | field is required |