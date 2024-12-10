package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Util {

    public static int purchasePrice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static int nonAutoCount() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static List<LottoNumbers> lottoNumbersList(int nonAutoCount) {
        Scanner sc = new Scanner(System.in);
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < nonAutoCount; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            int n4 = sc.nextInt();
            int n5 = sc.nextInt();
            int n6 = sc.nextInt();

            ArrayList<Integer> numberList = new ArrayList<>(List.of(n1, n2, n3, n4, n5, n6));

            lottoNumbersList.add(new LottoNumbers(numberList));
        }

        return lottoNumbersList;
    }

    public static void lottoNumber(int purchasePrice, int nonAutoCount, List<LottoNumbers> lottoNumbersList) {
        List<Integer> numberList = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toCollection(ArrayList::new));

        int count = purchasePrice / 1000 - nonAutoCount;

        for (int i = 0; i < count; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers(numberList);
            lottoNumbersList.add(lottoNumbers);
        }

    }

    public static void choosePrint(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            lottoNumber.print();
        }
    }

    public static LottoNumbers winningList() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            temp.add(scanner.nextInt());
        }

        return new LottoNumbers(temp);
    }

    public static int bonusNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Rank> rankList(List<LottoNumbers> lottoNumbersList, LottoNumbers winningList, int bonusNumber) {
        ArrayList<Rank> rankList = new ArrayList<>();

        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            List<Integer> temp = lottoNumbers.getLottoList();
            temp.retainAll(winningList.getLottoList());
            boolean matchBonus = winningList.getLottoList().contains(Integer.valueOf(bonusNumber));
            rankList.add(Rank.valueOf(temp.size(), matchBonus));
        }

        return rankList;
    }

    public static void resultPrint(List<Rank> rankList) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            if (rank.equals(Rank.SECOND)) {
                System.out.println("5개 일치 ,보너스 볼 일치(30000000원) " + Collections.frequency(rankList, rank) + "개");
            } else
                System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)- " + Collections.frequency(rankList, rank) + "개");
        }
    }

    public static void calculateRateOfReturn(List<Rank> rankList, int purchasePrice) {
        double sum = 0;
        for (Rank rank : rankList) {
            sum += rank.getWinningMoney();
        }

        System.out.println("총 수익률은 " + Math.floor(sum / purchasePrice * 100) / (double) 100 + "입니다.");
    }
}
