import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceAdvancedTest {

    // 1. コンストラクタがなくても@InjectMocksを使ったらMockitoがリフレクションでフィールドに注入してくれる。
    @Mock
    private PaymentRepository mockRepository;

    @InjectMocks
    private PaymentServiceV2 paymentServiceV2;

    @Test
    public void testFieldInjection() {
        paymentServiceV2.processPayment(200);
        verify(mockRepository).save(200);
    }

    // 2. メソッド内部でnewで生成するときの例（MockedConstructionを利用）
    @Test
    public void testLocalConstruction() {
        try (MockedConstruction<PaymentRepository> mocked = mockConstruction(PaymentRepository.class)) {
            PaymentServiceV3 service = new PaymentServiceV3();
            
            service.processPayment(300);

            // 생성된 mock 객체들 중 첫 번째를 가져와서 검증
            PaymentRepository mockRepo = mocked.constructed().get(0);
            verify(mockRepo).save(300);
        }
    }
}
