package ee.mtakso.driver.platform.autofill;

import android.content.Intent;
import ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: ConfirmationCodeRetriever.kt */
/* loaded from: classes3.dex */
public abstract class ConfirmationCodeRetriever {

    /* renamed from: a  reason: collision with root package name */
    private final PublishSubject<String> f23274a;

    public ConfirmationCodeRetriever() {
        PublishSubject<String> e8 = PublishSubject.e();
        Intrinsics.e(e8, "create<String>()");
        this.f23274a = e8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e(String str, int i8) {
        String value;
        MatchResult b8 = Regex.b(new Regex("[0-9]{" + i8 + "}"), str, 0, 2, null);
        if (b8 == null || (value = b8.getValue()) == null) {
            return "";
        }
        return value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(Function1 tmp0, Object obj) {
        Intrinsics.f(tmp0, "$tmp0");
        return (String) tmp0.invoke(obj);
    }

    public abstract void c(Intent intent);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(String code) {
        Intrinsics.f(code, "code");
        this.f23274a.onNext(code);
    }

    public final Single<String> f(final int i8) {
        Observable e8 = h().e(this.f23274a);
        final Function1<String, String> function1 = new Function1<String, String>() { // from class: ee.mtakso.driver.platform.autofill.ConfirmationCodeRetriever$retrieveConfirmationCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b */
            public final String invoke(String it) {
                String e9;
                Intrinsics.f(it, "it");
                e9 = ConfirmationCodeRetriever.this.e(it, i8);
                return e9;
            }
        };
        Single<String> firstOrError = e8.map(new Function() { // from class: y1.a
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String g8;
                g8 = ConfirmationCodeRetriever.g(Function1.this, obj);
                return g8;
            }
        }).firstOrError();
        Intrinsics.e(firstOrError, "fun retrieveConfirmation…    .firstOrError()\n    }");
        return firstOrError;
    }

    protected abstract Completable h();
}
