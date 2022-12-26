package com.example.conn;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonMethod {
    // 해당하는 getData라는 메소드를 여러 액티비티와 프래그먼트에서 재활용을 통해
    // Spring에 연결 후 데이터를 가지고 오는 처리를 해야함.
    // 어떤식으로 바뀌면 재활용이 편할까???
    private HashMap<String , Object> params = new HashMap<>();
    public CommonMethod setParams(String key , Object value){
        params.put(key,value);
        return this;
    }

    public void sendPost(String url , CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connPost(url , params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace();
            }
        });
    }

    public void sendPostFile(String url ,String path, CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connFilePost(url ,stringToRequest(),pathToPartFile(path));
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace();
            }
        });
    }

    public MultipartBody.Part pathToPartFile(String path){
        if(path != null){
            RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), new File(path));
            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", "img.png",fileBody);
            return filePart;
        }
        return null;
    }

    public RequestBody stringToRequest(){
        if(!params.isEmpty()){
            RequestBody data = RequestBody.create(
                    MediaType.parse("multipart/form-data"), new Gson().toJson(
                            params.get("param")
                    )
            );
            return  data;
        }
        return null;
    }

    public void sendGet(String url , CallBackResult callback){
        ApiInterface apiInterface = new ApiClient().getApiClient().create(ApiInterface.class);
        Call<String> apiTest =  apiInterface.connGet(url , params);
        apiTest.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                callback.result(true, response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                callback.result(false, "");
                t.printStackTrace();
            }
        });
    }
    public interface CallBackResult{
        //메인에서 Commandthod를 통해서 Callback<String> 인터페이스를 넘겨서 실행할때마다
        //두개의 메소드가 오버라이드 됨
        public void result(boolean isResult, String data);
    }

    //갤러리에서 가져온이미지 패스가 uri형태로 실제 물리적인 주소가 Xfile로 만들 수 없음
    //해당하느 메소드는 uri를통해 실제 이미지 물리적 주소를 얻어오는 메소드
    //20222.12.26  hy 만듬
    public String getRealPath(Uri uri, Context context){
        String rtn = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, proj,null,null,null);
        if(cursor.moveToFirst()){
            int colum_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            rtn = cursor.getString(colum_index);
        }
        cursor.close();
        return rtn;
    }

    public File createFile(Context context){
        String fileName = "LastProject" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File storageDir =  context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File rtnFile = null;

        try{
            rtnFile = File.createTempFile(fileName, ".jpg",storageDir);
        }catch (IOException e){
            e.printStackTrace();
        }

        return  rtnFile;

    }

}

