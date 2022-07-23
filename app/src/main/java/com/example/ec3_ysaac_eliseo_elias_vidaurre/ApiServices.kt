package com.example.ec3_ysaac_eliseo_elias_vidaurre

import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {
    @GET("/products")
    fun getProducts(): Call<List<ProductosModel>>

    @GET("/categorias")
    fun getCategorias(): Call<List<CategoriasModel>>

    @GET("/clientes")
    fun getClientes(): Call<List<ClientesPerfilModel>>

    @GET("/detallecompras")
    fun getDetalleCompra(): Call<List<DetalleCompraModel>>

}