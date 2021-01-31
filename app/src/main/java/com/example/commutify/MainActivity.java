package com.example.commutify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;

public class MainActivity extends AppCompatActivity{

    private Button register;
    private Button login;
    SignInButton signInButton;
    GoogleSignInClient mGoogleSignInClient;
    final int RC_SIGN_IN = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        // Build a GoogleSignInClient with the options specified by gso.
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // setting the dimensions of the sign-in button
        signInButton = findViewById(R.id.sign_in);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        signInButton.setOnClickListener(view -> {
            if (view.getId() == R.id.sign_in) {
                signIn();
            }
        });


        login = (Button)findViewById(R.id.login);
        register = (Button)findViewById(R.id.register);


    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // checks for existing Google sign in account, if not signed in - returns a non-null object
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        updateUI(account);

    }

    private void updateUI(GoogleSignInAccount account) {
        // TODO - if the user is already signed in - redirect to other screen, else other screen
        System.out.print("hi i am here");
    }


    @Override
    public void onBackPressed(){
        // Do here whatever you want to do on back press.
    }

}





