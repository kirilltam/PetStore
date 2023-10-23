# encoding: UTF-8
# language: ru

Функциональность:


  Сценарий: Получение списка животных со статусом available
    * GET запрос /pet/findByStatus/?status=available
    * код ответа 200

  Сценарий: Получение списка животных со статусом pending
    * GET запрос /pet/findByStatus/?status=pending
    * код ответа 200

  Сценарий: Получение списка животных со статусом sold
    * GET запрос /pet/findByStatus/?status=sold
    * код ответа 200


  Сценарий: Проверка поля status со значением available
    * Запрос /pet/findByStatus/?status=available соответствует статусу в ответе 'available'

  Сценарий: Проверка поля status со значением pending
    * Запрос /pet/findByStatus/?status=pending соответствует статусу в ответе 'pending'

  Сценарий: Проверка поля status со значением sold
    * Запрос /pet/findByStatus/?status=sold соответствует статусу в ответе 'sold'

  Сценарий: значения соответствуют типом данных
    * Проверка всех полей на соответствия типу данных










