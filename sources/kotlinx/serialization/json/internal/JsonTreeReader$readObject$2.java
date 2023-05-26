package kotlinx.serialization.json.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonTreeReader.kt */
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {23}, m = "readObject")
/* loaded from: classes5.dex */
public final class JsonTreeReader$readObject$2 extends ContinuationImpl {

    /* renamed from: f  reason: collision with root package name */
    Object f52414f;

    /* renamed from: g  reason: collision with root package name */
    Object f52415g;

    /* renamed from: h  reason: collision with root package name */
    Object f52416h;

    /* renamed from: i  reason: collision with root package name */
    Object f52417i;

    /* renamed from: j  reason: collision with root package name */
    /* synthetic */ Object f52418j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ JsonTreeReader f52419k;

    /* renamed from: l  reason: collision with root package name */
    int f52420l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readObject$2> continuation) {
        super(continuation);
        this.f52419k = jsonTreeReader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object h8;
        this.f52418j = obj;
        this.f52420l |= Integer.MIN_VALUE;
        h8 = this.f52419k.h(null, this);
        return h8;
    }
}
