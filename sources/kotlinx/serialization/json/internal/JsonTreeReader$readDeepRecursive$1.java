package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonPrimitive;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonTreeReader.kt */
@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {112}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {

    /* renamed from: g  reason: collision with root package name */
    int f52411g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ Object f52412h;

    /* renamed from: i  reason: collision with root package name */
    final /* synthetic */ JsonTreeReader f52413i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readDeepRecursive$1> continuation) {
        super(3, continuation);
        this.f52413i = jsonTreeReader;
    }

    @Override // kotlin.jvm.functions.Function3
    /* renamed from: h */
    public final Object l(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.f52413i, continuation);
        jsonTreeReader$readDeepRecursive$1.f52412h = deepRecursiveScope;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.f50853a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object d8;
        AbstractJsonLexer abstractJsonLexer;
        AbstractJsonLexer abstractJsonLexer2;
        JsonElement f8;
        JsonPrimitive j8;
        JsonPrimitive j9;
        d8 = IntrinsicsKt__IntrinsicsKt.d();
        int i8 = this.f52411g;
        if (i8 != 0) {
            if (i8 == 1) {
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.b(obj);
            DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.f52412h;
            abstractJsonLexer = this.f52413i.f52408a;
            byte E = abstractJsonLexer.E();
            if (E == 1) {
                j9 = this.f52413i.j(true);
                return j9;
            } else if (E == 0) {
                j8 = this.f52413i.j(false);
                return j8;
            } else if (E == 6) {
                JsonTreeReader jsonTreeReader = this.f52413i;
                this.f52411g = 1;
                obj = jsonTreeReader.h(deepRecursiveScope, this);
                if (obj == d8) {
                    return d8;
                }
            } else if (E == 8) {
                f8 = this.f52413i.f();
                return f8;
            } else {
                abstractJsonLexer2 = this.f52413i.f52408a;
                AbstractJsonLexer.y(abstractJsonLexer2, "Can't begin reading element, unexpected token", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        return (JsonElement) obj;
    }
}
