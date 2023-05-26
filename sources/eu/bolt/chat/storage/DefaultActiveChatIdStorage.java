package eu.bolt.chat.storage;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import com.russhwolf.settings.Settings;
import eu.bolt.chat.network.data.parser.ChatJsonParserKt;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActiveChatIdStorage.kt */
/* loaded from: classes5.dex */
public final class DefaultActiveChatIdStorage implements ActiveChatIdStorage {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f39541f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Settings f39542a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f39543b;

    /* renamed from: c  reason: collision with root package name */
    private final Json f39544c;

    /* renamed from: d  reason: collision with root package name */
    private final Mutex f39545d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f39546e;

    /* compiled from: ActiveChatIdStorage.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DefaultActiveChatIdStorage(Settings settings, Logger logger) {
        Lazy b8;
        Intrinsics.f(settings, "settings");
        Intrinsics.f(logger, "logger");
        this.f39542a = settings;
        this.f39543b = logger;
        this.f39544c = ChatJsonParserKt.a();
        this.f39545d = MutexKt.a(false);
        b8 = LazyKt__LazyJVMKt.b(new Function0<Set<String>>() { // from class: eu.bolt.chat.storage.DefaultActiveChatIdStorage$cache$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Set<String> invoke() {
                Set<String> e8;
                e8 = DefaultActiveChatIdStorage.this.e();
                return e8;
            }
        });
        this.f39546e = b8;
    }

    private final Set<String> d() {
        return (Set) this.f39546e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Set<String> e() {
        String str;
        Set<String> K0;
        Settings settings = this.f39542a;
        KClass b8 = Reflection.b(String.class);
        if (Intrinsics.a(b8, Reflection.b(Integer.TYPE))) {
            str = (String) settings.e("ACTIVE_CHAT_IDS");
        } else if (Intrinsics.a(b8, Reflection.b(Long.TYPE))) {
            str = (String) settings.d("ACTIVE_CHAT_IDS");
        } else if (Intrinsics.a(b8, Reflection.b(String.class))) {
            str = settings.c("ACTIVE_CHAT_IDS");
        } else if (Intrinsics.a(b8, Reflection.b(Float.TYPE))) {
            str = (String) settings.b("ACTIVE_CHAT_IDS");
        } else if (Intrinsics.a(b8, Reflection.b(Double.TYPE))) {
            str = (String) settings.f("ACTIVE_CHAT_IDS");
        } else if (Intrinsics.a(b8, Reflection.b(Boolean.TYPE))) {
            str = (String) settings.a("ACTIVE_CHAT_IDS");
        } else {
            throw new IllegalArgumentException("Invalid type!");
        }
        if (str == null) {
            return new LinkedHashSet();
        }
        Json json = this.f39544c;
        KSerializer<Object> c8 = SerializersKt.c(json.a(), Reflection.j(List.class, KTypeProjection.f51072c.a(Reflection.i(String.class))));
        Intrinsics.d(c8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        List list = (List) json.b(c8, str);
        Logger logger = this.f39543b;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Info;
        if (a8.compareTo(severity) <= 0) {
            String d8 = logger.d();
            logger.f(severity, d8, null, "Restored active chat ids: " + list);
        }
        K0 = CollectionsKt___CollectionsKt.K0(list);
        return K0;
    }

    private final void f(Set<String> set) {
        List H0;
        Json json = this.f39544c;
        H0 = CollectionsKt___CollectionsKt.H0(set);
        KSerializer<Object> c8 = SerializersKt.c(json.a(), Reflection.j(List.class, KTypeProjection.f51072c.a(Reflection.i(String.class))));
        Intrinsics.d(c8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        this.f39542a.putString("ACTIVE_CHAT_IDS", json.d(c8, H0));
        Logger logger = this.f39543b;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            String d8 = logger.d();
            logger.f(severity, d8, null, "Saved active chat ids: " + set);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    @Override // eu.bolt.chat.storage.ActiveChatIdStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object a(kotlin.jvm.functions.Function2<? super java.util.Set<java.lang.String>, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof eu.bolt.chat.storage.DefaultActiveChatIdStorage$read$1
            if (r0 == 0) goto L13
            r0 = r9
            eu.bolt.chat.storage.DefaultActiveChatIdStorage$read$1 r0 = (eu.bolt.chat.storage.DefaultActiveChatIdStorage$read$1) r0
            int r1 = r0.f39553k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39553k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.DefaultActiveChatIdStorage$read$1 r0 = new eu.bolt.chat.storage.DefaultActiveChatIdStorage$read$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f39551i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39553k
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L4d
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.f39548f
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L31
            goto L78
        L31:
            r9 = move-exception
            goto L80
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.f39550h
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.f39549g
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r4 = r0.f39548f
            eu.bolt.chat.storage.DefaultActiveChatIdStorage r4 = (eu.bolt.chat.storage.DefaultActiveChatIdStorage) r4
            kotlin.ResultKt.b(r9)
            r9 = r8
            r8 = r2
            goto L62
        L4d:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.f39545d
            r0.f39548f = r7
            r0.f39549g = r8
            r0.f39550h = r9
            r0.f39553k = r4
            java.lang.Object r2 = r9.a(r5, r0)
            if (r2 != r1) goto L61
            return r1
        L61:
            r4 = r7
        L62:
            java.util.Set r2 = r4.d()     // Catch: java.lang.Throwable -> L7c
            r0.f39548f = r9     // Catch: java.lang.Throwable -> L7c
            r0.f39549g = r5     // Catch: java.lang.Throwable -> L7c
            r0.f39550h = r5     // Catch: java.lang.Throwable -> L7c
            r0.f39553k = r3     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r8 = r8.s(r2, r0)     // Catch: java.lang.Throwable -> L7c
            if (r8 != r1) goto L75
            return r1
        L75:
            r6 = r9
            r9 = r8
            r8 = r6
        L78:
            r8.b(r5)
            return r9
        L7c:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L80:
            r8.b(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.DefaultActiveChatIdStorage.a(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    @Override // eu.bolt.chat.storage.ActiveChatIdStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> java.lang.Object b(kotlin.jvm.functions.Function2<? super java.util.Set<java.lang.String>, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof eu.bolt.chat.storage.DefaultActiveChatIdStorage$write$1
            if (r0 == 0) goto L13
            r0 = r9
            eu.bolt.chat.storage.DefaultActiveChatIdStorage$write$1 r0 = (eu.bolt.chat.storage.DefaultActiveChatIdStorage$write$1) r0
            int r1 = r0.f39559k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39559k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.DefaultActiveChatIdStorage$write$1 r0 = new eu.bolt.chat.storage.DefaultActiveChatIdStorage$write$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f39557i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39559k
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L51
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r8 = r0.f39555g
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r0 = r0.f39554f
            eu.bolt.chat.storage.DefaultActiveChatIdStorage r0 = (eu.bolt.chat.storage.DefaultActiveChatIdStorage) r0
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L35
            goto L7d
        L35:
            r9 = move-exception
            goto L8c
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3f:
            java.lang.Object r8 = r0.f39556h
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.f39555g
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            java.lang.Object r4 = r0.f39554f
            eu.bolt.chat.storage.DefaultActiveChatIdStorage r4 = (eu.bolt.chat.storage.DefaultActiveChatIdStorage) r4
            kotlin.ResultKt.b(r9)
            r9 = r8
            r8 = r2
            goto L66
        L51:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.f39545d
            r0.f39554f = r7
            r0.f39555g = r8
            r0.f39556h = r9
            r0.f39559k = r4
            java.lang.Object r2 = r9.a(r5, r0)
            if (r2 != r1) goto L65
            return r1
        L65:
            r4 = r7
        L66:
            java.util.Set r2 = r4.d()     // Catch: java.lang.Throwable -> L88
            r0.f39554f = r4     // Catch: java.lang.Throwable -> L88
            r0.f39555g = r9     // Catch: java.lang.Throwable -> L88
            r0.f39556h = r5     // Catch: java.lang.Throwable -> L88
            r0.f39559k = r3     // Catch: java.lang.Throwable -> L88
            java.lang.Object r8 = r8.s(r2, r0)     // Catch: java.lang.Throwable -> L88
            if (r8 != r1) goto L79
            return r1
        L79:
            r0 = r4
            r6 = r9
            r9 = r8
            r8 = r6
        L7d:
            java.util.Set r1 = r0.d()     // Catch: java.lang.Throwable -> L35
            r0.f(r1)     // Catch: java.lang.Throwable -> L35
            r8.b(r5)
            return r9
        L88:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L8c:
            r8.b(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.DefaultActiveChatIdStorage.b(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
