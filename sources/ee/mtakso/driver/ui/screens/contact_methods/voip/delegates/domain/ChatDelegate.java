package ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain;

import ee.mtakso.driver.network.client.OrderHandle;
import ee.mtakso.driver.service.chat.ChatMessageMapper;
import ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate;
import ee.mtakso.driver.utils.Optional;
import eu.bolt.chat.chatcore.entity.OrderHandleEntity;
import eu.bolt.driver.chat.DriverChatSdk;
import eu.bolt.driver.chat.service.ChatManager;
import eu.bolt.driver.chat.service.NewConversationParams;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatDelegate.kt */
/* loaded from: classes3.dex */
public final class ChatDelegate {

    /* renamed from: a  reason: collision with root package name */
    private final ContactOptionsDelegate f27895a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatMessageMapper f27896b;

    /* compiled from: ChatDelegate.kt */
    /* loaded from: classes3.dex */
    public static final class ChatInfo {

        /* renamed from: a  reason: collision with root package name */
        private final ChatOptionsData f27897a;

        /* renamed from: b  reason: collision with root package name */
        private final OrderHandle f27898b;

        public ChatInfo(ChatOptionsData chatOptionsData, OrderHandle orderHandle) {
            this.f27897a = chatOptionsData;
            this.f27898b = orderHandle;
        }

        public final OrderHandle a() {
            return this.f27898b;
        }

        public final ChatOptionsData b() {
            return this.f27897a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ChatInfo) {
                ChatInfo chatInfo = (ChatInfo) obj;
                return Intrinsics.a(this.f27897a, chatInfo.f27897a) && Intrinsics.a(this.f27898b, chatInfo.f27898b);
            }
            return false;
        }

        public int hashCode() {
            ChatOptionsData chatOptionsData = this.f27897a;
            int hashCode = (chatOptionsData == null ? 0 : chatOptionsData.hashCode()) * 31;
            OrderHandle orderHandle = this.f27898b;
            return hashCode + (orderHandle != null ? orderHandle.hashCode() : 0);
        }

        public String toString() {
            ChatOptionsData chatOptionsData = this.f27897a;
            OrderHandle orderHandle = this.f27898b;
            return "ChatInfo(chatDetails=" + chatOptionsData + ", activeOrderHandle=" + orderHandle + ")";
        }
    }

    @Inject
    public ChatDelegate(ContactOptionsDelegate contactOptionsDelegate, ChatMessageMapper chatMessageMapper) {
        Intrinsics.f(contactOptionsDelegate, "contactOptionsDelegate");
        Intrinsics.f(chatMessageMapper, "chatMessageMapper");
        this.f27895a = contactOptionsDelegate;
        this.f27896b = chatMessageMapper;
    }

    private final Single<Optional<ChatOptionsData>> d(OrderHandle orderHandle, ChatOptionsData chatOptionsData) {
        if (chatOptionsData == null) {
            return this.f27895a.l(orderHandle);
        }
        Single<Optional<ChatOptionsData>> w7 = Single.w(Optional.f(chatOptionsData));
        Intrinsics.e(w7, "just(Optional.of(knownChatData))");
        return w7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatInfo f(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (ChatInfo) tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SingleSource g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (SingleSource) tmp0.invoke(obj);
    }

    public final Single<ChatInfo> e(final OrderHandle orderHandle, ChatOptionsData chatOptionsData) {
        Intrinsics.f(orderHandle, "orderHandle");
        Single<Optional<ChatOptionsData>> d8 = d(orderHandle, chatOptionsData);
        final Function1<Optional<ChatOptionsData>, ChatInfo> function1 = new Function1<Optional<ChatOptionsData>, ChatInfo>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate$requestCallInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final ChatDelegate.ChatInfo invoke(Optional<ChatOptionsData> chatData) {
                Intrinsics.f(chatData, "chatData");
                return new ChatDelegate.ChatInfo(chatData.c(), OrderHandle.this);
            }
        };
        Single<R> x7 = d8.x(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ChatDelegate.ChatInfo f8;
                f8 = ChatDelegate.f(Function1.this, obj);
                return f8;
            }
        });
        final Function1<ChatInfo, SingleSource<? extends ChatInfo>> function12 = new Function1<ChatInfo, SingleSource<? extends ChatInfo>>() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.ChatDelegate$requestCallInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final SingleSource<? extends ChatDelegate.ChatInfo> invoke(ChatDelegate.ChatInfo info) {
                ChatMessageMapper chatMessageMapper;
                Intrinsics.f(info, "info");
                if (info.b() != null && info.a() != null) {
                    ChatManager c8 = DriverChatSdk.f40388a.c();
                    String a8 = info.b().a().a();
                    long a9 = info.b().a().b().a();
                    String b8 = info.b().a().b().b();
                    String c9 = info.b().a().b().c();
                    OrderHandleEntity orderHandleEntity = new OrderHandleEntity(OrderHandle.this.b(), OrderHandle.this.c(), Long.valueOf(OrderHandle.this.a()));
                    chatMessageMapper = this.f27896b;
                    return c8.g(new NewConversationParams(a8, a9, b8, c9, orderHandleEntity, chatMessageMapper.a(info.b().a().a(), info.b().a().c()))).f(Single.w(info));
                }
                throw new IllegalArgumentException();
            }
        };
        Single<ChatInfo> r7 = x7.r(new Function() { // from class: ee.mtakso.driver.ui.screens.contact_methods.voip.delegates.domain.b
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SingleSource g8;
                g8 = ChatDelegate.g(Function1.this, obj);
                return g8;
            }
        });
        Intrinsics.e(r7, "fun requestCallInfo(orde…nfo))\n            }\n    }");
        return r7;
    }
}
