package com.example.ec3_ysaac_eliseo_elias_vidaurre


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products, container, false)
        val getButton = view.findViewById<View>(R.id.get_productos)
        val getButton2 = view.findViewById<View>(R.id.get_categorias)
        val getButton3 = view.findViewById<View>(R.id.get_clientes)
        val getButton4 = view.findViewById<View>(R.id.get_DetalleCompra)

        val serviceGenerator = ServiceGenerator.buildService(ApiServices::class.java)
        val call = serviceGenerator.getProducts()
        val call2 = serviceGenerator.getCategorias()
        val call3 = serviceGenerator.getClientes()
        val call4 = serviceGenerator.getDetalleCompra()
        getButton.setOnClickListener {
            call.enqueue(object : Callback<List<ProductosModel>> {
                override fun onResponse(call: Call<List<ProductosModel>>, response: Response<List<ProductosModel>>) {
                    val products = response.body()
                    Log.d("ProductsFragment", "Products: $products")
                }

                override fun onFailure(call: Call<List<ProductosModel>>, t: Throwable) {
                    Log.d("ProductsFragment", "Error: ${t.message}")
                }
            })
        }
        getButton2.setOnClickListener {
            call2.enqueue(object : Callback<List<CategoriasModel>> {
                override fun onResponse(call: Call<List<CategoriasModel>>, response: Response<List<CategoriasModel>>) {
                    val category = response.body()
                    Log.d("CategoryFragment", "Categorias: $category")
                }

                override fun onFailure(call: Call<List<CategoriasModel>>, t: Throwable) {
                    Log.d("CategoryFragment", "Error: ${t.message}")
                }
            })
        }

        getButton3.setOnClickListener {
            call3.enqueue(object : Callback<List<ClientesPerfilModel>> {
                override fun onResponse(call: Call<List<ClientesPerfilModel>>, response: Response<List<ClientesPerfilModel>>) {
                    val clientes = response.body()
                    Log.d("PerfilFragment", "Clientes: $clientes")
                }

                override fun onFailure(call: Call<List<ClientesPerfilModel>>, t: Throwable) {
                    Log.d("PerfilFragment", "Error: ${t.message}")
                }
            })
        }

        getButton4.setOnClickListener {
            call4.enqueue(object : Callback<List<DetalleCompraModel>> {
                override fun onResponse(call: Call<List<DetalleCompraModel>>, response: Response<List<DetalleCompraModel>>) {
                    val detallecompra = response.body()
                    Log.d("ComprasFragment", "Detallecompra: $detallecompra")
                }

                override fun onFailure(call: Call<List<DetalleCompraModel>>, t: Throwable) {
                    Log.d("ComprasFragment", "Error: ${t.message}")
                }
            })
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}