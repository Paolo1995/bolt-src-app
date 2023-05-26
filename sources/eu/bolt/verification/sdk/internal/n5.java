package eu.bolt.verification.sdk.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* loaded from: classes5.dex */
public final class n5 extends Exception {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class a extends Lambda implements Function1<Map<String, Object>, Unit> {

        /* renamed from: f  reason: collision with root package name */
        public static final a f44292f = new a();

        a() {
            super(1);
        }

        public final void b(Map<String, Object> map) {
            Intrinsics.f(map, "$this$null");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
            b(map);
            return Unit.f50853a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n5(String title, boolean z7, Throwable th, Function1<? super Map<String, Object>, Unit> extraPayload) {
        super("", th);
        int v7;
        Intrinsics.f(title, "title");
        Intrinsics.f(extraPayload, "extraPayload");
        String str = "[diagnosis]:" + title;
        StackTraceElement stackTraceElement = new StackTraceElement(str, "ex", str + ".kt", 0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        extraPayload.invoke(linkedHashMap);
        Set<Map.Entry> entrySet = linkedHashMap.entrySet();
        Intrinsics.e(entrySet, "LinkedHashMap<String, An…ply(extraPayload).entries");
        v7 = CollectionsKt__IterablesKt.v(entrySet, 10);
        ArrayList arrayList = new ArrayList(v7);
        for (Map.Entry entry : entrySet) {
            Object key = entry.getKey();
            Intrinsics.e(key, "it.key");
            Object value = entry.getValue();
            Intrinsics.e(value, "it.value");
            arrayList.add(a((String) key, value));
        }
        StackTraceElement[] originalStackTrace = z7 ? getStackTrace() : new StackTraceElement[0];
        Sequence x7 = SequencesKt.x(SequencesKt.j(stackTraceElement), arrayList);
        Intrinsics.e(originalStackTrace, "originalStackTrace");
        setStackTrace((StackTraceElement[]) SequencesKt.D(SequencesKt.z(x7, originalStackTrace)).toArray(new StackTraceElement[0]));
    }

    public /* synthetic */ n5(String str, boolean z7, Throwable th, Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? true : z7, (i8 & 4) != 0 ? null : th, (i8 & 8) != 0 ? a.f44292f : function1);
    }

    private final StackTraceElement a(String str, Object obj) {
        return new StackTraceElement("e", str + " = " + obj, n5.class.getSimpleName(), 0);
    }
}
