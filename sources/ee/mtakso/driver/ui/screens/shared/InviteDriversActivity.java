package ee.mtakso.driver.ui.screens.shared;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import ee.mtakso.driver.R;
import ee.mtakso.driver.di.Injector;
import ee.mtakso.driver.service.analytics.event.facade.ReferralCampaignsAnalytics;
import ee.mtakso.driver.ui.base.BaseActivity;
import java.util.Locale;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class InviteDriversActivity extends BaseActivity {
    @Inject

    /* renamed from: j  reason: collision with root package name */
    ReferralCampaignsAnalytics f33316j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f33317k;

    /* renamed from: l  reason: collision with root package name */
    private String f33318l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        Y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(View view) {
        Z();
    }

    private void Y() {
        this.f33316j.f2();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.invite_to_taxify_title));
        intent.putExtra("android.intent.extra.TEXT", this.f33318l);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void Z() {
        this.f33316j.B1();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.invite_drivers));
        intent.putExtra("android.intent.extra.TEXT", this.f33318l);
        startActivity(Intent.createChooser(intent, getString(R.string.invite_drivers_title)));
    }

    private void a0() {
        this.f33316j.U0();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        intent.putExtra("sms_body", this.f33318l);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override // ee.mtakso.driver.ui.base.BaseActivity
    protected void P() {
        Injector.f2().Y1().d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ee.mtakso.driver.ui.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("extra_ref_code");
        if (stringExtra == null) {
            finish();
            return;
        }
        String format = String.format(Locale.ENGLISH, "https://partners.taxify.eu/#?refid=%s", stringExtra);
        setContentView(R.layout.activity_invite_drivers);
        Q();
        if (getSupportActionBar() != null) {
            getSupportActionBar().v(R.string.invite_drivers);
        }
        this.f33317k = (TextView) findViewById(R.id.useReferralCodeHintTxt);
        findViewById(R.id.inviteBtnSms).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.shared.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteDriversActivity.this.V(view);
            }
        });
        findViewById(R.id.inviteBtnEmail).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.shared.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteDriversActivity.this.W(view);
            }
        });
        findViewById(R.id.inviteBtnShare).setOnClickListener(new View.OnClickListener() { // from class: ee.mtakso.driver.ui.screens.shared.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InviteDriversActivity.this.X(view);
            }
        });
        this.f33317k.setText(Html.fromHtml(String.format(getString(R.string.your_friends_should_use_refcode), stringExtra)));
        this.f33318l = getString(R.string.drive_with_taxify, format);
    }

    @Override // ee.mtakso.driver.ui.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
