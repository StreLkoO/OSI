import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static final String HOST = "netology.homework";
    public static final int PORT = 8080;

    public static void main(String[] args) {

        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            out.println("Trying connect with server");
            String serverResponse;
            while (true) {
                serverResponse = in.readLine();
                System.out.println("Server replies \"" + serverResponse + "\"");
                if (serverResponse.startsWith("Welcome")) {
                    break;
                }
                out.println(scanner.nextLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
