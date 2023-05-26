package eu.bolt.driver.chat;

import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import io.reactivex.Observable;
import java.util.List;

/* compiled from: ActiveOrdersSource.kt */
/* loaded from: classes5.dex */
public interface ActiveOrdersSource {
    Observable<List<OrderHandleEntity>> a();
}
