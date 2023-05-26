package eu.bolt.driver.chat.ui.notification;

import android.os.Build;
import eu.bolt.chat.chatcore.entity.ChatEntity;
import eu.bolt.chat.chatcore.entity.ChatMessageEntity;
import eu.bolt.driver.chat.service.analytics.ChatAnalytics;
import eu.bolt.driver.core.permission.PermissionManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatNotificationManager.kt */
@Singleton
/* loaded from: classes5.dex */
public final class ChatNotificationManager {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f40569g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ChatAnalytics f40570a;

    /* renamed from: b  reason: collision with root package name */
    private final ChatNotificationDrawer f40571b;

    /* renamed from: c  reason: collision with root package name */
    private final PermissionManager f40572c;

    /* renamed from: d  reason: collision with root package name */
    private String f40573d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, List<NotificationMessage>> f40574e;

    /* renamed from: f  reason: collision with root package name */
    private String f40575f;

    /* compiled from: ChatNotificationManager.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ChatNotificationManager(ChatAnalytics chatAnalytics, ChatNotificationDrawer drawer, PermissionManager permissionManager) {
        Intrinsics.f(chatAnalytics, "chatAnalytics");
        Intrinsics.f(drawer, "drawer");
        Intrinsics.f(permissionManager, "permissionManager");
        this.f40570a = chatAnalytics;
        this.f40571b = drawer;
        this.f40572c = permissionManager;
        this.f40574e = new LinkedHashMap();
    }

    public final boolean a(String chatId) {
        boolean z7;
        Intrinsics.f(chatId, "chatId");
        if (Intrinsics.a(this.f40575f, chatId)) {
            return true;
        }
        boolean b8 = b();
        if (Build.VERSION.SDK_INT >= 33 && this.f40572c.o("android.permission.POST_NOTIFICATIONS").d() != PermissionManager.PermissionStatus.GRANTED) {
            z7 = false;
        } else {
            z7 = true;
        }
        if (!b8) {
            this.f40575f = chatId;
        }
        if (b8 && z7) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        return this.f40571b.a();
    }

    public final void c(String chatId) {
        Intrinsics.f(chatId, "chatId");
        if (Intrinsics.a(this.f40573d, chatId)) {
            this.f40573d = null;
        }
    }

    public final void d(String chatId) {
        Intrinsics.f(chatId, "chatId");
        this.f40573d = chatId;
    }

    public final void e(ChatEntity chat, ChatMessageEntity message) {
        String k8;
        Intrinsics.f(chat, "chat");
        Intrinsics.f(message, "message");
        this.f40570a.f4();
        if (message.n() || message.o()) {
            return;
        }
        this.f40570a.m0();
        if (Intrinsics.a(chat.b(), this.f40573d) || (k8 = message.k()) == null) {
            return;
        }
        Map<String, List<NotificationMessage>> map = this.f40574e;
        String b8 = chat.b();
        List<NotificationMessage> list = map.get(b8);
        if (list == null) {
            list = new ArrayList<>();
            map.put(b8, list);
        }
        List<NotificationMessage> list2 = list;
        list2.add(new NotificationMessage(k8, message.c()));
        this.f40571b.c(chat.b(), chat.f(), chat.a(), list2);
        this.f40570a.g1();
    }

    public final void f(String chatId) {
        Intrinsics.f(chatId, "chatId");
        this.f40574e.remove(chatId);
    }
}
