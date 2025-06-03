// first method

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class client {

    private static final int PORT = 5000;
    private static ExecutorService clientPool = Executors.newFixedThreadPool(10); // Supports up to 10 clients

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT + "...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                clientPool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Handles each connected client
class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String request = in.readLine();
            System.out.println("Received request: " + request + " from " + socket.getInetAddress());

            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Approve request from " + socket.getInetAddress() + "? (yes/no): ");
            String decision = console.readLine();

            if ("yes".equalsIgnoreCase(decision)) {
                out.println("APPROVED");
                System.out.println("Request approved.\n");
            } else {
                out.println("DENIED");
                System.out.println("Request denied.\n");
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// second method

// import java.net.*;
// import java.io.*;

// public class  client {
//     public static void main (String [] args) thorws IOException{
//         Socket s = new Socket("localhost",122);

// sending data 

// PrintWriter p = new PrintWriter(s.getOutputStream());
// p.println("hello from server");
// p.flush();
//     }
    
// }