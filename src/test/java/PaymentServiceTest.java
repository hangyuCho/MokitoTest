import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PaymentServiceTest {

    @Test
    public void testProcessPayment() {
        // Mockオブジェクト生成
        PaymentRepository mockRepository = Mockito.mock(PaymentRepository.class);
        
        // Service生成（Mock注入）
        PaymentService paymentService = new PaymentService(mockRepository);

        // テスト実行
        paymentService.processPayment(100);

        // 検証：repositoryのsaveメソッドの引数が100で呼ばれたのか？
        verify(mockRepository).save(100);
    }

    @Test
    public void testProcessPayment_InvalidAmount() {
        PaymentRepository mockRepository = Mockito.mock(PaymentRepository.class);
        PaymentService paymentService = new PaymentService(mockRepository);

        paymentService.processPayment(-10);

        // 検証：金額が0以下の場合はsaveメソッドが呼ばれっちゃだめ。
        verify(mockRepository, times(0)).save(anyLong());
    }
}
