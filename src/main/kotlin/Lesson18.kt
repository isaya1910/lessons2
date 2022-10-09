/*
  1. Subtype inheritance: Класс Administrator является подтипом класса Employee если он никак не расширяет и не ограничевает все методы класса Employee
  2. Restriction inheritance: Класс Administrator может быть наследником ограничивающим класс Employee если например в методе communicate(other: Employee)
      мы переопределим метод как communicate(other: Administrator) то есть администратор может взаимодействовать только с другими администраторами
  3. Extension inheritance:
    Хорошим примером такого наследование будет класс DoubleLinkedList наследуемый от ParentLinkedList в данном случае у DoubleLinkedList появляются совершенно новый свойства (методы previous и тд)
*/
