import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public final static int SERVICE_PORT = 8080;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, SERVICE_PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Hello SERVER!");
            System.out.println(in.readLine());
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
