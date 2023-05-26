package ee.mtakso.driver.service.polling.message;

import ee.mtakso.driver.network.client.driver.PollMessage;
import ee.mtakso.driver.network.client.driver.PollMessageSeverity;
import ee.mtakso.driver.utils.Optional;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollMessageManager.kt */
/* loaded from: classes3.dex */
public final class PollMessageManager {

    /* renamed from: a  reason: collision with root package name */
    private final PollMessageCache f25578a;

    @Inject
    public PollMessageManager(PollMessageCache pollMessageCache) {
        Intrinsics.f(pollMessageCache, "pollMessageCache");
        this.f25578a = pollMessageCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Optional c(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (Optional) tmp0.invoke(obj);
    }

    public final Observable<Optional<PollMessage>> b() {
        Observable<List<PollMessage>> b8 = this.f25578a.b();
        final PollMessageManager$observePollMessage$1 pollMessageManager$observePollMessage$1 = new Function1<List<? extends PollMessage>, Optional<PollMessage>>() { // from class: ee.mtakso.driver.service.polling.message.PollMessageManager$observePollMessage$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final Optional<PollMessage> invoke(List<PollMessage> messages) {
                Object obj;
                boolean z7;
                Intrinsics.f(messages, "messages");
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : messages) {
                    if (((PollMessage) obj2).b() != PollMessageSeverity.LOW) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    if (z7) {
                        arrayList.add(obj2);
                    }
                }
                Iterator it = arrayList.iterator();
                if (!it.hasNext()) {
                    obj = null;
                } else {
                    Object next = it.next();
                    if (!it.hasNext()) {
                        obj = next;
                    } else {
                        int ordinal = ((PollMessage) next).b().ordinal();
                        do {
                            Object next2 = it.next();
                            int ordinal2 = ((PollMessage) next2).b().ordinal();
                            if (ordinal > ordinal2) {
                                next = next2;
                                ordinal = ordinal2;
                            }
                        } while (it.hasNext());
                        obj = next;
                    }
                }
                return Optional.f(obj);
            }
        };
        Observable map = b8.map(new Function() { // from class: ee.mtakso.driver.service.polling.message.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Optional c8;
                c8 = PollMessageManager.c(Function1.this, obj);
                return c8;
            }
        });
        Intrinsics.e(map, "pollMessageCache\n       …          )\n            }");
        return map;
    }
}
