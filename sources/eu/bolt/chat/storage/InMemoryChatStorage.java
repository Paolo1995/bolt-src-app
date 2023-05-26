package eu.bolt.chat.storage;

import co.touchlab.kermit.Logger;
import eu.bolt.chat.data.Chat;
import eu.bolt.chat.data.message.ChatMessage;
import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: InMemoryChatStorage.kt */
/* loaded from: classes5.dex */
public final class InMemoryChatStorage implements ChatStorage {

    /* renamed from: a  reason: collision with root package name */
    private final Logger f39600a;

    /* renamed from: b  reason: collision with root package name */
    private final Mutex f39601b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Chat> f39602c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, LinkedHashSet<String>> f39603d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, ChatMessage> f39604e;

    public InMemoryChatStorage(Logger logger) {
        Intrinsics.f(logger, "logger");
        this.f39600a = logger;
        this.f39601b = MutexKt.a(false);
        this.f39602c = new HashMap<>();
        this.f39603d = new HashMap<>();
        this.f39604e = new HashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c A[Catch: all -> 0x0082, TryCatch #0 {all -> 0x0082, blocks: (B:18:0x0055, B:20:0x006c, B:21:0x007a), top: B:27:0x0055 }] */
    @Override // eu.bolt.chat.storage.ChatStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(eu.bolt.chat.data.Chat r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.storage.InMemoryChatStorage$updateChatDetails$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.storage.InMemoryChatStorage$updateChatDetails$1 r0 = (eu.bolt.chat.storage.InMemoryChatStorage$updateChatDetails$1) r0
            int r1 = r0.f39633k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39633k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.InMemoryChatStorage$updateChatDetails$1 r0 = new eu.bolt.chat.storage.InMemoryChatStorage$updateChatDetails$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39631i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39633k
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.f39630h
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f39629g
            eu.bolt.chat.data.Chat r1 = (eu.bolt.chat.data.Chat) r1
            java.lang.Object r0 = r0.f39628f
            eu.bolt.chat.storage.InMemoryChatStorage r0 = (eu.bolt.chat.storage.InMemoryChatStorage) r0
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
            kotlinx.coroutines.sync.Mutex r7 = r5.f39601b
            r0.f39628f = r5
            r0.f39629g = r6
            r0.f39630h = r7
            r0.f39633k = r4
            java.lang.Object r0 = r7.a(r3, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.HashMap<java.lang.String, eu.bolt.chat.data.Chat> r1 = r0.f39602c     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = r6.d()     // Catch: java.lang.Throwable -> L82
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L82
            eu.bolt.chat.data.Chat r1 = (eu.bolt.chat.data.Chat) r1     // Catch: java.lang.Throwable -> L82
            java.util.HashMap<java.lang.String, eu.bolt.chat.data.Chat> r2 = r0.f39602c     // Catch: java.lang.Throwable -> L82
            java.lang.String r4 = r6.d()     // Catch: java.lang.Throwable -> L82
            r2.put(r4, r6)     // Catch: java.lang.Throwable -> L82
            if (r1 != 0) goto L7a
            java.util.HashMap<java.lang.String, java.util.LinkedHashSet<java.lang.String>> r0 = r0.f39603d     // Catch: java.lang.Throwable -> L82
            java.lang.String r6 = r6.d()     // Catch: java.lang.Throwable -> L82
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet     // Catch: java.lang.Throwable -> L82
            r1.<init>()     // Catch: java.lang.Throwable -> L82
            r0.put(r6, r1)     // Catch: java.lang.Throwable -> L82
        L7a:
            kotlin.Unit r6 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L82
            r7.b(r3)
            kotlin.Unit r6 = kotlin.Unit.f50853a
            return r6
        L82:
            r6 = move-exception
            r7.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.InMemoryChatStorage.a(eu.bolt.chat.data.Chat, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8 A[Catch: all -> 0x0189, TRY_ENTER, TryCatch #0 {all -> 0x0189, blocks: (B:18:0x0055, B:22:0x0071, B:24:0x007b, B:26:0x0085, B:28:0x0097, B:29:0x00c0, B:33:0x00c8, B:34:0x00cb, B:36:0x00e5, B:38:0x00f7, B:39:0x0114, B:40:0x0117, B:42:0x0129, B:43:0x0146, B:46:0x014c, B:48:0x015e, B:49:0x0183), top: B:55:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e5 A[Catch: all -> 0x0189, TryCatch #0 {all -> 0x0189, blocks: (B:18:0x0055, B:22:0x0071, B:24:0x007b, B:26:0x0085, B:28:0x0097, B:29:0x00c0, B:33:0x00c8, B:34:0x00cb, B:36:0x00e5, B:38:0x00f7, B:39:0x0114, B:40:0x0117, B:42:0x0129, B:43:0x0146, B:46:0x014c, B:48:0x015e, B:49:0x0183), top: B:55:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0117 A[Catch: all -> 0x0189, TryCatch #0 {all -> 0x0189, blocks: (B:18:0x0055, B:22:0x0071, B:24:0x007b, B:26:0x0085, B:28:0x0097, B:29:0x00c0, B:33:0x00c8, B:34:0x00cb, B:36:0x00e5, B:38:0x00f7, B:39:0x0114, B:40:0x0117, B:42:0x0129, B:43:0x0146, B:46:0x014c, B:48:0x015e, B:49:0x0183), top: B:55:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x015e A[Catch: all -> 0x0189, TryCatch #0 {all -> 0x0189, blocks: (B:18:0x0055, B:22:0x0071, B:24:0x007b, B:26:0x0085, B:28:0x0097, B:29:0x00c0, B:33:0x00c8, B:34:0x00cb, B:36:0x00e5, B:38:0x00f7, B:39:0x0114, B:40:0x0117, B:42:0x0129, B:43:0x0146, B:46:0x014c, B:48:0x015e, B:49:0x0183), top: B:55:0x0055 }] */
    @Override // eu.bolt.chat.storage.ChatStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(eu.bolt.chat.data.message.ChatMessage r8, kotlin.coroutines.Continuation<? super eu.bolt.chat.storage.data.MessageUpdateResult> r9) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.InMemoryChatStorage.b(eu.bolt.chat.data.message.ChatMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    @Override // eu.bolt.chat.storage.ChatStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(java.lang.String r6, kotlin.coroutines.Continuation<? super eu.bolt.chat.data.message.ChatMessage> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.storage.InMemoryChatStorage$getMessage$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.storage.InMemoryChatStorage$getMessage$1 r0 = (eu.bolt.chat.storage.InMemoryChatStorage$getMessage$1) r0
            int r1 = r0.f39617k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39617k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.InMemoryChatStorage$getMessage$1 r0 = new eu.bolt.chat.storage.InMemoryChatStorage$getMessage$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39615i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39617k
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.f39614h
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f39613g
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f39612f
            eu.bolt.chat.storage.InMemoryChatStorage r0 = (eu.bolt.chat.storage.InMemoryChatStorage) r0
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
            kotlinx.coroutines.sync.Mutex r7 = r5.f39601b
            r0.f39612f = r5
            r0.f39613g = r6
            r0.f39614h = r7
            r0.f39617k = r4
            java.lang.Object r0 = r7.a(r3, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.HashMap<java.lang.String, eu.bolt.chat.data.message.ChatMessage> r0 = r0.f39604e     // Catch: java.lang.Throwable -> L61
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Throwable -> L61
            eu.bolt.chat.data.message.ChatMessage r6 = (eu.bolt.chat.data.message.ChatMessage) r6     // Catch: java.lang.Throwable -> L61
            r7.b(r3)
            return r6
        L61:
            r6 = move-exception
            r7.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.InMemoryChatStorage.c(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[Catch: all -> 0x00e4, TryCatch #0 {all -> 0x00e4, blocks: (B:18:0x005b, B:20:0x0065, B:22:0x0077, B:23:0x008f, B:26:0x0097, B:27:0x00a0, B:29:0x00a6, B:31:0x00b6, B:32:0x00ba, B:33:0x00c3, B:35:0x00c9, B:37:0x00dc), top: B:44:0x005b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097 A[Catch: all -> 0x00e4, TRY_ENTER, TryCatch #0 {all -> 0x00e4, blocks: (B:18:0x005b, B:20:0x0065, B:22:0x0077, B:23:0x008f, B:26:0x0097, B:27:0x00a0, B:29:0x00a6, B:31:0x00b6, B:32:0x00ba, B:33:0x00c3, B:35:0x00c9, B:37:0x00dc), top: B:44:0x005b }] */
    @Override // eu.bolt.chat.storage.ChatStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object d(java.lang.String r6, kotlin.jvm.functions.Function1<? super eu.bolt.chat.data.message.ChatMessage, java.lang.Boolean> r7, kotlin.coroutines.Continuation<? super java.util.List<? extends eu.bolt.chat.data.message.ChatMessage>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof eu.bolt.chat.storage.InMemoryChatStorage$getMessages$1
            if (r0 == 0) goto L13
            r0 = r8
            eu.bolt.chat.storage.InMemoryChatStorage$getMessages$1 r0 = (eu.bolt.chat.storage.InMemoryChatStorage$getMessages$1) r0
            int r1 = r0.f39624l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39624l = r1
            goto L18
        L13:
            eu.bolt.chat.storage.InMemoryChatStorage$getMessages$1 r0 = new eu.bolt.chat.storage.InMemoryChatStorage$getMessages$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f39622j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39624l
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r6 = r0.f39621i
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r7 = r0.f39620h
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r1 = r0.f39619g
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f39618f
            eu.bolt.chat.storage.InMemoryChatStorage r0 = (eu.bolt.chat.storage.InMemoryChatStorage) r0
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
            kotlinx.coroutines.sync.Mutex r8 = r5.f39601b
            r0.f39618f = r5
            r0.f39619g = r6
            r0.f39620h = r7
            r0.f39621i = r8
            r0.f39624l = r3
            java.lang.Object r0 = r8.a(r4, r0)
            if (r0 != r1) goto L5a
            return r1
        L5a:
            r0 = r5
        L5b:
            java.util.HashMap<java.lang.String, java.util.LinkedHashSet<java.lang.String>> r1 = r0.f39603d     // Catch: java.lang.Throwable -> Le4
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> Le4
            java.util.LinkedHashSet r1 = (java.util.LinkedHashSet) r1     // Catch: java.lang.Throwable -> Le4
            if (r1 != 0) goto L97
            co.touchlab.kermit.Logger r7 = r0.f39600a     // Catch: java.lang.Throwable -> Le4
            co.touchlab.kermit.LoggerConfig r0 = r7.c()     // Catch: java.lang.Throwable -> Le4
            co.touchlab.kermit.Severity r0 = r0.a()     // Catch: java.lang.Throwable -> Le4
            co.touchlab.kermit.Severity r1 = co.touchlab.kermit.Severity.Warn     // Catch: java.lang.Throwable -> Le4
            int r0 = r0.compareTo(r1)     // Catch: java.lang.Throwable -> Le4
            if (r0 > 0) goto L8f
            java.lang.String r0 = r7.d()     // Catch: java.lang.Throwable -> Le4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le4
            r2.<init>()     // Catch: java.lang.Throwable -> Le4
            java.lang.String r3 = "Trying to get messages for not existing chat with id: "
            r2.append(r3)     // Catch: java.lang.Throwable -> Le4
            r2.append(r6)     // Catch: java.lang.Throwable -> Le4
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> Le4
            r7.f(r1, r0, r4, r6)     // Catch: java.lang.Throwable -> Le4
        L8f:
            java.util.List r6 = kotlin.collections.CollectionsKt.k()     // Catch: java.lang.Throwable -> Le4
            r8.b(r4)
            return r6
        L97:
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Le4
            r6.<init>()     // Catch: java.lang.Throwable -> Le4
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> Le4
        La0:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> Le4
            if (r2 == 0) goto Lba
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> Le4
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Le4
            java.util.HashMap<java.lang.String, eu.bolt.chat.data.message.ChatMessage> r3 = r0.f39604e     // Catch: java.lang.Throwable -> Le4
            java.lang.Object r2 = r3.get(r2)     // Catch: java.lang.Throwable -> Le4
            eu.bolt.chat.data.message.ChatMessage r2 = (eu.bolt.chat.data.message.ChatMessage) r2     // Catch: java.lang.Throwable -> Le4
            if (r2 == 0) goto La0
            r6.add(r2)     // Catch: java.lang.Throwable -> Le4
            goto La0
        Lba:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Le4
            r0.<init>()     // Catch: java.lang.Throwable -> Le4
            java.util.Iterator r6 = r6.iterator()     // Catch: java.lang.Throwable -> Le4
        Lc3:
            boolean r1 = r6.hasNext()     // Catch: java.lang.Throwable -> Le4
            if (r1 == 0) goto Le0
            java.lang.Object r1 = r6.next()     // Catch: java.lang.Throwable -> Le4
            r2 = r1
            eu.bolt.chat.data.message.ChatMessage r2 = (eu.bolt.chat.data.message.ChatMessage) r2     // Catch: java.lang.Throwable -> Le4
            java.lang.Object r2 = r7.invoke(r2)     // Catch: java.lang.Throwable -> Le4
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> Le4
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> Le4
            if (r2 == 0) goto Lc3
            r0.add(r1)     // Catch: java.lang.Throwable -> Le4
            goto Lc3
        Le0:
            r8.b(r4)
            return r0
        Le4:
            r6 = move-exception
            r8.b(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.InMemoryChatStorage.d(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    @Override // eu.bolt.chat.storage.ChatStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(java.lang.String r6, kotlin.coroutines.Continuation<? super eu.bolt.chat.data.Chat> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.storage.InMemoryChatStorage$getChat$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.storage.InMemoryChatStorage$getChat$1 r0 = (eu.bolt.chat.storage.InMemoryChatStorage$getChat$1) r0
            int r1 = r0.f39611k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39611k = r1
            goto L18
        L13:
            eu.bolt.chat.storage.InMemoryChatStorage$getChat$1 r0 = new eu.bolt.chat.storage.InMemoryChatStorage$getChat$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f39609i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39611k
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 != r4) goto L38
            java.lang.Object r6 = r0.f39608h
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            java.lang.Object r1 = r0.f39607g
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f39606f
            eu.bolt.chat.storage.InMemoryChatStorage r0 = (eu.bolt.chat.storage.InMemoryChatStorage) r0
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
            kotlinx.coroutines.sync.Mutex r7 = r5.f39601b
            r0.f39606f = r5
            r0.f39607g = r6
            r0.f39608h = r7
            r0.f39611k = r4
            java.lang.Object r0 = r7.a(r3, r0)
            if (r0 != r1) goto L54
            return r1
        L54:
            r0 = r5
        L55:
            java.util.HashMap<java.lang.String, eu.bolt.chat.data.Chat> r0 = r0.f39602c     // Catch: java.lang.Throwable -> L61
            java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Throwable -> L61
            eu.bolt.chat.data.Chat r6 = (eu.bolt.chat.data.Chat) r6     // Catch: java.lang.Throwable -> L61
            r7.b(r3)
            return r6
        L61:
            r6 = move-exception
            r7.b(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.InMemoryChatStorage.e(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // eu.bolt.chat.storage.ChatStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object f(java.lang.String r5, kotlin.jvm.functions.Function1<? super eu.bolt.chat.data.message.ChatMessage, java.lang.Boolean> r6, kotlin.coroutines.Continuation<? super java.lang.Integer> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof eu.bolt.chat.storage.InMemoryChatStorage$getMessagesCount$1
            if (r0 == 0) goto L13
            r0 = r7
            eu.bolt.chat.storage.InMemoryChatStorage$getMessagesCount$1 r0 = (eu.bolt.chat.storage.InMemoryChatStorage$getMessagesCount$1) r0
            int r1 = r0.f39627h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39627h = r1
            goto L18
        L13:
            eu.bolt.chat.storage.InMemoryChatStorage$getMessagesCount$1 r0 = new eu.bolt.chat.storage.InMemoryChatStorage$getMessagesCount$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f39625f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.d()
            int r2 = r0.f39627h
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r7)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r7)
            r0.f39627h = r3
            java.lang.Object r7 = r4.d(r5, r6, r0)
            if (r7 != r1) goto L3d
            return r1
        L3d:
            java.util.List r7 = (java.util.List) r7
            int r5 = r7.size()
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.b(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.chat.storage.InMemoryChatStorage.f(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
