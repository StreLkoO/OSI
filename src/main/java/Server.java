import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {


            System.out.println("New connection accepted");
            String input = in.readLine();
            System.out.println("Client connecting with \"" + input + "\"");
            out.println("Write your name");
            String name = in.readLine();
            out.println("Are you child? (yes/no)");
            input = in.readLine();
            out.println(input.equals("no") ? "Welcome to the adult zone, " + name +
                    "! Have a good rest, or a good working day!"
                    : "Welcome to the kids area, " + name + "! Let's play!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
