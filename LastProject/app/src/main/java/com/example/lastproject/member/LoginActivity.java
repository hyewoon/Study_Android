package com.example.lastproject.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.example.lastproject.R;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.User;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {

    Button btn_login, btn_join;
    EditText edt_id, edt_pw;
    ImageView imgv_kakao_login;
    NidOAuthLoginButton buttonOAuthLoginImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ApiClient.setBASEURL("http://192.168.0.14/middle/");
        
        //네이버
       // hpPe1Ow7Y9VZV60t0fl6
        //        iMj1yRCBYj
        //네이티브 앱키
        NaverIdLoginSDK.INSTANCE.initialize(this, "hpPe1Ow7Y9VZV60t0fl6", "iMj1yRCBYj", "LastProject");
        KakaoSdk.init(this, "53848ba251529de5d09f9d05e62cb48b");
        btn_login= findViewById(R.id.btn_login);
        btn_join= findViewById(R.id.btn_join);
        edt_id= findViewById(R.id.edt_id);
        edt_pw= findViewById(R.id.edt_pw);
        imgv_kakao_login= findViewById(R.id.imgv_kakao_login);
        buttonOAuthLoginImg =findViewById(R.id.buttonOAuthLoginImg);



        //new + enter
        buttonOAuthLoginImg.setOAuthLogin(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("로그", "onSuccess: ");
                //NidOAuthLogin().callProfileApi
                new NidOAuthLogin().callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse nidProfileResponse) {
                        Log.d("로그", "onSuccess: " +nidProfileResponse.getProfile().getEmail());
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {
                        Log.d("로그", "onFailure: ");

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {
                        Log.d("로그", "onError: ");
                    }
                });
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("로그", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("로그", "onError: " + s);
            }
        });

        //카카오로그인
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* edt_id.getText().toString();
               if( edt_id.getText().toString().equals("admin")&& edt_pw.getText().toString().equals("admin_pw")){

                        //로그인이
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                }*/
                //로그인 처리가 정상
                new CommonMethod().setParams("email" ,edt_id.getText().toString())
                        .setParams("pw",edt_pw.getText().toString())
                        .sendPost("login.me", new CommonMethod.CallBackResult() {

                            @Override
                            public void result(boolean isResult, String data) {
                                if(isResult){
                                    Log.d("로그", "result: " + data);
                                }
                            }
                        });

            }
        });
        getHashKey();

        //카카오로그인 메소드 호출
        imgv_kakao_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kakaoLogin();
                Log.d("로그", "onClick: ");
            }
        });

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
            }
        });

    }//onCreate()
   /*    Ap80FLtNEVg2OpwSOfKnpI+4Oqc=    */
    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("로그", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("로그", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    private void kakaoLogin() {
        // 카카오톡으로 로그인
        //크롬이 안켜지면 크롬 사용 중지 후 사용
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                Log.d("로그", "invoke: " + oAuthToken.toString());
                UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                    @Override
                    public Unit invoke(User user, Throwable throwable) {
                        Log.d("로그", "invoke: " + user.getId());
                        Log.d("로그", "invoke: " + user.getKakaoAccount().getEmail());
                        /*    Log.d("로그", "invoke: " + user.getKakaoAccount().getProfile().getThumbnailImageUrl());*/

                        socialLogin(user.getKakaoAccount().getEmail() );
                        return null;

                    }
                });
                return null;
            }

        };
        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)) {
            UserApiClient.getInstance().loginWithKakaoTalk(this, callback);


        } else {
            UserApiClient.getInstance().loginWithKakaoAccount(this, callback);
        }

        }
/*
         public String socialLogin(User user,  Throwable throwable) {
            //소셜 로그인 정보(이메일)를 spring으로 전송하기
            String spring = user.getKakaoAccount().getEmail();
             Log.d("로그", "socialLogin: " + spring);
            return spring;
    }
*/

    public void socialLogin(String email) {

        Log.d("로그", "socialLogin: " + email);
        new CommonMethod().setParams("email", email).sendPost("social.me", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {

            }
        });

    }
}