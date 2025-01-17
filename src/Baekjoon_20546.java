import java.util.Scanner;

public class Baekjoon_20546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        // 시드 머니 입력
        int start = sc.nextInt();
        int walletJ = start;
        int walletS = start;
        int accJ = 0;
        int accS = 0;

        // 주가 입력
        int[] price = new int[14];
        for (int i = 0; i < 14; i++) {
            price[i] = sc.nextInt();
        }
        
        // 준현이 수익 계산
        for (int i = 0; i < 14; i++) {
            if (price[i] <= walletJ) {
                accJ = walletJ / price[i];
                walletJ -= walletJ / price[i] * price[i];
            }
        }

        // 성민이 수익 계산
        int buy = 0; // 3 : 매수 타이밍
        int sell = 0; // 3 : 매도 타이밍
        for (int i = 1; i < 14; i++) {
            int yesterday = price[i-1];
            int now = price[i];


            // 상승
            if (yesterday < now) {
                buy++;
                sell = 0;
                if (buy >= 3) {
                    // 전량 매도
                    if (accJ > 0) {
                        walletS += accS * now;
                        accS = 0;
                    }
                }
            }
            // 하락
            else if (yesterday > now) {
                sell++;
                buy = 0;
                if (sell >= 3) {
                    // 전량 매수
                    if (walletS >= now) {
                        accS += walletS / now;
                        walletS -= (walletS / now) * now;
                    }
                }
            }
        }

        walletJ = walletJ + (price[13] * accJ);
        walletS = walletS + (price[13] * accS);
        System.out.println(walletJ + " " + walletS);

        if (walletJ > walletS) {
            System.out.println("BNP");
        }
        else if (walletJ < walletS) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
}
