import java.io.*;
import java.net.*;
public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9876);
            System.out.println("Serveur TCP démarré...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouveau client connecté : " + clientSocket);
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                String clientMessage = inFromClient.readLine();
                System.out.println("Message du client : " + clientMessage);
                outToClient.println("Message reçu : " + clientMessage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
