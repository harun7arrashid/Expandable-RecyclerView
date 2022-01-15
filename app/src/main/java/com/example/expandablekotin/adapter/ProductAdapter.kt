package com.example.expandablekotin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.RotateAnimation
import com.example.expandablekotin.databinding.ListItemCompanyBinding
import com.example.expandablekotin.databinding.ListItemProductBinding
import com.example.expandablekotin.model.Company
import com.example.expandablekotin.model.Product
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class ProductAdapter(groups: List<ExpandableGroup<*>>?)
    : ExpandableRecyclerViewAdapter<ProductAdapter.CompanyViewHolder, ProductAdapter.ProductViewHolder>(groups) {

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): CompanyViewHolder {
        val view = ListItemCompanyBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return CompanyViewHolder(view)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ProductViewHolder {
        val view = ListItemProductBinding.inflate(LayoutInflater.from(parent?.context), parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindChildViewHolder(holder: ProductViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?, childIndex: Int) {
        val product: Product = group?.items?.get(childIndex) as Product
        holder?.bind(product)
    }

    override fun onBindGroupViewHolder(holder: CompanyViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?) {
        val company: Company = group as Company
        holder?.bind(company)
    }

    inner class ProductViewHolder(private val binding: ListItemProductBinding): ChildViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.tvListProduct.text = product.name
        }
    }

    inner class CompanyViewHolder(private val binding: ListItemCompanyBinding): GroupViewHolder(binding.root) {
        fun bind(company: Company) {
            binding.tvListCompany.text = company.title
        }

        override fun expand() { animateExpand() }

        override fun collapse() {
            // super.collapse()
            animateCollapse()
        }

        private fun animateExpand() {
            val rotate: RotateAnimation = RotateAnimation(360f, 180f,
                RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
            rotate.duration = 300
            rotate.fillAfter = true
            binding.imgArrow.animation = rotate
        }

        private fun animateCollapse() {
            val rotate: RotateAnimation = RotateAnimation(180f, 360f,
                RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
            rotate.duration = 300
            rotate.fillAfter = true
            binding.imgArrow.animation = rotate
        }
    }
}