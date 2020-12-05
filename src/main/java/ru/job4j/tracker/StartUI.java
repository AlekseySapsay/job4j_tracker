package ru.job4j.tracker;


public class StartUI {
    // select == 0
    public static void createItem(Input input, Tracker tracker) {
        System.out.println(" === Create a new Item === ");
        String name = input.askStr("Enter name : ");
        Item item = new Item(name);
        tracker.add(item);
    }

    // select == 1
    public static void showItems(Input input, Tracker tracker) {
        System.out.println(" === Show all items === ");
        Item[] itemsArray = tracker.findAll();
        for (Item elements : itemsArray) {
            System.out.println(elements);
        }
    }

    // select == 2;
    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println(" ==== Update item ==== ");
        int id = Integer.parseInt(input.askStr("Enter id : "));
        String name = input.askStr("Enter a new name of item : ");
        Item item = new Item(name);
        item.setId(id);

        //2. Для методов replace/delete сделать вывод в виде:
        if (tracker.replace(id, item)) {
            // вывод об успешности операции
            System.out.println("замена элемента по id выполненна успешно");
        } else {
            // вывод об ошибке
            System.out.println("возникла ошибка при попытке замены элемента");
            System.out.println("возможно элемента с таким id не существует");
            System.out.println("попробуйте снова");
        }
    }

    // select == 3
    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Введите id элемента для удаления : "));
        if (tracker.delete(id)) {
            // вывод об успешности операции
            System.out.println("Удаление элемента по id выполненно успешно");
        } else {
            // вывод об ошибке
            System.out.println("Возникла ошибка при попытке удаления элемента");
            System.out.println("Возможно элемента с таким id не существует");
            System.out.println("Попробуйте снова");
        }
    }
    // select == 4
    public static void findItemById(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Введите id элемента для поиска : "));
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Заявка с таким id не найдена");
        } else {
            System.out.println(item.getName());
        }
    }
    // select == 5
    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("Введите имя для поиске в списке заявок");
        String name = input.askStr("Enter name : ");
        Item[] itemArray = tracker.findByName(name);

        if (itemArray.length == 0) {
            System.out.println("Заявки с таким именем не найдены");
        } else {
            for (Item element : itemArray) {
                System.out.println(element);
            }
        }
    }

    
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr("Select action : "));

            if (select == 0) {
                StartUI.createItem(input, tracker);

            } else if (select == 1) {
                StartUI.showItems(input, tracker);

            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);

            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);

            } else if (select == 4) {
                StartUI.findItemById(input, tracker);

            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);

            } else if (select == 6) {
                System.out.println("Выходим из программы ");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println(" ******* Menu ******* ");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
//        StartUI.createItem(input, tracker);
    }
}