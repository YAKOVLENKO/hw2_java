# hw2_java

Java-11

Сборка + запуск:

./gradlew build

**./gradlew :LoggerApplication:run** или **./gradlew :LoggerApplication:run --args='**_любой_тэг_**'** - для вывода в консоль

**./gradlew :LoggerApplication:run --args='file_logger filetag'** - для вывода в файл

**./gradlew :LoggerApplication:run --args='all_logger mytag'** - вывод и в консоль, и в файл

Файл с логами лежит в LoggerApplication - data.txt
