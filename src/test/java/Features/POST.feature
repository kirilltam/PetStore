# encoding: UTF-8
# language: ru

Функциональность: Создание питомца

  Сценарий: Создать питомца
    * POST запрос /pet

      | id        | 345                            |
      | category  | {"id": 4, "dog": "string"}     |
      | name      | Mailo                          |
      | photoUrls | ["string"]                     |
      | tags      | [{"id": 23, "name": "string"}] |
      | status    | available                      |
    * код ответа 200


  Сценарий: Создать питомца с невалидными данными ошибка 405
    * POST запрос /pet

      | id        | invaliddddddddddddddddddddddddddddddddddddddddddd                      |
      | category  | {"4dwfwdwd4": 4xzcC, "456dsfadsf": "Mai5xcvxcv6"}                      |
      | name      | 2xczvcxvxv22222                                                        |
      | photoUrls | ["strzxcbvcbvcning"]                                                   |
      | tags      | [{"wewrwerewrewrewrwerwerweer": re, "123": "123                    "}] |
      | status    | 123                                                                    |

  Сценарий: Создать питомца со значениями null
    * POST запрос /pet

      | id        |                  |
      | category  | {"": , "": ""}   |
      | name      |                  |
      | photoUrls | [""]             |
      | tags      | [{"": , "": ""}] |
      | status    |                  |

  Сценарий: Создание заказ на питомца
    * POST запрос /store/order

      | id       | 56                           |
      | petId    | 9                            |
      | quantity | 1                            |
      | shipDate | 2023-10-17T17:10:40.558+0000 |
      | status   | "placed"                     |
      | complete | true                         |
    * код ответа 200

  Сценарий: Создание заказа на питомца c некорректными данными
    * POST запрос /store/order
      | id       | 56                                   |
      | petId    | asdasd                               |
      | quantity | ddsd                                 |
      | shipDate | 2023-10-dfdf17T17:10:40.5dfdf58+0000 |
      | status   | 123123123123                         |
      | complete |                                      |
    * код ответа 500


  Сценарий: Создание заказа на питомца со значнениями null
    * POST запрос /store/order

      | id       |  |
      | petId    |  |
      | quantity |  |
      | shipDate |  |
      | status   |  |
      | complete |  |


  Сценарий: Обновить данные питомца
    * POST запрос /store/pet/55
      | id     | 345       |
      | name   | doggie    |
      | status | available |


  Сценарий: Обновить данные питомца c невалидными данными
    * POST запрос /store/pet/55
      | id     | qwe     |
      | name   | 123     |
      | status | 4567678 |
    * код ответа 404

  Сценарий: Обновить данные питомца c пустыми данными
    * POST запрос /store/pet/55
      | id     |  |
      | name   |  |
      | status |  |
    * код ответа 404




