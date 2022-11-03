import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeOfList = 0;
        int upperBound = 0;
        int filterInt = 0;
        Logger logger = Logger.getInstance();
        logger.log("Запуск программы");
        logger.log("Просьба ввести пользователем данные");

        while (true) {
            System.out.println("Введите размер списка и его вернхнюю границу через пробел");
            String[] input = (scanner.nextLine().split(" "));
            sizeOfList = Integer.parseInt(input[0]);
            upperBound = Integer.parseInt(input[1]);
            if (sizeOfList <= 0 || upperBound <= 0) {
                logger.log("Неверные входные данные");
                logger.log("Повторите попытку");
            } else {
                logger.log("Введены коректные входные данные");
                break;
            }

        }
        logger.log("Создаем и наполняем список");
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sizeOfList; i++) {
            list.add(random.nextInt(upperBound));
        }
        logger.log("Вот случайный список " + list);
        while (true) {
            logger.log("Введите число для фильтрации");
            filterInt = scanner.nextInt();
            if (filterInt < 0) {
                logger.log("Данные введены некорректно, повторите попытку");
            } else {
                logger.log("Введены корректные данные");
                break;
            }
        }
        Filter filter = new Filter(filterInt);
        List<Integer> filterList = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filterList);
        logger.log("Завершаем программу");
    }
}