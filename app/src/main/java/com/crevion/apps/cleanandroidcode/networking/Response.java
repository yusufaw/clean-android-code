package com.crevion.apps.cleanandroidcode.networking;

import com.google.gson.annotations.SerializedName;

/**
 * Created by yusufaw on 1/27/18.
 */

public class Response {
    @SerializedName("status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Response() {}

    public Response(String status) {
        this.status = status;
    }
}
