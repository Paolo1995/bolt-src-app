package eu.bolt.chat.chatcore.repo;

import eu.bolt.chat.chatcore.network.repo.ChatEvent;
import eu.bolt.chat.tools.logger.Logger;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultChatRepo.kt */
/* loaded from: classes5.dex */
public final class DefaultChatRepo$onClientInit$1 extends Lambda implements Function1<ChatEvent, CompletableSource> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ DefaultChatRepo f38442f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultChatRepo$onClientInit$1(DefaultChatRepo defaultChatRepo) {
        super(1);
        this.f38442f = defaultChatRepo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // kotlin.jvm.functions.Function1
    /* renamed from: c */
    public final CompletableSource invoke(ChatEvent event) {
        Logger logger;
        Completable H0;
        Intrinsics.f(event, "event");
        logger = this.f38442f.f38407e;
        logger.b("got new message " + event);
        H0 = this.f38442f.H0(event);
        final DefaultChatRepo defaultChatRepo = this.f38442f;
        final Function1<Throwable, Unit> function1 = new Function1<Throwable, Unit>() { // from class: eu.bolt.chat.chatcore.repo.DefaultChatRepo$onClientInit$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.f50853a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable it) {
                Logger logger2;
                logger2 = DefaultChatRepo.this.f38407e;
                Intrinsics.e(it, "it");
                logger2.a(it, "Error during handling chat event");
            }
        };
        return H0.p(new Consumer() { // from class: eu.bolt.chat.chatcore.repo.g0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                DefaultChatRepo$onClientInit$1.d(Function1.this, obj);
            }
        }).A();
    }
}
