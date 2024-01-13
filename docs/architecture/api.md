# API

## Сущности

1. Training (тренировка)

## Описание сущности Training

1. Info
   1. Title (6-128 символов)
   2. Description (100-10000 символов)
   3. Owner (UserId)
   4. Visibility (личный, публичный, группа)
2. TrainingIntensity (средний, высокий, низкий) - интенсивность тренировки.
3. PlanID (GUID 16-64 символа) - идентификатор плана тренировок

## Функции (эндпониты)

1. Training CRUDS
   1. create
   2. read
   3. update
   4. delete
   5. search - поиск по фильтрам
2. Training Дополнительные 
   1. plan (привязка тренировки к плану тренировок)
