package 스레드실습;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 상품 등록: 맥북 프로 10대
        StockManager stockManager = new StockManager("맥북 프로 M4", 10);

        // ✅ Daemon Thread 로 품절 감시 시작
        StockMonitor monitor = new StockMonitor(stockManager);
        monitor.start();

        // 동시 주문 사용자 15명 (재고 10개보다 많음 → 5명은 실패해야 함)
        String[][] orders = {
                {"user01", "2"}, {"user02", "1"}, {"user03", "3"}, {"user04", "1"},
                {"user05", "2"}, {"user06", "1"}, {"user07", "1"}, {"user08", "2"},
                {"user09", "1"}, {"user10", "1"}, {"user11", "1"}, {"user12", "2"},
                {"user13", "1"}, {"user14", "1"}, {"user15", "3"}
        };

        List<Thread> threads = new ArrayList<>();

        for (String[] order : orders) {
            String userId   = order[0];
            int    quantity = Integer.parseInt(order[1]);
            Thread t = new Thread(new OrderThread(stockManager, userId, quantity));
            t.setName("order-" + userId);
            threads.add(t);
        }

        System.out.println("🛒 ====== 쇼핑몰 주문 시스템 오픈 ======");
        System.out.printf("🛒  상품: %s | 초기 재고: %d개%n%n",
                stockManager.getProductName(), stockManager.getStock());

        // 모든 주문 스레드 동시 시작
        for (Thread t : threads) {
            t.start();
            Thread.sleep(30); // ✅ sleep() : 사용자 접속 시차 연출 (30ms 간격)
        }

        // ✅ join() : 모든 주문 스레드 종료까지 메인 스레드 대기
        for (Thread t : threads) {
            t.join();
        }

        monitor.stopMonitor();

        System.out.println();
        System.out.println("🏁 ====== 주문 처리 완료 ======");
        System.out.printf("🏁  최종 잔여 재고 : %d개%n", stockManager.getStock());
        System.out.printf("🏁  총 성공 주문수 : %d건%n", stockManager.getTotalOrders());
    }
}