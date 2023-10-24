package doston.olchashop.networking


import android.icu.util.ULocale.Category
import doston.olchashop.model.CartData
import doston.olchashop.model.Login
import doston.olchashop.model.Product
import doston.olchashop.model.ProductData
import doston.olchashop.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @POST("/auth/login")
    fun login(@Body login: Login): Call<User>

    @GET("/products")
    fun getAllProducts():Call<ProductData>

    @GET("/products/categories")
    fun getAllCategories():Call<List<String>>

    @GET("/products/{id}")
    fun getProduct(@Path("id") id: Int): Call<Product>

    @GET("/users/{id}/carts")
    fun getCartsOfUser(@Path("id") id: Int):Call<CartData>

    @GET("/products/category/{category}")
    fun getProductsofCategory(@Path("category") category: String):Call<ProductData>

    @GET("/products/search")
    fun searchByName(@Query("q") name: String): Call<ProductData>


}