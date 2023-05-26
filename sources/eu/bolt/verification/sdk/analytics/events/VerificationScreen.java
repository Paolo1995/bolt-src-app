package eu.bolt.verification.sdk.analytics.events;

import java.io.Serializable;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class VerificationScreen implements Serializable {

    /* renamed from: f  reason: collision with root package name */
    private final String f41937f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Pair<String, Serializable>> f41938g;

    /* JADX WARN: Multi-variable type inference failed */
    public VerificationScreen(String name, List<? extends Pair<String, ? extends Serializable>> parameters) {
        Intrinsics.f(name, "name");
        Intrinsics.f(parameters, "parameters");
        this.f41937f = name;
        this.f41938g = parameters;
    }

    public final String a() {
        return this.f41937f;
    }

    public final List<Pair<String, Serializable>> b() {
        return this.f41938g;
    }
}
