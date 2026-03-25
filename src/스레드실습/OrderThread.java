package 스레드실습;

public class OrderThread implements Runnable {

    private final StockManager stockManager;
    private final String userId;
    private final int quantity;

    public OrderThread(StockManager stockManager, String userId, int quantity) {
        this.stockManager = stockManager;
        this.userId = userId;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        // 이미 품절이면 서버 요청 자체를 하지 않음 (트래픽 절감)
        if (stockManager.isOutOfStock()) {
            System.out.printf("  ❌ [품절] %-8s | 주문 불가 (이미 품절)%n", userId);
            return;
        }

        System.out.printf("👤 [접속] %-8s | %d개 주문 시도%n", userId, quantity);
        boolean success = stockManager.order(userId, quantity);

        if (!success && !stockManager.isOutOfStock()) {
            System.out.printf("  ❌ [실패] %-8s | 주문 처리 중 오류 발생%n", userId);
        }
    }
}