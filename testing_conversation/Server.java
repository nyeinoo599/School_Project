// First Method

import java.io.*;
import java.net.*;

public class Server {

    private static final String SERVER_IP = "192.168.1.10"; // Replace with PC.A's IP
    private static final int SERVER_PORT = 5000;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            // Send request to server
            String requestMessage = "Client " + InetAddress.getLocalHost().getHostName() + " requests access";
            out.println(requestMessage);
            System.out.println("Sent request: " + requestMessage);

            // Wait for response
            String response = in.readLine();
            System.out.println("Server response: " + response);

            if ("APPROVED".equalsIgnoreCase(response)) {
                System.out.println("You are approved to continue.");
                // Example: Launch Notepad (Windows only)
                Runtime.getRuntime().exec("notepad");
            } else {
                System.out.println("Access denied by server.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//  second Method
// import java.net.*;
// import java.io.*;

// public class  Server {
//     public static void main (String [] args) thorws IOException{
//         ServerSocket s = new ServerSocket(122);
//         Socket s = s.accept();

//         System.out.println("client connected");

// sending data
InputStreamReader in = new InputStreamReader(s.getInputStream);
BufferedReader bf = new BufferedReader(in);

// String str = bf.readLine();
// System.out.println("client : "+ str);
//     }
    
// }