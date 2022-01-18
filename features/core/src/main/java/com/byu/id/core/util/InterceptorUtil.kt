package com.byu.id.core.util

import com.byu.id.core.model.ResultDto
import com.google.gson.Gson
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.Buffer
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

object InterceptorUtil {

//    fun set(context: Context, entity: HttpLoggingEntity) {
//        if (BuildConfig.ALWAYS_DEBUG_ERROR_HTTP) {
//            val cache = CacheUtil.get(context, Cache.HTTP_LOGGING, "")
//            val httpLoggingListEntity = if (cache.isEmpty()) {
//                HttpLoggingListEntity(
//                    requests = mutableListOf(
//                        entity
//                    )
//                )
//            } else {
//                val httpLoggingListDtoMapper = HttpLoggingListDtoMapper(HttpLoggingDtoMapper())
//                val httpLoggingListDto = Gson().fromJson(cache, HttpLoggingListDto::class.java)
//                val httpLoggingListEntity = httpLoggingListDtoMapper(httpLoggingListDto)
//                val index = httpLoggingListEntity.requests.indexOfFirst { it.url == entity.url }
//                if (index != -1)
//                    httpLoggingListEntity.requests.removeAt(index)
//                httpLoggingListEntity.requests.add(entity)
//                httpLoggingListEntity
//            }
//            val httpLoggingListEntityMapper = HttpLoggingListEntityMapper(HttpLoggingEntityMapper())
//            val savedHttpLoggingListDto = httpLoggingListEntityMapper(httpLoggingListEntity)
//            val log = Gson().toJson(savedHttpLoggingListDto)
//            CacheUtil.set(context, Cache.HTTP_LOGGING, log)
//        }
//    }
//
//    fun get(context: Context, url: String): HttpLoggingEntity {
//        return if (BuildConfig.ALWAYS_DEBUG_ERROR_HTTP) {
//            val cache = CacheUtil.get(context, Cache.HTTP_LOGGING, "")
//            return if (cache.isEmpty()) {
//                HttpLoggingEntity.DEFAULT
//            } else {
//                val httpLoggingListDtoMapper = HttpLoggingListDtoMapper(HttpLoggingDtoMapper())
//                val httpLoggingListDto = Gson().fromJson(cache, HttpLoggingListDto::class.java)
//                val httpLoggingListEntity = httpLoggingListDtoMapper(httpLoggingListDto)
//                val index = httpLoggingListEntity.requests.indexOfFirst { it.url == url }
//                if (index != -1) {
//                    httpLoggingListEntity.requests[index]
//                } else {
//                    HttpLoggingEntity.DEFAULT
//                }
//            }
//        } else HttpLoggingEntity.DEFAULT
//    }
//
//    fun clear(context: Context) {
//        CacheUtil.set(context, Cache.HTTP_LOGGING, "")
//    }
//
//    fun copyLog(context: Context, httpLoggingEntity: HttpLoggingEntity, onSuccessCopy: (() -> Unit)? = null) {
//        val httpLoggingEntityMapper = HttpLoggingEntityMapper()
//        val httpLoggingDto = httpLoggingEntityMapper(httpLoggingEntity)
//        val json = Gson().toJson(httpLoggingDto)
//        CopyToClipboardUtil.copy(context, text = json)
//        onSuccessCopy?.invoke()
//    }

    fun bodyToString(request: RequestBody?): String {
        return try {
            val buffer = Buffer()
            if (request != null) request.writeTo(buffer) else return ""
            buffer.readUtf8()
        } catch (e: IOException) {
            e.printStackTrace()
            ""
        }
    }
    fun bodyToStringWithoutLang(request: RequestBody?): String {
        try {
            val buffer = Buffer()
            if (request != null) request.writeTo(buffer) else return ""
            val reqString = buffer.readUtf8()
            val req = JSONObject(reqString)
            req.remove("lang")
            return req.toString()
        } catch (e: IOException) {
            e.printStackTrace()
            return ""
        }catch (e: JSONException) {
            e.printStackTrace()
            return ""
        }
    }

    fun bodyToString(response: ResponseBody?): String {
        return try {
            if (response != null) {
                val source = response.source()
                source.request(Long.MAX_VALUE)
                var buffer = source.buffer
                val contentLength = response.contentLength()
                val contentType = response.contentType()
                val charset: Charset = contentType?.charset(StandardCharsets.UTF_8) ?: StandardCharsets.UTF_8
                if (contentLength != 0L) {
                    buffer.clone().readString(charset)
                } else
                    ""
            } else
                ""
        } catch (e: Exception) {
            e.printStackTrace();
            ""
        }
    }

    fun isApiSuccess(responseJson: String): Boolean {
        return try {
            val resultDto = Gson().fromJson(responseJson, ResultDto::class.java)
            if (resultDto != null)
                resultDto.code == ResultDto.SUCCESS
            else false
        } catch (e: Exception){
            e.printStackTrace()
            false
        }
    }
}