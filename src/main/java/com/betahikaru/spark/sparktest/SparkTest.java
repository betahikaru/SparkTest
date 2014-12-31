/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.betahikaru.spark.sparktest;

import static spark.Spark.*;

/**
 * Spark Framework使い方メモ http://qiita.com/opengl-8080/items/801b32a8d44089fa1c04
 *
 * @author betahikaru
 */
public class SparkTest {

    public static void main(String[] args) {
        /**
         * ルーティングの定義 HTTP メソッド（get, post, put, delete, head, trace, options,
         * connect）
         */

        /**
         * GET "/hello"
         */
        get("/hello", (request, response) -> "<h1>Hello Spark!!</h1>");
        // // Java7の場合(Spark2.1では非サポート)
        // get("/hello", new Route() {
        //     @Override
        //     public Object handle(Request rqst, Response rspns) throws Exception {
        //         return "<h1>Hello Spark!!</h1>";
        //     }
        // });

        /**
         * GET "/shutdown" Shutdown jetty server.
         *
         * stop() メソッドを実行してもすぐには停止せず、少ししてから InterruptedException がスローされて終了する。
         */
        get("/shutdown", (request, response) -> {
            stop();
            return null;
        });

        /**
         * パスパラメータ パラメータは、リクエストの params() メソッドで取得できる。
         */
        get("/hello/:param", (request, response) -> "param = " + request.params("param"));

    }

}
