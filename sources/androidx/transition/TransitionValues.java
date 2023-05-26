package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class TransitionValues {

    /* renamed from: b  reason: collision with root package name */
    public View f7876b;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f7875a = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    final ArrayList<Transition> f7877c = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.f7876b == transitionValues.f7876b && this.f7875a.equals(transitionValues.f7875a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (this.f7876b.hashCode() * 31) + this.f7875a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f7876b + "\n") + "    values:";
        for (String str2 : this.f7875a.keySet()) {
            str = str + "    " + str2 + ": " + this.f7875a.get(str2) + "\n";
        }
        return str;
    }

    public TransitionValues(@NonNull View view) {
        this.f7876b = view;
    }
}
