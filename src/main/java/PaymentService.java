public final class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void processPayment(long amount) {
        if (amount > 0) {
            paymentRepository.save(amount);
        }
    }
}
