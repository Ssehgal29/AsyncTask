package com.example.synqtask;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Toast;

public class AsyncTask extends android.os.AsyncTask<String,String,String> {

    private String resp;
    private String sleepTime;
    private ProgressDialog progressDialog;
    private Context context;

    public AsyncTask(String sleepTime, Context context) {
        this.sleepTime = sleepTime;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle("Calculating Sleep Time");
        progressDialog.setMessage("Wait For "+sleepTime+" seconds!");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("Sleeping...");
        try {
            int time = Integer.parseInt(strings[0])*1000;
            Thread.sleep(time);
            resp = "Slept for "+strings[0]+" seconds";
        }catch (InterruptedException e){
            e.printStackTrace();
            resp = e.getMessage();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        progressDialog.dismiss();
        Toast.makeText(context, resp, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }
}
