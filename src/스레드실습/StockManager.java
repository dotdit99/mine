package 스레드실습;

public class StockManager {

    private final String productName;
    private int stock;                   // 현재 재고 수량
    private boolean outOfStock = false;  // 품절 여부 플래그
    private int totalOrders = 0;         // 성공한 주문 수

    public StockManager(String productName, int initialStock) {
        this.productName = productName;
        this.stock = initialStock;
    }

    // ✅ synchronized : 동시에 여러 스레드가 재고에 접근하지 못하도록 Lock
    public synchronized boolean order(String userId, int quantity) {

        // 이미 품절이면 즉시 반환
        if (outOfStock) {
            return false;
        }

        // 주문 수량보다 재고가 부족한 경우
        if (stock < quantity) {
            System.out.printf("  ❌ [주문 실패] %-8s | 요청 %d개 | 재고 부족 (현재 %d개)%n",
                    userId, quantity, stock);
            return false;
        }

        // 실제 결제 및 재고 차감 처리 (DB 처리 시간 시뮬레이션)
        try {
            System.out.printf("  ⏳ [처리 중] %-8s | %d개 주문 결제 진행...%n", userId, quantity);
            Thread.sleep(200); // ✅ sleep() : 결제 처리 대기 (Lock은 유지됨)
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }

        stock -= quantity;
        totalOrders++;

        System.out.printf("  ✅ [주문 완료] %-8s | %d개 구매 | 잔여 재고: %d개%n",
                userId, quantity, stock);

        // 재고 소진 시 품절 처리 + 대기 중인 스레드 모두 깨우기
        if (stock == 0) {
            outOfStock = true;
            notifyAll(); // ✅ notifyAll() : StockMonitor의 wait() 해제
        }

        return true;
    }

    // ✅ wait() : 품절이 될 때까지 모니터 스레드가 여기서 대기
    public synchronized void waitUntilOutOfStock() throws InterruptedException {
        while (!outOfStock) {
            wait(); // 품절 신호가 올 때까지 Lock 반납 후 대기
        }
    }

    public boolean isOutOfStock() { return outOfStock; }
    public int getStock()         { return stock; }
    public int getTotalOrders()   { return totalOrders; }
    public String getProductName(){ return productName; }
}