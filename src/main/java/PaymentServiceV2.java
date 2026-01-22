public final class PaymentServiceV2 {
    // コンストラクタではなくフィールドで定義している場合
    private PaymentRepository paymentRepository = new PaymentRepository();

    public void processPayment(long amount) {
        if (amount > 0) {
            paymentRepository.save(amount);
        }
    }
}
