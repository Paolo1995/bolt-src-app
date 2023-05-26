package ee.mtakso.driver.service.chat;

import ee.mtakso.driver.network.client.contact.ChatConfiguration;
import ee.mtakso.driver.param.ChatSettingsManager;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatConfigManager.kt */
@Singleton
/* loaded from: classes3.dex */
public final class ChatConfigManager {

    /* renamed from: a  reason: collision with root package name */
    private final ChatSettingsManager f23992a;

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f23993b;

    @Inject
    public ChatConfigManager(ChatSettingsManager chatSettingsManager) {
        Lazy a8;
        Intrinsics.f(chatSettingsManager, "chatSettingsManager");
        this.f23992a = chatSettingsManager;
        a8 = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<BehaviorSubject<ChatConfiguration>>() { // from class: ee.mtakso.driver.service.chat.ChatConfigManager$chatConfigurationSubject$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final BehaviorSubject<ChatConfiguration> invoke() {
                ChatConfiguration d8;
                d8 = ChatConfigManager.this.d();
                return BehaviorSubject.f(d8);
            }
        });
        this.f23993b = a8;
    }

    private final BehaviorSubject<ChatConfiguration> b() {
        Object value = this.f23993b.getValue();
        Intrinsics.e(value, "<get-chatConfigurationSubject>(...)");
        return (BehaviorSubject) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChatConfiguration d() {
        return new ChatConfiguration(this.f23992a.a(), null, 2, null);
    }

    public final Observable<ChatConfiguration> c() {
        return b();
    }

    public final void e() {
        this.f23992a.b();
    }

    public final void f(ChatConfiguration chatConfiguration) {
        Intrinsics.f(chatConfiguration, "chatConfiguration");
        this.f23992a.c(chatConfiguration.b());
        b().onNext(chatConfiguration);
    }
}
