import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите IP-адрес: ");
        String ipAddress = scanner.nextLine();

        String regex = "^((\\d|\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ipAddress);

        try {
            FileWriter writer = new FileWriter("ip_addresses.txt", true); // открываем файл для записи
            if (matcher.find()) {                                                        //Поиск в строке str соответствий с помощью метода find() объекта matcher.
                writer.write(ipAddress + " соответствует шаблону IP-адреса\n");
                System.out.println(matcher.group() + " соответствует шаблону IP-адреса");
            } else {
                writer.write(ipAddress + " не соответствует шаблону IP-адреса\n");
                System.out.println(ipAddress + " не соответствует шаблону IP-адреса");
            }
            writer.close();                                                              // закрываем файл
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}