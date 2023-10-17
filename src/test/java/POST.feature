# encoding: UTF-8
# language: ru

Функциональность: Создание питомца

  Сценарий: Создать питомца
    * POST запрос https://petstore.swagger.io/v2/pet
      | field     | value                          |
      | id        | 25                             |
      | category  | {"id": 4, "name": "Mailo"}     |
      | name      | doggie                         |
      | photoUrls | ["string"]                     |
      | tags      | [{"id": 4, "name": "chachao"}] |
      | status    | available                      |




  Сценарий: Создать питомца с невалидными данными ошибка 405
    * POST запрос https://petstore.swagger.io/v2/pet
      | field     | value                          |
      | id        | invalid                        |
      | category  | {"id": 4, "name": "Mailo"}     |
      | name      | 2                              |
      | photoUrls | ["string"]                     |
      | tags      | [{"id": 4, "name": "chachao"}] |
      | status    | available                      |

