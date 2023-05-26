package ee.mtakso.driver.service.integration.clevertap.internal;

import com.clevertap.android.sdk.CTInboxListener;
import io.reactivex.subjects.Subject;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CleverTapInboxListener.kt */
/* loaded from: classes3.dex */
public final class CleverTapInboxListener implements CTInboxListener {

    /* renamed from: a  reason: collision with root package name */
    private final Subject<CleverTapInboxEvent> f24576a;

    public CleverTapInboxListener(Subject<CleverTapInboxEvent> listener) {
        Intrinsics.f(listener, "listener");
        this.f24576a = listener;
    }

    @Override // com.clevertap.android.sdk.CTInboxListener
    public void a() {
        this.f24576a.onNext(CleverTapInboxEvent.UPDATED);
    }

    @Override // com.clevertap.android.sdk.CTInboxListener
    public void b() {
        this.f24576a.onNext(CleverTapInboxEvent.INITIALISED);
    }
}
