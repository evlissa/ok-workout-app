# Пользовательские истории

## 1. Создание плана тренировок

**В качестве** пользователя, \
**Я хочу** иметь возможность задать желаемое количество тренеровок в неделю, \
**Для того, чтобы** отслеживать свой прогресс в достижении желаемого результата.

1. Сценарий: задание количества тренировок. \
   **Дано:** я нахожусь в своем личном кабинете. \
   **Когда** я захожу туда в первый раз, \
   **тогда** появляется поле "Необходимое количество тренировок в неделю" \
   **и** я могу ввести необходимое количество занятий и сохранить данные, нажав на кнопку "Сохранить план".
2. Сценарий: выбор предпочтительных дней для тренировок. \
   **Дано:** я редактирую план тренировок. \
   **Когда** я выбираю необязательный пункт "Выбрать предпочтительные дни для тренировок", \
   **тогда** я вижу список дней недели и могу выбрать необходимые, а также сохранить данные, нажав кнопку "Сохранить план". \

## 2. Поиск тренировки пользователем

**В качестве** пользователя, \
**Я хочу** иметь возможность находить тренировку согласно своему запросу, \
**Для того, чтобы** найти подходящую тренировку.

1. Сценарий: поиск тренировок по фильтру. \
   **Дано:** я зашел в сервис. \
   **Когда** я знаю какой тип тренировки или/и интенсивность я хочу выбрать, \
   **тогда** я могу использовать фильтрацию тренировок по необходимым параметрам, \
   **и** получить список тренировок, соответствующий своим предпочтениям. \
2. Сценарий: быстрый поиск тренировок. \
   **Дано:** я зашел в сервис \
   **И** выполнил быстрый поиск тренировок. \
   **Когда** я нажимую кнопку "Выбрать тренировку", \
   **тогда** мне выводится список тренировок на основе их популярности в приложении, а также фильтра "Интенсивность" в значении "Средний". \

## 3. Добавление тренировки пользователем

**В качестве** пользователя, \
**Я хочу** иметь возможность добавить свою тренировку в список тренировок, \
**Для того, чтобы** отслеживать прогресс тренировок со сторонних ресурсов.

1. Сценарий: добавление новой тренировки. \
   **Дано:** у меня есть ресурс, на котором находится желаемая тренировка. \
   **Когда** я нажимаю кнопку "Хотите добавить свою тренировку?", \
   **тогда** я получаю список полей, которые нужно заполнить для добавления тренировки \
   **и** могу добавить к ней описание, а также ссылку на сторонний ресурс (например, видеоролик).
2. Сценарий: поиск добавленной тренировки. \
   **Дано:** после добавления тренировки я желаю её быстро найти. \
   **Когда** я захожу в личный кабинет и нажимаю кнопку "Мои тренировки", \
   **тогда** я получаю список всех тренировок, которые я когда-либо добавлял. \
