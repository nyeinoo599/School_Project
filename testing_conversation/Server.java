import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        System.out.println("🔒 Server started on port " + PORT + ". Waiting for connections...");
        Scanner scanner = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                // System.out.println("\n📥 IP address ?: " + socket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String clientName = in.readLine();
                if (clientName == null) {
                    System.out.println("⚠️ Client disconnected before sending name.");
                    socket.close();
                    continue;
                }

                System.out.println("🔔 Access request from: " + clientName);
                System.out.print("Approve " + clientName + "? (yes/no): ");
                String decision = scanner.nextLine().trim().toLowerCase();

                if (decision.equals("yes")) {
                    out.println("APPROVED");
                    out.println("Welcome, " + clientName + "! You are now connected to the server.");
                    System.out.println("✅ " + clientName + " approved.");
                } else {
                    out.println("DECLINED");
                    System.out.println("❌ " + clientName + " declined.");
                }

                socket.close();
                System.out.println("🔌 Connection closed with " + clientName);
            }
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}
