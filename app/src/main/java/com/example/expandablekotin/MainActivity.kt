package com.example.expandablekotin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expandablekotin.adapter.ProductAdapter
import com.example.expandablekotin.databinding.ActivityMainBinding
import com.example.expandablekotin.model.Company
import com.example.expandablekotin.model.Product

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupRecyclerview()
    }

    private fun setupRecyclerview() {
        val companies: ArrayList<Company> = arrayListOf()

        val googleProduct: ArrayList<Product> = arrayListOf()
        googleProduct.add(Product("Google AdSense"))
        googleProduct.add(Product("Google Mail"))
        googleProduct.add(Product("Google Drive"))
        googleProduct.add(Product("Google Meet"))
        googleProduct.add(Product("Google Doc"))
        googleProduct.add(Product("Google Android"))

        val google = Company("Google", googleProduct)
        companies.add(google)

        val microsoftProduct = ArrayList<Product>()
        microsoftProduct.add(Product("Windows "))
        microsoftProduct.add(Product("Windows Phone"))
        microsoftProduct.add(Product("Microsoft Store"))
        microsoftProduct.add(Product("Microsoft Office"))
        microsoftProduct.add(Product("SkyDrive"))

        val microsoft = Company("Microsoft", microsoftProduct)
        companies.add(microsoft)

        val mAdapter = ProductAdapter(companies)
        with(binding.rvMain) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }
}