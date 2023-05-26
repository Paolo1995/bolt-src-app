package androidx.room;

import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* compiled from: CoroutinesRoom.kt */
/* loaded from: classes.dex */
public final class CoroutinesRoomKt {
    public static final CoroutineDispatcher a(RoomDatabase roomDatabase) {
        Intrinsics.f(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.k();
        Intrinsics.e(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            Executor queryExecutor = roomDatabase.o();
            Intrinsics.e(queryExecutor, "queryExecutor");
            obj = ExecutorsKt.a(queryExecutor);
            backingFieldMap.put("QueryDispatcher", obj);
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }

    public static final CoroutineDispatcher b(RoomDatabase roomDatabase) {
        Intrinsics.f(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.k();
        Intrinsics.e(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            Executor transactionExecutor = roomDatabase.r();
            Intrinsics.e(transactionExecutor, "transactionExecutor");
            obj = ExecutorsKt.a(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        Intrinsics.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) obj;
    }
}
