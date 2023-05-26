package com.clevertap.android.sdk.inbox;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.Toast;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes.dex */
class CTInboxButtonClickListener implements View.OnClickListener {

    /* renamed from: f  reason: collision with root package name */
    private JSONObject f11512f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11513g;

    /* renamed from: h  reason: collision with root package name */
    private final CTInboxListViewFragment f11514h;

    /* renamed from: i  reason: collision with root package name */
    private final CTInboxMessage f11515i;

    /* renamed from: j  reason: collision with root package name */
    private final int f11516j;

    /* renamed from: k  reason: collision with root package name */
    private ViewPager f11517k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxButtonClickListener(int i8, CTInboxMessage cTInboxMessage, String str, JSONObject jSONObject, CTInboxListViewFragment cTInboxListViewFragment) {
        this.f11516j = i8;
        this.f11515i = cTInboxMessage;
        this.f11513g = str;
        this.f11514h = cTInboxListViewFragment;
        this.f11512f = jSONObject;
    }

    private void a(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData newPlainText = ClipData.newPlainText(this.f11513g, this.f11515i.f().get(0).f(this.f11512f));
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(newPlainText);
            Toast.makeText(context, "Text Copied to Clipboard", 0).show();
        }
    }

    private HashMap<String, String> b(CTInboxMessage cTInboxMessage) {
        if (cTInboxMessage != null && cTInboxMessage.f() != null && cTInboxMessage.f().get(0) != null && "kv".equalsIgnoreCase(cTInboxMessage.f().get(0).l(this.f11512f))) {
            return cTInboxMessage.f().get(0).g(this.f11512f);
        }
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewPager viewPager = this.f11517k;
        if (viewPager != null) {
            CTInboxListViewFragment cTInboxListViewFragment = this.f11514h;
            if (cTInboxListViewFragment != null) {
                cTInboxListViewFragment.K(this.f11516j, viewPager.getCurrentItem());
            }
        } else if (this.f11513g != null && this.f11512f != null) {
            if (this.f11514h != null) {
                if (this.f11515i.f().get(0).l(this.f11512f).equalsIgnoreCase("copy") && this.f11514h.getActivity() != null) {
                    a(this.f11514h.getActivity());
                }
                this.f11514h.J(this.f11516j, this.f11513g, this.f11512f, b(this.f11515i));
            }
        } else {
            CTInboxListViewFragment cTInboxListViewFragment2 = this.f11514h;
            if (cTInboxListViewFragment2 != null) {
                cTInboxListViewFragment2.J(this.f11516j, null, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CTInboxButtonClickListener(int i8, CTInboxMessage cTInboxMessage, String str, CTInboxListViewFragment cTInboxListViewFragment, ViewPager viewPager) {
        this.f11516j = i8;
        this.f11515i = cTInboxMessage;
        this.f11513g = str;
        this.f11514h = cTInboxListViewFragment;
        this.f11517k = viewPager;
    }
}
