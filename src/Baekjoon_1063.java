import java.util.*;
import java.io.*;

public class Baekjoon_1063 {
    static int kingA;
    static int kingB;
    static int stoneA;
    static int stoneB;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 킹의 위치 입력
        String king = st.nextToken();
        kingA = apbToNum(king.charAt(0));
        kingB = king.charAt(1) - '0';

        // 돌의 위치 입력
        String stone = st.nextToken();
        stoneA = apbToNum(stone.charAt(0));
        stoneB = stone.charAt(1) - '0';
    
        // 킹 이동
        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int newKingA = 0;
            int newKingB = 0;
            switch (command) {
                case "R": // 한 칸 오른쪽으로
                    newKingA = kingA + 1;
                    if (newKingA <= 8) {
                        if (newKingA == stoneA && kingB == stoneB) {
                            if (stoneA + 1 <= 8) {
                                stoneA++;
                                kingA = newKingA;
                            }
                        } else {
                            kingA = newKingA;
                        }
                    }
                    break;
                case "L": // 한 칸 왼쪽으로
                    newKingA = kingA - 1;
                    if (newKingA >= 1) {
                        if (newKingA == stoneA && kingB == stoneB) {
                            if (stoneA - 1 >= 1) {
                                stoneA--;
                                kingA = newKingA;
                            }
                        } else {
                            kingA = newKingA;
                        }
                    }
                    break;
                case "B": // 한 칸 아래로
                    newKingB = kingB - 1;
                    if (newKingB >= 1) {
                        if (kingA == stoneA && newKingB == stoneB) {
                            if (stoneB - 1 >= 1) {
                                stoneB--;
                                kingB = newKingB;
                            }
                        } else {
                            kingB = newKingB;
                        }
                    }
                    break;
                case "T": // 한 칸 위로
                    newKingB = kingB + 1;
                    if (newKingB <= 8) {
                        if (kingA == stoneA && newKingB == stoneB) {
                            if (stoneB + 1 <= 8) {
                                stoneB++;
                                kingB = newKingB;
                            }
                        } else {
                            kingB = newKingB;
                        }
                    }
                    break;
                case "RT": // 오른쪽 위 대각선으로
                    newKingA = kingA + 1;
                    newKingB = kingB + 1;
                    if (newKingA <= 8 && newKingB <= 8) {
                        if (newKingA == stoneA && newKingB == stoneB) {
                            if (stoneA + 1 <= 8 && stoneB + 1 <= 8) {
                                stoneA++;
                                stoneB++;
                                kingA = newKingA;
                                kingB = newKingB;
                            }
                        } else {
                            kingA = newKingA;
                            kingB = newKingB;
                        }
                    }
                    break;
                case "LT": // 왼쪽 위 대각선으로
                    newKingA = kingA - 1;
                    newKingB = kingB + 1;
                    if (newKingA >= 1 && newKingB <= 8) {
                        if (newKingA == stoneA && newKingB == stoneB) {
                            if (stoneA - 1 >= 1 && stoneB + 1 <= 8) {
                                stoneA--;
                                stoneB++;
                                kingA = newKingA;
                                kingB = newKingB;
                            }
                        } else {
                            kingA = newKingA;
                            kingB = newKingB;
                        }
                    }
                    break;
                case "RB": // 오른쪽 아래 대각선으로
                    newKingA = kingA + 1;
                    newKingB = kingB - 1;
                    if (newKingA <= 8 && newKingB >= 1) {
                        if (newKingA == stoneA && newKingB == stoneB) {
                            if (stoneA + 1 <= 8 && stoneB - 1 >= 1) {
                                stoneA++;
                                stoneB--;
                                kingA = newKingA;
                                kingB = newKingB;
                            }
                        } else {
                            kingA = newKingA;
                            kingB = newKingB;
                        }
                    }
                    break;
                case "LB": // 왼쪽 아래 대각선으로
                    newKingA = kingA - 1;
                    newKingB = kingB - 1;
                    if (newKingA >= 1 && newKingB >= 1) {
                        if (newKingA == stoneA && newKingB == stoneB) {
                            if (stoneA - 1 >= 1 && stoneB - 1 >= 1) {
                                stoneA--;
                                stoneB--;
                                kingA = newKingA;
                                kingB = newKingB;
                            }
                        } else {
                            kingA = newKingA;
                            kingB = newKingB;
                        }
                    }
                    break;
                
            }
        }
        sb.append(numToApb(kingA));
        sb.append(kingB);
        sb.append("\n");
        sb.append(numToApb(stoneA));
        sb.append(stoneB);
        System.out.println(sb.toString());
    }

    public static int apbToNum(char apb) {
        int output = 0;

        switch (apb) {
            case 'A':
                output = 1;
                break;
            case 'B':
                output = 2;
                break;
            case 'C':
                output = 3;
                break;
            case 'D':
                output = 4;
                break;
            case 'E':
                output = 5;
                break;
            case 'F':
                output = 6;
                break;
            case 'G':
                output = 7;
                break;
            case 'H':
                output = 8;
                break;
        }
        return output;
    }

    public static char numToApb(int num) {
        char output = ' ';

        switch (num) {
            case 1:
                output = 'A';
                break;
            case 2:
                output = 'B';
                break;
            case 3:
                output = 'C';
                break;
            case 4:
                output = 'D';
                break;
            case 5:
                output = 'E';
                break;
            case 6:
                output = 'F';
                break;
            case 7:
                output = 'G';
                break;
            case 8:
                output = 'H';
                break;
        }
        return output;
    }
}
