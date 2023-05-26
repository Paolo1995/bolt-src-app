package eu.bolt.verification.sdk.internal;

import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import javax.inject.Singleton;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Singleton
/* loaded from: classes5.dex */
public final class ub {

    /* renamed from: b  reason: collision with root package name */
    public static final a f45344b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final cb<z3> f45345c = new cb<>("storage_key_user_language", z3.class);

    /* renamed from: d  reason: collision with root package name */
    public static final cb<rg> f45346d = new cb<>("storage_key_user_locale", rg.class);

    /* renamed from: a  reason: collision with root package name */
    private final BehaviorRelay<rg> f45347a;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Observable<rg> a() {
        return this.f45347a;
    }
}
