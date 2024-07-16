import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String opCode = st.nextToken();

            printOpcode(opCode);
            if (opCode.charAt(opCode.length() - 1) == 'C') {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            System.out.print("0");
            printRegisterD(Integer.parseInt(st.nextToken()));
            printRegisterA(Integer.parseInt(st.nextToken()), opCode);
            printRegisterB(Integer.parseInt(st.nextToken()), opCode);
            if (i != n - 1) {
                System.out.println();
            }
        }

    }

    private static void printOpcode(String opCode) {
        String result = "";

        if (opCode.contains("ADD")) {
            result = "0000";
        } else if (opCode.contains("SUB")) {
            result = "0001";
        } else if (opCode.contains("MOV")) {
            result = "0010";
        } else if (opCode.contains("AND")) {
            result = "0011";
        } else if (opCode.contains("OR")) {
            result = "0100";
        } else if (opCode.contains("NOT")) {
            result = "0101";
        } else if (opCode.contains("MULT")) {
            result = "0110";
        } else if (opCode.contains("LSFTL")) {
            result = "0111";
        } else if (opCode.contains("LSFTR")) {
            result = "1000";
        } else if (opCode.contains("ASFTR")) {
            result = "1001";
        } else if (opCode.contains("RL")) {
            result = "1010";
        } else if (opCode.contains("RR")) {
            result = "1011";
        }

        System.out.print(result);
    }
    private static void printRegisterD(int num) {
        System.out.print(String.format("%3s", Integer.toBinaryString(num)).replace(' ', '0'));
    }
    private static void printRegisterA(int num, String opCode) {
        if (opCode.contains("MOV") || opCode.contains("NOT")) {
            System.out.print("000");
        } else {
            System.out.print(String.format("%3s", Integer.toBinaryString(num)).replace(' ', '0'));
        }
    }
    private static void printRegisterB(int num, String opCode) {
        if (opCode.endsWith("C")) {
            System.out.print(String.format("%4s", Integer.toBinaryString(num)).replace(' ', '0'));
        } else {
            String binary = String.format("%3s", Integer.toBinaryString(num)).replace(' ', '0');
            System.out.print(binary + "0");
        }
    }
}
