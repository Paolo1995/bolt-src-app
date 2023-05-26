package com.mixpanel.android.viewcrawler;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DynamicEventTracker implements ViewVisitor.OnEventListener {

    /* renamed from: e  reason: collision with root package name */
    private static String f19440e = "MixpanelAPI.DynamicEventTracker";

    /* renamed from: a  reason: collision with root package name */
    private final MixpanelAPI f19441a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f19442b;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Signature, UnsentEvent> f19444d = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f19443c = new SendDebouncedTask();

    /* loaded from: classes3.dex */
    private final class SendDebouncedTask implements Runnable {
        private SendDebouncedTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (DynamicEventTracker.this.f19444d) {
                Iterator it = DynamicEventTracker.this.f19444d.entrySet().iterator();
                while (it.hasNext()) {
                    UnsentEvent unsentEvent = (UnsentEvent) ((Map.Entry) it.next()).getValue();
                    if (currentTimeMillis - unsentEvent.f19447a > 1000) {
                        DynamicEventTracker.this.f19441a.V(unsentEvent.f19448b, unsentEvent.f19449c);
                        it.remove();
                    }
                }
                if (!DynamicEventTracker.this.f19444d.isEmpty()) {
                    DynamicEventTracker.this.f19442b.postDelayed(this, 500L);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class Signature {

        /* renamed from: a  reason: collision with root package name */
        private final int f19446a;

        public Signature(View view, String str) {
            this.f19446a = view.hashCode() ^ str.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Signature) || this.f19446a != obj.hashCode()) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f19446a;
        }
    }

    /* loaded from: classes3.dex */
    private static class UnsentEvent {

        /* renamed from: a  reason: collision with root package name */
        public final long f19447a;

        /* renamed from: b  reason: collision with root package name */
        public final String f19448b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f19449c;

        public UnsentEvent(String str, JSONObject jSONObject, long j8) {
            this.f19448b = str;
            this.f19449c = jSONObject;
            this.f19447a = j8;
        }
    }

    public DynamicEventTracker(MixpanelAPI mixpanelAPI, Handler handler) {
        this.f19441a = mixpanelAPI;
        this.f19442b = handler;
    }

    private static String e(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text == null) {
                return null;
            }
            return text.toString();
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z7 = false;
            for (int i8 = 0; i8 < childCount && sb.length() < 128; i8++) {
                String e8 = e(viewGroup.getChildAt(i8));
                if (e8 != null && e8.length() > 0) {
                    if (z7) {
                        sb.append(", ");
                    }
                    sb.append(e8);
                    z7 = true;
                }
            }
            if (sb.length() > 128) {
                return sb.substring(0, 128);
            }
            if (!z7) {
                return null;
            }
            return sb.toString();
        }
    }

    @Override // com.mixpanel.android.viewcrawler.ViewVisitor.OnEventListener
    public void a(View view, String str, boolean z7) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("$text", e(view));
            jSONObject.put("$from_binding", true);
            jSONObject.put("time", currentTimeMillis / 1000);
        } catch (JSONException e8) {
            MPLog.d(f19440e, "Can't format properties from view due to JSON issue", e8);
        }
        if (z7) {
            Signature signature = new Signature(view, str);
            UnsentEvent unsentEvent = new UnsentEvent(str, jSONObject, currentTimeMillis);
            synchronized (this.f19444d) {
                boolean isEmpty = this.f19444d.isEmpty();
                this.f19444d.put(signature, unsentEvent);
                if (isEmpty) {
                    this.f19442b.postDelayed(this.f19443c, 1000L);
                }
            }
            return;
        }
        this.f19441a.V(str, jSONObject);
    }
}
