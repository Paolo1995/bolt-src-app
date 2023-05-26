package ee.mtakso.driver.service.order.details;

import io.reactivex.Observable;
import java.util.List;

/* compiled from: OrderProvider.kt */
/* loaded from: classes3.dex */
public interface OrderProvider {
    Observable<List<OrderDetails>> a();

    List<OrderDetails> f();
}
