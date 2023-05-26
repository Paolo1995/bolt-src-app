package kotlinx.coroutines.selects;

import kotlinx.coroutines.internal.Symbol;

/* compiled from: Select.kt */
/* loaded from: classes5.dex */
public final class SelectKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f51987a = new Symbol("NOT_SELECTED");

    /* renamed from: b  reason: collision with root package name */
    private static final Object f51988b = new Symbol("ALREADY_SELECTED");

    /* renamed from: c  reason: collision with root package name */
    private static final Object f51989c = new Symbol("UNDECIDED");

    /* renamed from: d  reason: collision with root package name */
    private static final Object f51990d = new Symbol("RESUMED");

    /* renamed from: e  reason: collision with root package name */
    private static final SeqNumber f51991e = new SeqNumber();

    public static final Object d() {
        return f51988b;
    }

    public static final Object e() {
        return f51987a;
    }
}
