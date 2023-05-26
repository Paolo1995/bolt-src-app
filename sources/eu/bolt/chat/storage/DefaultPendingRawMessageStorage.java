package eu.bolt.chat.storage;

import co.touchlab.kermit.Logger;
import co.touchlab.kermit.Severity;
import com.russhwolf.settings.Settings;
import eu.bolt.chat.network.data.parser.ChatJsonParserKt;
import eu.bolt.chat.storage.data.PendingRawMessageModel;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: PendingRawMessageStorage.kt */
/* loaded from: classes5.dex */
public final class DefaultPendingRawMessageStorage implements PendingRawMessageStorage {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f39560f = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final Settings f39561a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f39562b;

    /* renamed from: c  reason: collision with root package name */
    private final Json f39563c;

    /* renamed from: d  reason: collision with root package name */
    private final Mutex f39564d;

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f39565e;

    /* compiled from: PendingRawMessageStorage.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DefaultPendingRawMessageStorage(Settings settingsStore, Logger logger) {
        Lazy b8;
        Intrinsics.f(settingsStore, "settingsStore");
        Intrinsics.f(logger, "logger");
        this.f39561a = settingsStore;
        this.f39562b = logger;
        this.f39563c = ChatJsonParserKt.a();
        this.f39564d = MutexKt.a(false);
        b8 = LazyKt__LazyJVMKt.b(new Function0<Map<String, LinkedHashSet<PendingRawMessage>>>() { // from class: eu.bolt.chat.storage.DefaultPendingRawMessageStorage$memoryStorage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Map<String, LinkedHashSet<PendingRawMessage>> invoke() {
                Map<String, LinkedHashSet<PendingRawMessage>> h8;
                h8 = DefaultPendingRawMessageStorage.this.h();
                return h8;
            }
        });
        this.f39565e = b8;
    }

    private final Map<String, LinkedHashSet<PendingRawMessage>> g() {
        return (Map) this.f39565e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, LinkedHashSet<PendingRawMessage>> h() {
        String str;
        Logger logger = this.f39562b;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            logger.f(severity, logger.d(), null, "About to load messages from persisted storage...");
        }
        Settings settings = this.f39561a;
        KClass b8 = Reflection.b(String.class);
        if (Intrinsics.a(b8, Reflection.b(Integer.TYPE))) {
            str = (String) settings.e("PENDING_MESSAGES_STORE");
        } else if (Intrinsics.a(b8, Reflection.b(Long.TYPE))) {
            str = (String) settings.d("PENDING_MESSAGES_STORE");
        } else if (Intrinsics.a(b8, Reflection.b(String.class))) {
            str = settings.c("PENDING_MESSAGES_STORE");
        } else if (Intrinsics.a(b8, Reflection.b(Float.TYPE))) {
            str = (String) settings.b("PENDING_MESSAGES_STORE");
        } else if (Intrinsics.a(b8, Reflection.b(Double.TYPE))) {
            str = (String) settings.f("PENDING_MESSAGES_STORE");
        } else if (Intrinsics.a(b8, Reflection.b(Boolean.TYPE))) {
            str = (String) settings.a("PENDING_MESSAGES_STORE");
        } else {
            throw new IllegalArgumentException("Invalid type!");
        }
        if (str == null) {
            return new HashMap();
        }
        Json json = this.f39563c;
        SerializersModule a9 = json.a();
        KTypeProjection.Companion companion = KTypeProjection.f51072c;
        KSerializer<Object> c8 = SerializersKt.c(a9, Reflection.k(Map.class, companion.a(Reflection.i(String.class)), companion.a(Reflection.j(List.class, companion.a(Reflection.i(PendingRawMessageModel.class))))));
        Intrinsics.d(c8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        Map<String, LinkedHashSet<PendingRawMessage>> a10 = PendingMessagesMapMapper.f39640a.a((Map) json.b(c8, str));
        Logger logger2 = this.f39562b;
        if (logger2.c().a().compareTo(severity) <= 0) {
            String d8 = logger2.d();
            logger2.f(severity, d8, null, "Loaded from persisted storage " + a10.size() + " messages");
        }
        return a10;
    }

    private final void i() {
        Logger logger = this.f39562b;
        Severity a8 = logger.c().a();
        Severity severity = Severity.Debug;
        if (a8.compareTo(severity) <= 0) {
            String d8 = logger.d();
            logger.f(severity, d8, null, "About to write messages " + g().size() + " to storage...");
        }
        Map<String, List<PendingRawMessageModel>> b8 = PendingMessagesMapMapper.f39640a.b(g());
        Json json = this.f39563c;
        SerializersModule a9 = json.a();
        KTypeProjection.Companion companion = KTypeProjection.f51072c;
        KSerializer<Object> c8 = SerializersKt.c(a9, Reflection.k(Map.class, companion.a(Reflection.i(String.class)), companion.a(Reflection.j(List.class, companion.a(Reflection.i(PendingRawMessageModel.class))))));
        Intrinsics.d(c8, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        this.f39561a.putString("PENDING_MESSAGES_STORE", json.d(c8, b8));
        Logger logger2 = this.f39562b;
        if (logger2.c().a().compareTo(severity) <= 0) {
            logger2.f(severity, logger2.d(), null, "Saved messages to persisted storage.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    @Override // eu.bolt.chat.storage.PendingRawMessageStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeAllMessagesFor$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeAllMessagesFor$1 r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeAllMessagesFor$1) r0
            int r1 = r0.f39584k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39584k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeAllMessagesFor$1 r0 = new eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeAllMessagesFor$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39582i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39584k
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.f39581h
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f39580g
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f39579f
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage) r0
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.f39564d
            r0.f39579f = r5
            r0.f39580g = r6
            r0.f39581h = r7
            r0.f39584k = r4
            java.lang.Object r0 = r7.a(r3, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.Map r1 = r0.g()     // Catch: java.lang.Throwable -> L67
            r1.remove(r6)     // Catch: java.lang.Throwable -> L67
            r0.i()     // Catch: java.lang.Throwable -> L67
            kotlin.Unit r6 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L67
            r7.b(r3)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L67:
            r6 = move-exception
            r7.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.DefaultPendingRawMessageStorage.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[Catch: all -> 0x007e, TryCatch #0 {all -> 0x007e, blocks: (B:18:0x005b, B:20:0x0067, B:21:0x0073), top: B:27:0x005b }] */
    @Override // eu.bolt.chat.storage.PendingRawMessageStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(final java.util.Set<java.lang.String> r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeMessages$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeMessages$1 r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeMessages$1) r0
            int r1 = r0.f39591l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39591l = r1
            goto L18
        L13:
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeMessages$1 r0 = new eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeMessages$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f39589j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39591l
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r6 = r0.f39588i
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.f39587h
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r1 = r0.f39586g
            java.util.Set r1 = (java.util.Set) r1
            java.lang.Object r0 = r0.f39585f
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage) r0
            kotlin.ResultKt.b(r8)
            r8 = r6
            r6 = r1
            goto L5b
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.Mutex r8 = r5.f39564d
            r0.f39585f = r5
            r0.f39586g = r6
            r0.f39587h = r7
            r0.f39588i = r8
            r0.f39591l = r4
            java.lang.Object r0 = r8.a(r3, r0)
            if (r0 != r1) goto L5a
            return r1
        L5a:
            r0 = r5
        L5b:
            java.util.Map r1 = r0.g()     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r7 = r1.get(r7)     // Catch: java.lang.Throwable -> L7e
            java.util.LinkedHashSet r7 = (java.util.LinkedHashSet) r7     // Catch: java.lang.Throwable -> L7e
            if (r7 == 0) goto L73
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeMessages$2$1 r1 = new eu.bolt.chat.storage.DefaultPendingRawMessageStorage$removeMessages$2$1     // Catch: java.lang.Throwable -> L7e
            r1.<init>()     // Catch: java.lang.Throwable -> L7e
            boolean r6 = kotlin.collections.CollectionsKt.G(r7, r1)     // Catch: java.lang.Throwable -> L7e
            kotlin.coroutines.jvm.internal.Boxing.a(r6)     // Catch: java.lang.Throwable -> L7e
        L73:
            r0.i()     // Catch: java.lang.Throwable -> L7e
            kotlin.Unit r6 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L7e
            r8.b(r3)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L7e:
            r6 = move-exception
            r8.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.DefaultPendingRawMessageStorage.b(java.util.Set, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #0 {all -> 0x006b, blocks: (B:18:0x0055, B:20:0x0061), top: B:28:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    @Override // eu.bolt.chat.storage.PendingRawMessageStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(java.lang.String r6, kotlin.coroutines.Continuation<? super java.util.List<eu.bolt.chat.storage.PendingRawMessage>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.storage.DefaultPendingRawMessageStorage$getMessages$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$getMessages$1 r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage$getMessages$1) r0
            int r1 = r0.f39577k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39577k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$getMessages$1 r0 = new eu.bolt.chat.storage.DefaultPendingRawMessageStorage$getMessages$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39575i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39577k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r6 = r0.f39574h
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f39573g
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f39572f
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage) r0
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.f39564d
            r0.f39572f = r5
            r0.f39573g = r6
            r0.f39574h = r7
            r0.f39577k = r3
            java.lang.Object r0 = r7.a(r4, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.Map r0 = r0.g()     // Catch: java.lang.Throwable -> L6b
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Throwable -> L6b
            java.util.LinkedHashSet r6 = (java.util.LinkedHashSet) r6     // Catch: java.lang.Throwable -> L6b
            if (r6 == 0) goto L66
            java.util.List r6 = kotlin.collections.CollectionsKt.H0(r6)     // Catch: java.lang.Throwable -> L6b
            goto L67
        L66:
            r6 = r4
        L67:
            r7.b(r4)
            return r6
        L6b:
            r6 = move-exception
            r7.b(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.DefaultPendingRawMessageStorage.c(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b A[Catch: all -> 0x0084, LOOP:0: B:19:0x0065->B:21:0x006b, LOOP_END, TryCatch #0 {all -> 0x0084, blocks: (B:18:0x0055, B:19:0x0065, B:21:0x006b, B:22:0x0079), top: B:28:0x0055 }] */
    @Override // eu.bolt.chat.storage.PendingRawMessageStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(java.util.Set<java.lang.String> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.storage.DefaultPendingRawMessageStorage$cleanupGarbage$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$cleanupGarbage$1 r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage$cleanupGarbage$1) r0
            int r1 = r0.f39571k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39571k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$cleanupGarbage$1 r0 = new eu.bolt.chat.storage.DefaultPendingRawMessageStorage$cleanupGarbage$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39569i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39571k
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.f39568h
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f39567g
            java.util.Set r1 = (java.util.Set) r1
            java.lang.Object r0 = r0.f39566f
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage) r0
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r1
            goto L55
        L38:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L40:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.f39564d
            r0.f39566f = r5
            r0.f39567g = r6
            r0.f39568h = r7
            r0.f39571k = r4
            java.lang.Object r0 = r7.a(r3, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.Map r1 = r0.g()     // Catch: java.lang.Throwable -> L84
            java.util.Set r1 = r1.keySet()     // Catch: java.lang.Throwable -> L84
            java.util.Set r6 = kotlin.collections.CollectionsKt.w0(r1, r6)     // Catch: java.lang.Throwable -> L84
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> L84
        L65:
            boolean r1 = r6.hasNext()     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L79
            java.lang.Object r1 = r6.next()     // Catch: java.lang.Throwable -> L84
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L84
            java.util.Map r2 = r0.g()     // Catch: java.lang.Throwable -> L84
            r2.remove(r1)     // Catch: java.lang.Throwable -> L84
            goto L65
        L79:
            r0.i()     // Catch: java.lang.Throwable -> L84
            kotlin.Unit r6 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L84
            r7.b(r3)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L84:
            r6 = move-exception
            r7.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.DefaultPendingRawMessageStorage.d(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[Catch: all -> 0x00ac, TryCatch #0 {all -> 0x00ac, blocks: (B:18:0x005b, B:20:0x0065, B:21:0x006d, B:23:0x0087, B:24:0x00a4), top: B:30:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087 A[Catch: all -> 0x00ac, TryCatch #0 {all -> 0x00ac, blocks: (B:18:0x005b, B:20:0x0065, B:21:0x006d, B:23:0x0087, B:24:0x00a4), top: B:30:0x005b }] */
    @Override // eu.bolt.chat.storage.PendingRawMessageStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(eu.bolt.chat.storage.PendingRawMessage r6, java.lang.String r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof eu.bolt.chat.storage.DefaultPendingRawMessageStorage$updateMessage$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$updateMessage$1 r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage$updateMessage$1) r0
            int r1 = r0.f39599l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39599l = r1
            goto L18
        L13:
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage$updateMessage$1 r0 = new eu.bolt.chat.storage.DefaultPendingRawMessageStorage$updateMessage$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f39597j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39599l
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.f39596i
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.f39595h
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r1 = r0.f39594g
            eu.bolt.chat.storage.PendingRawMessage r1 = (eu.bolt.chat.storage.PendingRawMessage) r1
            java.lang.Object r0 = r0.f39593f
            eu.bolt.chat.storage.DefaultPendingRawMessageStorage r0 = (eu.bolt.chat.storage.DefaultPendingRawMessageStorage) r0
            kotlin.ResultKt.b(r8)
            r8 = r6
            r6 = r1
            goto L5b
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.Mutex r8 = r5.f39564d
            r0.f39593f = r5
            r0.f39594g = r6
            r0.f39595h = r7
            r0.f39596i = r8
            r0.f39599l = r3
            java.lang.Object r0 = r8.a(r4, r0)
            if (r0 != r1) goto L5a
            return r1
        L5a:
            r0 = r5
        L5b:
            java.util.Map r1 = r0.g()     // Catch: java.lang.Throwable -> Lac
            java.lang.Object r2 = r1.get(r7)     // Catch: java.lang.Throwable -> Lac
            if (r2 != 0) goto L6d
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet     // Catch: java.lang.Throwable -> Lac
            r2.<init>()     // Catch: java.lang.Throwable -> Lac
            r1.put(r7, r2)     // Catch: java.lang.Throwable -> Lac
        L6d:
            java.util.LinkedHashSet r2 = (java.util.LinkedHashSet) r2     // Catch: java.lang.Throwable -> Lac
            r2.add(r6)     // Catch: java.lang.Throwable -> Lac
            r0.i()     // Catch: java.lang.Throwable -> Lac
            co.touchlab.kermit.Logger r7 = r0.f39562b     // Catch: java.lang.Throwable -> Lac
            co.touchlab.kermit.LoggerConfig r0 = r7.c()     // Catch: java.lang.Throwable -> Lac
            co.touchlab.kermit.Severity r0 = r0.a()     // Catch: java.lang.Throwable -> Lac
            co.touchlab.kermit.Severity r1 = co.touchlab.kermit.Severity.Debug     // Catch: java.lang.Throwable -> Lac
            int r0 = r0.compareTo(r1)     // Catch: java.lang.Throwable -> Lac
            if (r0 > 0) goto La4
            java.lang.String r0 = r7.d()     // Catch: java.lang.Throwable -> Lac
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lac
            r2.<init>()     // Catch: java.lang.Throwable -> Lac
            java.lang.String r3 = "Added "
            r2.append(r3)     // Catch: java.lang.Throwable -> Lac
            r2.append(r6)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = " to storage"
            r2.append(r6)     // Catch: java.lang.Throwable -> Lac
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> Lac
            r7.f(r1, r0, r4, r6)     // Catch: java.lang.Throwable -> Lac
        La4:
            kotlin.Unit r6 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> Lac
            r8.b(r4)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        Lac:
            r6 = move-exception
            r8.b(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.DefaultPendingRawMessageStorage.e(eu.bolt.chat.storage.PendingRawMessage, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
