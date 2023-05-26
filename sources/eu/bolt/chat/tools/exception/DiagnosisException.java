package eu.bolt.chat.tools.exception;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: DiagnosisException.kt */
/* loaded from: classes5.dex */
public final class DiagnosisException extends Exception {
    public /* synthetic */ DiagnosisException(String str, boolean z7, Function1 function1, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i8 & 2) != 0 ? true : z7, (i8 & 4) != 0 ? new Function1<Map<String, Object>, Unit>() { // from class: eu.bolt.chat.tools.exception.DiagnosisException.1
            public final void b(Map<String, Object> map) {
                Intrinsics.f(map, "$this$null");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Map<String, Object> map) {
                b(map);
                return Unit.f50853a;
            }
        } : function1);
    }

    private final StackTraceElement a(String str, Object obj) {
        return new StackTraceElement("e", str + " = " + obj, DiagnosisException.class.getSimpleName(), 0);
    }

    public DiagnosisException(String title, boolean z7, Function1<? super Map<String, Object>, Unit> extraPayload) {
        int v7;
        Sequence j8;
        Sequence x7;
        Sequence z8;
        List D;
        Intrinsics.f(title, "title");
        Intrinsics.f(extraPayload, "extraPayload");
        StackTraceElement stackTraceElement = new StackTraceElement(title, "ex", "[diagnosis]:" + title, 0);
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
        j8 = SequencesKt__SequencesKt.j(stackTraceElement);
        x7 = SequencesKt___SequencesKt.x(j8, arrayList);
        Intrinsics.e(originalStackTrace, "originalStackTrace");
        z8 = SequencesKt___SequencesKt.z(x7, originalStackTrace);
        D = SequencesKt___SequencesKt.D(z8);
        setStackTrace((StackTraceElement[]) D.toArray(new StackTraceElement[0]));
    }
}
