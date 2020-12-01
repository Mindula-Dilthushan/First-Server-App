import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Waiting wor the client...");
            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted! ");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String message="" , reply="";

            while (!message.equals("end")){
                message=dataInputStream.readUTF();
                System.out.println(message);
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }

            dataInputStream.close();
            dataOutputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
