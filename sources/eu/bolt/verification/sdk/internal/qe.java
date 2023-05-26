package eu.bolt.verification.sdk.internal;

import eu.bolt.coroutines.dispatchers.DispatchersBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes5.dex */
public final class qe {

    /* renamed from: a  reason: collision with root package name */
    private final DispatchersBundle f44646a;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f44647a;

        /* renamed from: b  reason: collision with root package name */
        private final List<h2> f44648b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(CharSequence query, List<? extends h2> countries) {
            Intrinsics.f(query, "query");
            Intrinsics.f(countries, "countries");
            this.f44647a = query;
            this.f44648b = countries;
        }

        public final List<h2> a() {
            return this.f44648b;
        }

        public final CharSequence b() {
            return this.f44647a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return Intrinsics.a(this.f44647a, aVar.f44647a) && Intrinsics.a(this.f44648b, aVar.f44648b);
            }
            return false;
        }

        public int hashCode() {
            return (this.f44647a.hashCode() * 31) + this.f44648b.hashCode();
        }

        public String toString() {
            CharSequence charSequence = this.f44647a;
            List<h2> list = this.f44648b;
            return "Args(query=" + ((Object) charSequence) + ", countries=" + list + ")";
        }
    }

    @DebugMetadata(c = "ee.mtakso.client.core.interactors.auth.PhonePrefixCodeQueryInteractor$execute$2", f = "PhonePrefixCodeQueryInteractor.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes5.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends h2>>, Object> {

        /* renamed from: g  reason: collision with root package name */
        int f44649g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ a f44650h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ qe f44651i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, qe qeVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f44650h = aVar;
            this.f44651i = qeVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f44650h, this.f44651i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: h */
        public final Object s(CoroutineScope coroutineScope, Continuation<? super List<? extends h2>> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.f50853a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String H;
            IntrinsicsKt__IntrinsicsKt.d();
            if (this.f44649g == 0) {
                ResultKt.b(obj);
                if (this.f44650h.b().length() > 0) {
                    String obj2 = this.f44650h.b().toString();
                    Locale locale = Locale.getDefault();
                    Intrinsics.e(locale, "getDefault()");
                    String lowerCase = obj2.toLowerCase(locale);
                    Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    H = StringsKt__StringsJVMKt.H(lowerCase, "+", "", false, 4, null);
                    List<h2> a8 = this.f44650h.a();
                    qe qeVar = this.f44651i;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj3 : a8) {
                        if (qeVar.b((h2) obj3, H)) {
                            arrayList.add(obj3);
                        }
                    }
                    return arrayList;
                }
                return this.f44650h.a();
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Inject
    public qe(DispatchersBundle dispatchersBundle) {
        Intrinsics.f(dispatchersBundle, "dispatchersBundle");
        this.f44646a = dispatchersBundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(h2 h2Var, String str) {
        boolean J;
        boolean z7;
        boolean L;
        J = StringsKt__StringsJVMKt.J(h2Var.e(), str, true);
        if (J) {
            return true;
        }
        String[] h8 = h2Var.h();
        int length = h8.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                z7 = false;
                break;
            }
            L = StringsKt__StringsJVMKt.L(h8[i8], str, false, 2, null);
            if (L) {
                z7 = true;
                break;
            }
            i8++;
        }
        return z7;
    }

    public Object a(a aVar, Continuation<? super List<? extends h2>> continuation) {
        return BuildersKt.g(this.f44646a.a(), new b(aVar, this, null), continuation);
    }
}
