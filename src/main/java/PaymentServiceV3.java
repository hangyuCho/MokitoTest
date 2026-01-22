public final class PaymentServiceV3 {
    public void processPayment(long amount) {
        if (amount > 0) {
            // メソッド内部で触接オブジェクトを生成する場合
            PaymentRepository repository = new PaymentRepository();
            repository.save(amount);
        }
    }
}
