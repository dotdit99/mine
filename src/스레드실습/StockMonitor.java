package 스레드실습;

public class StockMonitor extends Thread {

    private final StockManager stockManager;
    private volatile boolean stop = false; // ✅ stop 플래그 : 안전한 스레드 종료

    public StockMonitor(StockManager stockManager) {
        this.stockManager = stockManager;
        this.setDaemon(true);         // ✅ Daemon Thread : 메인 종료 시 자동 소멸
        this.setName("stock-monitor");
    }

    public void stopMonitor() {
        stop = true;
        interrupt(); // wait() 상태라면 즉시 깨움
    }

    @Override
    public void run() {
        System.out.println("🔍 [모니터] 재고 감시 시작 → 상품: " + stockManager.getProductName());

        try {
            stockManager.waitUntilOutOfStock(); // ✅ wait() 로 품절 신호 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        if (!stop) {
            System.out.println();
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
            System.out.println("🚨 [품절 알림] " + stockManager.getProductName() + " 재고 소진!");
            System.out.println("📩  대기 고객 전원에게 품절 알림 발송 완료");
            System.out.println("📊  총 주문 성공 건수: " + stockManager.getTotalOrders() + "건");
            System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
    }
}