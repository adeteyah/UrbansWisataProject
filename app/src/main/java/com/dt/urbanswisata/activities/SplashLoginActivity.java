package com.dt.urbanswisata.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.dt.urbanswisata.R;
import com.dt.urbanswisata.databinding.ActivitySplashLoginBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SplashLoginActivity extends AppCompatActivity {

    private Intent i;
    private FirebaseAuth fa;
    private FirebaseUser fu;
    private AuthCredential ac;
    private GoogleSignInClient gsic;
    private GoogleSignInOptions gsio;
    private ActivitySplashLoginBinding b;
    private GoogleSignInAccount gsia;
    private Task<GoogleSignInAccount> t;
    private static final int RC_SIGN_IN = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivitySplashLoginBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        myCode();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fu = fa.getCurrentUser();
        if (fu != null) {
            i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    }

    private void myCode() {
        b.buttonLoginWithGoogle.setOnClickListener(v -> {
            i = gsic.getSignInIntent();
            startActivityForResult(i, RC_SIGN_IN);
        });
        fa = FirebaseAuth.getInstance();
        gsio = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.clientId))
                .requestEmail()
                .build();
        gsic = GoogleSignIn
                .getClient(this, gsio);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            t = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                gsia = t.getResult(ApiException.class);
                firebaseAuthWithGoogle(gsia.getIdToken());
            } catch (ApiException e) {
                Toast.makeText(this,
                        R.string.msg_error,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        ac = GoogleAuthProvider.getCredential(idToken, null);
        fa.signInWithCredential(ac).addOnCompleteListener(this, signin -> {
            if (signin.isSuccessful()) {
                i = new Intent(this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            } else {
                Toast.makeText(this,
                        R.string.msg_error,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}