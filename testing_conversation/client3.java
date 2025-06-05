import java.io.*;
import java.net.*;

public class client3 {
    private static final String SERVER_IP = "192.168.100.8"; // 
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        String clientName = "client 3"; // 

        try (
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            System.out.println("🔌 Connected to server at " + SERVER_IP + ":" + SERVER_PORT);

            out.println(clientName); // Send name

            String response = in.readLine();
            if (response == null) {
                System.out.println("❌ No response from server.");
                return;
            }

            System.out.println("Server response: " + response);

            if ("APPROVED".equals(response)) {
                String message = in.readLine();
                System.out.println("Message from server: " + message);
            } else if ("DECLINED".equals(response)) {
                System.out.println("Access was declined by the server.");
            }

        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }
}
