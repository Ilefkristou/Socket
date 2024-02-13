import java.io.*;
import java.net.*;
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 9876);
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.print("Veuillez saisir un message : ");
            String message = inFromUser.readLine();
            outToServer.println(message);
            String modifiedMessage = inFromServer.readLine();
            System.out.println("Réponse du serveur : " + modifiedMessage);
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
