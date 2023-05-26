package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.customviews.MediaPlayerRecyclerView;
import com.clevertap.android.sdk.customviews.VerticalSpaceItemDecoration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CTInboxListViewFragment extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    CleverTapInstanceConfig f11532f;

    /* renamed from: i  reason: collision with root package name */
    LinearLayout f11535i;

    /* renamed from: j  reason: collision with root package name */
    MediaPlayerRecyclerView f11536j;

    /* renamed from: k  reason: collision with root package name */
    RecyclerView f11537k;

    /* renamed from: l  reason: collision with root package name */
    CTInboxStyleConfig f11538l;

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<InboxListener> f11540n;

    /* renamed from: o  reason: collision with root package name */
    private int f11541o;

    /* renamed from: g  reason: collision with root package name */
    boolean f11533g = Utils.f11091a;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<CTInboxMessage> f11534h = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private boolean f11539m = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface InboxListener {
        void i(Context context, CTInboxMessage cTInboxMessage, Bundle bundle);

        void w(Context context, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap);
    }

    private ArrayList<CTInboxMessage> F(ArrayList<CTInboxMessage> arrayList, String str) {
        ArrayList<CTInboxMessage> arrayList2 = new ArrayList<>();
        Iterator<CTInboxMessage> it = arrayList.iterator();
        while (it.hasNext()) {
            CTInboxMessage next = it.next();
            if (next.i() != null && next.i().size() > 0) {
                for (String str2 : next.i()) {
                    if (str2.equalsIgnoreCase(str)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        return arrayList2;
    }

    private boolean N() {
        if (this.f11541o <= 0) {
            return true;
        }
        return false;
    }

    void D(Bundle bundle, int i8, HashMap<String, String> hashMap) {
        InboxListener H = H();
        if (H != null) {
            H.w(getActivity().getBaseContext(), this.f11534h.get(i8), bundle, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(Bundle bundle, int i8) {
        InboxListener H = H();
        if (H != null) {
            H.i(getActivity().getBaseContext(), this.f11534h.get(i8), bundle);
        }
    }

    void G(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("\n", "").replace("\r", "")));
            if (getActivity() != null) {
                Utils.w(getActivity(), intent);
            }
            startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    InboxListener H() {
        InboxListener inboxListener;
        try {
            inboxListener = this.f11540n.get();
        } catch (Throwable unused) {
            inboxListener = null;
        }
        if (inboxListener == null) {
            Logger.n("InboxListener is null for messages");
        }
        return inboxListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MediaPlayerRecyclerView I() {
        return this.f11536j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(int i8, String str, JSONObject jSONObject, HashMap<String, String> hashMap) {
        boolean z7;
        String i9;
        try {
            Bundle bundle = new Bundle();
            JSONObject n8 = this.f11534h.get(i8).n();
            Iterator<String> keys = n8.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    bundle.putString(next, n8.getString(next));
                }
            }
            if (str != null && !str.isEmpty()) {
                bundle.putString("wzrk_c2a", str);
            }
            D(bundle, i8, hashMap);
            if (hashMap != null && !hashMap.isEmpty()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (jSONObject != null) {
                if (!z7 && !this.f11534h.get(i8).f().get(0).l(jSONObject).equalsIgnoreCase("copy") && (i9 = this.f11534h.get(i8).f().get(0).i(jSONObject)) != null) {
                    G(i9);
                    return;
                }
                return;
            }
            String a8 = this.f11534h.get(i8).f().get(0).a();
            if (a8 != null) {
                G(a8);
            }
        } catch (Throwable th) {
            Logger.a("Error handling notification button click: " + th.getCause());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(int i8, int i9) {
        try {
            Bundle bundle = new Bundle();
            JSONObject n8 = this.f11534h.get(i8).n();
            Iterator<String> keys = n8.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    bundle.putString(next, n8.getString(next));
                }
            }
            D(bundle, i8, null);
            G(this.f11534h.get(i8).f().get(i9).a());
        } catch (Throwable th) {
            Logger.a("Error handling notification button click: " + th.getCause());
        }
    }

    void L(InboxListener inboxListener) {
        this.f11540n = new WeakReference<>(inboxListener);
    }

    void M(MediaPlayerRecyclerView mediaPlayerRecyclerView) {
        this.f11536j = mediaPlayerRecyclerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f11532f = (CleverTapInstanceConfig) arguments.getParcelable("config");
            this.f11538l = (CTInboxStyleConfig) arguments.getParcelable("styleConfig");
            this.f11541o = arguments.getInt("position", -1);
            String string = arguments.getString("filter", null);
            if (context instanceof CTInboxActivity) {
                L((InboxListener) getActivity());
            }
            CleverTapAPI K = CleverTapAPI.K(getActivity(), this.f11532f);
            if (K != null) {
                ArrayList<CTInboxMessage> r7 = K.r();
                if (string != null) {
                    r7 = F(r7, string);
                }
                this.f11534h = r7;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R$layout.inbox_list_view, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R$id.list_view_linear_layout);
        this.f11535i = linearLayout;
        linearLayout.setBackgroundColor(Color.parseColor(this.f11538l.c()));
        TextView textView = (TextView) inflate.findViewById(R$id.list_view_no_message_view);
        if (this.f11534h.size() <= 0) {
            textView.setVisibility(0);
            textView.setText(this.f11538l.g());
            textView.setTextColor(Color.parseColor(this.f11538l.h()));
            return inflate;
        }
        textView.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        CTInboxMessageAdapter cTInboxMessageAdapter = new CTInboxMessageAdapter(this.f11534h, this);
        if (this.f11533g) {
            MediaPlayerRecyclerView mediaPlayerRecyclerView = new MediaPlayerRecyclerView(getActivity());
            this.f11536j = mediaPlayerRecyclerView;
            M(mediaPlayerRecyclerView);
            this.f11536j.setVisibility(0);
            this.f11536j.setLayoutManager(linearLayoutManager);
            this.f11536j.h(new VerticalSpaceItemDecoration(18));
            this.f11536j.setItemAnimator(new DefaultItemAnimator());
            this.f11536j.setAdapter(cTInboxMessageAdapter);
            cTInboxMessageAdapter.w();
            this.f11535i.addView(this.f11536j);
            if (this.f11539m && N()) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.clevertap.android.sdk.inbox.CTInboxListViewFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CTInboxListViewFragment.this.f11536j.K1();
                    }
                }, 1000L);
                this.f11539m = false;
            }
        } else {
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.list_view_recycler_view);
            this.f11537k = recyclerView;
            recyclerView.setVisibility(0);
            this.f11537k.setLayoutManager(linearLayoutManager);
            this.f11537k.h(new VerticalSpaceItemDecoration(18));
            this.f11537k.setItemAnimator(new DefaultItemAnimator());
            this.f11537k.setAdapter(cTInboxMessageAdapter);
            cTInboxMessageAdapter.w();
        }
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.f11536j;
        if (mediaPlayerRecyclerView != null) {
            mediaPlayerRecyclerView.L1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.f11536j;
        if (mediaPlayerRecyclerView != null) {
            mediaPlayerRecyclerView.I1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.f11536j;
        if (mediaPlayerRecyclerView != null) {
            mediaPlayerRecyclerView.J1();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        MediaPlayerRecyclerView mediaPlayerRecyclerView = this.f11536j;
        if (mediaPlayerRecyclerView != null && mediaPlayerRecyclerView.getLayoutManager() != null) {
            bundle.putParcelable("recyclerLayoutState", this.f11536j.getLayoutManager().m1());
        }
        RecyclerView recyclerView = this.f11537k;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            bundle.putParcelable("recyclerLayoutState", this.f11537k.getLayoutManager().m1());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("recyclerLayoutState");
            MediaPlayerRecyclerView mediaPlayerRecyclerView = this.f11536j;
            if (mediaPlayerRecyclerView != null && mediaPlayerRecyclerView.getLayoutManager() != null) {
                this.f11536j.getLayoutManager().l1(parcelable);
            }
            RecyclerView recyclerView = this.f11537k;
            if (recyclerView != null && recyclerView.getLayoutManager() != null) {
                this.f11537k.getLayoutManager().l1(parcelable);
            }
        }
    }
}
