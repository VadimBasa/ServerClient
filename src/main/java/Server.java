import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT);) { // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
            System.out.println("Server started!");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    System.out.println("New connection accepted");
                    //System.out.println(in.readLine());
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    //out.println("Соединение установлено с порта " + clientSocket.getPort());
                    out.println("Соединение установлено с адреса " + clientSocket.getInetAddress());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
